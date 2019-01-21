package shop;

public class Product {
	
	private String name;
	private double price;
	private int quantity;
	
	/**
	 *  a constructor
     *  @param name The name of the product.
     *  @param price The price of the product.
     *  @param quantity The quantity of the product.
     */
	public Product (String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	/**
     *  Getter for the Name.
     *  @return The Name of the product is returned.
     */
	public String getName() {
		return this.name;
	}
	
	/**
     *  Getter for the Price.
     *  @return The Price of the product is returned.
     */
	public double getPrice() {
		return this.price;
	}
	
	/**
     *  Getter for the Quantity.
     *  @return The Quantity of the product is returned.
     */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
     *  Setter for the Quantity. The Quantity of the product is updated.
     *  @param Quantity The new Quantity of the updated product.
     */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
     *  Getter for the TotalPric.
     *  @return The TotalPric of the product is returned.
     */
	public double getTotalPrice() {
		return getQuantity() * getPrice();
	}
}
