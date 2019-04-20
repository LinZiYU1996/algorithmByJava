package sword_offer_01;


import sword_offer.ListNode;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *输入一个链表，输出该链表中倒数第k个结点。

注意：

k >= 0;
如果k大于链表长度，则返回 NULL;
样例
输入：链表：1->2->3->4->5 ，k=2

输出：4

 *
 * @Date 21:46 2019/4/20
 **/
public class TestfindKthToTail {


    public ListNode findKthToTail(ListNode pListHead, int k) {

        ListNode head = pListHead;
        int num = 0;
        while (head != null) {
            head = head.next;
            num++;
        }

        if (k > num) {
            return null;
        }

        ListNode p1;
        ListNode p2;

        p1 = pListHead;
        p2 = pListHead;
        int i = 0;
        while ( p1 != null && i < k){
            p1 = p1.next;
            i++;
        }
        while ( p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {

    }
}
