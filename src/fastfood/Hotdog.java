package fastfood;

import java.time.LocalDate;

public class Hotdog extends FoodItem {

   public Hotdog(String name, double weight, LocalDate bestBefore){
       super(name,weight,bestBefore);
   }
   
    @Override
    public String getCategory() {
        return "Hotdog";
    }
}