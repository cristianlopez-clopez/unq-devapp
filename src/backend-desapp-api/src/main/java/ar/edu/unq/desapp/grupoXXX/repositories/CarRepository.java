package ar.edu.unq.desapp.grupoXXX.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoXXX.model.Car;


@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

	Car findById(String id);

}
