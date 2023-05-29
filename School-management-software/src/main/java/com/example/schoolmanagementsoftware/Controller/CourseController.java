package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Model.Course;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Service.CourseService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity getAllCourse() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("done add Course");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @Valid @RequestBody Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body("done updated Course");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("done deleted Course");
    }

    @PutMapping("/assign/{idTeacher}/{idCourse}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer idTeacher, @PathVariable Integer idCourse) {
        courseService.assignTeacherToCourse(idTeacher, idCourse);
        return ResponseEntity.status(200).body("done assign");

    }

    @GetMapping("/get-teacher-for-course/{idCourse}")
    public ResponseEntity whoTeacherForCourse(@PathVariable Integer idCourse) {
        String name = courseService.whoTeacherForCourse(idCourse);
        return ResponseEntity.status(200).body(name);
    }


}
