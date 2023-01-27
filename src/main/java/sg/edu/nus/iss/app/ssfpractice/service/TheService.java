package sg.edu.nus.iss.app.ssfpractice.service;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.ssfpractice.models.Order;

@Service
public class TheService {
  public Double totalCost(Order order){
    Integer quantity = order.getQuantity();
    String selection = order.getPizzaname();
    String size = order.getSize();
    Boolean rush = order.getRush();
    System.out.println("quantity: " + quantity);
    System.out.println("selection: " + selection);
    System.out.println("size: " + size);
    System.out.println("rush: " + rush);
    Integer priceOfPizza = 0;
    Double multiplier = 0.0;
    if(selection.equals("bella") || selection.equals("marinara") || selection.equals("spianatacalabrese")){
      priceOfPizza = 30;
    } else if(selection.equals("margherita")){
      priceOfPizza = 22;
    } else if(selection.equals("trioformaggio")){
      priceOfPizza = 25;
    } else{
      System.out.println("there is something awfully wrong...");
    }

    if(size.equals("sm")){
      multiplier = 1.0;

    } else if(size.equals("md")){
      multiplier = 1.2;

    } else if(size.equals("lg")){
      multiplier = 1.5;

    } else{
      System.out.println("you probably made another mistake...");
    }

    if(rush){
      return ((Double)multiplier * priceOfPizza * quantity) + 2;      
    }

    return (Double)multiplier * priceOfPizza * quantity;
  }
}
