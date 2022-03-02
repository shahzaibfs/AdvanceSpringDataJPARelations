package com.example.rdbmsPractice.service;


import com.example.rdbmsPractice.entity.Course;
import com.example.rdbmsPractice.entity.Teacher;
import com.example.rdbmsPractice.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TeacherService {
    private TeacherRepo teacherRepo ;
    @Autowired
    TeacherService(TeacherRepo teacherRepo){
        this.teacherRepo = teacherRepo;
    }

    public Teacher saveTeacher(Teacher teacher ){

        return teacherRepo.save(teacher);

    }


    public Teacher saveTeacherCourse(int teacherId , Course course){
        Teacher teacher = teacherRepo.findById(teacherId) ;
        if(teacher != null){
            teacher.setOneCourse(course);

            return teacherRepo.save(teacher);
        }
        return new Teacher("null");
    }


    public Teacher saveTeacherCourses(int teacherId , List<Course> courses){
        Teacher teacher = teacherRepo.findById(teacherId) ;
        if(teacher != null){
            teacher.getCourses().addAll(courses);

            return teacherRepo.save(teacher);
        }
        return new Teacher("not found ");
    }

    public List<Teacher> findAllTeachers(){

        return teacherRepo.findAll();
    }

    public Teacher findById(int id){

        return teacherRepo.findById(id);
    }

    public String DeleteById(int id){
        try{
            teacherRepo.deleteById(id);
            return "deleted succesfully";
        }catch(Exception e){
            return e.toString();
        }

    }

    public Teacher updateTeacher(int teacherId , Teacher teacher){
        Teacher existingTeacher = teacherRepo.findById(teacherId);
        if(existingTeacher != null){

            existingTeacher.setCourses(teacher.getCourses());
            existingTeacher.setName(teacher.getName());
            existingTeacher.setRole(teacher.getRole());
            return teacherRepo.save(existingTeacher);
        }
        return new Teacher("not found teacher");
    }

}
