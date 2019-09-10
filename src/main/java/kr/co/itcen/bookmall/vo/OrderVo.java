package kr.co.itcen.bookmall.vo;

public class OrderVo {
	
	//int로 하면 null이 들어가면 안되고
	//integer로 하면 null이 들어감
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	@Override
	public String toString() {
		return "주문 [주문번호=" + orderNumber + ", 사용자번호=" + userNumber + ", 가격=" + price
				+ ", 배송지=" + deliveryAddress + ", 주문상태=" + orderStatus + "]";
	}

	private int orderNumber;
	private int userNumber; 
	private int price;
	private String deliveryAddress;
	private String orderStatus;
	
	
}
