package kr.co.itcen.bookmall.vo;

public class BookVo {
	

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", book_price=" + book_price + ", category_no=" + category_no
				+ "]";
	}
	private Long no;
	private String title;
	private int book_price;
	private int category_no;


}