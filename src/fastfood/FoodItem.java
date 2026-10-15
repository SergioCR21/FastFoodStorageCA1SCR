package fastfood;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FoodItem {
    private String name;
    private double weight; //weight in grams
    private LocalDate bestBefore; //Max two weeks after Todays date
    private LocalDateTime timePlaced;
    
    //======Constructor====
    public FoodItem(String name, double weight, LocalDate bestBefore) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.timePlaced = LocalDateTime.now();
    }
    //=======Getters==== 
    public String getName(){
        return name;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public LocalDate getBestBefore(){
        return bestBefore;
    }
    
    public LocalDateTime getTimePlaced(){
        return timePlaced;
    }
    
    //======Setters====
    public void setName(String name){
        this.name = name;
    }
    
    public void setWeight(double weight){
        this.weight = weight;
    }
    
    public void setBestBefore(LocalDate bestBefore){
        this.bestBefore = bestBefore;
    }
    
    //Subclass Get info
    
    public String getCategory(){
        return "Generic Food";
    }
    
    // To String to present information 
    @Override
public String toString() {
    DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    return String.format(
        "[%s] %s | %.1f g | Best before: %s | Placed: %s",
        getCategory(),
        name,
        weight,
        bestBefore.format(dateFmt),
        timePlaced.format(timeFmt)
    );
}
}
