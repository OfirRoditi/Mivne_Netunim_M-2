import java.security.spec.ECField;
import java.util.EmptyStackException;

public class MyStack {
    int[] array;
    int top = -1;

    public MyStack() {
        array = new int[3];
    }

    protected boolean isEmpty() {
        try {
            if (top == -1) {
                throw new Exception();
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    protected void push(int index)
    {
        int size = array.length;
        //Every time its getting full we enter and double the array.
        if (size - 1 == top)
        {
            int[] newArray = new int[0];
            //System.out.println("Stuck is full. Creating new array");
            newArray = new int[size * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            newArray[++top] = index;
            array = newArray;
        } else array[++top] = index;


    }

    protected int pop() {
        isEmpty();
        int value = array[top];
        top--;
        return value;
    }

    protected int peek() {
        return array[top];
    }

    public String toString() {  // Define a method called toString that returns a string representation of the stack
        isEmpty();
           // Otherwise
            String string = "["; // Create a new string starting with an opening bracket
            for (int i = 0; i <= top; i++) { // Loop through each element of the stack (from the bottom to the top)
                string += array[i]; // Add the current element to the string
                if (i < top) // If the current element is not the top element,
                    string += ", "; // add a comma and a space after it
            }
            return string + "]"; // Return the string with a closing bracket


    }
}




