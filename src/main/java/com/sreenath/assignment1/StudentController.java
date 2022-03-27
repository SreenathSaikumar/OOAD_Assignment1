package com.sreenath.assignment1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Autowired
    StudentRepository repository;

    @Autowired
    collegeSubjectRepository subjectRepository;

    @RequestMapping("/student/{id}")
    public String student(@PathVariable Long id, Model model) {
        model.addAttribute("student", repository.findById(id));
        model.addAttribute("subjects", subjectRepository.findAll());
        return "student";
    }

    @RequestMapping(value="/students",method=RequestMethod.GET)
    public String studentsList(Model model) {
        model.addAttribute("students", repository.findAll());
        return "students";
    }

    @RequestMapping(value="/students",method=RequestMethod.POST)
    public String developersAdd(@RequestParam String email,
                                @RequestParam String firstName, @RequestParam String lastName, Model model) {
        Student newStudent = new Student();
        newStudent.setEmail(email);
        newStudent.setFirstName(firstName);
        newStudent.setLastName(lastName);
        repository.save(newStudent);

        model.addAttribute("student", newStudent);
        model.addAttribute("subjects", subjectRepository.findAll());
        return "redirect:/student/" + newStudent.getId();
    }

    @RequestMapping(value="/student/{id}/subjectsS", method=RequestMethod.POST)
    public String studentsAddSkill(@PathVariable Long id, @RequestParam Long subjectId, Model model) {
        Optional<collegeSubject> optionalSubject = subjectRepository.findById(subjectId);
        collegeSubject subject=optionalSubject.get();
        Optional<Student> optionalStudent = repository.findById(id);
        Student student=optionalStudent.get();

        if (student != null) {
            if (!student.hasSubject(subject)) {
                student.getCollegeSubjects().add(subject);
            }
            repository.save(student);
            model.addAttribute("student", repository.findById(id));
            model.addAttribute("subjects", subjectRepository.findAll());
            return "redirect:/student/" + student.getId();
        }

        model.addAttribute("students", repository.findAll());
        return "redirect:/students";
    }
}
