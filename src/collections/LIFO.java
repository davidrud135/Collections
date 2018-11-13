package collections;
/**
 * @author David Rudenko, group CS-31
 */
public class LIFO {
  private int stackSize;
  private int itemsAmount;
  private int[] stack;
  /**
   * Creates stack with default size (10).
   */
  public LIFO() {
    stackSize = 10;
    itemsAmount = 0;
    stack = new int[stackSize];
  }
  /**
   * Creates stack with given size.
   * @param size maximum size of elements stack can have.
   * @throws Exception when size is negative or equals 0.
   */
  public LIFO(int size) throws Exception {
    setSize(size);
    itemsAmount = 0;
    stack = new int[stackSize];
  }
  /**
   * Adds new item to stack.
   * <br>
   * You can use call chains of this method.
   * @param value integer value.
   * @return current object state.
   * @throws Exception when stack is full already.
   */
  LIFO push(int value) throws Exception {
    if (itemsAmount != stackSize) {
      stack[itemsAmount] = value;
      itemsAmount += 1; 
    } else {
      throw new Exception(String.format("Stack is full! Max size is %d!", stackSize));
    }
    return this;
  }
  /**
   * Gets last input from stack.
   * @return last input value.
   * @throws Exception when stack is empty.
   */
  int pop() throws Exception {
    if (itemsAmount != 0) {
      int lastItemIndex = itemsAmount - 1;
      int lastStackItem = stack[lastItemIndex];
      stack[lastItemIndex] = 0;
      itemsAmount -= 1;
      return lastStackItem;
    } else {
      throw new Exception("Stack is empty!");
    }
  }
  /**
   * Sets new size of stack.
   * @param size integer value bigger or equals 1.
   * @throws Exception when new value is negative or equals 0.
   */
  void setSize(int size) throws Exception {
    if (size >= 1) {
      stackSize = size;
    } else {
      throw new Exception("Stack size can not be negative or equals 0!");
    }
  }
  /**
   * @return the stack size.
   */
  public int getStackSize() {
    return stackSize;
  }
  /**
   * @return the items amount.
   */
  public int getItemsAmount() {
    return itemsAmount;
  }
  /**
   * Shows graphic interface of stack items in console.
   */
  public void drawStack() {
    String singleSpace = " ";
    String doubleSpace = "  ";
    String tubeBorder = "_";
    String circleTop = " /  \\";
    String circleBody = "|    |";
    String circleBottom = "\\__/";
    String stackItems = "";
    for (int i = 0; i < itemsAmount; i++) {
      stackItems += stack[i];
      stackItems += singleSpace;
    }
    int stackItemsStrLength = stackItems.length();
    int tubeTopBordersAmount = stackItemsStrLength + 4;
    int spacesInsideTube = stackItemsStrLength;
    int tubeBottomBordersAmount = stackItemsStrLength + 1;
    // Border
    System.out.print(doubleSpace);
    for (int i = 0; i < tubeTopBordersAmount; i++) {
      System.out.print(tubeBorder);
    }
    System.out.println("");
    // Cicrles top and spaces
    System.out.print(" /");
    for (int i = 0; i < spacesInsideTube; i++) {
      System.out.print(singleSpace);
    }
    System.out.println(circleTop);
    // Circles body and stack
    System.out.print("| " + stackItems + circleBody);
    System.out.println("");
    // Circles bottom and spaces
    System.out.print(singleSpace + "\\");
    for (int i = 0; i < tubeBottomBordersAmount; i++) {
      System.out.print(tubeBorder);
    }
    System.out.println(circleBottom);
  }
}