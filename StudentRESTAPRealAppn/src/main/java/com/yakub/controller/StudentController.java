package com.yakub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yakub.model.Student;
import com.yakub.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService stdService;

	@PostMapping("/save")
	public String save(@RequestBody Student std)
	{
		Student ss=stdService.saveStudent(std);
		String message = null;
		if (ss!= null) {
			message = "Student saved successfully in DataBase";
		}
		else 
		{
			message = "Student not save in Database";
		}
		return message; 
	}

	@DeleteMapping("/delete/{sid}")
	public void delete(@PathVariable Integer sid)
	{
		stdService.deleteStudent(sid);
	}
	@GetMapping("/get/{sid}")
	public Student getOne(@PathVariable Integer sid)
	{
		Student s2=stdService.getStudent(sid);
		return s2;
	}

	@GetMapping("/getAll")
	public List<Student> getAll() {

		List<Student> students=stdService.getAllStudent();
		return students;

	}

	@PutMapping("/update/{sid}")
	public Student updateStudent(@RequestBody Student student,
			@PathVariable Integer sid) 
	{
		return stdService.updateStudent(student, sid);   // save for update record                         
	}
	
}


