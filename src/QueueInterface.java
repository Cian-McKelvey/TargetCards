public interface QueueInterface <T> {

    public void enqueue(T newEntry);
    /* Adds a new entry to the back of the queue

    @param (T) newEntry - the item to be added to the bag

    */

    public T dequeue();
    /* Removes entry from the front of the queue

    @return - (T) the item removed from the queue

    */

    public void clear();
    /* Removes everything in the queue

    */
}