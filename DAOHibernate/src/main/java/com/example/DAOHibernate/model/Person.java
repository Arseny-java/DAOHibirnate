package com.example.DAOHibernate.model;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Person {
    @EmbeddedId
    private PersonId personId;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String city_of_living;

}
