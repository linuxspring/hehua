package util;

/**
 *
 * @since 2013-10-18
 * @author lwh
 */

public class Search {
	
	private String eq;
	private String lt;
	private String gt;
	private String le;
	private String ge;
	private String lk;
	private String in;
	
	public Search() {
		super();
	}

	public Search(String eq, String lt, String gt, String le, String ge,
			String lk, String in) {
		super();
		this.eq = eq;
		this.lt = lt;
		this.gt = gt;
		this.le = le;
		this.ge = ge;
		this.lk = lk;
		this.in = in;
	}

	public String getEq() {
		return eq;
	}

	public void setEq(String eq) {
		this.eq = eq;
	}

	public String getLt() {
		return lt;
	}

	public void setLt(String lt) {
		this.lt = lt;
	}

	public String getGt() {
		return gt;
	}

	public void setGt(String gt) {
		this.gt = gt;
	}

	public String getLe() {
		return le;
	}

	public void setLe(String le) {
		this.le = le;
	}

	public String getGe() {
		return ge;
	}

	public void setGe(String ge) {
		this.ge = ge;
	}

	public String getLk() {
		return lk;
	}

	public void setLk(String lk) {
		this.lk = lk;
	}

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}

}
