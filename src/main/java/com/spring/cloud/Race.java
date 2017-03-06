package com.spring.cloud;

public class Race 
{
	private String name;
	private String id;
	private String city;
	private String state;
	
	public Race(String name,String id,String city,String state)
	{
		this.name = name;
		this.id = id;
		this.city = city;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Race [name=" + name + ", id=" + id + ", city=" + city + ", state=" + state + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
