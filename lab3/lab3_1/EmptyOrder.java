package lab3.lab3_1;

class EmptyOrder extends Exception{
    @Override
    public String getMessage() {
        return "EmptyOrder";
    }
}
