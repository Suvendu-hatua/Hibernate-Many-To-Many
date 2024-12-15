package com.spring_boot.hiberate.Hibernate_Many_To_Many.dao;

import com.spring_boot.hiberate.Hibernate_Many_To_Many.entity.Course;
import com.spring_boot.hiberate.Hibernate_Many_To_Many.entity.Student;

public interface AppDao {
    public void addStudentWithCourse(Student student);
    public void addCourse(Course course);
    public void addStudent(Student student);
    public Student findStudentWithFetchCourse(int id);
    public Course findCourseWithFetchStudent(int id);
    public void deleteStudentById(int id);
    public void deleteCourseById(int id);
    public void assignCourseToStudent(int courseId,int studentId);
}
