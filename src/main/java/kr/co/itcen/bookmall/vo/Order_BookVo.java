package kr.co.itcen.bookmall.vo;

public class Order_BookVo {

	
		
		public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
		@Override
	public String toString() {
		return "Order_BookVo [no=" + no + ", amount=" + amount + ", orderNumber=" + orderNumber + ", bookNumber="
				+ bookNumber + "]";
	}
		private int no;
		private int amount;
		private int orderNumber;
		private int bookNumber;
		
}
