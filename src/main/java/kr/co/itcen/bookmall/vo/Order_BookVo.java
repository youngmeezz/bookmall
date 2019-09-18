package kr.co.itcen.bookmall.vo;

public class Order_BookVo {

	public Long getNo() {
	return no;
	}
	public void setNo(Long no) {
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
		return "주문도서 [번호=" + no + ", 개수=" + amount + ", 주문번호=" + orderNumber + ", 도서번호="
				+ bookNumber + "]";
	}
		private Long no;
		private int amount;
		private int orderNumber;
		private int bookNumber;
		
}