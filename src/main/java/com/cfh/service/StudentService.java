package com.cfh.service;

import com.cfh.entity.Student;

import java.util.List;

public interface StudentService {

    /**
     *  查询列表
     * @return
     */
    public List<Student> showStudentList();

    /**
     * 根据ID查询
     * @param sno
     * @return
     */
    public boolean checkID(int sno);

    /**
     * 添加学生列表
     * @param stu
     * @return
     */
    public boolean addStudent(Student stu);

    public int deleteByID(int sno);

    public Student getStudentByID(Integer id);

    public int updateByID(Student stu);
}
