package com.mohibur.OneToMany.Repository;

import com.mohibur.OneToMany.Entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
