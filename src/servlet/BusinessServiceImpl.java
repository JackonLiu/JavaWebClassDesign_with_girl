package servlet;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.Category;
import bean.Order;
import bean.OrderItem;
import bean.Product;
import bean.User;
import dao.CategoryDAO;
import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.ProductDAO;
import dao.UserDAO;
import util.Page;



public class BusinessServiceImpl {

	private OrderDAO orderDao=new OrderDAO();
	private OrderItemDAO orderItemDao=new OrderItemDAO();
	private ProductDAO proDao=new ProductDAO();
	CategoryDAO categoryDao=new CategoryDAO();

	private UserDAO userDao=new UserDAO();
	
	public void addCategory(Category category){
//			category.setId(UUID.randomUUID());
			categoryDao.add(category);
	}

	
	public List<Category> findAllCategories() {
		
		return categoryDao.list();
	}


	public boolean isCategoryExists(String categoryName) {
		Category category=categoryDao.get(0,categoryName);
		return category==null?false:true;
	}

	
	public void  delCategory(String categoryName) {
		categoryDao.delete(0,categoryName);
		
	}

	
	public Category findCategoryById(int categoryId) {
		
		return categoryDao.get(categoryId,null);
	}

	
	public Page findPage(String num) {
		int pageNum =1;
		if(num!=null){
			pageNum=Integer.parseInt(num);
		}
		int totalRecordsNum=proDao.getTotalRecordsNum();
		Page page=new Page(pageNum,totalRecordsNum);
		List<Product>  records=proDao.list(page.getStartIndex(), page.getPageSize());
		
		proDao.setSaleAndReviewNumber(records);
		for(int i=0,j=records.size();i<j;i++){
			proDao.setFirstProductImage(records.get(i));
		}
		page.setRecords(records);
		return page;
	}

	
	public Page findPage(String num, String categoryId) {
		int pageNum =1;
		List<Product>  records=null;
		if(num!=null){
			pageNum=Integer.parseInt(num);
		}
		int totalRecordsNum=proDao.getTotalRecordsNum(categoryId);
		Page page=new Page(pageNum,totalRecordsNum);
		if(isNumeric(categoryId)){
			int cid = Integer.valueOf(categoryId).intValue();
			records=proDao.list(cid);
		}else{
			records=proDao.search(categoryId,page.getStartIndex(), page.getPageSize());
		}
		//category改为关键词
		
		if(records==null){
			System.out.println("bus  93 行  该页为空！");
		}
		else{
			System.out.println("page.setRecords(records);！");
			page.setRecords(records);
		}
		return page;
	}

	public Product findProductById(String bookId) {
//		 int i = Integer.parseInt([String]); 
//		 i = Integer.parseInt([String],[int radix]);
		 int proid = Integer.valueOf(bookId).intValue();
		
		return proDao.get(proid);

	}

	public void registCustomer(User user) {
//		user.setId(UUID.randomUUID());
		userDao.add(user);
		
	}

	public User findByCode(int code) {
		
		return userDao.get(code);
	}

	public User login(String username, String password) {
		
		User customer = userDao.get(username,password);
		if(customer==null)
			return null;
		return customer;
	}

	//生成订单
	public void genOrder(Order order) {
		if(order==null)
				throw new RuntimeException("订单不能为空");
		orderDao.add(order);
		
	}

	public Order findOrderByNum(int ordernum) {
		
		return orderDao.get(ordernum);
	}

	public void updateOrder(Order order) {
		orderDao.update(order);
		
	}
	public void changeOrderStatus(String status, int ordernum) {
		Order order=findOrderByNum(ordernum);
		order.setStatus(status);
		updateOrder(order);
	}

	public List<Order> findOrdersByCustomerId(int customerId,String excludedStatus) {
		
		return orderDao.list(customerId,excludedStatus);
	}

	public List<OrderItem> findOrderItemByCustomerId(int ordernum) {
	
		return orderItemDao.listByUser(ordernum);
	}

	public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
 }
	

}
