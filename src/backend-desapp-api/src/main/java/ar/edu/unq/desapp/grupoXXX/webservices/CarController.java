package ar.edu.unq.desapp.grupoXXX.webservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupoXXX.services.CarService;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/api/car/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getCar(@PathVariable("id") String id) {
        carService.findByID(id);
        return ResponseEntity.ok().build();
    }
    
    @RequestMapping(value = "/api/version", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getVersion() {
    	String version = "0.2.1";
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("version", version);
		return ResponseEntity.ok().body(resultado);
	}
   
}