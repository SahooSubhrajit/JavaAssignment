package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@PostMapping(value = "/saveStudent")
	public String saveStudent(@Valid @RequestBody Student student) {

		if (studentService.saveStudentData(student)) {
			return "Student Record saved.";
		} else {
			return "Student Record did not save.";
		}

	}

	@PutMapping(value = "/updateMark/{id}")
	public String updateMarkById(@PathVariable int id, @Valid @RequestBody Student student) {

		if (student != null) {
			return studentService.updateStudentMarkById(id, student);

		}
		return "Error occured while updating Student marks";

	}

}
