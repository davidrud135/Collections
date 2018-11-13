package collections;
/**
 * @author David Rudenko, CS-31
 */
public class FIFO {
  private int queueSize;
  private int itemsAmount;
  private int[] queue;
  /**
   * Creates queue with default size (10).
   */
  public FIFO() {
    queueSize = 10;
    itemsAmount = 0;
    queue = new int[queueSize];
  }
  /**
   * Creates queue with given size.
   * @param size maximum size of elements queue can have.
   * @throws Exception when size is negative or equals 0.
   */
  public FIFO(int size) throws Exception {
    setSize(size);
    itemsAmount = 0;
    queue = new int[queueSize];
  }
  /**
   * Adds new item to queue.
   * <br>
   * You can use call chains of this method.
   * @param value integer value.
   * @return current object state.
   * @throws Exception when queue is full already.
   */
  FIFO put(int value) throws Exception {
    if (itemsAmount != queueSize) {
      queue[itemsAmount] = value;
      itemsAmount += 1;
    } else {
      throw new Exception(String.format("Queue is full! Max size is %d!", queueSize));
    }
    return this;
  }
  /**
   * Gets first input from queue.
   * @return first item value.
   * @throws Exception when queue is empty.
   */
  int get() throws Exception {
    if (itemsAmount != 0) {
      int firstItem = queue[0];
      int queueLastIndex = queue.length - 1;
      // Moving queue to the left by 1.
      for (int i = 0; i < queueLastIndex; i++) {
        queue[i] = queue[i + 1];
      }
      queue[queueLastIndex] = 0;
      itemsAmount -= 1;
      return firstItem;
    } else {
      throw new Exception("Queue min size is 0!");
    }
  }
  /**
   * Sets new size of queue.
   * @param size integer value bigger or equals 1.
   * @throws Exception when new value is negative or equals 0.
   */
  void setSize(int size) throws Exception {
    if (size >= 1) {
      queueSize = size;
    } else {
      throw new Exception("Queue size can not be negative or equals 0!");
    }
  }
  /**
   * @return the queue size.
   */
  public int getQueueSize() {
    return queueSize;
  }
  /**
   * @return the items amount.
   */
  public int getItemsAmount() {
    return itemsAmount;
  }
  /**
   * Shows graphic interface of queue items in console.
   */
  public void drawQueue() {
    String singleSpace = " ";
    String doubleSpace = "  ";
    String tubeBorder = "_";
    String circleTop = " /  \\";
    String circleBody = "|    |";
    String circleBottom = "\\__/";
    String queueItems = "";
    for (int i = 0; i < itemsAmount; i++) {
      queueItems += queue[i];
      queueItems += singleSpace;
    }
    int queueItemsStrLength = queueItems.length();
    int tubeTopBordersAmount = queueItemsStrLength + 4 + 5;
    int spacesInsideTube = queueItemsStrLength + 2;
    int tubeBottomBordersAmount = queueItemsStrLength + 3;
    // Border
    System.out.print(doubleSpace);
    for (int i = 0; i < tubeTopBordersAmount; i++) {
      System.out.print(tubeBorder);
    }
    System.out.println("");
    // Cicrles top and spaces
    System.out.print(circleTop);
    for (int i = 0; i < spacesInsideTube; i++) {
      System.out.print(singleSpace);
    }
    System.out.println(circleTop);
    // Circles body and queue
    System.out.print(circleBody + singleSpace + queueItems + circleBody);
    System.out.println("");
    // Circles bottom and spaces
    System.out.print(singleSpace + circleBottom);
    for (int i = 0; i < tubeBottomBordersAmount; i++) {
      System.out.print(tubeBorder);
    }
    System.out.println(circleBottom);
  }
}