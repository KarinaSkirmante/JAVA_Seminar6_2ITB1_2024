package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class Seminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar6Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testDabaseLayer(IStudentRepo studRepo, 
			IProfessorRepo profRepo, ICourseRepo courseRepo,
			IGradeRepo grRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				//TODO
				//pielikt vel vienu pansiedzeju Arturu Orbidānu
				//pielikt Datu Struktūras Karinai Sķirmantei
				//Noamianīt LAN uz Operētājsistēmām
				//piesaistīt Operētājsistēmā gan Naktiņu, gan Orbidānu
				//palaists sistemu un apskatīties h2-consolē, vai ir starptabula
				
				
				Professor pr1 = new Professor("Marcis", "Naktins", Degree.mg);
				Professor pr2 = new Professor("Karina", "Skirmante", Degree.mg);
				Professor pr3 = new Professor("Arturs", "Orbidans", Degree.mg);
				profRepo.save(pr1);
				profRepo.save(pr2);
				profRepo.save(pr3);

				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Liga", "Jauka");
				studRepo.save(st1);
				studRepo.save(st2);

				Course c1 = new Course("Programesana timekli JAVA", 4, pr2);
				Course c2 = new Course("Operetajsistemas", 2, pr1, pr3);
				Course c3 = new Course("Datu strukturas", 2, pr2);
				courseRepo.save(c1);
				courseRepo.save(c2);
				courseRepo.save(c3);
				
				pr2.addCourse(c1);//Karinai piesaistām JAVA
				pr2.addCourse(c3);//Karinai piesaistām DataSTR
				profRepo.save(pr2);
				
				pr1.addCourse(c2);//Naktiņam piesaistām Opersis
				profRepo.save(pr1);
				
				pr3.addCourse(c2);//Orbidānam piesaistam Opersis
				profRepo.save(pr3);
				
				
				
				grRepo.save(new Grade(st1, c1, 8));//Janis nopelnīja 8 JAVA
				grRepo.save(new Grade(st1, c2, 3));//Janis nopelnīja 3 LAN
				grRepo.save(new Grade(st2, c1, 9));//Liga nopelnīja 9 JAVA
				grRepo.save(new Grade(st2, c2, 4));//Liga nopelnīja 4 LAN
				
				//TODO uztaisīt servisu ar sekojošu funkcionalitāti
				//selectGradesByStudent() - return all grades of specific student;
				//selectCoursesByStudent() - return all courses where specific student is
				//involved;
				//selectCoursesByProfessor() - return all courses of specific professor;
				//calculateAVGGradeInCourse() - return average grade in specific course;
				
			}
		};
	}

}
