package kr.co.itcen.bookmall.vo;

public class CategoryVo {
	
	@Override
	public String toString() {
		return "카테고리 [카테고리번호=" + category_no + ", 카테고리이름=" + category_name + "]";
	}

	
	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	private Long category_no;
	private String category_name;
}