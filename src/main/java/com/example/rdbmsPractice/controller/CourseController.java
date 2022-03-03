package com.example.rdbmsPractice.controller;


import com.example.rdbmsPractice.entity.Course;
import com.example.rdbmsPractice.pojos.CourseRequest;
import com.example.rdbmsPractice.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/addCourse")
    public Course  addCourse(@RequestBody CourseRequest courseRequest){
        System.out.println(courseRequest.courseContents.toString());
        return courseService.addCourse(courseRequest);
    }
}
