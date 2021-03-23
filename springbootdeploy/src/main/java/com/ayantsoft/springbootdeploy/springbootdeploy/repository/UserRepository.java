package com.ayantsoft.springbootdeploy.springbootdeploy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayantsoft.springbootdeploy.springbootdeploy.model.Student;
import com.ayantsoft.springbootdeploy.springbootdeploy.model.User;


public interface UserRepository extends JpaRepository<User, Long>,Serializable{
			
	User findByUsername(String username);
	
	@Query("SELECT st.year FROM Student st where st.id<=:id")
	public Iterable<Student>getStudentsLessThanOrEqualParam(@Param("id") Long id);

}
