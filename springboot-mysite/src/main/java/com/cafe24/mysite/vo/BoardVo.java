package com.cafe24.mysite.vo;

public class BoardVo {
	
	private Integer no;
	private Integer userNo;
	private String userName;
	private String title;
	private String contents;
	private Integer hit;
	private String regDate;
	private Integer groupNo;
	private Integer orderNo;
	private Integer depth;
	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Integer getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(Integer groupNo) {
		this.groupNo = groupNo;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", userNo=" + userNo + ", userName=" + userName + ", title=" + title
				+ ", contents=" + contents + ", hit=" + hit + ", regDate=" + regDate + ", groupNo=" + groupNo
				+ ", orderNo=" + orderNo + ", depth=" + depth + "]";
	}
	public String urlBuilder() {
		return "?groupNo=" + groupNo + "&orderNo=" + orderNo + "&depth=" + depth;
	}
	public Integer getOrderNoPlus() {
		return orderNo + 1;
	}
	public Integer getDepthPlus() {
		return depth + 1;
	}
}
