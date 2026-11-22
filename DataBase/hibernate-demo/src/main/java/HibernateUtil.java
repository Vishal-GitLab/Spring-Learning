import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;           //  ak sessionFactory create kar rhe hai

    static {                   // ak static block create karte hai .. jab ham static me kuch likhte hai to vo Hibernate me  load hota hai fir static me execute hota hai
        try {
            sessionFactory  = new Configuration()     // data relation se jo bhi configutation hota hai usko map karta hai
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClasses(UserClassHibernate.class)
                    .buildSessionFactory();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
      // session jitne bhi create hote hai vo sessionfactory create karta hai
    // session ak trah ka connection hai jo database ko stablish karta h
    public static Session getSession() {       // ye factory me se current object ko return kar dega
        return sessionFactory.getCurrentSession();
    }

    public static void close() {
        sessionFactory.close();    // jab run ho jaye to close karne ke liye use karte hai
    }
}

// hibernate kya problem ko solve karta hai JDBC ke comparing me  ?
// --  JDBC me bahut kyada boiler code likhna padta hai .. hibernate boiler code  ko hta deta hai aur jo query hai automatically generate hoti hai aur jo java objects hai vo map ho jate hai automatically kyunki
// kyunki hibernate ak ORM hai















