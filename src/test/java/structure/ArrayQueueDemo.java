package structure;


import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * 数组队列
 *
 * @author 倪勤华
 */
class ArrayQueueDemo {

    @SuppressWarnings("unchecked")
    static void main(String[] args) {
        System.out.println("请输入队列大小：");
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        ArrayQueue arrayQueue = new ArrayQueue(capacity);
        boolean flag = true;
        while (flag) {
            System.out.println("s：显示队列；e：退出程序；a：添加；r：移出数据；");
            char key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数据：");
                    arrayQueue.add(scanner.next());
                    break;
                case 'r':
                    System.out.println(arrayQueue.romove());
                    break;
                default:
                    break;
            }
        }


    }


    static class ArrayQueue<T> {
        private int capacity;
        private T[] queue;
        private int head;
        private int tail;

        @SuppressWarnings("unchecked")
        ArrayQueue(int capacity) {
            this.capacity = capacity + 1;
            //预留一个位置来判断是否满
            queue = (T[]) new Object[capacity + 1];
            head = 0;
            tail = 0;
        }

        //判断队列是否满
        boolean isFull() {
            return (tail + 1) % capacity == head;
        }

        //判断队列是否为空
        boolean isNull() {
            return head == tail;
        }

        //添加数据
        void add(T o) {
            if (isFull()) {
                System.out.println("Queue full");
                return;
            }
            queue[tail] = o;
            tail = (tail + 1) % capacity;
        }

        //取出数据
        T romove() {
            if (isNull()) {
                System.out.println("Queue empty");
                return null;
            }
            T value = queue[head];
            queue[head] = null;
            head = (head + 1) % capacity;
            return value;
        }

        //列出所有数据
        void showQueue() {
            if (isNull()) {
                System.out.println("队列是空的");
                return;
            }
            for (int i = head; i < size() + head; i++) {
                System.out.print(i % capacity + ":" + queue[i % capacity] + " ");
            }
            System.out.println();
        }

        //当前队列的有效个数
        int size() {
            return (tail - head + capacity) % capacity;
        }

      
    }
}
