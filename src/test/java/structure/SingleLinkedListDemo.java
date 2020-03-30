package structure;


import java.util.Stack;

/**
 * 单链表
 *
 * @author 倪勤华
 */
class SingleLinkedListDemo {
    public static void main(String[] args) {

        Node node1 = new Node(3, "小明");
        Node node2 = new Node(1, "小红");
        Node node3 = new Node(2, "小白");
        //按加入顺序
        System.out.println("按加入顺序排列节点");
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        singleLinkedList1.add(node1);
        singleLinkedList1.add(node2);
        singleLinkedList1.add(node3);
        singleLinkedList1.show();
        System.out.println("===============");
        //按排名no顺序
        System.out.println("按no排列节点");
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.addByNo(node1);
        singleLinkedList2.addByNo(node2);
        singleLinkedList2.addByNo(node3);
        singleLinkedList2.show();
        System.out.println("===============");
        //修改
        System.out.println("修改结果：" + singleLinkedList2.update(2, "白痴"));
        singleLinkedList2.show();
        System.out.println("===============");
        //删除
        System.out.println("删除结果：" + singleLinkedList2.delete(1));
        singleLinkedList2.show();
        System.out.println("===============");
        //长度
        System.out.println("当前长度：" + singleLinkedList2.getLen());
        System.out.println("===============");
        //查找单链表中的倒数第k个节点
        System.out.println("单链表中的倒数第1个节点：" + singleLinkedList2.getLastIndexNode(1));
        System.out.println("===============");
        //逆序打印，不改变单链表结构
        System.out.println("逆序打印，不改变单链表结构:");
        System.out.println("逆序打印：");
        singleLinkedList2.reversePrint();
        System.out.println("原始结构：");
        singleLinkedList2.show();
        System.out.println("===============");
        //单链表的反转
        System.out.println("链表结构反转：");
        singleLinkedList2.reverse();
        singleLinkedList2.show();
        System.out.println("===============");
        //合并两个有序的链表，合并之后依然有序
        Node nodeA1 = new Node(1, "小明");
        Node nodeA2 = new Node(3, "小红");
        Node nodeA3 = new Node(7, "小白");
        SingleLinkedList singleLinkedListA = new SingleLinkedList();
        singleLinkedListA.add(nodeA1);
        singleLinkedListA.add(nodeA2);
        singleLinkedListA.add(nodeA3);
        System.out.println("有序链表1：");
        singleLinkedListA.show();
        Node nodeB1 = new Node(2, "小狗");
        Node nodeB2 = new Node(4, "小猫");
        Node nodeB3 = new Node(6, "小兔");
        Node nodeB4 = new Node(9, "小蛇");
        SingleLinkedList singleLinkedListB = new SingleLinkedList();
        singleLinkedListB.add(nodeB1);
        singleLinkedListB.add(nodeB2);
        singleLinkedListB.add(nodeB3);
        singleLinkedListB.add(nodeB4);
        System.out.println("有序链表2：");
        singleLinkedListB.show();
        System.out.println("两个有序的链表，合并之后依然有序：");
        singleLinkedListA.mergeByNo(singleLinkedListB.getHead());
        singleLinkedListA.show();

    }


    /**
     * 单链表
     */
    static class SingleLinkedList {
        /**
         * 头结点
         */
        private Node head = new Node(0, "");

        Node getHead() {
            return head;
        }

        void add(Node node) {
            Node temp = head;

            //找到最后那个的节点，该节点的next为null;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
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
            node.next = temp.next;
            temp.next = node;

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
                    temp.next = temp.next.next;
                    return true;
                }
                temp = temp.next;
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

        int getLen() {
            int len = 0;
            Node temp = head.next;
            while (temp != null) {
                len++;
                temp = temp.next;
            }
            return len;
        }

        Node getLastIndexNode(int lastIndex) {
            int len = getLen();
            if (len < lastIndex || lastIndex < 1) {
                return null;
            }
            Node temp = head;
            for (int i = 0; i <= len - lastIndex; i++) {
                temp = temp.next;
            }
            return temp;
        }

        void reverse() {
            Node reverseHead = new Node(0, "");
            Node curTemp = head.next;
            Node nextTemp;

            while (curTemp != null) {
                nextTemp = curTemp.next;
                curTemp.next = reverseHead.next;
                reverseHead.next = curTemp;
                curTemp = nextTemp;
            }
            head.next = reverseHead.next;
        }

        @SuppressWarnings("unchecked")
        void reversePrint() {
            Stack stack = new Stack();
            Node temp = head;
            while (temp.next != null) {
                stack.add(temp.next);
                temp = temp.next;
            }
            while (!stack.empty()) {
                System.out.println(stack.pop());
            }
        }

        void mergeByNo(Node head) {
            Node temp1 = this.head.next;
            Node temp2 = head.next;
            if (temp1 == null) {
                this.head = head;
                return;
            }
            if (temp2 == null) {
                return;
            }

            Node newHead = this.head;
            while (temp1 != null && temp2 != null) {
                if (temp1.no > temp2.no) {
                    newHead.next = temp2;
                    temp2 = temp2.next;
                } else {
                    newHead.next = temp1;
                    temp1 = temp1.next;
                }
                newHead = newHead.next;
            }
            newHead.next = temp1 == null ? temp2 : temp1;
        }
    }

    /**
     * 节点
     */
    static class Node {
        int no;
        String name;
        Node next;

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
}
