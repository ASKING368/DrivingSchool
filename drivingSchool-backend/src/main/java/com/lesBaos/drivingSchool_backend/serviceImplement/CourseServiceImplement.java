package com.lesBaos.drivingSchool_backend.serviceImplement;

import com.lesBaos.drivingSchool_backend.dao.CourseRepository;
import com.lesBaos.drivingSchool_backend.data.Course;
import com.lesBaos.drivingSchool_backend.dto.CourseDTO;
import com.lesBaos.drivingSchool_backend.mappers.Mappers;
import com.lesBaos.drivingSchool_backend.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class CourseServiceImplement implements CourseService {
    private final CourseRepository courseRepository;
    private final Mappers mappers;

    public CourseServiceImplement(CourseRepository courseRepository, Mappers mappers) {

        this.courseRepository = courseRepository;
        this.mappers = mappers;
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = mappers.fromCourseDTO(courseDTO);
        return mappers.fromCourse(courseRepository.save(course));
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course course1 = findCourseById(id);
        course1.setName(course.getName());
        course1.setInstructorName(course.getInstructorName());
        course1.setDate(course.getDate());
        course1.setLocation(course.getLocation());
        course1.setTypeCourse(course.getTypeCourse());
        return courseRepository.save(course1);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = findCourseById(id);
        courseRepository.delete(course);
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Course with id %s not found", id))
        );
    }

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }
}
