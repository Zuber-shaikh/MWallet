package mwallet.repositories;

import java.util.List;

public interface CRUDOperations<T, ID> {
    public T save(T entity);
    public List<T> getAll();
    public void delete(T entity);
}

