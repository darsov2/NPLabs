package lab2.lab2_3;

class ObjectCanNotBeMovedException extends Exception{
    Movable m;

    public ObjectCanNotBeMovedException(Movable m)
    {
        this.m = m;
    }

    @Override
    public String getMessage()
    {
        return "Point (" + m.getCurrentXPosition() + "," + m.getCurrentYPosition() + ")  is out of bounds";
    }
}
