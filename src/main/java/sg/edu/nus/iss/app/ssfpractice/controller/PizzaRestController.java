package sg.edu.nus.iss.app.ssfpractice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.app.ssfpractice.models.Notfound;
import sg.edu.nus.iss.app.ssfpractice.models.Order;
import sg.edu.nus.iss.app.ssfpractice.repository.PizzaRepo;

@RestController
@RequestMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class PizzaRestController {

  @Autowired
  PizzaRepo pizzaRepo;

  @GetMapping(path = "{id}")
  public ResponseEntity<String> getOrder(@PathVariable String id){

    Optional<Object> or = pizzaRepo.getOrder(id);
    if(or.isPresent()){
      Order order = (Order) pizzaRepo.getOrder(id).get();
      return ResponseEntity.status(HttpStatus.OK)
      .contentType(MediaType.APPLICATION_JSON)
      .body(order.toJSON().toString());
    }

    Notfound notfound = new Notfound();
    
    return ResponseEntity
    .status(HttpStatus.NOT_FOUND)
    .contentType(MediaType.APPLICATION_JSON)
    .body(notfound.toJSON(id).toString());

  }
  
}
