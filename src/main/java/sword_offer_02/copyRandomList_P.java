package sword_offer_02;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 请实现一个函数可以复制一个复杂链表。
 *
 * 在复杂链表中，每个结点除了有一个指针指向下一个结点外，还有一个额外的指针指向链表中的任意结点或者null。
 *
 *
 *
 *
 * @Date: Create in 20:13 2019/5/1
 */
public class copyRandomList_P {

    /*
    用hashmap将每个节点先进行copy，然后用原节点做key，复制节点做value存进hashmap
    然后遍历链表，把复制节点取出连好即可，因为hashmap的增删改查是O（n）。所以时间复杂度很低。
     */
    public ListNode copyRandomList(ListNode head) {
        if(head==null)
            return null;

        Map<ListNode,ListNode> copy = new HashMap<ListNode,ListNode>();

        ListNode node = head;
        while(node!=null){
            ListNode CloneNode = new ListNode(node.val);
            copy.put(node,CloneNode);
            node = node.next;
        }

        node = head;//重新赋值
        ListNode CloneHead = copy.get(node);
        ListNode CloneNode = CloneHead;

        while(node!=null){
            CloneNode.next = copy.get(node.next);
            if(node.random!=null){
                CloneNode.random = copy.get(node.random);
            }
            CloneNode = CloneNode.next;
            node = node.next;
        }

        return CloneHead;

    }




}
