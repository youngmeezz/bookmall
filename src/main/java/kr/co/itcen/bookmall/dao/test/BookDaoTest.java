package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;


public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
	}

	

	public static void insertTest() {

		System.out.println("insert test---------------------------------------------------------");
		
		BookDao dao = new BookDao();

		BookVo vo1 = new BookVo();
		

		vo1.setTitle("90년대생이 온다");
		vo1.setBook_price(10000);
		vo1.setCategory_no(6);
		dao.insert(vo1);
		System.out.println(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setTitle("삶이 극적으로 바뀌는 인문학적 통찰");
		vo2.setBook_price(15300);
		vo2.setCategory_no(1);
		dao.insert(vo2);
		System.out.println(vo2);
		
		
		BookVo vo3 = new BookVo();
		vo3.setTitle("성공한 사람듦나 갖고있는 놀라운 성공 공식의 힘");
		vo3.setBook_price(15120);
		vo3.setCategory_no(3);
		dao.insert(vo3);
		System.out.println(vo3);
		
		

	}

	private static void selectTest() {

		System.out.println("select test---------------------------------------------------------");
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();

		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}
}