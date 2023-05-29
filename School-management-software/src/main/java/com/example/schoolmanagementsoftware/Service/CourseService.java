package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.ApiException.ApiException;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.CourseRepository;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Course> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        if (courses.isEmpty()) {
            throw new ApiException("not have any course");
        }
        return courses;
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course) {
        Course oldCourse = courseRepository.findCourseById(id);
        if (oldCourse == null) {
            throw new ApiException("do not have any course by this id");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            throw new ApiException("do not have any course by this id");
        }
        courseRepository.delete(course);
    }

    public void assignTeacherToCourse(Integer idTeacher, Integer idCourse) {
        Teacher teacher = teacherRepository.findTeacherById(idTeacher);
        Course course = courseRepository.findCourseById(idCourse);
        if (teacher == null || course == null) {
            throw new ApiException("id wrong , can not assign teacher to course");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }


    public String whoTeacherForCourse(Integer idCourse) {
        Course course = courseRepository.findCourseById(idCourse);
        if (course == null) {
            throw new ApiException("id wrong do not have any course by this id");
        }
        if (course.getTeacher() == null) {
            throw new ApiException("this course not assign for any teacher");
        }

        return course.getTeacher().getName();
    }


}
