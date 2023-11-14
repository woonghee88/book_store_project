package kbs.mvc.model.domain;

public class Category {
	
	private String categoryNo;
	private String categoryName;
	private Category parent;
	
	public Category() {}

	public Category(String categoryNo, String categoryName, Category parent) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.parent = parent;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}
	
	

}
