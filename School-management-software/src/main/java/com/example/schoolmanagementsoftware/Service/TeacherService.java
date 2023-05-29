package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.ApiException.ApiException;
import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.CourseRepository;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final CourseService courseService;

    public List<Teacher> getAllTeacher() {
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers.isEmpty()) {
            throw new ApiException("do not hava any teacher");
        }
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        System.out.println(teacher.getId());
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("do not have any teacher by this id");

        }
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setName(teacher.getName());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setEmail(teacher.getEmail());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null) {
            throw new ApiException("do not have any teacher by this id");

        }
        List<Course> courses = courseRepository.findAllCourseForTeacher(id);
        for (int i = 0; i < teacher.getCourse().size(); i++) {
            courses.get(i).setTeacher(null);
        }

        teacherRepository.delete(teacher);
    }

    public Address teacherDetails(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("not have any teacher by this id");
        }
        if (teacher.getAddress() == null) {
            throw new ApiException("the teacher not has address");
        }
        Address address = teacher.getAddress();
        return address;
    }


}
