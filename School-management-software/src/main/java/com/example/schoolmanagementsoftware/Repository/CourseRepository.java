package com.example.schoolmanagementsoftware.Repository;

import com.example.schoolmanagementsoftware.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);

    @Query("SELECT courses from Course courses where courses.teacher.id=?1")
    List<Course> findAllCourseForTeacher(Integer idTeacher);

}
