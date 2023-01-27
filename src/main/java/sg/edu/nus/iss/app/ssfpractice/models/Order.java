package sg.edu.nus.iss.app.ssfpractice.models;

import java.util.Random;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Order {
  private String id;
  @NotBlank(message = "Please provide a name.")
  @Size(min = 3, message = "Please provide a longer name.")
  private String cname;

  @NotBlank(message = "Please provide an address.")
  private String address;

  @NotBlank(message = "Please provide a phone number.")
  @Size(min = 8, max = 8, message = "Please provide a phone number 8 digits long.")
  private String phone;

  private Boolean rush = false;

  private String comments;

  private String pizzaname;
  private String size;
  private Integer quantity;
  private Double cost;

  private synchronized String generateId(int numChars){
    Random r = new Random();
    StringBuilder sb = new StringBuilder();
    while(sb.length() < numChars){
      sb.append(Integer.toHexString(r.nextInt()));
    }
    return sb.toString().substring(0,numChars);
  }

  public Order(){
    if(this.id == null){
      this.id=this.generateId(8);
      System.out.println(this.id);
    }

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Boolean getRush() {
    return rush;
  }

  public void setRush(Boolean rush) {
    this.rush = rush;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getPizzaname() {
    return pizzaname;
  }

  public void setPizzaname(String pizzaname) {
    this.pizzaname = pizzaname;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
    System.out.println("++++++++" + cost);
  }

  public JsonObject toJSON() {
    return Json.createObjectBuilder()
            .add("orderId", this.getId())
            .add("name", this.getCname())
            .add("address", this.getAddress())
            .add("phone", this.getPhone())
            .add("rush", this.getRush())
            .add("comments", this.getComments())
            .add("pizza", this.getPizzaname())
            .add("size", this.getSize())
            .add("quantity", this.getQuantity())
            .add("total", this.getCost())
            .build();
  }
}
