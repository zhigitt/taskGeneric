package dao.impl;

import dao.DaoCRUD;
import db.DataBase;
import model.Person;

import java.util.List;

public class PersonDaoImpl implements DaoCRUD<Person, Integer> {
    private final DataBase dataBase;

    public PersonDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public boolean add(Person newPerson) {
        return dataBase.add(newPerson);
    }

    @Override
    public Person getById(Integer id) {
        List<Person> personList = dataBase.getAllPeople();
        for (Person person : personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new RuntimeException(String.format("Person with id: %d not found!", id));
    }

    @Override
    public List<Person> getAll() {
        return dataBase.getAllPeople();
    }

    @Override
    public Person remove(Person person) {
        dataBase.remove(person);
        return person;
    }
}
