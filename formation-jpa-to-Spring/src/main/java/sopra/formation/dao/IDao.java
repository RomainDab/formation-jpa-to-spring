package sopra.formation.dao;

import java.util.List;

public interface IDao<T, PK> {
	List<T> findAll();

	T findById(Long id);

	T save(T obj);

	void deleteById(Long id);

	void delete(T obj);
}
