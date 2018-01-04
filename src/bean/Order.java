package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private String orderCode;
    private String address;
    private Cart cart;
	private String post;
    private String receiver;
    private String mobile;
    private String userMessage;
    private Date createDate;
    private Date payDate;
    private Date deliveryDate;
    private Date confirmDate;
    private User user;
    private int id;
    private List<OrderItem> orderItems;
    private float total;
    private int totalNumber;
    private String status;
	private String ordernum;
	private float price;
	private int number;
	
	private List<OrderItem> items=new ArrayList<OrderItem>();
     
    public String getStatusDesc(){
        String desc ="δ֪";
        switch(status){
//          case OrderDAO.waitPay:
//              desc="������";
//              break;
//          case OrderDAO.waitDelivery:
//              desc="������";
//              break;
//          case OrderDAO.waitConfirm:
//              desc="���ջ�";
//              break;
//          case OrderDAO.waitReview:
//              desc="������";
//              break;
//          case OrderDAO.finish:
//              desc="���";
//              break;
//          case OrderDAO.delete:
//              desc="�h��";
//              break;
//          default:
//              desc="δ֪";
        }
        return desc;
    }
     
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
 
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getUserMessage() {
        return userMessage;
    }
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public Date getConfirmDate() {
        return confirmDate;
    }
    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }
 
    public String getReceiver() {
        return receiver;
    }
 
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
 
    public String getOrderCode() {
        return orderCode;
    }
 
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
 
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
 
    public float getTotal() {
        return total;
    }
 
    public void setTotal(float total) {
        this.total = total;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public int getTotalNumber() {
        return totalNumber;
    }
 
    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public void setCart(Cart cart) {
		this.cart=cart;
	}
   	public Cart getCart() {
		return cart;
	}


}
