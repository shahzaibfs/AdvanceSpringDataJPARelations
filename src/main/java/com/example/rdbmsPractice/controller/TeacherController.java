package com.example.rdbmsPractice.controller;


import com.example.rdbmsPractice.entity.Course;
import com.example.rdbmsPractice.entity.Teacher;
import com.example.rdbmsPractice.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    private final TeacherService teacherService ;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/teacher/new")
    public Teacher saveTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @PutMapping("/teacher/{teacherId}/newCourse")
    public Teacher saveTeacherCourse(@PathVariable(value = "teacherId") int teacherId , @RequestBody Course course){
        System.out.println(teacherId);
        return teacherService.saveTeacherCourse(teacherId,course);
    }

    @PutMapping("/teacher/{teacherId}/newCourses")
    public Teacher saveTeacherCourse(@PathVariable(value = "teacherId") int teacherId , @RequestBody List<Course> courses){

        return teacherService.saveTeacherCourses(teacherId,courses);
    }

    @GetMapping("/teachers")
    public List<Teacher> findAllTeachers(){
        return teacherService.findAllTeachers();
    }
    @GetMapping("/teacher/{teacherId}")
    public Teacher findAllTeachers(@PathVariable(value = "teacherId") int teacherId){
        return teacherService.findById(teacherId);
    }

    @DeleteMapping("/teacher/remove/{teacherId}")
    public String removeTeacherById(@PathVariable(value = "teacherId") int teacherId){
        return teacherService.DeleteById(teacherId);
    }

    @PutMapping("/teacher/update/{teacherId}")
    public Teacher updateTeacher(@PathVariable(value = "teacherId") int teacherId , @RequestBody Teacher teacher){
        return teacherService.updateTeacher(teacherId,teacher);
    }
}
