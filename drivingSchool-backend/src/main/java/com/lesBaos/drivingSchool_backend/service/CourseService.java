package com.lesBaos.drivingSchool_backend.service;

import com.lesBaos.drivingSchool_backend.data.Course;
import com.lesBaos.drivingSchool_backend.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    public CourseDTO createCourse(CourseDTO courseDTO);
    public Course updateCourse(Long id, Course course);
    public void deleteCourse(Long id);
    public Course findCourseById(Long id);
    public List<Course> findAllCourses();
}
