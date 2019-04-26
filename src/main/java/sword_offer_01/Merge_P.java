package sword_offer_01;


import sword_offer.ListNode;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。

   样例
   输入：1->3->5 , 2->4->5
   输出：1->2->3->4->5->5
*
 *
 * @Date 20:30 2019/4/26
 **/
public class Merge_P {

    //思路
    //递归实现：合并过程中，每次都是从两个链表中找出较小的一个来链接，因此可以采用递归来实现：
    // 当任意一个链表为null时，直接链接另一个链表即可；其余情况只需要在两个链表中找出较小的一个结点进行链接
    // ，该结点的next值继续通过递归函数来链接。
    //
    //　　非递归实现：非递归实现比较容易想到，直接进行分情况讨论即可，要稍微注意下后面代码中头结点的赋值过程。

    public ListNode merge(ListNode list1, ListNode list2) {

        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummyHead=new ListNode(0);  //不能为null
        ListNode p=dummyHead;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                p.next=list1;
                list1=list1.next;
            }else{
                p.next=list2;
                list2=list2.next;
            }
            p=p.next;
        }
        if(list1==null)
            p.next=list2;
        else
            p.next=list1;
        return dummyHead.next;

    }


    /*
     * 递归版本
     */
    public ListNode merges(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        if(list1.val<list2.val) {
            list1.next=merges(list1.next, list2);
            return list1;
        }else {
            list2.next=merges(list1, list2.next);
            return list2;
        }
    }






    public static void main(String[] args) {

    }


}
