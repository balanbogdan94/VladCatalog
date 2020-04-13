package com.vira.service;

import com.vira.model.Person;
import com.vira.perssistance.CatalogDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonService {
    private CatalogDAO catalogDao;

    public PersonService(CatalogDAO catalogDao) {
        this.catalogDao = catalogDao;
    }

    public void addPerson(String name, String email, String dateOfBirth){
        //validation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-1yyyy");
        Person newPerson = new Person(name,email, LocalDate.parse(dateOfBirth,formatter));
        catalogDao.addPerson(newPerson);
    }

    public void displayPerson() {
        for(Person person: catalogDao.getPersons()){
            System.out.println(person);
        }
    }

    public Person getOldestPerson() {
        return catalogDao.getPersons().stream().min((person1,person2) -> person1.getDateOfBirth().compareTo(person2.getDateOfBirth())).get();
    }

    public Person getYoungestPerson(){
        return catalogDao.getPersons().stream().max((person1,person2) -> person1.getDateOfBirth().compareTo(person2.getDateOfBirth())).get();
    }

    public double getAverageAge() {
        //return persons.stream().collect(Collectors.averagingInt(Person::getAge));

        int sumOfAllAges = 0;
        for(Person person : catalogDao.getPersons()) {
            sumOfAllAges += person.getAge();
        }

        return  sumOfAllAges/catalogDao.getPersons().size();

    }


}
