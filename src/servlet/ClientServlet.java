package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.CartItem;
import bean.Category;
import bean.Order;
import bean.OrderItem;
import bean.Product;
import bean.Review;
import bean.User;
import dao.ReviewDAO;
import dao.UserDAO;
import util.OrderNumUtil;
import util.Page;


public class ClientServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BusinessServiceImpl s=new BusinessServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op=request.getParameter("op");
		if("listProducts".equals(op)){
			listProducts(request,response);
		}else if("listProductByCategory".equals(op)){
			listProductByCategory(request,response);
		}else if("buyProducts".equals(op)){
			buyProducts(request,response);
		}else if("delOneItem".equals(op)){
			delOneItem(request,response);
		}else if("changeNum".equals(op)){
			changeNum(request,response);
		}else if("customerRegist".equals(op)){
			customerRegist(request,response);
		}else if("login".equals(op)){
			login(request,response);
		}else if("logout".equals(op)){
			logout(request,response);
		}else if("genOrder".equals(op)){
			genOrder(request,response);
		}else if("showOrders".equals(op)){
			showOrders(request,response);
		}else if("showReviews".equals(op)){
			showReviews(request,response);
		}else if("showUsers".equals(op)){
			showUsers(request,response);
		}else if("listOrder".equals(op)){
			listOrder(request,response);
		}else if("ProductDetail".equals(op)){
			ProductDetail(request,response);
		}
	}





	//订单详情
	private void showOrders(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		//检测是否登录； 
				response.setCharacterEncoding("UTF-8");
				HttpSession session=request.getSession();
				User customer=(User) session.getAttribute("customer");
				if(customer==null){
					response.getWriter().write("Please login!");
					response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/commons/login.jsp");
				}//customer.getId()
				else{
					List<Order>  orders=s.findOrdersByCustomerId(1,"0");
					request.setAttribute("orders", orders);
					
					request.getRequestDispatcher("/commons/listOrders.jsp").forward(request, response);
				}
	}

	//管理员查看订单
	private void listOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
				response.setCharacterEncoding("UTF-8");
				List<Order>  orders=s.findOrdersByCustomerId(1,"0");
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("/admin/listOrder.jsp").forward(request, response);
	}
	
	//生成订单
	private void genOrder(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException  {
		//检测是否登录； 
		HttpSession session=request.getSession();
		User customer=(User) session.getAttribute("customer");
		
		if(customer==null){
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("please login");
			response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/commons/login.jsp");
			return ;
		}
		
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		
		Order order=new Order();
		order.setCart(cart);
		order.setOrdernum(OrderNumUtil.genOrderNum());
		order.setPrice(cart.getPrice());
		order.setNumber(cart.getNumber());
		order.setUser(customer);
		
		
		List<OrderItem>  oItems=new ArrayList<OrderItem>();
		//设置订单项
		for(Map.Entry<String, CartItem>  me:cart.getItems().entrySet()){
			OrderItem item=new OrderItem();
//			item.setId(UUID.randomUUID());
			item.setNumber(me.getValue().getNumber());
			item.setPrice(me.getValue().getPrice());
			item.setProduct(me.getValue().getBook());
			oItems.add(item);
		}
		//建立和订单的关系
		order.setOrderItems(oItems);
		s.genOrder(order);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/commons/pay.jsp").forward(request, response);
		
		
	}


	//注销登录
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		request.getSession().removeAttribute("customer");
		response.getWriter().write("注销成功！2秒后转向主页");
		response.setHeader("Refresh", "2;URL="+request.getContextPath());
		
	}


	//用户登录
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text"); 
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User customer=s.login(username, password);
		
		if(customer==null){
			System.out.println(username+password);
			response.getWriter().write("wrong username or password！5 seconds to login.jsp");
//			request.getRequestDispatcher("index.jsp").forward(request, response); 
//			response.setHeader("Refresh", "5;URL="+request.getContextPath()+"/commons/login.jsp");
			 PrintWriter out = response.getWriter();   
			out.print(false);
		}
		System.out.println(username+password);
		request.getSession().setAttribute("customer", customer);
		 response.setContentType("text/html;charset=utf-8");
	       response.setContentType("text");  
	        System.out.println(username);  
	        PrintWriter out = response.getWriter();  
	        String json=readJSONData(request);
	        System.out.println(json); 
	        out.print("true");
	        out.flush();  
	        out.close(); 
	}

	private String readJSONData(HttpServletRequest request) {
        StringBuffer json=new StringBuffer();
        String lineString=null;
        try {
            BufferedReader reader=request.getReader();
            while ((lineString=reader.readLine())!=null) {
                json.append(lineString);                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return json.toString();
    }

//String json=readJSONData(request);
////将json字符串转为java对象
//Gson gson=new Gson();
//Person person=gson.fromJson(json, Person.class);
	
	//改变数量
	private void changeNum(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String bookId=request.getParameter("productId");
		Cart cart=(Cart) request.getSession().getAttribute("cart");
		CartItem item=cart.getItems().get(bookId);
		item.setNumber(Integer.parseInt(request.getParameter("num")));
		
		response.sendRedirect(request.getContextPath()+"/commons/showCart.jsp");
	}


	//删除购物车中的一项
	private void delOneItem(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String bookId=request.getParameter("productId");
		Product product=s.findProductById(bookId);
		if(product==null){
			response.getWriter().write("Wrong Product ID！5 Senconds to listProduct.jsp");
		}
		else{
				Cart cart=(Cart) request.getSession().getAttribute("cart");
				cart.getItems().remove(bookId);
		
				response.sendRedirect(request.getContextPath()+"/commons/showCart.jsp");
		}
	
		
	}

	//加入购物车
	private void buyProducts(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//得到商品
		String productId=request.getParameter("productId");
		
		Product product=s.findProductById(productId);
		
		//购物车
		HttpSession session=request.getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addBook2Items(product);
		//提示
//		response.getWriter().write("加入购物车成功");
		request.setAttribute("cart",cart);
		
		
		request.setAttribute("message", "success！<a href='javascript:window.history.back()'>返回</a>");
		try {
			request.getRequestDispatcher("/commons/message.jsp").forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//按照分类查询商品的分页信息
	private void listProductByCategory(HttpServletRequest request,
			HttpServletResponse response) {
		List<Category>  cs=s.findAllCategories();
		request.setAttribute("cs", cs);
		
		//查询所有商品的分页数据
//		String num=request.getParameter("num");
		String categoryId=request.getParameter("categoryId");
		Page page=s.findPage("1",categoryId);
		
		page.setUrl("/ClientServlet?op=listProductByCategory&categoryId="+categoryId);
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/commons/listProducts.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void listProducts(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//查询所有分类
		List<Category>  cs=s.findAllCategories();
		request.setAttribute("cs", cs);
		
		//查询所有商品的分页数据
		String num=request.getParameter("num");
		Page page=s.findPage(num);
		System.out.println(page.getPageSize());
		page.setUrl("/ClientServlet?op=listProducts");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/commons/listProducts.jsp").forward(request, response);
		
	}
	

	private void ProductDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		Page page=s.findPage(pid);
		System.out.println(page.getPageSize());
		page.setUrl("/ClientServlet?op=listProducts");
		request.setAttribute("page", page);
		request.getRequestDispatcher("/commons/listProducts.jsp").forward(request, response);
		
	}
	
	//新用户注册
	private void customerRegist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		User bean = new User();
        bean.setName(username);
        bean.setPhone(phone);
        bean.setPassword(password);
        System.out.println(bean.getName()+bean.getPhone()+bean.getPassword());
        if(bean.getName()==null||bean.getPhone()==null||bean.getPassword()==null){
        	response.getWriter().write("worong,Please input!");
        	response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/commons/regist.jsp");
        }
        else{
        	s.registCustomer(bean);
        	response.getWriter().write("ok  2 seconds to index ");//+"/listProducts.jsp"
        	response.setHeader("Refresh", "2;URL="+request.getContextPath());
        }
	}
	


	private void showReviews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		List<Review> beans = new ArrayList<Review>();
		int proid = Integer.valueOf(pid).intValue();
		ReviewDAO rdao = new ReviewDAO();
		beans=rdao.list(proid,0,Short.MAX_VALUE);
		request.setAttribute("beans", beans);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		/*HttpSession session=request.getSession();
		Review review=(Review) session.getAttribute("review");
		if(review==null){
			review=new Review();
			session.setAttribute("review", review);
		}
		for(int i=0,j=beans.size();i<j;i++){
			review=beans.get(i);
		}
		*/
	}
	

	private void showUsers(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	        List<User> beans = new ArrayList<User>();
	        UserDAO userDao=new UserDAO();
	        beans=userDao.list();
			request.setAttribute("beans", beans);
			request.getRequestDispatcher("/admin/listClient.jsp").forward(request, response);
	}




	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
