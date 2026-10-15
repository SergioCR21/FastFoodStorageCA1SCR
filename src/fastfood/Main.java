package fastfood;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage(Storage.MODE_TWO_SIDES);
        
        // Main loop: keeps showing the menu until the user chooses Exit
        while(true){
            //shows menu
            System.out.println("=======FAST FOOD STORAGE=====");
            System.out.println("1. Add Food Item");
            System.out.println("2. Remove Food Item");
            System.out.println("3. Peek top Item");
            System.out.println("4. Search Item");
            System.out.println("5. Display all");
            System.out.println("6. Change Mode");
            System.out.println("7. Exit");
            System.out.println("Choose am option");
            
            int option = sc.nextInt();
            sc.nextLine();//clears buffer
            
            switch (option){
                case 1->{
                    //Ask user food type
                    System.out.println("Type (1=Burger, 2=Pizza, 3=Fries, 4=Sandwich, 5=Hotdog");
                    String tipoStr = sc.nextLine();
                    int tipo;
                    try{
                        tipo = Integer.parseInt(tipoStr);
                    }catch (Exception e){
                        System.out.println("Error type must be a number");
                        continue;
                    }
                    
                    // Ask user for name
                    System.out.print("Name: ");
                    String nombre = sc.nextLine();
                    
                    System.out.print("Weight (g): ");
                    String pesoStr = sc.nextLine();
                    double peso;
                        try{
                            peso = Double.parseDouble(pesoStr);
                        } catch (Exception e){
                            System.out.println("Error: weight must be a number");
                            continue;
                        }

                    //Ask user for the best-before date
                    System.out.print("Best-before date (yyyy-MM-dd): ");
                    String fechaStr = sc.nextLine();
                    
                    
                    try{
                        LocalDate fecha = LocalDate.parse(fechaStr);
                        FoodItem item = null;
                        
                        if(tipo == 1){
                            item = new Burger (nombre, peso, fecha);
                        }else if (tipo == 2){
                            item = new Pizza (nombre, peso, fecha);
                  
                        }else if (tipo == 3){
                            item = new Fries (nombre, peso, fecha);
                        }else if (tipo == 4){
                            item = new Sandwich (nombre, peso, fecha);
                        }else if (tipo == 5){
                            item = new Hotdog (nombre, peso, fecha);
                        }else{
                            System.out.println("Invalid fOOD Type");
                        }
                        
                        
                        //Add the item to storage ( only if it was created successfully)
                        
                        if(item != null){
                            storage.add(item);
                        } 
                    }catch(Exception e){
                        System.out.println("Error Invalid date format. Use yyyy-MM-dd.");
                    }
                }
                case 2 -> {
                    storage.remove();
                }
                case 3 -> {
                    storage.peek();
                }
                case 4 -> {
                    System.out.println("Enter name to search: ");
                    String nombreBuscar = sc.nextLine();
                    storage.search(nombreBuscar);
                }
                case 5 -> {
                    storage.display();
                }
                case 6 -> {
                    System.out.println("Mode (1= One side, 2=Two sides");
                    int nuevoModo = sc.nextInt();
                    sc.nextLine();
                    storage.setMode(nuevoModo);
                }
                case 7 ->{
                    System.out.println("Thank you. GoodBye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again");
            } 
        }  
    }
}
