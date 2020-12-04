package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.Class;

import java.util.List;

public class ClassDaoImpl implements ClassDAO {

    private Session sessionFactory;

    public ClassDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory.openSession();
    }

    public List<Class> getAllClasses() {
        Session session = sessionFactory;
        session.beginTransaction();
        Query query = session.createQuery("from Class");
        List classes = query.list();
        session.getTransaction().commit();
        return classes;
    }

    public Class getClassByID(Integer id) {
        for (Class cl : getAllClasses()) {
            if (cl.getId() == id) {
                return cl;
            }
        }
        return null;
    }

    public void insertClass(Class classEntity) {
        Session session = sessionFactory;
        session.beginTransaction();
        session.save(classEntity);
        System.out.println("Inserted Successfully");
        session.getTransaction().commit();
    }

    public void deleteClass(Integer id) {
        Session session = sessionFactory;
        session.beginTransaction();
        Class cl = (Class) session.load(Class.class, id);
        session.delete(cl);
        System.out.println("Deleted Successfully");
        session.getTransaction().commit();
    }

}