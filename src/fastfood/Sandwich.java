package fastfood;

import java.time.LocalDate;

public class Sandwich extends FoodItem {

   public Sandwich(String name, double weight, LocalDate bestBefore){
       super(name,weight,bestBefore);
   }
   
    @Override
    public String getCategory() {
        return "Sandwich";
    }
}
