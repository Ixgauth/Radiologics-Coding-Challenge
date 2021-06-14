package com.restTest.transfer;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** 
 * Transfer object to be used when an edit of one of the Subjects is required.
 * @author ian
 *
 */
public class SubjectEditTransferObject {

	@NotNull
	@Size(min = 0, message = "Age must be at least 0.")
	private int age;
	
	@NotNull
	@Min(2)
	private String sex;
	
	@NotNull
	@Size(min = 2, message = "Occupation field must have at least 2 characters.")
	private String occupation;
	
	
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
                ", Age='" + age + '\'' +
                ", Sex='" + sex + '\'' +
                ", Occupation='" + occupation + '\'' +
                '}';
	}
}
