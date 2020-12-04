package dao;

import pojo.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();

    Student getStudentByID(Integer id);

    void insertStudent(Student student);

    void deleteStudent(Integer id);

}