package com.example.demo.student;

import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "student")                                                                                                // Name of database
public class Student {
    @Id                                                                                                                 // Generates a unique identifier for each entry
    @SequenceGenerator(                                                                                                 // Generates a unique identifier for each entry
        name           = "student_sequence",                                                                            // Generates a unique identifier for each entry
            sequenceName   = "student_sequence",                                                                        // Generates a unique identifier for each entry
            allocationSize = 1                                                                                          // Generates a unique identifier for each entry
    )
    @GeneratedValue (                                                                                                   // Generates a unique identifier for each entry
            strategy  = GenerationType.SEQUENCE,                                                                        // Generates a unique identifier for each entry
            generator = "student_sequence"                                                                              // Generates a unique identifier for each entry
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient                                                                                                          // Field is ignored by the mapping framework and not mapped to a db column
    private Integer age;

    public Student() {}
    public void setId(Long id)          { this.id = id;                                                 }
    public String getName()             { return name;                                                  }
    public void setName(String name)    { this.name = name;                                             }
    public String getEmail()            { return email;                                                 }
    public void setEmail(String email)  { this.email = email;                                           }
    public Integer getAge()             { return Period.between(this.dob, LocalDate.now()).getYears();  }               // Calculation of student's age based on their dob input
    public void setAge(Integer age)     { this.age = age;                                               }
    public LocalDate getDob()           { return dob;                                                   }
    public void setDob(LocalDate dob)   { this.dob = dob;                                               }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' +
                ", age=" + age + ", dob=" + dob + '}';
    }
}


