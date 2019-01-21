package shop;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Exercise2Tests {
	public static final double TOLERANCE = 0.00001;
	private Product Product1, Product2, Product3, Product4, Product5;
	private MultiBuyProduct MultiBuyProduct;
	ShoppingCart ShoppingCart = new ShoppingCart();
	
	@Before
	public void setUp() {
		
		Product1 = new Product("Milk (1pt)", 0.79, 9);
		Product2 = new Product("Fish", 1.51, 3);
		Product3 = new Product("Tomato", 0.53, 5);
		Product4 = new Product("Milk (1pt)", 0.79, 4);
		Product5 = new Product("Tomato", 0.53, 7);
		
		MultiBuyProduct = new MultiBuyProduct("Tomato", 0.5, 20, 10, 3);
	}

	//testing getters of a product total price
	@Test
	public void getProductTotalPrice() {
		
		ShoppingCart.add(Product1);
		ShoppingCart.add(Product2);
		ShoppingCart.add(Product3);
		
		double expectedMilkTotalPrice = 7.11;
		double actualMilkTotalPrice = Product1.getTotalPrice();
		assertEquals(expectedMilkTotalPrice, actualMilkTotalPrice, TOLERANCE);
		
		double expectedFishTotalPrice = 4.53;
		double actualFishTotalPrice = Product2.getTotalPrice();
		assertEquals(expectedFishTotalPrice, actualFishTotalPrice, TOLERANCE);
		
		double expectedTomatoTotalPrice = 2.65;
		double actualTomatoTotalPrice = Product3.getTotalPrice();
		assertEquals(expectedTomatoTotalPrice, actualTomatoTotalPrice, TOLERANCE);
	}
	
	//testing getters of a MultiBuy product total price
	@Test
	public void getMultiBuyProductTotalPrice() {
		
		ShoppingCart.add(Product1);
		ShoppingCart.add(Product3);
		ShoppingCart.add(Product4);
		ShoppingCart.add(Product5);
		
		double expectedMilkTotalPrice = 10.27;
		double actualMilkTotalPrice = Product1.getTotalPrice();
		assertEquals(expectedMilkTotalPrice, actualMilkTotalPrice, TOLERANCE);
		
		double expectedTomatoTotalPrice = 6.36;
		double actualTomatoTotalPrice = Product3.getTotalPrice();
		assertEquals(expectedTomatoTotalPrice, actualTomatoTotalPrice, TOLERANCE);
	}
	
	//testing getters of a discounted product total price
	@Test
	public void getDiscountedProductTotalPrice() {
		
		ShoppingCart.add(MultiBuyProduct);
		
		double expectedDiscountedTomatoTotalPrice = 9.7;
		double actualDiscountedTomatoTotalPrice = MultiBuyProduct.getTotalPrice();
		assertEquals(expectedDiscountedTomatoTotalPrice, actualDiscountedTomatoTotalPrice, TOLERANCE);
	}
}
