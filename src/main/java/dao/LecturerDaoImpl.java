package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Lecturer;

import java.util.List;

public class LecturerDaoImpl implements LecturerDAO {

    private Session sessionFactory;

    public LecturerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory.openSession();
    }

    public List<Lecturer> getAllLecturers() {
        Session session = sessionFactory;
        session.beginTransaction();
        Query query = session.createQuery("from Lecturer");
        List classes = query.list();
        session.getTransaction().commit();
        return classes;
    }

    public Lecturer getLecturerByID(Integer id) {
        for (Lecturer cl : getAllLecturers()) {
            if(cl.getLecturerID()==id){
                return cl;
            }
        }
        return null;
    }

    public void insertLecturer(Lecturer lecturer) {
        Session session = sessionFactory;
        session.beginTransaction();
        session.save(lecturer);
        System.out.println("Inserted Successfully");
        session.getTransaction().commit();
    }

    public void deleteLecturer(Integer id) {
        Session session = sessionFactory;
        session.beginTransaction();
        Lecturer lecturer = (Lecturer) session.load(Lecturer.class, id);
        session.delete(lecturer);
        System.out.println("Deleted Successfully");
        session.getTransaction().commit();
    }

}