package bean;

import java.io.Serializable;


//购物项
public class CartItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float price;//小计：单价*数量
	private int number;//数量
	private Product product;//该项对应的商品
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	public CartItem(Product product){
		this.product = product;
	}
	
	public Product getBook() {
		return product;
	}
	public void setBook(Product product) {
		this.product = product;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getPrice() {
		return product.getOrignalPrice()*number;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	

}
