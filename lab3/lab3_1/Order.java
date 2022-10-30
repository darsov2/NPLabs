package lab3.lab3_1;

import java.util.Arrays;

class Order {
    Item [] items;
    int [] qty;
    boolean locked;

    public Order()
    {
        items = new Item[0];
        qty = new int[0];
        locked = false;
    }

    private int checkItem(Item item)
    {
        for(int i = 0; i < items.length; i++)
        {
            if(item.getName().equals(items[i].getName()))
            {
                return i;
            }
        }
        return -1;
    }

    public void addItem(Item item, int count) throws ItemOutOfStockException, OrderLockedException {
        if(locked)
        {
            throw new OrderLockedException();
        }
        if(count > 10)
        {
            throw new ItemOutOfStockException(item);
        }
        int contains = checkItem(item);
        if(contains != -1)
        {
            items[contains] = item;
            qty[contains] = count;
        }
        else
        {
            items = Arrays.copyOf(items, items.length + 1);
            qty = Arrays.copyOf(qty, qty.length + 1);
            items[items.length - 1] = item;
            qty[qty.length - 1] = count;
        }
    }

    public int getPrice()
    {
        int sum = 0;

        for(int i = 0; i < items.length; i++)
        {
            sum += items[i].getPrice() * qty[i];
        }

        return sum;
    }

    public void displayOrder()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < items.length; i++)
        {
            sb.append(String.format("%3d.%-14s x%2d%5d$\n", i + 1, items[i].getName(), qty[i], qty[i] * items[i].getPrice()));
        }
        sb.append(String.format("%-22s%5d$", "Total:", getPrice()));
        System.out.println(sb);
    }

    public void removeItem(int idx) throws ArrayIndexOutOfBоundsException, OrderLockedException
    {
        if(locked)
        {
            throw new OrderLockedException();
        }
        if(idx < 0 || idx > items.length)
        {
            throw new ArrayIndexOutOfBоundsException(idx);
        }
        for(int i = idx + 1; i < items.length; i++)
        {
            items[i - 1] = items[i];
        }
        items = Arrays.copyOf(items, items.length - 1);
    }

    public void lock() throws EmptyOrder
    {
        if(items.length < 1)
        {
            throw new EmptyOrder();
        }
        locked = true;
    }

}
