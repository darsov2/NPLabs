package lab2.lab2_3;

interface Movable {

    void moveUp() throws ObjectCanNotBeMovedException;
    void moveLeft() throws ObjectCanNotBeMovedException;
    void moveRight() throws ObjectCanNotBeMovedException;
    void moveDown() throws ObjectCanNotBeMovedException;

    int getCurrentXPosition();
    int getCurrentYPosition();

    TYPE typeOf();
}
