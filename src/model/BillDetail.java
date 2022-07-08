package model;

public class BillDetail {
	private int id ;
	private int billId ;
	private int ProductId ;
	private String nameProduct;
	private int quantity ;
	private float amount ;
	public BillDetail( int billId, int productId, int quantity, float amount,String nameProduct) {
		super();
		this.billId = billId;
		ProductId = productId;
		this.quantity = quantity;
		this.amount = amount;
		this.nameProduct = nameProduct;
	}
	public BillDetail() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	

}
