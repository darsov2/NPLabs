package lab3.lab3_1;

class ArrayIndexOutOfBоundsException extends Exception{
    int index;

    public ArrayIndexOutOfBоundsException(int index)
    {
        this.index = index;
    }
}
