package lab2.lab2_3;

import java.util.ArrayList;
import java.util.Arrays;

class MovablesCollection {
    Movable [] movable;
    static int x_MAX = 0, y_MAX = 0;

    public MovablesCollection(int x_MAX, int y_MAX)
    {
        this.x_MAX = x_MAX;
        this.y_MAX = y_MAX;
        movable = new Movable[0];
    }

    public static void setxMax(int i)
    {
        x_MAX = i;
    }

    public static void setyMax(int i)
    {
        y_MAX = i;
    }

    public void addMovableObject(Movable m) throws MovableObjectNotFittableException {
        if(m.typeOf() == TYPE.CIRCLE)
        {
            if(m.getCurrentXPosition() + ((MovableCircle) m).getRadius() > x_MAX || m.getCurrentXPosition() - ((MovableCircle) m).getRadius() < 0 || m.getCurrentYPosition() + ((MovableCircle) m).getRadius() > y_MAX || m.getCurrentYPosition() - ((MovableCircle) m).getRadius()< 0)
            {
                throw new MovableObjectNotFittableException(m);
            }
        }
        if(m.getCurrentXPosition() > x_MAX || m.getCurrentXPosition() < 0 || m.getCurrentYPosition() > y_MAX || m.getCurrentYPosition() < 0)
        {
            throw new MovableObjectNotFittableException(m);
        }
        movable = Arrays.copyOf(movable, movable.length + 1);
        movable[movable.length - 1] = m;
    }

    public void moveObjectsFromTypeWithDirection(TYPE type, DIRECTION direction)
    {
        for(Movable m : movable)
        {
            if(m.typeOf() == type)
            {
                try
                {
                    if(direction == DIRECTION.UP)
                    {
                        m.moveUp();
                    }
                    else if(direction == DIRECTION.DOWN)
                    {
                        m.moveDown();
                    }
                    else if(direction == DIRECTION.LEFT)
                    {
                        m.moveLeft();
                    }
                    else if(direction == DIRECTION.RIGHT)
                    {
                        m.moveRight();
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }

            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Collection of movable objects with size " +
                movable.length + ":\n");
        for (Movable m: movable)
        {
            sb.append(m.toString() + '\n');
        }
        return sb.toString();
    }
}
