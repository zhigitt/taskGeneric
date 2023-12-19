package db;

import model.Animal;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Person> personList = new ArrayList<>();
    private List<Animal> animalList = new ArrayList<>();

    public <T> Boolean add(T type) {
        if (type instanceof Person) {
            return personList.add((Person) type);
        } else if (type instanceof Animal) {
            return animalList.add((Animal) type);
        }
        throw new RuntimeException("Incorrect type!");
    }

    public <T> Boolean remove(T type) {
        if (type instanceof Person) {
            return personList.remove(personList);
        } else if (type instanceof Animal) {
            return animalList.remove(animalList);
        }
        throw new RuntimeException("Invalid remove!");
    }

    public List<Person> getAllPeople(){
        return personList;
    }

    public List<Animal> getAllAnimals(){
        return animalList;
    }
}
