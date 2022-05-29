package com.almikhailov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/employee") // Controller mapping
public class MyController {

    @RequestMapping("/") // Method mapping
    public String showFirstView(){
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model){
//        Employee emp = new Employee();
//        emp.setName("lyosha");
//        emp.setSurname("mikhailov");
//        emp.setSalary(500);
//        model.addAttribute("employee", emp);

        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

    @GetMapping (path = "/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp, BindingResult bindingResult){
//        String name = emp.getName();
//        emp.setName("Mr. " + name);
//
//        String surname = emp.getSurname();
//        emp.setSurname(surname + "!");
//
//        int salary = emp.getSalary();
//        emp.setSalary(salary*2);

        if(bindingResult.hasErrors()){
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";
        }
    }





//    @RequestMapping("/showDetails")
//    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model){
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttribute", empName);
//        return "show-emp-details-view";
//    }

//    @RequestMapping("/showDetails")
//    public String showEmpDetails(){
//        return "show-emp-details-view";
//    }

//    @RequestMapping("/showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model){
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("description", "dotaPlayer");
//        return "show-emp-details-view";
//    }


}
