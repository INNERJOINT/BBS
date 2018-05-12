package model;

public class Response {
	/* id int(11) NOT NULL AUTO_INCREMENT,
	 ______delected___ respname varchar(30) NOT NULL,
	  respcontent varchar(50) NOT NULL,
	  userid int(11) NOT NULL,
	  sendtime date NOT NULL,
	  topicid int(11) NOT NULL,*/
	private int id;
	private int userid;
	private int topicid;
	private String respcontent;
	private String sendtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public String getRespcontent() {
		return respcontent;
	}
	public void setRespcontent(String respcontent) {
		this.respcontent = respcontent;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	
	
}
