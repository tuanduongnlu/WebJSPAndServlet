package model;

public class Product {
	private int id ;
	private String name ;
	private String author ;
	private String publisher ;
	private int category;
	private int quantity;
	private float price;
	private float sale;
	private String image;
	private String status;
	public Product() {
		super();
	}
	public Product(String name, String author, String publisher, int category, int quantity, float price,
			float sale, String image, String status) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.sale = sale;
		this.image = image;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getSale() {
		return sale;
	}
	public void setSale(float sale) {
		this.sale = sale;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
