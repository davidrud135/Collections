package collections;

public class Collections {
  public static void main(String[] args) throws Exception {
    LIFO stack = new LIFO();
    stack.push(890).push(34).push(3).push(90000).push(1);
    stack.drawStack();
    stack.pop();
    stack.pop();
    stack.drawStack();
    
    FIFO queue = new FIFO(5);
    queue.put(2).put(983).put(54).put(366);
    queue.drawQueue();
    queue.get();
    queue.drawQueue();
    queue.get();
    queue.drawQueue();
  }
}
