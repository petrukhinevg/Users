package program.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return  "id = " + id + '\n' +
                "age = " + age + '\n' +
                "name = " + name + '\n' +
                "country = " + country + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && getAge() == user.getAge() && getName().equals(user.getName()) && Objects.equals(getCountry(), user.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAge(), getName(), getCountry());
    }
}
