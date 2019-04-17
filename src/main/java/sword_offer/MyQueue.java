package sword_offer;


import java.util.Stack;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *请用栈实现一个队列，支持如下四种操作：

push(x) – 将元素x插到队尾；
pop() – 将队首的元素弹出，并返回该元素；
peek() – 返回队首元素；
empty() – 返回队列是否为空；
注意：

你只能使用栈的标准操作：push to top，peek/pop from top, size 和 is empty；
如果你选择的编程语言没有栈的标准库，你可以使用list或者deque等模拟栈的操作；
输入数据保证合法，例如，在队列为空时，不会进行pop或者peek等操作；
样例
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
 *
 *
 * @Date 20:02 2019/4/17
 **/
public class MyQueue {


    //AC
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();


    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.add(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
            while ( !stack1.isEmpty()){
                stack2.add(stack1.pop());
            }
            Integer num = stack2.pop();
            while ( !stack2.isEmpty()){
                stack1.add(stack2.pop());
            }
            return num;

    }

    /** Get the front element. */
    public int peek() {
        while ( !stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        Integer num = stack2.peek();
        while ( !stack2.isEmpty()){
            stack1.add(stack2.pop());
        }
        return num;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(111);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());

    }

}
