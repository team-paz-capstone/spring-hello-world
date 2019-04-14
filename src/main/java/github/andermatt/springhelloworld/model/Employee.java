package github.andermatt.springhelloworld.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee")  // This class represents the employee table.
@RequiredArgsConstructor
@Getter
@Setter
public class Employee {

    @Id  // This is the primary key.
    @GeneratedValue  // The database will auto-generate this value for us.
    private Long id;

    @Column(name = "first_name")  // Map this attribute to the first_name column in the employee table.
    @NonNull  // This is a required field for object construction.
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "email")
    @NonNull
    private String email;

    // Hibernate requires a no arg constructor.
    private Employee() {

    }
}
