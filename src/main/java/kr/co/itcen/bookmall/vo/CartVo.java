package kr.co.itcen.bookmall.vo;

public class CartVo {

	

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	
	@Override
	public String toString() {
		return "장바구니 [번호=" + no + ", 개수=" + count + ", 가격=" + price + ", 사용자번호=" + user_no + ", 도서번호="
				+ book_no + "]";
	}

	private Long no;
	private int count;
	private int price;
	private int user_no;
	private int book_no;
	
	
	
}
