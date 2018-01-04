package servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import bean.ProImage;
import dao.ProImageDAO;
import util.ImageUtil;
import util.Page;

public class ProductImageServlet extends BaseBackServlet {

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		//上传文件的输入流
        InputStream is = null;
        //提交上传文件时的其他参数
        Map<String,String> params = new HashMap<>();
 
        //解析上传
        is = parseUpload(request, params);      
         
        //根据上传的参数生成productImage对象
        String type= params.get("type");
        String proid = params.get("pid");
        int pid = Integer.parseInt(proid);
        Product p =productDAO.get(pid);
         
        ProImage pi = new ProImage();       
        pi.setType(type);
        pi.setProduct(p);
        productImageDAO.add(pi);
         
        //生成文件
        String fileName = pi.getId()+ ".jpg";
        String imageFolder;
        String imageFolder_small=null;
        String imageFolder_middle=null;
        if(ProImageDAO.type_single.equals(pi.getType())){
            imageFolder= request.getSession().getServletContext().getRealPath("img/productSingle");
            imageFolder_small= request.getSession().getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle= request.getSession().getServletContext().getRealPath("img/productSingle_middle");
        }
             
        else
            imageFolder= request.getSession().getServletContext().getRealPath("img/productDetail");
        File f = new File(imageFolder, fileName);
        f.getParentFile().mkdirs();
         
        // 复制文件
        try {
            if(null!=is && 0!=is.available()){
                try(FileOutputStream fos = new FileOutputStream(f)){
                    byte b[] = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.flush();
                    //通过如下代码，把文件保存为jpg格式
                    BufferedImage img = ImageUtil.change2jpg(f);
                    ImageIO.write(img, "jpg", f);       
                     
                    if(ProImageDAO.type_single.equals(pi.getType())){
                        File f_small = new File(imageFolder_small, fileName);
                        File f_middle = new File(imageFolder_middle, fileName);
 
                        ImageUtil.resizeImage(f, 56, 56, f_small);
                        ImageUtil.resizeImage(f, 217, 190, f_middle);
                    }
                         
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return "@admin_productImage_list?pid="+p.getId();
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		ProImage pi = productImageDAO.get(id);
        productImageDAO.delete(id);
         
        if(ProImageDAO.type_single.equals(pi.getType())){
            String imageFolder_single= request.getSession().getServletContext().getRealPath("img/productSingle");
            String imageFolder_small= request.getSession().getServletContext().getRealPath("img/productSingle_small");
            String imageFolder_middle= request.getSession().getServletContext().getRealPath("img/productSingle_middle");
             
            File f_single =new File(imageFolder_single,pi.getId()+".jpg");
            f_single.delete();
            File f_small =new File(imageFolder_small,pi.getId()+".jpg");
            f_small.delete();
            File f_middle =new File(imageFolder_middle,pi.getId()+".jpg");
            f_middle.delete();
             
        }
 
        else{
            String imageFolder_detail= request.getSession().getServletContext().getRealPath("img/productDetail");
            File f_detail =new File(imageFolder_detail,pi.getId()+".jpg");
            f_detail.delete();          
        }
        return "@admin_productImage_list?pid="+pi.getProduct().getId();
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
		String pid = request.getParameter("pid");
		Product p =null;
		if(pid!=null){
			int proid = Integer.valueOf(pid).intValue();
	        p =productDAO.get(proid);
		}else{
			p=productDAO.get(1); 
		}
        List<ProImage> pisSingle = productImageDAO.list(p, ProImageDAO.type_single);
        List<ProImage> pisDetail = productImageDAO.list(p, ProImageDAO.type_detail);
         
        request.setAttribute("p", p);
        request.setAttribute("pisSingle", pisSingle);
        request.setAttribute("pisDetail", pisDetail);
         
        return "admin/listProductImage.jsp";
	}

}
