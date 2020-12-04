import dao.ClassDaoImpl;
import dao.LecturerDaoImpl;
import dao.StudentDaoImpl;
import pojo.Class;
import pojo.Lecturer;
import pojo.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static LecturerDaoImpl lecturerDao = new LecturerDaoImpl(HibernateUtil.getSessionFactory());
    static ClassDaoImpl classDao = new ClassDaoImpl(HibernateUtil.getSessionFactory());
    static StudentDaoImpl studentDao = new StudentDaoImpl(HibernateUtil.getSessionFactory());

    public static void main(String[] args) {
        //Create some lecturers
        lecturerDao.insertLecturer(new Lecturer("First Lecturer"));
        lecturerDao.insertLecturer(new Lecturer("Second Lecturer"));

        //Create some classes and give them lecturers
        classDao.insertClass(new Class("Object-oriented programming Class", lecturerDao.getAllLecturers().get(0)));
        classDao.insertClass(new Class("Database Class", lecturerDao.getAllLecturers().get(0)));
        classDao.insertClass(new Class("Web-development Class", lecturerDao.getAllLecturers().get(1)));

        //Create some student and give them classes
        studentDao.insertStudent(new Student("First student", classDao.getAllClasses().get(0)));
        studentDao.insertStudent(new Student("Second student", classDao.getAllClasses().get(0)));
        studentDao.insertStudent(new Student("Third student", classDao.getAllClasses().get(1)));
        studentDao.insertStudent(new Student("Fourth student", classDao.getAllClasses().get(1)));
        studentDao.insertStudent(new Student("Fifth student", classDao.getAllClasses().get(2)));

        printTimetable(studentDao.getAllStudents(), classDao.getAllClasses());
    }

    private static void printTimetable(List<Student> allStudents, List<Class> allClasses) {
        for (Class entry : allClasses) {

            String lecturerName = lecturerDao.getLecturerByID(entry.getLecturer_id()).getLecturerName();
            List<String> studentList = new ArrayList<String>();
            for (Student studentEntry : allStudents) {
                if (classDao.getClassByID(studentEntry.getClass_id()).getClassName().equals(entry.getClassName())) {
                    studentList.add(studentEntry.getStudentName());
                }
            }

            System.out.println("Class with name " + entry.getClassName() +
                    " given by " + lecturerName +
                    " and attended by " + studentList);
        }

    }
}