public class Queue<T> implements QueueInterface<T>{

    private MyNode<T> front, rear;

    // Constructor
    public Queue() {
        front = null;
        rear = null;
    }

    // Add new objects to the queue
    public void enqueue(T newEntry){
        MyNode<T> newNode = new MyNode<T>(newEntry);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    // Remove objects from the queue
    public T dequeue() {
        if (front == null)
            return null;
        else {
            T returnedValue = front.getData();
            front = front.getNext();

            if (front == null)
                rear = null;

            return returnedValue;
        }
    }

    // Removing all items in the queue
    public void clear() {
        front = null;
        rear = null;
    }

}