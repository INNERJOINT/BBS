package model;

public class Topic {
	/*	id int(11) NOT NULL AUTO_INCREMENT,
	  topicname varchar(50) NOT NULL,
	  topiccontent varchar(200) NOT NULL,
	  sendtime date NOT NULL,
	  responsetime date NOT NULL,
	  userid int(11) NOT NULL,
	  sortid int(11) NOT NULL,*/
	private int id;
	private String topicname;
	private String topiccontent;
	private String sendtime;
	private String responsetime;
	private int userid;
	private int sortid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTopicname() {
		return topicname;
	}
	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
	public String getTopiccontent() {
		return topiccontent;
	}
	public void setTopiccontent(String topiccontent) {
		this.topiccontent = topiccontent;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}
	public String getResponsetime() {
		return responsetime;
	}
	public void setResponsetime(String responsetime) {
		this.responsetime = responsetime;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getSortid() {
		return sortid;
	}
	public void setSortid(int sortid) {
		this.sortid = sortid;
	}
	
}
