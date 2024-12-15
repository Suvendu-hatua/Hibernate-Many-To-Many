package com.spring_boot.hiberate.Hibernate_Many_To_Many.dao;

import com.spring_boot.hiberate.Hibernate_Many_To_Many.entity.Course;
import com.spring_boot.hiberate.Hibernate_Many_To_Many.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImpl implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void addStudentWithCourse(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void addCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findStudentWithFetchCourse(int id) {
        TypedQuery<Student>query =entityManager.createQuery("select s from Student s join fetch s.courses where s.id=:data",Student.class);
        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseWithFetchStudent(int id) {
        TypedQuery<Course>query =entityManager.createQuery("select c from Course c join fetch c.students where c.id=:data",Course.class);
        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course=entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void assignCourseToStudent(int courseId, int studentId) {
        //finding course with courseId
        Course course=entityManager.find(Course.class,courseId);
        //finding student with studentId
        Student student=entityManager.find(Student.class,studentId);

        //adding course to student.
        student.addCourse(course);

        //updating database.
        entityManager.merge(student);

    }
}
