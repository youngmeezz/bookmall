package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.Order_BookDao;
import kr.co.itcen.bookmall.vo.Order_BookVo;

public class Order_BookDaoTest {

	public static void main(String[] args) {
		
		insertTest();
		selectTest();
//		deleteAllTest();
	}

	
//	private static void deleteAllTest() {
//		
//		new ArtistDao().delete();
//		
//	}
	
	public static void insertTest() {

		System.out.println("insert test---------------------------------------------------------");
		
		Order_BookDao dao = new Order_BookDao();

		Order_BookVo vo1 = new Order_BookVo();
		
//		vo1.setCategoryNumber(1);
//		vo1.setTitle("90년대생이 온다");
//		vo1.setPrice((long) 50000);
		vo1.setOrderNumber(2);
		vo1.setBookNumber(6);
		vo1.setAmount(19992);
		
		
		dao.insert(vo1);
		System.out.println(vo1);
	}

	private static void selectTest() {

		System.out.println("select test---------------------------------------------------------");
		Order_BookDao dao = new Order_BookDao();
		List<Order_BookVo> list = dao.getList();

		for (Order_BookVo vo : list) {
			System.out.println(vo);
		}
	}
}


