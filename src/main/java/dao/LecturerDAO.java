package dao;

import pojo.Lecturer;

import java.util.List;

public interface LecturerDAO {

    List<Lecturer> getAllLecturers();

    Lecturer getLecturerByID(Integer id);

    void insertLecturer(Lecturer lecturer);

    void deleteLecturer(Integer id);

}