package lab3.lab3_1;

import java.util.Arrays;

class ExtraItem implements Item{
    String type;
    int price;

    public ExtraItem(String type) throws InvalidExtraTypeException
    {
        String [] extras = new String[]{"Coke", "Ketchup"};
        int [] prices = new int[]{5, 3};
        if(!Arrays.asList(extras).contains(type))
        {
            throw new InvalidExtraTypeException();
        }
        this.type = type;
        this.price = type.equals(extras[0]) ? prices[0] : type.equals(extras[1]) ? prices[1] : prices[2];
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
