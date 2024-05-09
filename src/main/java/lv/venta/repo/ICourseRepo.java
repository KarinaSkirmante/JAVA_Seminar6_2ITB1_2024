package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Long>{

	//pēc noklusējuma ir public abstract 
	ArrayList<Course> findByGradesStudentIdpe(long id);

	ArrayList<Course> findByProfessorIdpe(long id);
	
	ArrayList<Course> findByCp(int cp);

}
