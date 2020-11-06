package org.web.guestbook.dto;

import java.sql.Timestamp;

public class Guestbook {
	private Long id;
    private String name;
    private String content;
    private Timestamp regdate;
    
    public Guestbook(Long id, String name, String content, Timestamp regdate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.regdate = regdate;
    }

    public Guestbook(String name, String content) {
        this.name = name;
        this.content = content;
        this.regdate = new Timestamp(System.currentTimeMillis());
    }
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Guestbook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", regdate=" + regdate +
                '}';
	}
}
