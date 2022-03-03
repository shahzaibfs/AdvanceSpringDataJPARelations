package com.example.rdbmsPractice.pojos;

//pojos for requests

import com.example.rdbmsPractice.entity.CourseContent;

import java.util.Set;

public class CourseRequest {

    public int courseId ;

    public String courseName ;

    public Set<CourseContent> courseContents ;

}
