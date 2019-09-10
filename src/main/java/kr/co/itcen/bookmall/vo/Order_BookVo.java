package kr.co.itcen.bookmall.vo;

public class Order_BookVo {

	
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
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		
		@Override
		public String toString() {
			return " 주문_도서 테이블 [주문번호=" + orderNumber + ", 도서번호=" + bookNumber + ", 수량=" + amount
					+ "]";
		}


		private int orderNumber;
		private int bookNumber;
		private int amount;
}
