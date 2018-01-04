package servlet;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.CategoryDAO;
import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.ProImageDAO;
import dao.ProductDAO;
import dao.PropertyDAO;
import dao.PropertyValueDAO;
import dao.ReviewDAO;
import dao.UserDAO;
import util.Page;



public abstract class BaseBackServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract String add(HttpServletRequest request, HttpServletResponse response, Page page);
	public abstract String delete(HttpServletRequest request, HttpServletResponse response, Page page);
	public abstract String edit(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public abstract String update(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public abstract String list(HttpServletRequest request, HttpServletResponse response, Page page) ;
	
	
	protected CategoryDAO categoryDAO = new CategoryDAO();
	protected OrderDAO orderDAO = new OrderDAO();
	protected OrderItemDAO orderItemDAO = new OrderItemDAO();
	protected ProductDAO productDAO = new ProductDAO();
	protected ProImageDAO productImageDAO = new ProImageDAO();
	protected PropertyDAO propertyDAO = new PropertyDAO();
	protected PropertyValueDAO propertyValueDAO = new PropertyValueDAO();
	protected ReviewDAO reviewDAO = new ReviewDAO();
	protected UserDAO userDAO = new UserDAO();

	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			int start= 0;
			int count = 5;
			try {
				start = Integer.parseInt(request.getParameter("page.start"));
			} catch (Exception e) {
				
			}
			try {
				count = Integer.parseInt(request.getParameter("page.count"));
			} catch (Exception e) {
			}
			Page page = new Page(start,count);
			
			/*借助反射，调用对应的方法*/
			String method = (String) request.getAttribute("method");
			Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
					javax.servlet.http.HttpServletResponse.class,Page.class);
			String redirect = m.invoke(this,request, response,page).toString();
			
			/*根据方法的返回值，进行相应的客户端跳转，服务端跳转，或者仅仅是输出字符串*/
			System.out.println(">>>>>>>>>Service method:" + method + "+++++++redirect:" + redirect);
			if(redirect.startsWith("@")){
				System.out.println("客户端跳转：" + redirect.substring(1));
				response.sendRedirect(redirect.substring(1));//客户端跳转
			}
			else if(redirect.startsWith("%"))
				response.getWriter().print(redirect.substring(1));
			else
			{
				System.out.println("服务器跳转：" + redirect);
				request.getRequestDispatcher(redirect).forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	public InputStream parseUpload(HttpServletRequest request, Map<String, String> params) {
		return null;
	}
    
}
