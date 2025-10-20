package crmsystem.controller;

import crmsystem.entity.Courses;
import crmsystem.entity.Request;
import crmsystem.entity.Operators;
import crmsystem.service.CourseService;
import crmsystem.service.OperatorService;
import crmsystem.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private OperatorService operatorService;


    @GetMapping("/")
    public String allRequests(Model model) {
        model.addAttribute("requests", requestService.getAllRequests());
        model.addAttribute("pageTitle", "Все Заявки");
        return "index";
    }

    @GetMapping("/new")
    public String newRequests(Model model) {
        model.addAttribute("requests", requestService.getNewRequests());
        model.addAttribute("pageTitle", "Новые Заявки");
        return "index";
    }

    @GetMapping("/handled")
    public String handledRequests(Model model) {
        model.addAttribute("requests", requestService.getHandledRequests());
        model.addAttribute("pageTitle", "Обработанные заявки");
        return "index";
    }

    @GetMapping("/add-request")
    public String showAddRequestForm(Model model) {
        List<Courses> coursesList = courseService.getAllCourses();
        model.addAttribute("request", new Request());
        model.addAttribute("courses", coursesList);
        return "add-request";
    }

    @PostMapping("/add-request")
    public String addRequest(@ModelAttribute("request") Request request,
                             @RequestParam("course") Long courseId) {

        Courses selectedCourse = courseService.getCourseById(courseId);

        if (selectedCourse != null) {
            request.setCourse(selectedCourse);
        }

        requestService.addRequest(request);
        return "redirect:/";
    }


    @GetMapping("/details/{id}")
    public String requestDetails(@PathVariable Long id, Model model) {
        Request request = requestService.getRequestById(id);
        if (request != null) {
            model.addAttribute("request", request);

            List<Operators> operators = operatorService.getAllOperators();
            model.addAttribute("operators", operators);

            return "details";
        }
        return "redirect:/";
    }

    @PostMapping("/details/{id}/assign-operator")
    public String assignOperator(@PathVariable Long id, @RequestParam Long operatorId) {
        requestService.assignOperator(id, operatorId);
        return "redirect:/details/" + id;
    }

    @PostMapping("/details/{id}/unassign-operator")
    public String unassignOperator(@PathVariable Long id, @RequestParam Long operatorId) {
        requestService.unassignOperator(id, operatorId);
        return "redirect:/details/" + id;
    }

    @PostMapping("/handle/{id}")
    public String handleRequest(@PathVariable Long id) {
        requestService.handleRequest(id);
        return "redirect:/details/" + id;
    }

    @PostMapping("/delete/{id}")
    public String deleteRequest(@PathVariable Long id) {
        requestService.deleteRequest(id);
        return "redirect:/";
    }
}