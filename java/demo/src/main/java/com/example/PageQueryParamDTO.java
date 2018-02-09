package com.example;

/**
 * 分页查询参数DTO
 * 
 * @author 刘冬 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
public class PageQueryParamDTO {

	/**
	 * 页码
	 */
	private int page;

	/**
	 * 每页数量
	 */
	private int size;

	/**
	 * 查询条件
	 */
	private Object query;

	public PageQueryParamDTO() {
	}

	public PageQueryParamDTO(int page, int size, Object query) {
		this.page = page;
		this.size = size;
		this.query = query;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Object getQuery() {
		return query;
	}

	public void setQuery(Object query) {
		this.query = query;
	}

}
