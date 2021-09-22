package ar.edu.unq.desapp.grupoXXX.backenddesappapi.webservices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoXXX.backenddesappapi.model.Car;
import ar.edu.unq.desapp.grupoXXX.backenddesappapi.services.CarService;

@RestController
@EnableAutoConfiguration
public class CarRestService {

	@Autowired
	private CarService carService;

	// CarService carService = new CarService();

	@GetMapping("/api/cars")
	public ResponseEntity<?> allCars() {
		List<Car> list = otroMetodo();
		return ResponseEntity.ok().body(list);
	}

	private List<Car> otroMetodo() {
		List<Car> list = carService.findAll();
		return list;
	}

	@RequestMapping(value = "/api/version", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getVersion() {
		String version = "0.2.2";
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("version", version);
		return ResponseEntity.ok().body(resultado);
	}

}