package dao;

import entity.User;
import hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAO {

    public void add(User user) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(user);
        s.getTransaction().commit();
        s.close();
    }

    User getByEmail(String email){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        Query q = s.createQuery("FROM User WHERE email='"+email+"'");
        User out = (User)q.uniqueResult();
        s.close();
        return out;
    }
}
