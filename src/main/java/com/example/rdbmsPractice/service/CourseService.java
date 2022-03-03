package com.example.rdbmsPractice.service;

import com.example.rdbmsPractice.entity.Course;
import com.example.rdbmsPractice.entity.CourseContent;
import com.example.rdbmsPractice.pojos.CourseRequest;
import com.example.rdbmsPractice.repository.CourseContentRepo;
import com.example.rdbmsPractice.repository.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepo courseRepo ;
    private final CourseContentRepo courseContentRepo ;

    public CourseService(CourseRepo courseRepo, CourseContentRepo courseContentRepo) {
        this.courseRepo = courseRepo;
        this.courseContentRepo = courseContentRepo;
    }



    public Course addCourse(CourseRequest courseRequest){
        Course newCourse = new Course();
        newCourse.setName(courseRequest.courseName);
        newCourse.setCourseContents(
                courseRequest.courseContents.stream().map(
                       courseContent->{
                           CourseContent eachCourseContent = courseContent;
                           if(eachCourseContent.getCourseContentId() >0){
                               eachCourseContent = courseContentRepo.findById(eachCourseContent.getCourseContentId());
                           }
                           eachCourseContent.addCourse(newCourse);
                            return eachCourseContent ;
                       }

                ).collect(Collectors.toSet()));


        return courseRepo.save(newCourse);
    }
}
