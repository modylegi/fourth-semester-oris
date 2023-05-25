package ru.itis.hibernateexample;

import ru.itis.hibernateexample.model.Driver;
import ru.itis.hibernateexample.repository.DriverRepositoryHibernate;

public class Main {
    public static void main(String[] args) {

        DriverRepositoryHibernate repositoryHibernate = new DriverRepositoryHibernate();
        Driver driver1 = Driver.builder()
                .firstName("Polya")
                .lastName("Ryftina")
                .age(19)
                .build();
//        repositoryHibernate.save(driver1);
//        repositoryHibernate.delete(1L);
//        repositoryHibernate.findAll();
//        repositoryHibernate.findById(2L);
    }
}
