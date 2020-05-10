package org.privateschool.trainermvc.controllers;

import java.util.List;
import org.privateschool.trainermvc.entities.Trainer;
import org.privateschool.trainermvc.services.ITrainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String listAllTrainers(ModelMap view, @RequestParam(required = false) String alert, @RequestParam(required = false) String success) {
        List<Trainer> trainers = trainerService.findAll();
        view.addAttribute("trainers", trainers);
        view.addAttribute("editurl", editurl);
        view.addAttribute("deleteurl", deleteurl);
        view.addAttribute("newurl", newurl);
        view.addAttribute("alert", alert);
        view.addAttribute("success", success);
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
            view.addAttribute("success", new String("Trainer was added successfully!"));
        } else {
            view.addAttribute("alert", new String("Something went wrong. Please add the trainer again!"));
        }
        return ("redirect:/list");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(ModelMap view, @PathVariable int id) {
        if (trainerService.delete(id)) {
            view.addAttribute("success", new String("Trainer was deleted successfully!"));
        } else {
            view.addAttribute("alert", new String("Something went wrong. Please delete the trainer again!"));
        }
        return ("redirect:/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTrainer(ModelMap view, @PathVariable int id) {
        Trainer trainer = trainerService.findById(id);
        if (trainer == null) {
            view.addAttribute("alert", new String("The trainer does not exist any more."));
            return ("redirect:/list");
        } else {
            view.addAttribute("trainer", trainer);
            view.addAttribute("listurl", listurl);
            view.addAttribute("updateurl", updateurl);
            return "edittrainer";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStudent(ModelMap view, Trainer trainer) {
        if (trainerService.update(trainer)) {
            view.addAttribute("success", new String("Trainer was updated successfully!"));
        } else {
            view.addAttribute("alert", new String("Something went wrong. Please update the trainer again!"));
        }
        return ("redirect:/list");
    }
}
