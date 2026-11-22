import org.hibernate.Session;

public class HibernateDemoMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();   // is session se database se intract karenge       // getSession -- ye hibernate ka ak session dega

        try {
            UserClassHibernate user = new UserClassHibernate(  "Alice");
            session.beginTransaction();
            session.persist(user);    // agar database me kuch save karna  h to ham persist ka use karte hai
            session.getTransaction().commit();
            System.out.println("User saved: " +  user.getId());
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
    }
}