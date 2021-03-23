package com.ayantsoft.springbootdeploy.springbootdeploy.serviceImpl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayantsoft.springbootdeploy.springbootdeploy.exception.ResourceNotFoundException;
import com.ayantsoft.springbootdeploy.springbootdeploy.model.Roles;
import com.ayantsoft.springbootdeploy.springbootdeploy.model.Student;
import com.ayantsoft.springbootdeploy.springbootdeploy.model.User;
import com.ayantsoft.springbootdeploy.springbootdeploy.repository.AddressRepository;
import com.ayantsoft.springbootdeploy.springbootdeploy.repository.StudentRepository;
import com.ayantsoft.springbootdeploy.springbootdeploy.repository.UserRepository;
import com.ayantsoft.springbootdeploy.springbootdeploy.service.UserService;

@Service
public class UserServiceImpl implements UserService,Serializable {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7291413829286621667L;

	@Override
	public Set<Roles> getRoles(Long userId) {
		Optional<User> usrObj1=userRepository.findById(userId);
		User usr1=usrObj1.get();
		Set<Roles>roles=usr1.getRoles();
		
		return roles;

	}

	@Override
	@Transactional
	public Student saveStudent(Student st) {
		
		addressRepository.save(st.getAddress());	
		studentRepository.findById(new Long(66)).orElseThrow(ResourceNotFoundException::new);
		
		return studentRepository.save(st);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	/*@Override
	public List<Student> getCriteria() {
		// TODO Auto-generated method stub
		
		  Criteria crit = ((Criteria) em).createCriteria(Student.class);
	         crit.add(Restrictions.eq("name","somnath"));
	         List<Student> students = crit.list();
	  
		
		
	}*/
	

}
