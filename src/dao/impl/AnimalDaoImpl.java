package dao.impl;

import dao.DaoCRUD;
import db.DataBase;
import model.Animal;

import java.util.List;

public class AnimalDaoImpl implements DaoCRUD<Animal, Integer> {
    private final DataBase dataBase;

    public AnimalDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public boolean add(Animal newAnimal) {
        return dataBase.add(newAnimal);
    }

    @Override
    public Animal getById(Integer id) {
        List<Animal> animals = dataBase.getAllAnimals();
        for (Animal animal : animals) {
            if (animal.getId() == id){
                return animal;
            }
        }
        throw new RuntimeException(String.format("Animal with id: %d not found!", id));
    }

    @Override
    public List<Animal> getAll() {
        return dataBase.getAllAnimals();
    }

    @Override
    public Animal remove(Animal animal) {
        dataBase.remove(animal);
        return animal;
    }
}
