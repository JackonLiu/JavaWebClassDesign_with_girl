package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Cart;
import bean.Order;
import bean.User;
import util.DBUtil;
import util.DateUtil;
  
public class OrderDAO {
    public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";
     
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from Order_";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) { 
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }
  
    public void add(Order bean) {
 
        String sql = "insert into order_ values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
        	ps.setInt(1, bean.getId());
            ps.setString(2, bean.getOrderCode());
            ps.setString(3, bean.getAddress());
            ps.setString(4, bean.getPost());
            ps.setString(5, bean.getReceiver());
            ps.setString(6, bean.getMobile());
            ps.setString(7, bean.getUserMessage());
             
            ps.setTimestamp(8,  DateUtil.d2t(bean.getCreateDate()));
            ps.setTimestamp(9,  DateUtil.d2t(bean.getPayDate()));
            ps.setTimestamp(10,  DateUtil.d2t(bean.getDeliveryDate()));
            ps.setTimestamp(11,  DateUtil.d2t(bean.getConfirmDate()));
            ps.setInt(12, bean.getUser().getId());
            ps.setString(13, bean.getStatus());
            ps.setFloat(14, bean.getPrice());
            ps.setInt(15, bean.getCart().getId());
 
            ps.execute();
  
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public void update(Order bean) {
 
        String sql = "update order_ set address= ?, post=?, receiver=?,mobile=?,userMessage=? ,createDate = ? , "
        		+ "payDate =? , deliveryDate =?, confirmDate = ? , orderCode =?, uid=?, status=?,price=?,cartid=? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, bean.getAddress());
            ps.setString(2, bean.getPost());
            ps.setString(3, bean.getReceiver());
            ps.setString(4, bean.getMobile());
            ps.setString(5, bean.getUserMessage());
            ps.setTimestamp(6, DateUtil.d2t(bean.getCreateDate()));;
            ps.setTimestamp(7, DateUtil.d2t(bean.getPayDate()));;
            ps.setTimestamp(8, DateUtil.d2t(bean.getDeliveryDate()));;
            ps.setTimestamp(9, DateUtil.d2t(bean.getConfirmDate()));;
            ps.setString(10, bean.getOrderCode());
            ps.setInt(11, bean.getUser().getId());
            ps.setString(12, bean.getStatus());
            ps.setFloat(13, bean.getPrice());
            ps.setInt(14, bean.getCart().getId());
            ps.setInt(15, bean.getId());
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
  
    public void delete(int id) {
  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from Order_ where id = " + id;
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public Order get(int id) {
        Order bean = new Order();
  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from Order_ where id = " + id;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                String orderCode =rs.getString("orderCode");
                String address = rs.getString("address");
                String post = rs.getString("post");
                String receiver = rs.getString("receiver");
                String mobile = rs.getString("mobile");
                String userMessage = rs.getString("userMessage");
                String status = rs.getString("status");
                Float sum_price = rs.getFloat("price");
                int cart_id=rs.getInt("cartid");
                int uid =rs.getInt("uid");
                Date createDate = DateUtil.t2d( rs.getTimestamp("createDate"));
                Date payDate = DateUtil.t2d( rs.getTimestamp("payDate"));
                Date deliveryDate = DateUtil.t2d( rs.getTimestamp("deliveryDate"));
                Date confirmDate = DateUtil.t2d( rs.getTimestamp("confirmDate"));
                 
                bean.setOrderCode(orderCode);
                bean.setAddress(address);
                bean.setPost(post);
                bean.setReceiver(receiver);
                bean.setMobile(mobile);
                bean.setUserMessage(userMessage);
                bean.setCreateDate(createDate);
                bean.setPayDate(payDate);
                bean.setDeliveryDate(deliveryDate);
                bean.setConfirmDate(confirmDate);
                User user = new UserDAO().get(uid);
                bean.setUser(user);
                bean.setStatus(status);
                bean.setPrice(sum_price);
       		 	Cart cart=new Cart();
       		 	cart.setId(cart_id);
                bean.setCart(cart);
                 
                bean.setId(id);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return bean;
    }
  
    public List<Order> list() {
        return list(0, Short.MAX_VALUE);
    }
  
    public List<Order> list(int start, int count) {
        List<Order> beans = new ArrayList<Order>();
  
        String sql = "select * from Order_ order by id desc limit ?,? ";
  
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                Order bean = new Order();
                String orderCode =rs.getString("orderCode");
                String address = rs.getString("address");
                String post = rs.getString("post");
                String receiver = rs.getString("receiver");
                String mobile = rs.getString("mobile");
                String userMessage = rs.getString("userMessage");
                String status = rs.getString("status");
                Date createDate = DateUtil.t2d( rs.getTimestamp("createDate"));
                Date payDate = DateUtil.t2d( rs.getTimestamp("payDate"));
                Date deliveryDate = DateUtil.t2d( rs.getTimestamp("deliveryDate"));
                Date confirmDate = DateUtil.t2d( rs.getTimestamp("confirmDate"));
                int uid =rs.getInt("uid");                
                Float sum_price = rs.getFloat("price");
                int cart_id=rs.getInt("cartid");
                int id = rs.getInt("id");
                bean.setId(id);
                bean.setOrderCode(orderCode);
                bean.setAddress(address);
                bean.setPost(post);
                bean.setReceiver(receiver);
                bean.setMobile(mobile);
                bean.setUserMessage(userMessage);
                bean.setCreateDate(createDate);
                bean.setPayDate(payDate);
                bean.setDeliveryDate(deliveryDate);
                bean.setConfirmDate(confirmDate);
                User user = new UserDAO().get(uid);
                bean.setUser(user);
                bean.setStatus(status);
                bean.setPrice(sum_price);
       		 	Cart cart=new Cart();
       		 	cart.setId(cart_id);
                bean.setCart(cart);
                beans.add(bean);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return beans;
    }
     
    public List<Order> list(int uid,String excludedStatus) {
        return list(uid,excludedStatus,0, Short.MAX_VALUE);
    }
      
    public List<Order> list(int uid, String excludedStatus, int start, int count) {
        List<Order> beans = new ArrayList<Order>();
         
        String sql = "select * from Order_ where uid = ? and status != ? order by id desc limit ?,? ";
         
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
             
            ps.setInt(1, uid);
            ps.setString(2, excludedStatus);
            ps.setInt(3, start);
            ps.setInt(4, count);
             
            ResultSet rs = ps.executeQuery();
             
            while (rs.next()) {
                Order bean = new Order();
                String orderCode =rs.getString("orderCode");
                String address = rs.getString("address");
                String post = rs.getString("post");
                String receiver = rs.getString("receiver");
                String mobile = rs.getString("mobile");
                String userMessage = rs.getString("userMessage");
                String status = rs.getString("status");
                Date createDate = DateUtil.t2d( rs.getTimestamp("createDate"));
                Date payDate = DateUtil.t2d( rs.getTimestamp("payDate"));
                Date deliveryDate = DateUtil.t2d( rs.getTimestamp("deliveryDate"));
                Date confirmDate = DateUtil.t2d( rs.getTimestamp("confirmDate"));
                Float sum_price = rs.getFloat("price");
                int cart_id=rs.getInt("cartid");
                int id = rs.getInt("id");
                bean.setId(id);
                bean.setOrderCode(orderCode);
                bean.setAddress(address);
                bean.setPost(post);
                bean.setReceiver(receiver);
                bean.setMobile(mobile);
                bean.setUserMessage(userMessage);
                bean.setCreateDate(createDate);
                bean.setPayDate(payDate);
                bean.setDeliveryDate(deliveryDate);
                bean.setConfirmDate(confirmDate);
                User user = new UserDAO().get(uid);
                bean.setStatus(status);
                bean.setPrice(sum_price);
       		 	Cart cart=new Cart();
       		 	cart.setId(cart_id);
                bean.setCart(cart);
                bean.setUser(user);
                beans.add(bean);
            }
            System.out.println("根据用户查询订单成功！"+beans.toString());
        } catch (SQLException e) {
             
            e.printStackTrace();
        }
        return beans;
    }

//  //保存订单
//    
//  	public void save(Order order) {
//  		
//  		try {
//  			qr.update("insert into orders (ordernum,price,number,status,customerId) values (?,?,?,?,?)", 
//  					order.getOrdernum(),order.getPrice(),order.getNumber(),order.getStatus(),
//  					order.getCustomer()==null?null:order.getCustomer().getId());
//  			List<OrderItem> items = order.getItems();
//  			for(OrderItem item:items){
//  				qr.update("insert into orderitems (id,number,price,ordernum,bookid) values (?,?,?,?,?)", 
//  						item.getId(),item.getNumber(),item.getPrice(),order.getOrdernum(),item.getBook()==null?null:item.getBook().getId());
//  			}
//  		} catch (SQLException e) {
//  			throw new RuntimeException(e);
//  		}
//  	}


//  	public Order findByNum(String ordernum) {
//  		try {
//  			Order order = qr.query("select * from orders where ordernum=?", new BeanHandler<Order>(Order.class), ordernum);
//  			if(order!=null){
//  				Customer customer = qr.query("select * from customers where id=(select customerId from orders where ordernum=?)", new BeanHandler<Customer>(Customer.class), ordernum);
//  				order.setCustomer(customer);
//  			}
//  			return order;
//  		} catch (SQLException e) {
//  			throw new RuntimeException(e);
//  		}
//  	}


//  	public List<Order> findByCustomerId(int customerId) {
//  		try {
//  			List<Order> orders=qr.query("select * from orders where customerId=?  order by ordernum desc ", new BeanListHandler<Order>(Order.class),customerId);
//  			if(orders!=null){
//  				User customer=qr.query("select * from customers where id=? ",new BeanHandler<Customer>(Customer.class),customerId);
//  				for (Order order : orders) {
//  					order.setCustomer(customer);
//  				}
//  			}
//  			return orders;
//  		} catch (SQLException e) {
//  			throw new RuntimeException(e);
//  		}
//  	}


//  	public List<OrderItem> findOrderItem(String ordernum) {
////  		, new BeanListHandler<OrderItem>(OrderItem.class), 
//  		try {
//  			List<OrderItem> items = qr.query("select * from orderitems where ordernum=?",ordernum);
//  			if(items!=null){
//  				for(OrderItem o:items){
//  					Product product = qr.query("select * from books where id=(select bookId from orderitems where id=?)");
//  					o.setProduct(product);
//  				}
//  			}
//  			return items;
//  		} catch (SQLException e) {
//  			throw new RuntimeException(e);
//  		}
//  	}
  
}