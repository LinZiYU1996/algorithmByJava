package sword_offer_01;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序。

使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。

样例
输入：[1,2,3,4,5]

输出: [1,3,5,2,4]
 * @Date 21:26 2019/4/20
 **/
public class TestreOrderArray {


    //思路
    //　　对于任意一个整数数组，设置一个指针，从前往后走，如果遇到奇数则指针后移，
    // 遇到偶数时，希望把该偶数放在数组后面；因此，再设置一个指针，从后往前走，遇到偶
    // 数时指针前移，遇到奇数时，则恰好可以与前面的指针所指的偶数进行调换。

    public static void reOrderArray(int [] array) {
        if(array==null || array.length==0)
            return;
        int length = array.length;
        int low=0;
        int high=length-1;
        int temp;
        while(low<high){
            //向后移动low指针，直到它指向偶数
            while(low<length && (array[low]&1)!=0)//操作
                low++;
            //向前移动high指针，直到它指向奇数
            while(high>=0 && (array[high]&1)==0)//操作
                high--;
            if(low<high){
                temp=array[low];
                array[low]=array[high];
                array[high]=temp;
            }
        }
    }

    public static void main(String[] args) {
            int[] a = {1,2,3,4,5,6,7,8,9};
            reOrderArray(a);
        for (int i = 0; i < a.length ; i++) {
            System.out.println(a[i]);
        }

    }

}
