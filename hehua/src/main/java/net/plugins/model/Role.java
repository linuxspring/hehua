package net.plugins.model;

import java.io.Serializable;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
public class Role implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long role_id;
	
	private String role_name;
	
	private String title;
	
	private String description;
	
	@JsonIgnore
	private Collection<User> users;
	
	private Collection<Permission> pmss;
	
	
	public long getRole_id() {
		return role_id;
	}
	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	public Collection<Permission> getPmss() {
		return pmss;
	}
	public void setPmss(Collection<Permission> pmss) {
		this.pmss = pmss;
	}
}
