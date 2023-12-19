import dao.impl.AnimalDaoImpl;
import dao.impl.PersonDaoImpl;
import db.DataBase;
import model.Animal;
import model.Gender;
import model.Person;
import service.AnimalServiceImpl;
import service.GenericService;
import service.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        GenericService personService = new PersonServiceImpl(new PersonDaoImpl(dataBase));
        GenericService animalService = new AnimalServiceImpl(new AnimalDaoImpl(dataBase));

        List<Person> personList = new ArrayList<>(
                List.of(
                        new Person(1, "Urmat", 20, Gender.MALE),
                        new Person(2, "Zhigit", 22, Gender.MALE),
                        new Person(3, "Aliaskar", 23, Gender.MALE),
                        new Person(4, "Nurmuhammed", 18, Gender.MALE),
                        new Person(5, "Mirlan", 29, Gender.MALE)
                )
        );

        List<Animal> animalList = new ArrayList<>(
                List.of(
                        new Animal(1, "Cat", 3, Gender.MALE),
                        new Animal(2, "Dog", 6, Gender.FEMALE),
                        new Animal(3, "Horse", 1, Gender.MALE),
                        new Animal(4, "Cow", 2, Gender.FEMALE),
                        new Animal(5, "Wolf", 4, Gender.FEMALE)
                )
        );

        Person person = new Person(1, "Urmat", 20, Gender.MALE);




        while (true){
            System.out.print("""
                    1. add people                8. add animals
                    2. get person by ID          9. get animal by ID                       
                    3. get all people            10. get all animals
                    4. sort - A -Z               11. sort - A -Z
                    5. sort - Z -A               12. sort - Z -A
                    6. filter FEMALE             13. filter MALE
                    7. filter MALE               14. filter FEMALE
                    
                                15. Clear people
                                16. Clear animals
                    """);
            System.out.print("Select: ");

            switch (sc.nextInt()){
                case 1 -> {
                    personService.add(personList);
                }
                case 2 -> {
                    System.out.print("Peson ID: ");
                    System.out.println(personService.getbyId(sc.nextInt()));
                }
                case 3 -> {
                    System.out.println(personService.getAll());
                }
                case 4 -> {
                    System.out.println(personService.sortByName(1));
                }
                case 5 -> {
                    System.out.println(personService.sortByName(2));
                }
                case 6 -> {
                    System.out.println(personService.filtrByGender(1));
                }
                case 7 -> {
                    System.out.println(personService.filtrByGender(2));
                }
                case 8 -> {
                    animalService.add(animalList);
                }
                case 9 -> {
                    System.out.print("Animal ID: ");
                    System.out.println(animalService.getbyId(sc.nextInt()));
                }
                case 10 -> {
                    System.out.println(animalService.getAll());
                }
                case 11 -> {
                    System.out.println(animalService.sortByName(1));
                }
                case 12 -> {
                    System.out.println(animalService.sortByName(2));
                }
                case 13 -> {
                    System.out.println(animalService.filtrByGender(1));
                }
                case 14 -> {
                    System.out.println(animalService.filtrByGender(2));
                }
                case 15 -> {
                    personService.clear();
                }
                case 16 -> {
                    animalService.clear();
                }
            }

        }


    }
}