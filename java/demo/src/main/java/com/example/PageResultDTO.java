package com.example;

import java.util.List;

/**
 * 分页结果DTO
 * 
 * @author 刘冬 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
public class PageResultDTO {

	private long total;

	private List<?> rows;

	public PageResultDTO() {
	}

	public PageResultDTO(long total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
