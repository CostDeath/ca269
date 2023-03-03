package week6;

import java.util.*;

class Item {
    final String name;
    final double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return(this.name);
    }
}

class Basket {
    private final Stack<Item> basket;

    Basket() {
        this.basket = new Stack<>();
    }

    public void addItem(Item item) {
        basket.push(item);
    }

    public Item removeItem() {
        if(this.basket.isEmpty()) {
            return(null);
        }
        return(basket.pop());
    }

    public String toString() {
        return "basket:" + this.basket.toString();
    }
}

class Checkout {
    private final Queue<Item> checkout;

    Checkout(Basket basket) {
        checkout = new LinkedList<>();
        Item item = basket.removeItem();
        while(item != null) {
            addItem(item);
            item = basket.removeItem();
        }
    }

    public void addItem(Item item) {
        checkout.add(item);
    }

    public Item removeItem() {
        Item item = checkout.peek();
        if(item != null) {
            checkout.remove();
        }
        return(item);
    }

    public String toString() {
        return "checkout:" + this.checkout.toString();
    }
}

class Bill {
    private final Map<String,Integer> basket;
    private double price;

    Bill(Checkout checkout) {
        this.basket = new LinkedHashMap<>();
        this.price = 0;
        Item item = checkout.removeItem();
        while(item != null) {
            billItem(item);
            item = checkout.removeItem();
        }
    }

    public void billItem(Item item) {
        if(basket.containsKey(item.name)) {
            basket.replace(item.name, basket.get(item.name) + 1);
        }
        else {
            basket.put(item.name, 1);
        }
        this.price += item.price;
    }

    public double getTotal() {
        return this.price;
    }

    public String toString() {
        String output = "";
        for(String item: this.basket.keySet()) {
            output += item + " (" + this.basket.get(item) + "nos)\n";
        }
        return output + "total: " + this.price;
    }
}

public class ShopInventory2 {
    public static void main(String[] args) {
        Basket basket = new Basket();
        loadBasket(basket);
        // System.out.println(basket); // for DEBUG
        Checkout checkout = new Checkout(basket);
        // System.out.println(checkout); // for DEBUG
        Bill bill = new Bill(checkout);
        System.out.println(bill);
    }

    static void loadBasket(Basket basket) {
        basket.addItem(new Item("Twinings Earl Grey Tea", 4.50));
        basket.addItem(new Item("Folans Orange Marmalade", 4.00));
        basket.addItem(new Item("Free-range Eggs", 3.35));
        basket.addItem(new Item("Brennan's Bread", 2.15));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
    }
}
