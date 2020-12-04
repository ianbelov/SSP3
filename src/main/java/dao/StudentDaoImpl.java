package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDAO {

    private Session sessionFactory;

    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory.openSession();
    }

    public List<Student> getAllStudents() {
        Session session = sessionFactory;
        session.beginTransaction();
        Query query = session.createQuery("from Student");
        List students = query.list();
        session.getTransaction().commit();
        return students;
    }

    public Student getStudentByID(Integer id) {
        for (Student cl : getAllStudents()) {
            if (cl.getId() == id) {
                return cl;
            }
        }
        return null;
    }

    public void insertStudent(Student student) {
        Session session = sessionFactory;
        session.beginTransaction();
        session.save(student);
        System.out.println("Inserted Successfully");
        session.getTransaction().commit();
    }

    public void deleteStudent(Integer id) {
        Session session = sessionFactory;
        session.beginTransaction();
        Student student = (Student) session.load(Student.class, id);
        session.delete(student);
        System.out.println("Deleted Successfully");
        session.getTransaction().commit();
    }

}