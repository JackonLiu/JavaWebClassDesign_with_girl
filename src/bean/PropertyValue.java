package bean;

public class PropertyValue {
	//商品属性值，例如颜色、尺寸等
	private String value;
	//对应的商品
    private Product product;
    //对应的属性
    private Property property;
    private int id;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Property getProperty() {
        return property;
    }
    public void setProperty(Property property) {
        this.property = property;
    }
}
