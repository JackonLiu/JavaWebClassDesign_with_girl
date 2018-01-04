package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Product implements Serializable{
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String name;
	    private String subTitle;
	    private float orignalPrice;
	    private float promotePrice;
	    private int stock;
	    private Date createDate;
	    private Category category;
	    private int id;
	    private ProImage firstProductImage;
	    private List<ProImage> productImages;
	    private List<ProImage> productSingleImages;
	    private List<ProImage> productDetailImages;
	    private int reviewCount;
	    private int saleCount;
	 
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getSubTitle() {
	        return subTitle;
	    }
	    public void setSubTitle(String subTitle) {
	        this.subTitle = subTitle;
	    }
	    public float getOrignalPrice() {
	        return orignalPrice;
	    }
	    public void setOrignalPrice(float orignalPrice) {
	        this.orignalPrice = orignalPrice;
	    }
	    public float getPromotePrice() {
	        return promotePrice;
	    }
	    public void setPromotePrice(float promotePrice) {
	        this.promotePrice = promotePrice;
	    }
	    public int getStock() {
	        return stock;
	    }
	    public void setStock(int stock) {
	        this.stock = stock;
	    }
	    public Date getCreateDate() {
	        return createDate;
	    }
	    public void setCreateDate(Date createDate) {
	        this.createDate = createDate;
	    }
	    public Category getCategory() {
	        return category;
	    }
	    public void setCategory(Category category) {
	        this.category = category;
	    }
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	     
	    public String toString(){
	        return name;
	    }
	    public ProImage getFirstProductImage() {
	        return firstProductImage;
	    }
	    public void setFirstProductImage(ProImage firstProductImage) {
	        this.firstProductImage = firstProductImage;
	    }
	    public List<ProImage> getProductImages() {
	        return productImages;
	    }
	    public void setProductImages(List<ProImage> productImages) {
	        this.productImages = productImages;
	    }
	    public List<ProImage> getProductSingleImages() {
	        return productSingleImages;
	    }
	    public void setProductSingleImages(List<ProImage> productSingleImages) {
	        this.productSingleImages = productSingleImages;
	    }
	    public List<ProImage> getProductDetailImages() {
	        return productDetailImages;
	    }
	    public void setProductDetailImages(List<ProImage> productDetailImages) {
	        this.productDetailImages = productDetailImages;
	    }
	    public int getReviewCount() {
	        return reviewCount;
	    }
	    public void setReviewCount(int reviewCount) {
	        this.reviewCount = reviewCount;
	    }
	    public int getSaleCount() {
	        return saleCount;
	    }
	    public void setSaleCount(int saleCount) {
	        this.saleCount = saleCount;
	    }
}
