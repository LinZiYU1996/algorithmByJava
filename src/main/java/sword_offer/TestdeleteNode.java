package sword_offer;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 给定单向链表的一个节点指针，定义一个函数在O(1)时间删除该结点。

假设链表一定存在，并且该节点一定不是尾节点。

样例
输入：链表 1->4->6->8
      删掉节点：第2个节点即6（头节点为第0个节点）

输出：新链表 1->4->8
 * @Date 21:07 2019/4/19
 **/
public class TestdeleteNode {

    //思路
    //　　通常那样从头开始查找删除需要的时间为O(n)，要在O(1)时间删除某结点，可以这样实现：
    // 设待删除结点i的下一个结点为j，把j的值复制到i，再把i的指针指向j的下一个结点，最后删除j，
    // 效果就相当于删除j。
    //
    //　　注意特殊情况：1.当待删除结点i为尾结点时，无下一个结点，则只能从头到尾顺序遍历；
    // 2.当链表中只有一个结点时（即是头结点，又是尾结点），必须把头结点也设置为null。
    //
    //　　本题有个缺陷：要求O(1)时间删除，相当于隐藏了一个假设：待删除的结点的确在表中


    public void deleteNode(ListNode node) {//给定了要删除的节点
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public static void main(String[] args) {

    }

}
