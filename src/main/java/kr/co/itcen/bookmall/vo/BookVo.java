package kr.co.itcen.bookmall.vo;

public class BookVo {
	
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public int getCategoryNumber() {
		return categoryNumber;
	}
	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}

	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	@Override
	public String toString() {
		return "도서 [도서번호=" + bookNumber + ", 카테고리번호=" + categoryNumber + ", 도서제목=" + title
				+ ", 도서가격=" + price + ", 도서상태=" + bookStatus + "]";
	}
	private int bookNumber;
	private int categoryNumber;
	private String title;
	private Long price;
	private String bookStatus;
	
	

}