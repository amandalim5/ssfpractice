package sg.edu.nus.iss.app.ssfpractice.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Customer {
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

  
  
}
