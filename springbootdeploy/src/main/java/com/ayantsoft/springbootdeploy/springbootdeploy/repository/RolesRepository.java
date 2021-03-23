package com.ayantsoft.springbootdeploy.springbootdeploy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayantsoft.springbootdeploy.springbootdeploy.model.Roles;
import com.ayantsoft.springbootdeploy.springbootdeploy.model.Student;


public interface RolesRepository extends JpaRepository<Roles, Long>,Serializable {
	
	
/*@Query("SELECT t.title FROM Todo t where t.id = :id") 
String findTitleById(@Param("id") Long id);
*/
	@Query("SELECT st.year FROM Student st where st.id <= :id")
	public Iterable<Student>getStudentsLessThanOrEqualParam(@Param("id") Long id);
}