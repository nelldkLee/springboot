package com.cafe24.mysite.vo;

public class PageMaker {

	private Criteria cri;
	private int totalCount;
	
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	public PageMaker(Criteria cri, int totalCount) {
		this.cri = cri;
		this.totalCount = totalCount;
		setUp();
	}

	private void setUp() {
	//	startPage = cri.getPage() / cri.getPageViewCount()
	}
}
