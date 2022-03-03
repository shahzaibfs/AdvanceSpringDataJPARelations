package com.example.rdbmsPractice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId ;
    private String name ;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER

    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses ;



    @ManyToOne()
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "roleId"
    )
    private Role role ;

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher() {
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public void setOneCourse(Course course) {
        this.courses.add(course);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
