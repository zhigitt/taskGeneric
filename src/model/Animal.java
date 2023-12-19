package model;

import java.util.Comparator;

public class Animal implements Comparator<Animal> {
    private int id;
    private String name;

    public Animal() {
    }

    private int age;
    private Gender gender;

    public Animal(int id, String name, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}' + "\n";
    }

    @Override
    public int compare(Animal o1, Animal o2) {
        return 0;
    }

    public static Comparator<Animal> sortByNameAsc = new Comparator<Animal>(){

        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Animal> sortByNameDesc = new Comparator<Animal>(){

        @Override
        public int compare(Animal o1, Animal o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };
}
