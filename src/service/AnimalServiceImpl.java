package service;

import dao.impl.AnimalDaoImpl;
import model.Animal;
import model.Gender;

import java.util.ArrayList;
import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal>{
    private final AnimalDaoImpl animalDao;

    public AnimalServiceImpl(AnimalDaoImpl animalDao) {
        this.animalDao = animalDao;
    }


    @Override
    public String add(List<Animal> t) {
        for (Animal animal : t) {
            animalDao.add(animal);
        }
        return "added";
    }

    @Override
    public Animal getbyId(int id) {

        return animalDao.getById(id);
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    @Override
    public List<Animal> sortByName(int num) {
        List<Animal> animalList = new ArrayList<>(animalDao.getAll());

        if (num == 1){
            animalList.sort(Animal.sortByNameAsc);
        } else if (num == 2) {
            animalList.sort(Animal.sortByNameDesc);
        }
        return animalList ;
    }

    @Override
    public List<Animal> filtrByGender(int num) {
        List<Animal> animalList = new ArrayList<>(animalDao.getAll());

        if (num == 1){
            for (Animal animal : animalList) {
                if (animal.getGender().equals(Gender.FEMALE)){
                    animalList.add(animal);
                }
            }
        } else if (num == 2) {
            for (Animal animal : animalList) {
                if (animal.getGender().equals(Gender.MALE)){
                    animalList.add(animal);
                }
            }
        }
        return animalList;
    }

    @Override
    public List<Animal> clear() {
        animalDao.getAll().clear();
        return animalDao.getAll();
    }
}
