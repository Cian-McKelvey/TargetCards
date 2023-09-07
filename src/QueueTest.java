public class QueueTest {
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();

        q.enqueue("Milk");
        q.enqueue("Eggs");
        q.enqueue("Bread");

        for (int i = 1; i <= 4; i++) {
            System.out.println("Dequeue = " + q.dequeue());
        }

        q.enqueue("Cheese");
        q.enqueue("Steak");
        q.enqueue("Fish");

        q.clear();

        if (q.dequeue() == null) {
            System.out.println("queue is empty after clear method");
        }
    }
}