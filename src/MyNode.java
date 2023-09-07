public class MyNode <T> {
    // data = data content
    private T data;
    // next = reference to the next node
    private MyNode<T> next;

    // Constructor - creating a new node
    public MyNode(T data) {
        this.data = data;
        this.next = null;
    }

    // Getters for data and next

    // Gets the node data
    public T getData() {
        return this.data;
    }

    // Gets the reference of the next node
    public MyNode<T> getNext() {
        return this.next;
    }


    // Setters for data and next

    // Sets the data content
    public void setData(T data) {
        this.data = data;
    }

    // Sets the reference to the next node
    public void setNext(MyNode<T> next) {
        this.next = next;
    }
}