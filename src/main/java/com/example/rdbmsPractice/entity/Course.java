package com.example.rdbmsPractice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId ;
    private String name ;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinTable(
            name = "CourseWithCourseContent",
            joinColumns = @JoinColumn(
                    name = "courseId",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "courseContent_id",
                    referencedColumnName = "courseContent_id"
            )
    )
    @JsonIgnore
    private Set<CourseContent> courseContents ;

    public Set<CourseContent> getCourseContents() {
        return courseContents;
    }

    public void setCourseContents(Set<CourseContent> courseContents) {
        this.courseContents = courseContents;
    }
    public void addCourse(CourseContent courseContent){
        this.courseContents.add(courseContent);
    }

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
