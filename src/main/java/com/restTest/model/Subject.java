package com.restTest.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class definition of the subject as comprising an id, name, age, sex, and occupation.
 * @author ian
 *
 */
@Entity
@Table(name = "subject")
public class Subject {

	@Id
	private UUID id;
	private String name;
	private int age;
	private String sex;
	private String occupation;
	
	public Subject() {
		
	}
	
	public UUID getid()
	{
		return id;
	}
	
	public void setId(UUID id) 
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String getSex()
	{
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getOccupation()
	{
		return occupation;
	}
	
	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}
	
	@Override
	public String toString() 
	{
		return "Subject{ " +
				"id=" + id +
                ", Name='" + name + '\'' +
                ", Age='" + age + '\'' +
                ", Sex='" + sex + '\'' +
                ", Occupation='" + occupation + '\'' +
                '}';
	}
}
