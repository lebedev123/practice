package DesignPatterns.Pattreni_proektirovaniya.Fabric;

public class NYWithCheese extends Pizza {
    public NYWithCheese() {
        name = "NY pizza With Cheese";
        dough = "Extra Shit";
        sauce = "Space Maria sauce";
        toppings.add("Grated shit");
    }
}

class NYStandard extends Pizza {
    public NYStandard() {
        name = "Standard NY with cheese";
        dough = "standard";
        sauce = "Tomato ";
        toppings.add("Shredded niggers");
    }

    void cut() {
        System.out.println("Cutting the pizza int squares");
    }
}

class ChicagoWithCheese extends Pizza {
    public ChicagoWithCheese() {
        name = "Chicago extra super hot with cheese";
        dough = "cheese";
        sauce = "Pikotto";
        toppings.add("Shredded mexicans");
    }
}

class ChicagoStandard extends Pizza {
    public ChicagoStandard() {
        name="Chicago standard";
        dough = "Extra Thicc";
        sauce = "Plum tomato";
        toppings.add("Chick");
    }
}
