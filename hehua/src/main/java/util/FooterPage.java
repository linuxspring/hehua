package util;

import java.util.List;

/**
 *
 * @since 2013-10-27
 * @author lwh
 */

public class FooterPage<T> extends Page<T> {
	
	private List<Object> footer;

	public FooterPage(long total, List<T> rows, List<Object> footer) {
		super(total, rows);
		this.footer = footer;
	}

	public List getFooter() {
		return footer;
	}

	public void setFooter(List footer) {
		this.footer = footer;
	}
	

}
