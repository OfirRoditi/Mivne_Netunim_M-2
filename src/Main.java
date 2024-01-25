// Itamar Shapira 315387902 & Ofir Roditi 208647297

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        System.out.println("Cool");
        MyStack f0 = new MyStack();
        MyStack f1 = new MyStack();
        MyStack f2 = new MyStack();

        f1.push(1);
        f1.push(66);
        f1.push(7);
        f2.push(8);
        f0.push(5000);
        f1.push(99);

        HStack h1 = new HStack(f0, f1, f2);
        reOrder(f1);
        System.out.println(f1);
        sort(f1);
        System.out.println(f1);
        numIsExists(f1, 99);
        System.out.println(f1.toString());
        moveLargestToTop(h1);
        f1.toString();
        combineAndSort(h1);
        f0.toString();
        f1.toString();
        f2.toString();
    }//Methods!

    public static void reOrder(MyStack stack) {
        int size = stack.top + 1;
//        MyStack tempStack = new MyStack();
//        for(int i = 0;i<size;i++)
//        {
//            tempStack.array[i] = stack.array[i];
//        }
        int[] reversedArray = new int[size];

        // Pop elements from the original stack and store them in reversedArray
        for (int i = 0; i < size; i++) {
            reversedArray[i] = stack.pop();
        }

        // Push the elements back into the original stack to reverse the order
        for (int i = 0; i < size; i++) {
            stack.push(reversedArray[i]);
        }
    }

    public static void sort(MyStack stack) {

        int size = stack.top + 1;
        int[] elements = new int[size];

        // Pop elements from the stack and store them in an array
        for (int i = 0; i < size; i++) {
            elements[i] = stack.pop();
        }
        Arrays.sort(elements);


        // Push the sorted elements back into the stack
        for (int i = size - 1; i >= 0; i--) {
            stack.push(elements[i]);
        }
    }

    public static MyStack merge(MyStack s1, MyStack s2) {
        sort(s1);
        sort(s2);
        int value;
        int index1 = s1.top + 1;
        int index2 = s2.top + 1;
        MyStack mergeStack = new MyStack();
        for (int i = 0; i < index1; i++) {
            value = s1.pop();
            mergeStack.push(value);

        }
        for (int i = 0; i < index2; i++) {
            value = s2.pop();
            mergeStack.push(value);

        }
        return mergeStack;
    }

    public static boolean numIsExists(MyStack s1, int value) {
        int size = s1.top + 1;
        MyStack tempStack = new MyStack();

        // Create a temporary stack and remove the target value
        boolean found = false;
        for (int i = 0; i < size; i++) {
            int current = s1.pop();
            if (current == value && !found) {
                found = true;  // Mark that the value is found, don't push it back
            } else {
                tempStack.push(current);  // Push other elements to tempStack
            }
        }
        // Push elements back to the original stack
        while (!tempStack.isEmpty()) {
            s1.push(tempStack.pop());
        }
        // Reorder the original stack
        reOrder(s1);
        // Print the updated stack
        //System.out.println(s1.toString());
        return found;
    }

    public static void moveLargestToTop(HStack stacks) {
        MyStack newStack = new MyStack();
        int size = stacks.myStack[0].top + 1;
        int maxValue = 0;
        for (int i = 0; i < size; i++) {
            if (maxValue < stacks.myStack[0].array[i]) {
                maxValue = stacks.myStack[0].array[i];
            }
        }
        numIsExists(stacks.myStack[0], maxValue);
        stacks.myStack[1].push(maxValue);
        System.out.println(stacks.myStack[1]);


    }

    public static void combineAndSort(HStack stacks) {
        // Combine the contents of all three stacks into a temporary array
        MyStack tempStack1 = merge(stacks.myStack[0], stacks.myStack[1]);
        MyStack tempStack2 = merge(tempStack1, stacks.myStack[2]);
        sort(tempStack2);
        System.out.println("Sorted Temp Stack: " + tempStack2.toString());
    }


}