package structure;

/**
 * 单项循环链表
 *
 * @author 倪勤华
 */
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        System.out.println("加入5个小孩子：");
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoys();
        System.out.println("出圈顺序：");
        circleSingleLinkedList.outBoy(5,1,2);

    }
}

/**
 * 单项循环链表
 */
class CircleSingleLinkedList{
    /**
     * 头结点
     */
    private Boy headBoy;

    void addBoy(int n){
        if (n<1){
            System.out.println("n值不正确");
            return;
        }

        Boy curBoy =null;
        for (int i=1;i<=n;i++){
            Boy boy = new Boy(i);
            if (i==1){
                headBoy = boy;
                headBoy.next=headBoy;
                curBoy=boy;
            }else{
                curBoy.next=boy;
                boy.next=headBoy;
                curBoy=boy;
            }

        }
    }

    void showBoys(){
        if (headBoy==null){
            System.out.println("没有小孩");
            return;
        }
        Boy curBoy =headBoy;
        do{
            System.out.println(curBoy);
            curBoy=curBoy.next;
        }while(curBoy!=headBoy);
    }

     void outBoy(int n,int k,int m) {
        if (headBoy==null||n<k||k<1){
            System.out.println("输入参数不合理");
            return;
        }
        //用来指向出圈孩纸的前面那个孩纸
        Boy temp = headBoy;
        while(temp.next!=headBoy){
            temp=temp.next;
        }

        //把head和temp一起转动k个小孩
        for (int i=1;i<k;i++){
            headBoy =headBoy.next;
            temp= temp.next;
        }

        //开始取出小孩
        while(headBoy!=temp){
            //数到第m个小孩
            for (int i=1;i<m;i++){
                headBoy =headBoy.next;
                temp= temp.next;
            }
            System.out.println(headBoy);
            temp.next=headBoy.next;
            headBoy=headBoy.next;
        }
        System.out.println(headBoy);

    }
}

class Boy{
    private int no;
    Boy next;

    Boy(int no){
        this.no=no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}