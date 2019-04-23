package com.spring.boot.example.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@Entity // This tells Hibernate to make a table out of this class
public class User {
        @Id
        @GeneratedValue
        private Integer id;
        private String firstName;
        private String lastName;
        private String birthday;
        //@UniqueConstraint()
        private String email;
        private String password;

        @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
        //private Role role;
        @CollectionTable(name ="user_role", joinColumns = @JoinColumn(name = "user_id"))
        @Enumerated(EnumType.STRING)
        private Set<Role> roles;

        public User() {
        }
        @Override
        public String toString() {
                return String.format(
                        "Customer[id=%d, firstName='%s', lastName='%s']",
                        id, firstName, lastName);
        }
}
