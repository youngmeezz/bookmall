package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.dao.Order_BookDao;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.CartVo;
import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.OrderVo;
import kr.co.itcen.bookmall.vo.Order_BookVo;
import kr.co.itcen.bookmall.vo.UserVo;

public class BookmallTest {
	public static void main(String[] args) {

		System.out.println("================category====================");

		CategoryDao categotydao = new CategoryDao();

		List<CategoryVo> categorylist = categotydao.getList();
		for (CategoryVo vo : categorylist) {
			System.out.println(vo);
		}
		System.out.println("=================book========================");

		BookDao bookdao = new BookDao();

		List<BookVo> booklist = bookdao.getList();
		for (int i = 0; i < booklist.size(); i++) {
			System.out.println(booklist.get(i));
		}

		System.out.println("=================order_book===================");

		Order_BookDao order_bookdao = new Order_BookDao();

		List<Order_BookVo> orderbooklist = order_bookdao.getList();
		for (int i = 0; i < orderbooklist.size(); i++) {
			System.out.println(orderbooklist.get(i));
		}

		System.out.println("===================order=====================");

		OrderDao orderdao = new OrderDao();

		List<OrderVo> orderlist = orderdao.getList();
		for (int i = 0; i < orderlist.size(); i++) {
			System.out.println(orderlist.get(i));
		}

		System.out.println("===================cart========================");

		CartDao cartdao = new CartDao();

		List<CartVo> cartlist = cartdao.getList();
		for (int i = 0; i < cartlist.size(); i++) {
			System.out.println(cartlist.get(i));
		}

		System.out.println("===================user=========================");
		UserDao userdao = new UserDao();

		List<UserVo> userlist = userdao.getList();
		for (UserVo vo : userlist) {
			System.out.println(vo);
		}
	}
}
