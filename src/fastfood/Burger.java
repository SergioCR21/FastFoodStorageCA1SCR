package fastfood;

import java.time.LocalDate;

public class Burger extends FoodItem {

   public Burger(String name, double weight, LocalDate bestBefore){
       super(name,weight,bestBefore);
   }
   
    @Override
    public String getCategory() {
        return "Burger";
    }
}
