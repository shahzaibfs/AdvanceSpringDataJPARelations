package com.example.rdbmsPractice.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CourseContent")
public class CourseContent {

    @Id
    @Column(name = "courseContent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseContentId ;

    @Column(name = "courseContentName")
    private String courseContentName ;

    @ManyToMany(mappedBy = "courseContents")
    private Set<Course> courses = new HashSet<>();

    public CourseContent(String courseContentName) {
        this.courseContentName = courseContentName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public CourseContent() {
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public int getCourseContentId() {
        return courseContentId;
    }

    public void setCourseContentId(int courseContentId) {
        this.courseContentId = courseContentId;
    }

    public String getCourseContentName() {
        return courseContentName;
    }

    public void setCourseContentName(String courseContentName) {
        this.courseContentName = courseContentName;
    }
}
