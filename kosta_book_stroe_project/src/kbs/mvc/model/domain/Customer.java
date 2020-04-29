package kbs.mvc.model.domain;

import java.util.Date;

public class Customer {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private int age;
	private String addr;
	private String phone;
	private int mileage;
	private Date regDt;
	private String email;
	private int customerState;
	private Levels levels;


	public Customer() {}

	
	

	/**
	 * 회원 정보 수정하는 생성자 
	 */
	public Customer(String pwd, String name, int age, String addr, String phone, String email) {
		super();
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.phone = phone;
		this.email = email;
	}


	public Customer(String id, String pwd, String name, String gender, int age, String addr, String phone,
			String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.addr = addr;
		this.phone = phone;
		this.email = email;
	}












	public Customer(String id, String pwd, String name, String gender, int age, String addr, String phone, int mileage,
			Date regDt, String email, int customerState, Levels levels) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.addr = addr;
		this.phone = phone;
		this.mileage = mileage;
		this.regDt = regDt;
		this.email = email;
		this.customerState = customerState;
		this.levels = levels;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCustomerState() {
		return customerState;
	}

	public void setCustomerState(int customerState) {
		this.customerState = customerState;
	}

	public Levels getLevels() {
		return levels;
	}

	public void setLevels(Levels levels) {
		this.levels = levels;
	}



}
