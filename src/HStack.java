public class HStack {
    MyStack[] myStack = new MyStack[3];
    public HStack()
    {
        for (int i = 0; i < 3; i++)
        {
            myStack[i] = new MyStack();
        }
    }
    public HStack(MyStack f0, MyStack f1, MyStack f2)
    {
            myStack[0] = f0;
            myStack[1] = f1;
            myStack[2] = f2;
    }


    protected boolean isEmpty(int stackIndex) {
        boolean flag = myStack[stackIndex].isEmpty();
        return flag;

    }

    protected int peek(int stackIndex) {
        int value = myStack[stackIndex].peek();
        return value;
    }

    protected void move(int stackIndex) {

        int newStackIndex = stackIndex++;
        if (newStackIndex==myStack.length)
            newStackIndex=0;

        else {
            int peek = myStack[stackIndex].peek();
            myStack[newStackIndex].push(peek);
        }
    }
}
