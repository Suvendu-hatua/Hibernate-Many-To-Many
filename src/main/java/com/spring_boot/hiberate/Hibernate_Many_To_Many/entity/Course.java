package com.spring_boot.hiberate.Hibernate_Many_To_Many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "price",nullable = false)
    private float price;

    @Column(name = "no_enrollments")
    private long duration;

    //adding many-to-many relationship--->
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "student-course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
    //Constructor
    public Course() {
    }

    public Course(String title, float price,long duration) {
        this.title = title;
        this.price = price;
        this.duration=duration;
    }
//Setter and getter methods()

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    //Adding dedicated method to add Student
    public  void addStudent(Student student){
        if(students==null){
            students=new ArrayList<>();
        }
        students.add(student);
    }
    //toString() method--->

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                '}';
    }
}
