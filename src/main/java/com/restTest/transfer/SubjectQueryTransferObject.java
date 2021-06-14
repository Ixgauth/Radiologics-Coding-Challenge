package com.restTest.transfer;

import java.util.UUID;

/**
 * Transfer object to be returned when a query of the database is called for.
 * @author ian
 *
 */
public class SubjectQueryTransferObject {

	private UUID id;
	private String name;
	private int age;
	private String sex;
	private String occupation;
	
	public SubjectQueryTransferObject(UUID id, String name, int age, String sex, String occupation) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.occupation = occupation;
	}
	
	public UUID getid()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getSex()
	{
		return sex;
	}
	
	public String getOccupation()
	{
		return occupation;
	}
	
	@Override
	public String toString() 
	{
		return "SubjectQueryTransferObject{ " +
				"id=" + id +
                ", Name='" + name + '\'' +
                ", Age='" + age + '\'' +
                ", Sex='" + sex + '\'' +
                ", Occupation='" + occupation + '\'' +
                '}';
	}
	
}
