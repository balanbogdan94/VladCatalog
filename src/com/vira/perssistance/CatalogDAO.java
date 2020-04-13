package com.vira.perssistance;

import com.vira.model.Person;
import java.util.List;

public interface CatalogDAO {

    public List<Person> getPersons();
    public void addPerson(Person person);
    public  void removePerson(int id);
}
