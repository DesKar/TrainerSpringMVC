package org.privateschool.trainermvc.controllers;

import java.util.List;
import org.privateschool.trainermvc.entities.Trainer;
import org.privateschool.trainermvc.services.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TrainerController {

    private String listurl = "list";
    private String editurl = "edit";
    private String updateurl = "update";
    private String deleteurl = "delete";

    private @Autowired
    ITrainer trainerService;

    @Autowired
    MessageSource messageSource;
    // index

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listAllTrainers(ModelMap view, @RequestParam(required = false) String msg) {
        List<Trainer> trainers = trainerService.findAll();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("msg", msg);
        return ("trainerlist");
    }

//    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
//    public String newStudent(ModelMap view) {
//        Student student = new Student();
//        view.addAttribute("student", student);
//        view.addAttribute("listurl", listurl);
//        return "newstudent";
//    }
//
//    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
//    public String saveStudent(ModelMap view, Student student) {
//        view.addAttribute("listurl", listurl);
//        if (studentService.save(student)) {
//            view.addAttribute("message", new String("All good!"));
//        } else {
//            view.addAttribute("message", new String("All wrong!"));
//        }
//        return "newstudent";
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String deleteStudent(ModelMap view, @PathVariable int id) {
//        if (studentService.delete(id)) {
//            view.addAttribute("msg", new String("Deleted Successfully!"));
//        } else {
//            view.addAttribute("msg", new String("Not Deleted!"));
//        }
//        return ("redirect:/list");
//    }
//
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public String editStudent(ModelMap view, @PathVariable int id) {
//        Student student = studentService.findById(id);
//        view.addAttribute("student", student);
//        view.addAttribute("listurl", listurl);
//        view.addAttribute("updateurl", updateurl);
//        return "editstudent";
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String updateStudent(ModelMap view, Student student) {
//        if (studentService.update(student)) {
//            view.addAttribute("msg", new String("Edited Successfully!"));
//        } else {
//            view.addAttribute("msg", new String("Not Edited!"));
//        }
//        return ("redirect:/list");
//    }

}
