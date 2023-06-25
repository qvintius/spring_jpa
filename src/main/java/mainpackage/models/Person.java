package mainpackage.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private int id;

    @Getter
    @Setter
    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name_person")
    private String name;

    @Getter
    @Setter
    @Min(value = 1, message = "Age should be greater than 0")
    @Column(name = "age")
    private int age;

    @Getter
    @Setter
    @NotEmpty(message = "Email shouldn't be empty")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @OneToMany(mappedBy = "owner")
    private List<Item> items;

    public void addItems(Item item){
        if(this.items == null)
            this.items = new ArrayList<>();
        this.items.add(item);
        item.setOwner(this);
    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id_person=" + id +
                ", name_person='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
