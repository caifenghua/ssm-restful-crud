package com.cfh.service.impl;

import com.cfh.dao.StudentMapper;
import com.cfh.entity.Student;
import com.cfh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentDao;

    @Override
    public List<Student> showStudentList() {

        return studentDao.getAllStudent();
    }

    @Override
    public boolean checkID(int sno) {
        if(studentDao.getStudentByID(sno)!=null)
            return true;
        return false;
    }

    @Override
    public boolean addStudent(Student stu) {
        if(studentDao.insertStudent(stu)!=0)
            return true;
        return false;
    }

    @Override
    public int deleteByID(int sno) {
        if (studentDao.deleteByID(sno) != 1)
            return 0;
        return 1;
    }

    @Override
    public Student getStudentByID(Integer id) {
        return studentDao.getStudentByID(id);
    }

    @Override
    public int updateByID(Student stu) {
        return studentDao.updateByID(stu);
    }
}
