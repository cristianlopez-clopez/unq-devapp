package ar.edu.unq.desapp.grupoXXX.backenddesappapi.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.desapp.grupoXXX.backenddesappapi.model.Car;

@Transactional
@Service
public class InitService {


	@Autowired
	private CarService  carService;
	
	
	  @PostConstruct
	  public void initialize(){
		  	Car car = new Car(1,"PNA 879","Renault Clio");
		  	carService.save(car);
	  }
}
