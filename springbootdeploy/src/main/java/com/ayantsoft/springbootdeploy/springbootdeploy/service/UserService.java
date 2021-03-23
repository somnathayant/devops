package com.ayantsoft.springbootdeploy.springbootdeploy.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.ayantsoft.springbootdeploy.springbootdeploy.model.Roles;
import com.ayantsoft.springbootdeploy.springbootdeploy.model.Student;

public interface UserService extends Serializable{
				
	public Set<Roles> getRoles(Long UserId);
	public Student saveStudent(Student st);
	public List<Student>getStudents();
	//public List<Student>getCriteria();
}
