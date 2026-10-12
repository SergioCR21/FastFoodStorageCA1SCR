package fastfood;

import java.time.LocalDate;

public class Pizza extends FoodItem {

   public Pizza(String name, double weight, LocalDate bestBefore){
       super(name,weight,bestBefore);
   }
   
    @Override
    public String getCategory() {
        return "Pizza";
    }
}
