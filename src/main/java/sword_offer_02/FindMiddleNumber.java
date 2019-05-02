package sword_offer_02;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Mr.Lin
 * @Description:
 *
 * 如何得到一个数据流中的中位数？
 *
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 样例
 * 输入：1, 2, 3, 4
 *
 * 输出：1,1.5,2,2.5
 *
 * 解释：每当数据流读入一个数据，就进行一次判断并输出当前的中位数。
 *
 *
 *
 * @Date: Create in 21:56 2019/5/2
 */
public class FindMiddleNumber {

//直接使用PriorityQueue构造大小堆，大顶堆放小于中位数的集合，小顶堆放大于中位数的集合，
//取得时候，如果是奇数，就取前半部分的最大数，如果是偶数，就取前半部分的最大数和后半部分的最小数的平均数
//往里放的时候，如果总数是偶数，就往前放，需要现在后半部分过滤一遍选出后半部分最小的数往前放，奇数同理


    private PriorityQueue<Integer> maxHeap=new PriorityQueue(new Comparator<Integer>(){
        public int compare(Integer i1,Integer i2){
            return i2-i1;
        }
    });//小于中位数的集合
    private PriorityQueue<Integer> minHeap=new PriorityQueue();//大于中位数的集合

    public void insert(Integer num) {
        if(((minHeap.size()+maxHeap.size())&1)==1){
            //奇数个,就往后半部分加
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else{
            //偶数个,就往前半部分加
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double getMedian() {
        if(((minHeap.size()+maxHeap.size())&1)==1){
            return (double)maxHeap.peek();
        }else{
            return ((double)maxHeap.peek()+minHeap.peek())/2;
        }
    }



}
