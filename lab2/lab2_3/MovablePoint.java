package lab2.lab2_3;

class MovablePoint implements Movable{

    int x, y, xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed)
    {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }




    @Override
    public void moveUp() throws ObjectCanNotBeMovedException
    {
        if(y + ySpeed > MovablesCollection.y_MAX || y + ySpeed < 0)
        {
            throw new ObjectCanNotBeMovedException(new MovablePoint(x, y + ySpeed));
        }
        y += ySpeed;
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException
    {
        if(x - xSpeed > MovablesCollection.x_MAX || x - xSpeed < 0)
        {
            throw new ObjectCanNotBeMovedException(new MovablePoint(x-xSpeed, y));
        }
        x -= xSpeed;
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException
    {
        if(x + xSpeed > MovablesCollection.x_MAX || x + xSpeed < 0)
        {
            throw new ObjectCanNotBeMovedException(new MovablePoint(x+xSpeed, y));
        }
        x += xSpeed;
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException
    {
        if(y - ySpeed > MovablesCollection.y_MAX || y - ySpeed < 0)
        {
            throw new ObjectCanNotBeMovedException(new MovablePoint(x, y - ySpeed));
        }
        //y -= ySpeed;
    }

    @Override
    public int getCurrentXPosition()
    {
        return x;
    }

    @Override
    public int getCurrentYPosition()
    {
        return y;
    }

    @Override
    public String toString()
    {
        return "Movable point with coordinates (" + x + "," + y + ')';
    }

    public TYPE typeOf()
    {
        return TYPE.POINT;
    }
}
