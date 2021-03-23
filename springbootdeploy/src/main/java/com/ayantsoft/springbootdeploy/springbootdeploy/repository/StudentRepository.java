package com.ayantsoft.springbootdeploy.springbootdeploy.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayantsoft.springbootdeploy.springbootdeploy.model.Student;


/*public interface StudentRepository extends CrudRepository<Student, Long> {

}*/

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>,Serializable {
		
	
	/*@Query("SELECT t.title FROM Todo t where t.id = :id") 
    String findTitleById(@Param("id") Long id);
   */
		@Query("SELECT st.year FROM Student st where st.id <= :id")
		public Iterable<Student>getStudentsLessThanOrEqualParam(@Param("id") Long id);
		
		@Query(value = "CALL getStudentsData", nativeQuery = true)
		public List<Student>getStudents();
		
		
		
}