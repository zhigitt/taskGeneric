package service;

import dao.impl.PersonDaoImpl;
import db.DataBase;
import model.Gender;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements GenericService<Person>{
    DataBase dataBase;
   private final PersonDaoImpl personDao;

    public PersonServiceImpl(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }


    @Override
    public String add(List<Person>  person) {
        for (Person per : person) {
            personDao.add(per);
        }
        return  "added";
    }

    @Override
    public Person getbyId(int id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Person> sortByName(int num) {
        List<Person> personList = new ArrayList<>(personDao.getAll());

        if (num == 1){
            personList.sort(Person.sortByNameAsc);
        } else if (num == 2) {
            personList.sort(Person.sortByNameDesc);
        }
        return personList ;
    }

    @Override
    public List<Person> filtrByGender(int num) {
        List<Person> personList = new ArrayList<>(personDao.getAll());
        List<Person> personList1 = new ArrayList<>();

        if (num == 1){
            for (Person person : personList) {
                if (person.getGender().equals(Gender.FEMALE)){
                    personList1.add(person);
                }
            }
        } else if (num == 2) {
            for (Person person : personList) {
                if (person.getGender().equals(Gender.MALE)){
                    personList1.add(person);
                }
            }
        }
        return personList1;
    }

    @Override
    public List<Person> clear() {
        personDao.getAll().clear();
        return personDao.getAll();
    }
}
