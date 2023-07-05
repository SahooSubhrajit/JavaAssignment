package com.example.demo.service;

import com.example.demo.entity.Student;

public interface IStudentService {

	public Boolean saveStudentData(Student student);

	public String updateStudentMarkById(int id, Student student);

}
