package com.yakub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakub.model.Student;
import com.yakub.repo.StudentRepo;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentRepo stdRepo;

	@Override
	public Student saveStudent(Student student) {

		Student s1=stdRepo.save(student);
		return s1;
	}

	@Override
	public void deleteStudent(Integer stdId) {

		stdRepo.deleteById(stdId);
	}
	
	@Override
	public Student getStudent(Integer stdId) {
		Student s2=stdRepo.findById(stdId).get();
		return s2;
	}

	@Override
	public List<Student> getAllStudent() {
		
		List<Student> studentList=stdRepo.findAll();
		return studentList;
	
	}
	
	@Override
	public Student updateStudent(Student student,Integer sid) {
		Optional<Student> optional=stdRepo.findById(sid);
		Student student1=optional.get();
		student1.setStdId(sid);
		student1.setStdName(student.getStdName());
		student1.setCourse(student.getCourse());
		student1.setFee(student.getFee());
		return stdRepo.save(student1); 
	}


	
	

}
