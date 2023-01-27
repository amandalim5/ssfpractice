package sg.edu.nus.iss.app.ssfpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.app.ssfpractice.models.Order;
import sg.edu.nus.iss.app.ssfpractice.models.Pizza;
import sg.edu.nus.iss.app.ssfpractice.repository.PizzaRepo;
import sg.edu.nus.iss.app.ssfpractice.service.TheService;

@Controller
@RequestMapping(path="/")
public class PizzaController {

  Order newOrder = new Order();

  @Autowired
  TheService service;

  @Autowired
  PizzaRepo pizzaRepo;
  
  @GetMapping
  public String getOrderForm(Model model){
    model.addAttribute("pizza", new Pizza());
    return "index";
  }

  @PostMapping(path = "/pizza", consumes = "application/x-www-form-urlencoded", produces = "text/html")
  public String returnOrderForm(@Valid @ModelAttribute("pizza") Pizza pizza, BindingResult bind, Model model){
    if(bind.hasErrors()){
      model.addAttribute("pizza", pizza);
      return "index";
    }

    System.out.println("==========created an order with id" + newOrder.getId());
    newOrder.setPizzaname(pizza.getSelection());
    System.out.println("===========setting the pizza name" + pizza.getSelection());
    newOrder.setSize(pizza.getSize());
    System.out.println("===========setting the pizza size" + pizza.getSize());
    newOrder.setQuantity(pizza.getQuantity());
    System.out.println("===========setting the pizza quantity" + pizza.getQuantity());
    model.addAttribute("customer", newOrder);
    return "verify";
  }

  @PostMapping(path = "/pizza/order", consumes = "application/x-www-form-urlencoded", produces = "text/html")
  public String verify(@Valid @ModelAttribute("customer") Order order, BindingResult bind, Model model){
    if(bind.hasErrors()){
      model.addAttribute("customer", order);
      System.out.println("will this be printed..." + newOrder.getId());
      return "verify";
    }
    order.setPizzaname(newOrder.getPizzaname());
    order.setSize(newOrder.getSize());
    order.setQuantity(newOrder.getQuantity());
    System.out.println(order.getPizzaname() + "is there a pizza name here???");
    order.setCost(service.totalCost(order)); 
    System.out.println("the order's customer: " + order.getCname());
    model.addAttribute("order", order);
    Integer rush = 0;
    if(order.getRush()){
      rush = 2;
    }
    Double pizzaCost = order.getCost() - rush;
    model.addAttribute("thePizzaCost", pizzaCost);
    pizzaRepo.add(order.getId(), order);
    return "confirmation";
  }


}
