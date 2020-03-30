package structure;

import java.util.Scanner;

/**
 * 栈
 *
 * @author 倪勤华
 */
public class StackDemo {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(4);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("s：显示栈；e：退出程序；push：添加；pop：移出数据；");
            String key = scanner.next();
            switch (key) {
                case "s":
                    myStack.showStack();
                    break;
                case "e":
                    scanner.close();
                    flag = false;
                    break;
                case "push":
                    System.out.println("请输入一个数据：");
                    myStack.push(scanner.next());
                    break;
                case "pop":
                    myStack.pop();
                    break;
                default:
                    break;
            }
        }
    }

}

class MyStack {
    Object[] elementData;
    int elementCount;
    int top = -1;

    MyStack(int elementCount) {
        this.elementCount = elementCount;
        elementData = new Object[elementCount];
    }

    boolean isFull() {
        return top == elementCount - 1;
    }

    boolean isNull() {
        return top == -1;
    }

    void push(Object o) {
        if (isFull()) {
            System.out.println("已经栈满了");
            return;
        }
        top++;
        elementData[top] = o;
    }

    void pop() {
        if (isNull()) {
            System.out.println("栈空");
            return;
        }
        System.out.println(elementData[top]);
        top--;
    }

    void showStack() {
        if (isNull()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(i + ":" + elementData[i] + "、");
        }
    }
}