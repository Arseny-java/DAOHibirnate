package com.example.DAOHibernate.model;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class DataGenerator implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var random = new Random();
        var cities = List.of("Moscow", "Zarechniy", "Sacramento");
        var names = List.of("Arseny", "Sasha", "John");
        var surnames = List.of("Sazonov", "Grey", "Doe");

        IntStream.range(0,5)
                .forEach(i -> {
                    var person = Person.builder()
                            .personId(PersonId.builder()
                                    .age(random.nextInt(33))
                                    .name(names.get(random.nextInt(names.size())))
                                    .surname(surnames.get(random.nextInt(surnames.size())))
                                    .build())
                            .city_of_living(cities.get(random.nextInt(cities.size())))
                            .phone_number(String.valueOf(random.nextInt(99999999)))
                            .build();
                    entityManager.persist(person);
                });

    }
}
