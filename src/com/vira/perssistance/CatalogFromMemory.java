package com.vira.perssistance;

import com.vira.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CatalogFromMemory implements CatalogDAO {

    private List<Person> persons= new ArrayList<>();

    public CatalogFromMemory() {
        for(int i = 0; i<10;i++){
            persons.add(generatePerson());
        }
    }

    @Override
    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public void addPerson(Person person) {
        persons.add(person);
    }

    @Override
    public void removePerson(int id) {
        //persons.
    }

    private int counter = 0;
    private Person generatePerson() {
        counter++;
        return new Person("Person"+counter,"Person"+counter+"@asdf.com", LocalDate.of(getRandomNumberInRange(1970,2010),getRandomNumberInRange(1,12),getRandomNumberInRange(1,28)));
    }


    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
