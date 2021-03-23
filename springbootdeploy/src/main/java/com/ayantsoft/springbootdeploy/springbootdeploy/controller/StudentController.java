package com.ayantsoft.springbootdeploy.springbootdeploy.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ayantsoft.springbootdeploy.springbootdeploy.dto.StudentDto;
import com.ayantsoft.springbootdeploy.springbootdeploy.exception.InvalidInputException;
import com.ayantsoft.springbootdeploy.springbootdeploy.exception.ResourceNotFoundException;
import com.ayantsoft.springbootdeploy.springbootdeploy.model.Address;
import com.ayantsoft.springbootdeploy.springbootdeploy.model.Roles;
import com.ayantsoft.springbootdeploy.springbootdeploy.model.Student;
import com.ayantsoft.springbootdeploy.springbootdeploy.model.User;
import com.ayantsoft.springbootdeploy.springbootdeploy.repository.StudentRepository;
import com.ayantsoft.springbootdeploy.springbootdeploy.service.UserService;



@RestController
@RequestMapping(path="/students")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/saveStudentOnAdvice")
	public Student addStudentOnAdvice(@RequestBody StudentDto student) {
		Address ad=new Address();
		Student st=new Student();
		
		ad.setCity(student.getCity());
		
		st.setFirstName(student.getFirstName());
		st.setId(student.getId());
		st.setAddress(ad);
		
		return userService.saveStudent(st);
	}
	
	
	
	@PostMapping("saveStudent")
	public Student addStudent(@RequestBody Student student) {
		return userService.saveStudent(student);
	}
	
	
	@GetMapping("students")
	public List<Student> getStudents() {
		
		StudentDto st=new StudentDto();
		List<Student> stu=new ArrayList();
		
		stu= userService.getStudents();
		
		return stu;
		
	}
	
	@GetMapping("/find")
	public Student getStudentOnAdvice() {
		Long id=(long) 66;
		if(id==null) {
			throw new InvalidInputException("Invalid Input");
		}
		return studentRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
		//return userService.findById(id).orElseThrow(StudentNotFoundException::new);
	}
	
	@GetMapping("/getStudentsFromStoreProc")
	public List<Student> getStudentsFromStoreProc() {
		List<Student>stList=(List<Student>) studentRepository.getStudents();
			return  stList;
		//return userService.findById(id).orElseThrow(StudentNotFoundException::new);
	}
	
/*	
		@GetMapping("/")
	public String pingController() {
		return "server running";
	}

	@GetMapping("students")
	public Iterable<Student> getStudents() {
		//return repository.findAll();
	}	

	@GetMapping("{id}")
	public Student getStudent(@PathVariable Long id) {
		//return repository.findById(id).orElseThrow(StudentNotFoundException::new);
	}

	@PostMapping("saveStudent")
	public Student addStudent(@RequestBody Student student) {
		return repository.save(student);
	}

	@PutMapping("updateStudent/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student studentToUpdate = repository.findById(id).orElseThrow(StudentNotFoundException::new);

		studentToUpdate.setFirstName(student.getFirstName());
		studentToUpdate.setLastName(student.getLastName());
		studentToUpdate.setYear(student.getYear());
		 
		return repository.save(studentToUpdate);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		repository.findById(id).orElseThrow(StudentNotFoundException::new);
		repository.deleteById(id);
	}
	@RequestMapping(value="/file",headers=("content-type=multipart/*"),method=RequestMethod.POST)//http://localhost:8082/corsRestForAng4/saveFile
	//@PostMapping("/file",headers=("content-type=multipart/*"))
	public void uploadFile(@RequestParam("file") MultipartFile file) {
		System.out.println(file.getSize());
	}

	@GetMapping("/getStudentsLessThanOrEqualParam/{id}")
	public Iterable<Student> getStudentsLessThanOrEqualParam(@PathVariable Long id) {
		return repository.getStudentsLessThanOrEqualParam(id);
	}	

	//multi table operation 

	@PostMapping("/saveStudent/multi")
	public void saveStudent(@RequestBody Student student) {

		//deptRepo.save(student.getDept());	
		addRepo.save(student.getAddress());
		repository.save(student);

	}
	@PostMapping("/saveUser/multi")
	public void saveUser(@RequestBody User user) {
				userRepo.save(user);
		
	}
*/	
	@GetMapping("/getRoles")
	public ResponseEntity<?>getRoles(@RequestParam("userId") Long userId) {
		Set<Roles>roles=userService.getRoles(userId);
		return new ResponseEntity<Set<Roles>>(roles,HttpStatus.OK);	
		
	}



}
