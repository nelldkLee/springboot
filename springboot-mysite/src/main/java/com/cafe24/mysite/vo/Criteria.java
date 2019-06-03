package com.cafe24.mysite.vo;

public class Criteria {

	private int page;
	private String type;
	private String keyword;
	private int pagePerCount;
	private int pageViewCount;
	
	public Criteria() {
		page = 1;
		pagePerCount = 10;
		pageViewCount = 5;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if( page < 0) {
			page = 1;
		}
		this.page = page;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPagePerCount() {
		return pagePerCount;
	}

	public void setPagePerCount(int pagePerCount) {
		if(pagePerCount < 0 || pagePerCount > 20) {
			pagePerCount = 10;
		}
		this.pagePerCount = pagePerCount;
	}

	public double getPageViewCount() {
		return pageViewCount;
	}

	public void setPageViewCount(int pageViewCount) {
		if(pageViewCount < 0 || pageViewCount > 15) {
			pageViewCount = 10;
		}
		this.pageViewCount = pageViewCount;
	}
	
}
