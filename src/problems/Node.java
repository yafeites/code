package problems;

public class Node {

    public Node pre;

    public int value;
    public Node next;
    public Node left;
    public Node right;
    public Node parent;

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRnd() {
        return rnd;
    }

    public void setRnd(Node rnd) {
        this.rnd = rnd;
    }

    public Node rnd;
    public Node next()
    {
        return this.next;
    }

    public Node(int value) {
        this.value = value;
    }

    public Node() {

    }
}
