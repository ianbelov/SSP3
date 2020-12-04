package dao;

import pojo.Class;

import java.util.List;

public interface ClassDAO {

    List<Class> getAllClasses();

    Class getClassByID(Integer id);

    void insertClass(Class classEntity);

    void deleteClass(Integer id);

}