package lab3.lab3_1;

import java.util.Arrays;

class PizzaItem implements Item{
    String type;
    int price;

    public PizzaItem(String type) throws InvalidPizzaTypeException
    {
        String []pizzas = new String[]{"Standard", "Pepperoni", "Vegetarian"};
        int [] prices = new int[]{10, 12, 8};
        if(!Arrays.asList(pizzas).contains(type))
        {
            throw new InvalidPizzaTypeException();
        }
        this.type = type;
        this.price = type.equals(pizzas[0]) ? prices[0] : type.equals(pizzas[1]) ? prices[1] : prices[2];
    }

    public int getPrice()
    {
        return price;
    }

    @Override
    public String getName() {
        return type;
    }
}
