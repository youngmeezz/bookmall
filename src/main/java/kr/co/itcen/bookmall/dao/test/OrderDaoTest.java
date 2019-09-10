package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.OrderVo;
import kr.co.itcen.bookmall.vo.UserVo;

public class OrderDaoTest {

	public static void main(String[] args) {

		
		
		insertTest();
		selectTest();
		//deleteAllTest();
		updateTest(1,"경기도 수원시");

	}
	
	private static void updateTest(long order_number, String delivery_address) {
		// TODO Auto-generated method stub

		System.out.println("update test---------------------------------------------------------");
		
		OrderDao dao = new OrderDao();
		dao.update(order_number,delivery_address);
		
		List<OrderVo> list = dao.getList();

		for (OrderVo vo : list) {
			System.out.println(vo);
		}
		
		
	}

	private static void deleteAllTest() {
		
		new OrderDao().delete();
		
	}
	
	public static void insertTest() {

		System.out.println("insert test---------------------------------------------------------");
		
		OrderDao dao = new OrderDao();

		OrderVo vo1 = new OrderVo();
		
		vo1.setOrderNumber(10);
		vo1.setUserNumber(1);
		vo1.setPrice(20000);
		vo1.setDeliveryAddress("경기도 군포시");
		vo1.setOrderStatus("판매중"); //상태코드값 string 바꾸기
		
		dao.insert(vo1);
		System.out.println(vo1);
	}

	private static void selectTest() {

		System.out.println("select test---------------------------------------------------------");
		OrderDao dao = new OrderDao();
		List<OrderVo> list = dao.getList();

		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	}
}