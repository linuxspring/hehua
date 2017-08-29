package util;

import java.util.ArrayList;

/**
 *
 * @since 2013-11-24
 * @author lwh
 */

public class RolePermission {
	
	private long id;
	
	private ArrayList<RolePermission> children = new ArrayList<RolePermission>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<RolePermission> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<RolePermission> children) {
		this.children = children;
	}
	
	

}
