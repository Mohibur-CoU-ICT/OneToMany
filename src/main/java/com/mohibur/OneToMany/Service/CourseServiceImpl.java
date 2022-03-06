package com.mohibur.OneToMany.Service;

import com.mohibur.OneToMany.Entity.Course;
import com.mohibur.OneToMany.Entity.Department;
import com.mohibur.OneToMany.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> createCourses(List<Course> courseList) {
        return (List<Course>) courseRepository.saveAll(courseList);
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course getCourseById(long id) {
        Optional <Course> courseOptional = courseRepository.findById(id);
        Course course;
        if(courseOptional.isPresent()) {
            course = courseOptional.get();
        } else {
            throw new RuntimeException("No course found for id = " + id);
        }
        return course;
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }

}
