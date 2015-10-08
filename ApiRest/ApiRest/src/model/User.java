package model;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
public class User implements Serializable{

	private String id;
	private String name;
	private String lastname;
	
	@XmlElement
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement	
	public String getLastname() {
		return lastname;
	}
	
	public User(String id, String name, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}
	
	public User() {
		super();
	}
	
	
	
}
