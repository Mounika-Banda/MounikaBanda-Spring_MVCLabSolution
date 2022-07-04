package studentmanagement.controller;

//Import Packages for Spring MVC Framework
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import studentmanagement.entity.Student;
import studentmanagement.service.StudentService;

// Controller Annotation at the class level
@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired /*spring managed */
	private StudentService studentService;
	
	//Show All Students Data
	@RequestMapping("/list")
	public String findAll(Model model)
	{
		List<Student> studentList=studentService.findAll() ;
		model.addAttribute("students", studentList);
		return "Students";
	}
	
	//Save Students data
	@RequestMapping("/save")
	public String save(@RequestParam("studentid") Integer studentid,@RequestParam("name") String name,@RequestParam("departement") String departement,
			@RequestParam("country") String country)
	{
		Student b=null;
		if(studentid!=-1)
		{
			b=studentService.findById(studentid);
			b.setName(name);
			b.setDepartement(departement);
			b.setCountry(country);
		}
		else
			b=new Student(name, departement, country);
		
		studentService.save(b);
		return "redirect:list";
	}
	
	//Add Student
	@RequestMapping("/addStudent")
	public String addStudent(@RequestParam("studentid") Integer studentid, Model model)
	{
	
		
		if(studentid!=-1)
		{
			Student b=studentService.findById(studentid);
			model.addAttribute("student", b);
		}
		else
		{
			Student b=new Student();
			b.setStudentid(-1);
			model.addAttribute("student", b);
		}
		
		return "StudentForm";
	}
	
	//Delete Student Details
	@RequestMapping("/deleteStudent")
	public String delete(@RequestParam("studentid") Integer studentid)
	{
		Student b=null;
		if(studentid!=-1)
		{
			b=studentService.findById(studentid);
			studentService.delete(b);
		}
		
		return "redirect:list";
	}
	
	
	//Search Student
	
	@RequestMapping("/search")
	public String findByName_Departement(@RequestParam("name")String name, @RequestParam("departement") String departement,Model model)
	{
		List<Student> studentList=studentService.findByName_Departement(name,departement) ;
		System.out.println(studentList);
		if(studentList.size()!=0)
			model.addAttribute("students", studentList);
		else
			model.addAttribute("error", "No Students Found");
		return "Students";
	}
}
