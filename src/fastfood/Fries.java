package fastfood;

import java.time.LocalDate;

public class Fries extends FoodItem {

   public Fries(String name, double weight, LocalDate bestBefore){
       super(name,weight,bestBefore);
   }
   
    @Override
    public String getCategory() {
        return "Fries";
    }
}
