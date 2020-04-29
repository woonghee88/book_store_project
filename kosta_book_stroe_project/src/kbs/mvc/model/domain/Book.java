package kbs.mvc.model.domain;

public class Book {
	
	private String ISBN;
	private String bookName;
	private String bookImg;
	private String author;
	private int price;
	private String description;
	private String publisher;
	private String publishDt; 
	private Category categoryNo;
	private BookDetail bookDetail;
	
	public Book() {}
	
	//삭제할때
	public Book(String ISBN) {
		this.ISBN = ISBN;
	}

	public Book(String iSBN, String bookName, String bookImg, String author, int price, String description,
			String publisher, String publishDt, Category categoryNo, BookDetail bookDetail) {
		super();
		ISBN = iSBN;
		this.bookName = bookName;
		this.bookImg = bookImg;
		this.author = author;
		this.price = price;
		this.description = description;
		this.publisher = publisher;
		this.publishDt = publishDt;
		this.categoryNo = categoryNo;
		this.bookDetail = bookDetail;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookImg() {
		return bookImg;
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishDt() {
		return publishDt;
	}

	public void setPublishDt(String publishDt) {
		this.publishDt = publishDt;
	}

	public Category getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Category categoryNo) {
		this.categoryNo = categoryNo;
	}

	public BookDetail getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	
	

}
