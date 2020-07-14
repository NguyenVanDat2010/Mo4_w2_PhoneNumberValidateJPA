package demo.service;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
