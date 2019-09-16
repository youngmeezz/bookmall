package kr.co.itcen.bookmall.vo;

public class OrderVo {
	
	//int로 하면 null이 들어가면 안되고
	//integer로 하면 null이 들어감
	


	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", payment=" + payment + ", deliveryAddress=" + deliveryAddress + ", userNo="
				+ userNo + "]";
	}

	private Long no;
	private int payment;
	private String deliveryAddress;
	private int userNo;
	
	
	
}
