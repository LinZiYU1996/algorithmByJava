package sword_offer;


import java.util.Stack;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *输入一个链表的头结点，按照 从尾到头 的顺序返回节点的值。

返回的结果用数组存储。

样例
输入：[2, 3, 5]
返回：[5, 3, 2]
*
*结点遍历顺序只能从头到尾，但是输出的顺序却为从尾到头
* ，是典型的“后进先出”问题，这就要联想到使用栈，从而也可以联想到使用递归。
 * @Date 10:23 2019/4/17
 **/
public class TestprintListReversingly {


    //借助栈实现 AC
    public int[] printListReversingly(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] nums = new int[stack.size()];
        int i = 0;
        while ( !stack.empty()) {
            nums[i] = stack.pop();
            i++;
        }
        return nums;

    }


    //采用递归
    public static void printListReversingly_Recursively(ListNode head) {
        if(head!=null) {
            printListReversingly_Recursively(head.next);
            System.out.println(head.val);
        }else
            return;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        printListReversingly_Recursively(l1);
    }
}




