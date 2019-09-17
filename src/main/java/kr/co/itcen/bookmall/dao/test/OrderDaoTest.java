package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {

		
		
		insertTest();
		selectTest();
	

	}
	

	
	public static void insertTest() {

		System.out.println("insert test---------------------------------------------------------");
		
		OrderDao dao = new OrderDao();

		OrderVo vo1 = new OrderVo();
		
		vo1.setNo((long)10);
		vo1.setPayment(10000);
		vo1.setDeliveryAddress("경기도 군포시");
		vo1.setUserNo(1);
		
		
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