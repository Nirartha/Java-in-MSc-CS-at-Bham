/**
 *  Kuanyow Chen
 *  1756755
 */
public class Book {

	private String title;
	private int year;
	private String isbn;

	/**
     *  @param title The title of the book.
     *  @param year The year of the book.
     *  @param isbn The isbn of the book.
     */
	public Book(String title, int year, String isbn) {
		this.title = title;
		this.year = year;
		this.isbn = isbn;
	}
	/**
     *  Getter for the title.
     *  @return The title of the book is returned.
     */
	public String getTitle() {
		return title;
	}

	/**
     *  Getter for the year.
     *  @return The year of the book is returned.
     */ 
	public int getYear() {
		return year;
	}

	/**
     *  Getter for the isbn.
     *  @return The isbn of the book is returned.
     */ 
	public String getIsbn() {
		return isbn;
	}

	/**
     *  Setter for the title. The title of the book is updated.
     *  @param title The new title of the updated book.
     */ 
	public void setTitle(String title) {
		this.title = title;
	}

	/**
     * @return A human readable description of the book in form
     *     of the three field variables specifying it.
     */ 
	public String toString() {
		return "The Best Seller Book is " + getTitle() + " which published " + Integer.toString(getYear()) + " and it's ISBN is " + getIsbn();
	}

	/*
     *  main method with a test of the create the new book and
     *  toString method.
     */
	public static void main(String[] args) {
		Book BestSeller = new Book("The Girl in the Letter", 2018, "9781472255082");
		System.out.println(BestSeller);
		BestSeller.setTitle("The click");
		System.out.println(BestSeller);
	}

}