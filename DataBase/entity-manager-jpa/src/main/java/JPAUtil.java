 import jakarta.persistence.EntityManager;
 import jakarta.persistence.EntityManagerFactory;
 import jakarta.persistence.Persistence;

 public class JPAUtil {
    private static final EntityManagerFactory emf;     // hame entity manager me se milega enity factory

    static {    // jab class load ho to automatically execute ho class ke loading par
              emf = Persistence.createEntityManagerFactory("myJpaUnit");
    }
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public static void  close() {
        emf.close();
    }
}
