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
    private String newurl = "new";
    private String editurl = "edit";
    private String updateurl = "update";
    private String deleteurl = "delete";

    private @Autowired
    ITrainer trainerService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listAllTrainers(ModelMap view) {
        List<Trainer> trainers = trainerService.findAll();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("newurl", newurl);
        return ("trainerlist");
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newStudent(ModelMap view) {
        Trainer trainer = new Trainer();
        view.addAttribute("trainer", trainer);
        view.addAttribute("listurl", listurl);
        return "newtrainer";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveStudent(ModelMap view, Trainer trainer) {
        view.addAttribute("listurl", listurl);
        if (trainerService.save(trainer)) {
            return ("redirect:/list");
        } else {
            view.addAttribute("message", new String("Something went wrong. Please add the trainer again!"));
            return ("redirect:/new");
        }

    }

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
