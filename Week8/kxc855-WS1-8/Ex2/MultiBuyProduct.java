package shop;

public class MultiBuyProduct extends Product {
	
	int minDiscountedQuantity;
	int discountPercent;
	
	/**
	 *  a constructor extends Product
     *  @param name The name of the product.
     *  @param price The price of the product.
     *  @param quantity The quantity of the product.
     *  
     *  @param minDiscountedQuantity The minDiscountedQuantity of the MultiBuyProduct.
     *  @param discountPercent The discountPercent of the MultiBuyProduct.
     */
	public MultiBuyProduct(String name, double price, int quantity, int minDiscountedQuantity, int discountPercent) {
		super(name, price, quantity);
		this.minDiscountedQuantity = minDiscountedQuantity;
		this.discountPercent = discountPercent;
	}
	
	/**
     *  Getter for the TotalPrice of MultiBuyProduct.
     *  @return The TotalPrice of the MultiBuyProduct is returned.
     */
	public double getTotalPrice() {
		if (getQuantity() >= getMinDiscountedQuantity()) {
			System.out.println("MultiBuyProduct getTotalPrice : " + (getPrice() * getDiscountPercent())/100);
			return getQuantity() * (getPrice() - (getPrice() * getDiscountPercent()/100));
		} else {
			return super.getTotalPrice();
		}
	}
	
	/**
     *  Getter for the MinDiscountedQuantity.
     *  @return The MinDiscountedQuantity of the MultiBuyProduct is returned.
     */
	public int getMinDiscountedQuantity() {
		return minDiscountedQuantity;
	}
	
	/**
     *  Setter for the MinDiscountedQuantity. The MinDiscountedQuantity of the MultiBuyProduct is updated.
     *  @param MinDiscountedQuantity The new MinDiscountedQuantity of the updated MultiBuyProduct.
     */
	public void setMinDiscountedQuantity(int minDiscountedQuantity) {
		this.minDiscountedQuantity = minDiscountedQuantity;
	}
	
	/**
     *  Getter for the DiscountPercent.
     *  @return The DiscountPercent of the MultiBuyProduct is returned.
     */
	public int getDiscountPercent() {
		return discountPercent;
	}
	
	/**
     *  Setter for the DiscountPercent. The DiscountPercent of the MultiBuyProduct is updated.
     *  @param DiscountPercent The new DiscountPercent of the updated MultiBuyProduct.
     */
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

}
