package org.chaofei.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {

	private static final long serialVersionUID = -7652074771918759408L;
	private Integer	id;
	private String name;
	private Integer age;
	private byte[] image;
	private String description;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", image=" + Arrays.toString(image)
				+ ", description=" + description + "]";
	}
}
