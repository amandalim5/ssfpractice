package sg.edu.nus.iss.app.ssfpractice.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Pizza {
  @NotBlank (message = "Please choose a pizza.")
  private String selection;

  @NotBlank (message = "Please choose a size.")
  private String size;

  @NotNull (message = "Please put a quantity")
  @Min(value = 1, message = "Please choose 1 or more.")
  @Max(value = 10, message = "Please choose 10 or less.")
  private Integer quantity;

  public String getSelection() {
    return selection;
  }

  public void setSelection(String selection) {
    this.selection = selection;
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

  
}
