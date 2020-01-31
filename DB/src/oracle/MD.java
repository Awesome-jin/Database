package oracle;

import java.sql.Date;

public class MD {
	
	private int num;
	private String code;
	private String itemname;
	private int price ;
	private int quantity;
	private Date transdate; // sql date로 import하기
	private String userid;
	
	public MD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MD(int num, String code, String itemname, int price, int quantity, Date transdate, String userid) {
		super();
		this.num = num;
		this.code = code;
		this.itemname = itemname;
		this.price = price;
		this.quantity = quantity;
		this.transdate = transdate;
		this.userid = userid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getTransdate() {
		return transdate;
	}

	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String string) {
		this.userid = string;
	}

	@Override
	public String toString() {
		return "MD [num=" + num + ", code=" + code + ", itemname=" + itemname + ", price=" + price + ", quantity="
				+ quantity + ", transdate=" + transdate + ", userid=" + userid + "]";
	}
	
	
}
