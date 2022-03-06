package com.mohibur.OneToMany.Controller;

import com.mohibur.OneToMany.Entity.Course;
import com.mohibur.OneToMany.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/create")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PostMapping(value = "/create/many")
    public List<Course> createCourses(@RequestBody List<Course> courseList) {
        return courseService.createCourses(courseList);
    }

    @GetMapping(value = "/{id}")
    public Course getCourseById(@PathVariable("id") long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping(value = "")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping(value = "/update/{id}")
    public Course updateCourse(@PathVariable("id") long id, @RequestBody Course course) {
        Course course1 = courseService.getCourseById(id);

        if(course.getCourseTitle() != null) course1.setCourseTitle(course.getCourseTitle());
        if(course.getCourseCode() != null)  course1.setCourseCode(course.getCourseCode());
        if(course.getTheoryCredit() != null) course1.setTheoryCredit(course.getTheoryCredit());
        if(course.getLabCredit() != null)   course1.setLabCredit(course.getLabCredit());

        return courseService.createCourse(course1);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCourse(@PathVariable("id") long id) {
        courseService.deleteCourse(id);
    }

    @DeleteMapping(value = "/delete/all")
    public void deleteAllCourses() {
        courseService.deleteAllCourses();
    }
}
