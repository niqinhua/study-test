package structure;

/**
 * 双向链表
 *
 * @author 倪勤华
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node node1 = new Node(3, "小明");
        Node node2 = new Node(1, "小红");
        Node node3 = new Node(2, "小白");
        //按加入顺序
        //System.out.println("按加入顺序排列节点");
        //DoubleLinkedList doubleLinkedList1 = new DoubleLinkedList();
        //doubleLinkedList1.add(node1);
        //doubleLinkedList1.add(node2);
        //doubleLinkedList1.add(node3);
        //doubleLinkedList1.show();
        //System.out.println("===============");
        //按排名no顺序
        System.out.println("按no排列节点");
        DoubleLinkedList doubleLinkedList2 = new DoubleLinkedList();
        doubleLinkedList2.addByNo(node1);
        doubleLinkedList2.addByNo(node2);
        doubleLinkedList2.addByNo(node3);
        doubleLinkedList2.show();
        System.out.println("===============");
        //修改
        System.out.println("修改结果：" + doubleLinkedList2.update(2, "白痴"));
        doubleLinkedList2.show();
        System.out.println("===============");
        //删除
        System.out.println("删除结果：" + doubleLinkedList2.delete(1));
        doubleLinkedList2.show();
    }

}

/**
 * 单链表
 */
class DoubleLinkedList {
    /**
     * 头结点
     */
    private Node head = new Node(0, "");

    void add(Node node) {
        Node temp = head;

        //找到最后那个的节点，该节点的next为null;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    void addByNo(Node node) {
        Node temp = head;

        //找到要插入的前面一个节点;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no >= node.no) {
                break;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            temp.next = node;
            node.pre = temp;
        } else {
            node.next = temp.next;
            temp.next.pre = node;
            temp.next = node;
            node.pre = temp;
        }

    }

    void show() {

        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }

    }

    boolean update(int no, String name) {
        Node temp = head.next;
        while (true) {
            if (temp == null) {
                return false;
            }
            if (temp.no == no) {
                temp.name = name;
                return true;
            }
            temp = temp.next;
        }
    }

    boolean delete(int no) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                return false;
            }
            if (temp.next.no == no) {
                temp=temp.next;
                temp.pre.next=temp.next;
                temp.next.pre=temp.pre;
                return true;
            }
            temp = temp.next;
        }
    }

}

/**
 * 节点
 */
class Node {
    int no;
    String name;
    Node next;
    Node pre;

    Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}