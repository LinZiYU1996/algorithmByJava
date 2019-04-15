package sword_offer;



/*
*
 * @Author Mr.Lin
 * @Description //TODO
 *
 * 二维数组的查找
 *
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排列
 * 每一列都按照从上到下递增的顺序排列
 *
 * 输入一个整数，进行查找，看在不在这个二维数组中
 *
 *　查找整数时，如果从左上角开始查找，情况较为复杂，可以转换思路，
 * 从右上角开始查找：左边数字比较小，右边数字比较大，容易进行判断。
 *
 *
 * 算法
(单调性扫描) O(n+m)O(n+m)
核心在于发现每个子矩阵右上角的数的性质：

如下图所示，x左边的数都小于等于x，x下边的数都大于等于x。
*
* 因此我们可以从整个矩阵的右上角开始枚举，假设当前枚举的数是 xx：

如果 xx 等于target，则说明我们找到了目标值，返回true；
如果 xx 小于target，则 xx 左边的数一定都小于target，我们可以直接排除当前一整行的数；
如果 xx 大于target，则 xx 下边的数一定都大于target，我们可以直接排序当前一整列的数；
排除一整行就是让枚举的点的横坐标加一，排除一整列就是让纵坐标减一。
当我们排除完整个矩阵后仍没有找到目标值时，就说明目标值不存在，返回false。

时间复杂度分析
每一步会排除一行或者一列，矩阵一共有 nn 行，mm 列，所以最多会进行 n+mn+m 步。所以时间复杂度是 O(n+m)O(n+m)。

 * @Date 21:59 2019/4/15
 **/
public class FindNumberInDoubleArray {


    //AC
    public boolean searchArray(int[][] array, int target) {

        if (array.length == 0){
            return false;
        }
        // 正式查找
        int row = 0; // 行数
        int column = array[0].length - 1; // 列数
        while (row <= array.length - 1 && column >= 0) {
            if (target == array[row][column]) {
                return true;
            } else if (target <array[row][column]) {
                column--;
            } else {
                row++;
            }
        }
        return false;

    }

    public static void main(String[] args) {

    }




}
