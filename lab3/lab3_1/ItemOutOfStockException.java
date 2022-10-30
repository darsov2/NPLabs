package lab3.lab3_1;

class ItemOutOfStockException extends Exception{
    Item item;

    public ItemOutOfStockException(Item item) {
        this.item = item;
    }
}
