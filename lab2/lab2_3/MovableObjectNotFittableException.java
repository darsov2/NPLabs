package lab2.lab2_3;

class MovableObjectNotFittableException extends Exception{
    Movable mov;

    public MovableObjectNotFittableException(Movable mov)
    {
        this.mov = mov;
    }

    @Override
    public String getMessage() {
        return mov.toString().replace("center coordinates ", "") + " can not be fitted into the collection";
    }
}
