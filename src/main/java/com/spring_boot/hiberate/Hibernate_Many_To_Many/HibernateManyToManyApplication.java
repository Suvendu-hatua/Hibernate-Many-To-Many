package com.spring_boot.hiberate.Hibernate_Many_To_Many;

import com.spring_boot.hiberate.Hibernate_Many_To_Many.dao.AppDao;
import com.spring_boot.hiberate.Hibernate_Many_To_Many.entity.Course;
import com.spring_boot.hiberate.Hibernate_Many_To_Many.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateManyToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateManyToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao dao){
		return runner->{
//			addStudentWithCourses(dao);
//			addCourse(dao);
//			addStudent(dao);
//			assignCourseToStudent(dao);
			deleteCourseById(dao);
		};
	}

	private void deleteCourseById(AppDao dao) {
		int courseId=1;
		dao.deleteCourseById(courseId);
		System.out.println("Done!!");
	}

	private void assignCourseToStudent(AppDao dao) {
		int courseId=4;
		int studentId=2;
		System.out.println("Adding course to Student....");
		dao.assignCourseToStudent(courseId,studentId);
		System.out.println("Done!!!");
	}

	private void addStudent(AppDao dao) {
		Student student=new Student("Sonali","Samanta","samanta@gmail.com");
		System.out.println("Saving Student into DB....");
		dao.addStudent(student);
	}

	private void addCourse(AppDao dao) {
		Course course=new Course("Angular Course",3999.99f,20);
		System.out.println("Saving course intoDB....");
		dao.addCourse(course);
		System.out.println("Done!!!");
	}

	private void addStudentWithCourses(AppDao dao) {
		//creating student instance
		Student student=new Student("Suvendu","Hatua","suvendu@gmail.com");
		//creating course instances.
		Course course1=new Course("Angular Course",5999.99f,30);
		Course course2=new Course("Computer Networks",3499.99f,25);
		Course course3=new Course("System Design",9999.99f,30);
		//Adding courses to student instance.
		student.addCourse(course1);
		student.addCourse(course2);
		student.addCourse(course3);

		//saving student instance ot DB.
		System.out.println("Saving Student instance ......");
		dao.addStudentWithCourse(student);
		System.out.println("done!!!");
	}
}
