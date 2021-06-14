package com.restTest.transfer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Transfer object to be created and sent into the system when a new Subject is requested.
 * @author ian
 *
 */
public class SubjectCreateTransferObject {

	@NotNull
	@Size(min = 2, message = "Name field must contain at least 2 characters.")
	private String name;
	
	@NotNull
	@Min(0)
	private int age;
	
	@NotNull
	@Size(min = 2, message = "Sex field must include at least two characters.")
	private String sex;
	
	@NotNull
	@Size(min = 2, message = "Occupation field must have at least 2 characters.")
	private String occupation;
	
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
		return "SubjectEditTransferObject{ " +
                ", Name='" + name + '\'' +
                ", Age='" + age + '\'' +
                ", Sex='" + sex + '\'' +
                ", Occupation='" + occupation + '\'' +
                '}';
	}
}
