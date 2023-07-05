package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceimpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Boolean saveStudentData(Student student) {

		Student saveEntity = null;

		if (checkPassMark(student)) {

			Double totalMark = (double) (student.getMark1() + student.getMark2() + student.getMark3());

			student.setTotal(totalMark);
			student.setAverage(totalMark / 3);
			saveEntity = studentRepo.save(student);

		}

		if (saveEntity != null) {
			return true;
		}
		return false;
	}

	@Override
	public String updateStudentMarkById(int id, Student student) {

		Optional<Student> studentById = Optional.empty();

		studentById = studentRepo.findById(id);

		if (studentById.isPresent()) {
			Student studentData = studentById.get();
			studentData.setMark1(student.getMark1());
			studentData.setMark2(student.getMark2());
			studentData.setMark3(student.getMark3());

			Double totalMark = (double) (studentData.getMark1() + studentData.getMark2() + studentData.getMark3());

			studentData.setTotal(totalMark);
			studentData.setAverage(totalMark / 3);
			Student saveEntity = studentRepo.save(student);

			return "Mark updated for id " + id;
		} else {
			return "Mark did not update for id " + id;
		}

	}

	private Boolean checkPassMark(Student student) {

		if (student.getMark1() >= 35 && student.getMark2() >= 35 && student.getMark3() >= 35) {
			return true;
		} else {
			return false;
		}

	}

}
