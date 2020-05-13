package ar.edu.unq.desapp.grupoXXX.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoXXX.model.Car;
import ar.edu.unq.desapp.grupoXXX.repositories.CarRepository;


@Service
@Transactional
public class CarService  {

	@Autowired
	private CarRepository  repository;
	
	public Car save(Car model) {
		return this.repository.save(model);
	}

	public Car findByID(String id) {
		return this.repository.findById(id);
	}

}