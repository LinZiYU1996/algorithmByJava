package sword_offer_01;


import sword_offer.ListNode;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 给定一个链表，若其中包含环，则输出环的入口节点。

若其中不包含环，则输出null。
*
* 给定如上所示的链表：
[1, 2, 3, 4, 5, 6]
2
注意，这里的2表示编号是2的节点，节点编号从0开始。所以编号是2的节点就是val等于3的节点。

则输出环的入口节点3.
 * @Date 21:50 2019/4/23
 **/
public class P_entryNodeOfLoop {


    // 1  确定链表中有没有环
    // 用两个指针来解决，快慢指针同时从链表的头结点出发，一个指针一次走一步，另一个指针一次走两步
    //如果走的快的追上了慢的，那么链表就有环
    //如果快的走到了链表的末尾，都没有追上第一个 ， 那么就不包含环了

    //2 有的话
    // 继续用快慢指针
    //如果环有n 个节点，则指针 P1 先向前移动 n 步 然后两个指针以相同速度向前移动
    //当第二个指针指向环的入口节点时，第一个指针已经围绕环走了一圈，又回到入口节点了

    public static ListNode entryNodeOfLoop(ListNode head) {
        ListNode meetNode = hasEntry(head);
        if (meetNode == null){
            return null;
        }

        int number = 1;
        ListNode p1 = meetNode.next;
        while (p1 != meetNode) {
            number++;
            p1 = p1.next;
        }

        p1 = head;
        for (int i = 0; i < number ; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while ( p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }


    //确定链表是否有环，采用快慢指针确定
    // 返回值代表快慢指针相遇时的结点，返回null代表链表无环
    public static ListNode hasEntry(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null ) {
            fast = fast.next;
            slow = slow.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (slow != null && slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode3;

        System.out.println(entryNodeOfLoop(listNode1).val);

    }

}
