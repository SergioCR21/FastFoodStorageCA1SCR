package fastfood;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Storage implements StorageOperations {
    
    //=======Constants==========
    public static final int MAX_CAPACITY = 8;
    public static final int MODE_ONE_SIDE = 1;
    public static final int MODE_TWO_SIDES = 2;
    
    //=======ATRIBBUTES======
    
    private Deque<FoodItem> items;
    private int mode;
    
    //======Constructor=====
    public Storage(int mode){
        this.items = new ArrayDeque<>();
        this.mode = mode;
    }
    
    // ===== Getter and Setter =====
    public int getMode() {
        return mode;
    }
    
    public void setMode(int mode) {
    if (mode == MODE_ONE_SIDE || mode == MODE_TWO_SIDES) {
        this.mode = mode;
        System.out.println("Mode changed to: " + mode);
    } else {
        System.out.println("ERROR: Invalid mode. Use 1 or 2.");
    }
    }

    //Interface methods
    
    
   @Override
    public boolean add(FoodItem item) {
    // 1. Check iten is not null
    if (item == null) {
        System.out.println("ERROR: Item cannot be null.");
        return false;
    }

    // 2. check Storage is not full
    if (isFull()) {
        System.out.println("ERROR: Storage is full (max " + MAX_CAPACITY + " items).");
        return false;
    }

    // 3. Check weight is greater than 0
    if (item.getWeight() <= 0) {
        System.out.println("ERROR: Weight must be greater than 0.");
        return false;
    }

    // 4. check Dates best-before is between today and 2 weeks from today 
    java.time.LocalDate today = java.time.LocalDate.now();
    java.time.LocalDate maxDate = today.plusWeeks(2);

    if (item.getBestBefore() == null) {
        System.out.println("ERROR: Best-before date cannot be null.");
        return false;
    }

    if (item.getBestBefore().isBefore(today)) {
        System.out.println("ERROR: Best-before date is in the past.");
        return false;
    }

    if (item.getBestBefore().isAfter(maxDate)) {
        System.out.println("ERROR: Best-before date cannot be more than 2 weeks from today.");
        return false;
    }

    // 5. Add front of deque
    items.addFirst(item);
    System.out.println("SUCCESS: " + item.getName() + " added to storage.");
    return true;
}

     /* Removes an item from the storage based on the current mode.
     * Mode 1: removes from front.
     * Mode 2: removes from back.
     */
    
    @Override
    public FoodItem remove() {
    // 1. check item is not empty
    if (isEmpty()) {
        System.out.println("ERROR: Storage is empty. Nothing to remove.");
        return null;
    }

    // 2. Remover base in mode
    FoodItem removed;

    if (mode == MODE_ONE_SIDE) {
        // Modo 1: removes from front (same side as add)
        removed = items.removeFirst();
    } else {
        // Modo 2: removes from back
        removed = items.removeLast();
    }

    System.out.println("REMOVED: " + removed.getName() + " from storage.");
    return removed;
    }
    
    /**
     * Shows the first item without removing it.
     * Time complexity: O(1).
     */

    @Override
    public FoodItem peek() {
       //validate storage is not empty
        if (isEmpty()) {
        System.out.println("ERROR: Storage is empty. Nothing to peek.");
        return null;
      
    }
        //Check first Item without removing it
        FoodItem top = items.peekFirst();
        System.out.println("TOP ITEM: " + top);
    return top;
    }

    @Override
    public FoodItem search(String name) {
         // 1. check entry
    if (name == null || name.trim().isEmpty()) {
        System.out.println("ERROR: Search name cannot be empty.");
        return null;
    }

    // 2. Check storage is not empty 
    if (isEmpty()) {
        System.out.println("ERROR: Storage is empty. Nothing to search.");
        return null;
    }

    // 3. moving throught using iterator
    Iterator<FoodItem> it = items.iterator();
    while (it.hasNext()) {
        FoodItem current = it.next();
        if (current.getName().equalsIgnoreCase(name.trim())) {
            System.out.println("FOUND: " + current);
            return current;
        }
    }

    // 4.Not found
    System.out.println("NOT FOUND: No item named '" + name + "' in storage.");
    return null;
    }

    
    @Override
    public void display() {
    // 1. check if dtorage is emnpty 
    if (isEmpty()) {
        System.out.println("Storage is empty. Nothing to display.");
        return;
    }

    // 2. Mostrar cabecera
    System.out.println("\n===== STORAGE CONTENTS (" + items.size() + "/" + MAX_CAPACITY + ") =====");

    // 3. Recorrer con Iterator
    Iterator<FoodItem> it = items.iterator();
    int index = 1;
    while (it.hasNext()) {
        FoodItem current = it.next();
        System.out.println(index + ". " + current);
        index++;
    }

    System.out.println("==========================================\n");
}

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return items.size() >= MAX_CAPACITY;
    }

    // ===== Auxilary methods =====
    public int size() {
        return items.size();
    }
}


