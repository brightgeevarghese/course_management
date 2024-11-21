package edu.miu.cse.coursemanagement.controller;

import edu.miu.cse.coursemanagement.dto.request.CourseRequestDTO;
import edu.miu.cse.coursemanagement.dto.response.CourseResponseDTO;
import edu.miu.cse.coursemanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public String createCourse(@ModelAttribute CourseRequestDTO courseRequestDTO) {
        courseService.createCourse(courseRequestDTO);
        return "redirect:/api/v1/courses";//Redirect to path /api/v1/courses (request method is GET)
    }

    @GetMapping
    public String getCourses(Model model) {
        List<CourseResponseDTO> courseResponseDTOS = courseService.getAllCourses();
        model.addAttribute("courseResponseDTOS", courseResponseDTOS);
        return "result_page";
    }
}
