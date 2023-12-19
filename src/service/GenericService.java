package service;

import java.util.List;

public interface GenericService <T> {
    String add(List<T> t);
    T getbyId(int id);
    List<T> getAll();
    List<T> sortByName(int num);
    List<T> filtrByGender(int num);
    List<T> clear();
}
