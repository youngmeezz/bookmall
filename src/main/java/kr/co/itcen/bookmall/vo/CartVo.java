package kr.co.itcen.bookmall.vo;

public class CartVo {

	@Override
	public String toString() {
		return "장바구니 [도서번호=" + bookNumber + ", 사용자번호=" + user_id + ", 수량=" + count + "]";
	}
	private int bookNumber;
	private Long user_id;
	private int count;
	
	
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
