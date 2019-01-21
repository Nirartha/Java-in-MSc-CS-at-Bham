package shop;
import java.util.ArrayList;

public class ShoppingCart {
	
	private ArrayList<Product> productList = new ArrayList<Product>();
	
	/**
	 * boolean addNewProduct in order to judge the input product should
	 * 1. be added a new ArrayList<Product>
	 * 2. or added into the same products in the cart if their name and price is same
	 * @param p the next product would be added into shopping cart
	 */
	public void add(Product p) {
		
		boolean addNewProduct = true;
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getName().equals(p.getName()) && productList.get(i).getPrice() == p.getPrice()) {
				productList.get(i).setQuantity(productList.get(i).getQuantity() + p.getQuantity());
				addNewProduct = false;
			}
		}
		
		if (addNewProduct) {
			productList.add(p);
		}
		
	}
	
	/**
     * @return A human readable description of the product in form of the five fields variable specifying it.
     */ 
	public String toString() {
		String printToString = "";
		double printToTotal = 0;
		for (int i = 0; i < productList.size(); i++) {
			printToString += String.format("%d * GBP   %.2f %s   = GBP   %.2f \n", 
											productList.get(i).getQuantity(),
											productList.get(i).getPrice(),
											productList.get(i).getName(), 
											productList.get(i).getTotalPrice());
			printToTotal += productList.get(i).getTotalPrice();
			
		}
		printToString += String.format("-------------\nTOTAL GBP    %.2f", printToTotal);
		
		return printToString;
	}
	
	/* self test
	public static void main(String[] args) {
		
		ShoppingCart lists = new ShoppingCart();
		lists.add(new Product("Milk (1pt)", 0.79, 9));
		lists.add(new MultiBuyProduct("Tomato", 0.5, 20, 10, 3));
		lists.add(new Product("Tomato", 0.53, 5));
		lists.add(new Product("Milk (1pt)", 0.79, 4));
		lists.add(new Product("Tomato", 0.53, 7));
		
		System.out.println(lists);
	}
	*/
}
