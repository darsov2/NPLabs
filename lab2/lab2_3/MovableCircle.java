package lab2.lab2_3;

class MovableCircle implements Movable{
    int radius;
    MovablePoint center;

    public MovableCircle(int radius, MovablePoint center)
    {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void moveUp() throws ObjectCanNotBeMovedException
    {
        center.moveUp();
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException
    {
        center.moveLeft();
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException
    {
        center.moveRight();
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException
    {
        center.moveDown();
    }

    @Override
    public int getCurrentXPosition()
    {
        return center.getCurrentXPosition();
    }

    @Override
    public int getCurrentYPosition()
    {
        return center.getCurrentYPosition();
    }

    public int getRadius()
    {
        return radius;
    }

    @Override
    public String toString()
    {
        return "Movable circle with center coordinates (" +
                center.getCurrentXPosition() + "," + center.getCurrentYPosition() + ')' +
                " and radius " + radius;
    }

    public TYPE typeOf()
    {
        return TYPE.CIRCLE;
    }
}
