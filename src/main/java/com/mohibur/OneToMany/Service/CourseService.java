package com.mohibur.OneToMany.Service;

import com.mohibur.OneToMany.Entity.Course;
import com.mohibur.OneToMany.Entity.Department;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> createCourses(List<Course> courseList);
    List<Course> getAllCourses();
    Course getCourseById(long id);
    void deleteCourse(long id);
    void deleteAllCourses();
}
