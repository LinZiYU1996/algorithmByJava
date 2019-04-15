package sword_offer;

/*
*
 * @Author Mr.Lin
 * @Description //TODO
 *
 * 不修改数组找出重复的数字
 *
 * 在一个长度为 n+1 的数组里的所有数字都在1 - n 的范围内，所以数组中至少有一个数字是重复的
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组，
 *
 * 如：输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应的输出的重复的数字 2 或者 3
 *
 *
 * (分治，抽屉原理) O(nlogn)O(nlogn)
这道题目主要应用了抽屉原理和分治的思想。

抽屉原理：n+1 个苹果放在 n 个抽屉里，那么至少有一个抽屉中会放两个苹果。

用在这个题目中就是，一共有 n+1 个数，每个数的取值范围是1到n，所以至少会有一个数出现两次。

然后我们采用分治的思想，将每个数的取值的区间[1, n]划分成[1, n/2]和[n/2+1, n]两个子区间，然后分别统计两个区间中数的个数。
注意这里的区间是指 数的取值范围，而不是 数组下标。

划分之后，左右两个区间里一定至少存在一个区间，区间中数的个数大于区间长度。
这个可以用反证法来说明：如果两个区间中数的个数都小于等于区间长度，那么整个区间中数的个数就小于等于n，和有n+1个数矛盾。

因此我们可以把问题划归到左右两个子区间中的一个，而且由于区间中数的个数大于区间长度，根据抽屉原理，在这个子区间中一定存在某个数出现了两次。

依次类推，每次我们可以把区间长度缩小一半，直到区间长度为1时，我们就找到了答案。

复杂度分析
时间复杂度：每次会将区间长度缩小一半，一共会缩小 O(logn)O(logn) 次。
* 每次统计两个子区间中的数时需要遍历整个数组，时间复杂度是 O(n)O(n)。所以总时间复杂度是 O(nlogn)O(nlogn)。
空间复杂度：代码中没有用到额外的数组，所以额外的空间复杂度是 O(1)O(1)。


 * @Date 21:14 2019/4/15
 **/
public class GetDuplicationWithoutChanged {


    public int duplicateInArray(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("数组输入无效！");
            return -1;
        }
        for (int a : arr) {
            if (a < 1 || a > arr.length - 1) {
                System.out.println("数字大小超出范围！");
                return -1;
            }
        }


        int low = 1;
        int high = arr.length - 1; // high即为题目的n
        int mid, count;
        while (low <= high) {
            mid = ((high - low) >> 2) + low;  //右移两位  相当于除以4
            count = countRange(arr, low, mid);
            if (low == high) {
                if (count > 1)
                    return low;
                else
                    break; // 必有重复，应该不会出现这种情况吧？
            }
            if (count > mid - low + 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 返回在[low,high]范围中数字的个数
     */
    public int countRange(int[] arr, int low, int high) {
        if (arr == null)
            return 0;

        int count = 0;
        for (int a : arr) {
            if (a >= low && a <= high)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
