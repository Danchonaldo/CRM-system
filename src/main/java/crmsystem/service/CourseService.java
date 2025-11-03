package crmsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crmsystem.entity.Courses;
import crmsystem.entity.Request;
import crmsystem.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }
    public Courses addCourse(Courses course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Courses getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
}