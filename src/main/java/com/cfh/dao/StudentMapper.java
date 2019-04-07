package com.cfh.dao;

import com.cfh.entity.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> getAllStudent();

    public Student getStudentByID(int sno); //查找是否学号重复

    public int insertStudent(Student stu);

    public int deleteByID(int sno);

    public int updateByID(Student stu);
}