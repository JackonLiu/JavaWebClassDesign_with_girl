package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class Cart implements Serializable{
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private Map<String, CartItem> items = new HashMap<String, CartItem>();
	private float price;//总价
	private int number;//总数量
	public Map<String, CartItem> getItems() {
		return items;
	}
	//向items中添加一项
	public void addBook2Items(Product product){
		//书在items中有：数量加1
		if(items.containsKey(product.getId())){
			CartItem item = items.get(product.getId());
			item.setNumber(item.getNumber()+1);
		}else{
		//没有：创建一个新项
			CartItem item = new CartItem(product);
			item.setNumber(1);
			items.put(String.valueOf(product.getId()), item);
			System.out.println("//没有：创建一个新项");
		}
	}
	
	public float getPrice() {
		price = 0;
		for(Map.Entry<String, CartItem> me:items.entrySet()){
			price+=me.getValue().getPrice();
		}
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNumber() {
		number = 0;
		for(Map.Entry<String, CartItem> me:items.entrySet()){
			number+=me.getValue().getNumber();
		}
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
