package net.util;

import java.util.List;

/**
 *
 * @since 2013-10-2
 * @author lwh
 */

public class Page<T> {
	
	
	private long total;
	
	private List<T> rows;

	public Page(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	

}
