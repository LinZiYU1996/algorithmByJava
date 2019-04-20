package sword_offer;

/*
*
 * @Author Mr.Lin
 * @Description //
 *在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留。

样例1
输入：1->2->3->3->4->4->5

输出：1->2->5
样例2
输入：1->1->1->2->3

输出：2->3
 *
 * @Date 20:37 2019/4/20
 **/
public class TestdeleteDuplication {


    //思路
    //　　设置一个preNode，用于记录当前结点的前一个结点，再设置一个布尔变量needDelete，
    // 如果当前结点和后一结点的值相同（记该值为dupVal），needDelete赋值为真。
    //
    //　　当needDelete为真时，通过循环往后找到第一个不为dupVal的结点，把该结点设置为当前结点，
    // 并赋值给preNode.next，即相当于完成了删除操作；而当needDelete为假时，把当前结点和preNode往后移一位即可。





    //算法
    //(线性扫描) O(n)O(n)
    //为了方便处理边界情况，我们定义一个虚拟元素 dummydummy 指向链表头节点。
    //然后从前往后扫描整个链表，每次扫描元素相同的一段，如果这段中的元素个数多于1个，则将整段元素直接删除。
    //
    //时间复杂度
    //整个链表只扫描一遍，所以时间复杂度是 O(n)O(n)。
    public ListNode deleteDuplication(ListNode head) {
        ListNode  dummy = new ListNode(0);
        dummy.next = head;

        ListNode  p = dummy;
        while (p.next != null)
        {
            ListNode  q = p.next;
            while (q != null && q.val == p.next.val)
                q = q.next;
            if (p.next.next == q) p = p.next;
            else p.next = q;
        }
        return dummy.next;


    }

    public static void main(String[] args) {

    }
}





