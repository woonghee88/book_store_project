package kbs.mvc.model.domain;

public class Levels {
	private int levels;
	private int discount;
	private int min;
	private int max;
	
	public Levels() {}
		
	public Levels(int levels, int discount, int min, int max) {
		
		this.levels = levels;
		this.discount = discount;
		this.min = min;
		this.max = max;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	
	
	
	
}
