package sword_offer;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

输入一个升序的数组的一个旋转，输出旋转数组的最小元素。

例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。

数组可能包含重复项。

注意：数组内所含元素非负，若数组大小为0，请返回-1。

样例
输入：nums=[2,2,2,0,1]

输出：0
*
*
* 思路
　　数组在一定程度上是排序的，很容易分析出：可以采用二分法来寻找最小数字。

　　但是这里面有一些陷阱：

　　1.递增排序数组的本身是自己的旋转，则最小数字是第一个数字

　　2.中间数字与首尾数字大小相等，如{1,0,1,1,1,1}和{1,1,1,1,0,1}，无法采用二分法，只能顺序查找。
 *
 * @Date 20:55 2019/4/17
 **/
public class TestfindMin {


    //AC
    public int findMin(int[] array) {
        if (array == null || array.length <= 0) // 空数组或null时返回0
            return 0;
        int low = 0;
        int high = array.length - 1;
        int mid = (low + high) / 2;
        //升序数组
        if (array[low] < array[high])
            return array[low];
        //中间数字与首尾数字相等
        if (array[mid] == array[high] && array[mid] == array[low]) {
            for (int i = 1; i <= high; i++) {
                if (array[i] < array[i - 1])
                    return array[i];
            }
            return array[low];
        }
        //正常情况
        while (low < high) {
            if (high - low == 1)
                break;
            mid = (low + high) / 2;
            if (array[mid] <= array[high])
                high = mid;
            if (array[mid] > array[high])
                low = mid;
        }
        return array[high]; // 别错写成了return high; !!

    }

    public static void main(String[] args) {

    }


}
