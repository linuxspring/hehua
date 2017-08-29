package util;

import java.io.Serializable;

/**
 *
 * @since 2013-9-30
 * @author lwh
 */

public class Message implements Serializable{
	
	private String msg = "操作失败";
	
	private MsgType type = MsgType.error;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MsgType getType() {
		return type;
	}

	public void setType(MsgType type) {
		this.type = type;
	}
	
	
	public void set(MsgType type, String msg){
		if(type != null)
			setType(type);
		
		if(msg != null){
			setMsg(msg);
		}
	}
	
	public void success(){
		setType(MsgType.success);
		setMsg("操作成功");
	}
	
	public void error(){
		setType(MsgType.error);
		setMsg("操作失败");
	}
	
	public void error(String msg){
		setType(MsgType.error);
		setMsg(msg);
	}
	
	public void msg(String msg){
		setMsg(msg);
	}
	
}

