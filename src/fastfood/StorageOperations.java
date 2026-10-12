/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fastfood;
/**
 * Interface that will define the storage basic operations
 * Any Class must be included in this methods
 */
/**
 *
 * @author Dzhad
 */
public interface StorageOperations {
    
    boolean add(FoodItem item);
    
    FoodItem remove();
    
    FoodItem peek();

    FoodItem search(String name);

    void display();

    boolean isEmpty();

    boolean isFull();
}
