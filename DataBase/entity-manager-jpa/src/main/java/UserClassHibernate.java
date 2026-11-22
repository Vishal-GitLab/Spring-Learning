import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// jitne bhi annotation aate hai vo jakrta se aate hai jiske jariye ham chizo ko mention karte hai
@Entity
    public class UserClassHibernate {
              @Id                  // ye primary key hota hai jo mandatory hota hai
          @GeneratedValue(strategy =  GenerationType.IDENTITY)
        private Long id;
        private String name;

    public UserClassHibernate() {               // default constructor
    }

    public UserClassHibernate(Long id, String name) {
            this.id = id;
            this.name = name;
        }

    public UserClassHibernate(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
