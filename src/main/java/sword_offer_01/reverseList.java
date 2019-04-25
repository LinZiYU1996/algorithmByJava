package sword_offer_01;


import sword_offer.ListNode;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。

样例
输入:1->2->3->4->5->NULL

输出:5->4->3->2->1->NULL
 * @Date 22:14 2019/4/24
 **/
public class reverseList {

    public ListNode reverseList_P(ListNode head) {

        if(head == null)
            return null;
        ListNode pre = null;
        ListNode node = head;
        ListNode next = node;

        while(node.next!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        node.next = pre;
        return node;


    }

    public static void main(String[] args) {

    }
}
