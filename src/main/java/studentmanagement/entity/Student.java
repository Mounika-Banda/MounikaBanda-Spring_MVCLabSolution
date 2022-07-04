package studentmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity Annotation for Entity Class
@Entity
@Table(name="student")
public class Student {
	
	//Declaration of fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentid;
	private String name;
	private String departement;
	private String country;
	
	//Getter and Setter Methods
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	//Constructor
	public Student() {
		
	}
	
	//Parameterized Constructor
	public Student(String name, String departement, String country) {
		super();
		this.name = name;
		this.departement = departement;
		this.country = country;
	}
	
	//Override toString Method to display all the student details
	@Override
	public String toString() {
		return "Student Details: \nName: "+name+"\nDepartment: "+departement+"\nCountry: "+country;
	}	

}
