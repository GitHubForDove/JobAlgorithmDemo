package DataStruct;

/**
 * 使用数组实现 栈数据结构
 */
public class Stack<E> {
    int maxSize;
    Object[] stack = null;
    int top = -1;

    public Stack(){
        this(10);
    }

    Stack(int inittialSize) {
        if (inittialSize >=0) {
            this.maxSize = inittialSize;
            stack = new Object[maxSize];
            top = -1;
        } else {
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void push(int value) {
        if (top == maxSize) {
            throw new RuntimeException("栈已满，无法再将元素入栈");
        }else {
            stack[++top] = value;
        }

    }

    public E pop() {
        if (top != -1) {
            return (E)stack[top--];
        }else {
            throw new RuntimeException("栈已经没有元素！");
        }
    }

    public E peek() {
        if (top == -1) {
            throw new RuntimeException("没有元素在栈内");
        } else {
            return (E)stack[top];
        }
    }

    public boolean isEmpty() {
        if (top != -1) {
            return false;
        } else {
            return true;
        }
    }


}
