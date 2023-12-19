package dao;

import java.util.List;

public interface DaoCRUD<T, ID> {
    boolean add(T type);
    T getById (ID id);
    List<T> getAll();
    T remove(T t);
}
