package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;


public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
		//updateTest(1, "사람은 무엇으로 사는가");
	}

	

	private static void updateTest(int book_id, String name) {
		// TODO Auto-generated method stub

		System.out.println("update test---------------------------------------------------------");
		
		BookDao dao = new BookDao();
		dao.update(book_id, name);
		
		List<BookVo> list = dao.getList();

		for (BookVo vo : list) {
			System.out.println(vo);
		}
		
	}


	private static void deleteAllTest() {
		
		new BookDao().delete();
		
	}
	
	public static void insertTest() {

		System.out.println("insert test---------------------------------------------------------");
		
		BookDao dao = new BookDao();

		BookVo vo1 = new BookVo();
		
		vo1.setNo((long) 1);
		vo1.setTitle("90년대생이 온다");
		vo1.setBook_price(10000);
		vo1.setCategory_no(6);
		
		
		dao.insert(vo1);
		System.out.println(vo1);

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