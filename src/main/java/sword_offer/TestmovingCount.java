package sword_offer;



/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *地上有一个 m 行和 n 列的方格，横纵坐标范围分别是 0∼m−1 和 0∼n−1。

一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格。

但是不能进入行坐标和列坐标的数位之和大于 k 的格子。

请问该机器人能够达到多少个格子？

样例1
输入：k=7, m=4, n=5

输出：20
样例2
输入：k=18, m=40, n=40

输出：1484

解释：当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
      但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
注意:

0<=m<=50
0<=n<=50
0<=k<=100
*
*
*
 *
 * @Date 20:53 2019/4/18
 **/
public class TestmovingCount {

//(BFS) O(nm)O(nm)
//这是一个典型的宽度优先搜索问题，我们从 (0, 0) 点开始，每次朝上下左右四个方向扩展新的节点即可。
//
//扩展时需要注意新的节点需要满足如下条件：
//
//之前没有遍历过，这个可以用个bool数组来判断；
//没有走出边界；
//横纵坐标的各位数字之和小于 kk；
//最后答案就是所有遍历过的合法的节点个数。


    //回溯法 AC
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visited = new boolean[rows][cols];
        return countingSteps(threshold,rows,cols,0,0,visited);
    }
    public int countingSteps(int limit,int rows,int cols,int r,int c,boolean[][] visited){
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || visited[r][c] || bitSum(r) + bitSum(c) > limit)  return 0;
        visited[r][c] = true;
        return countingSteps(limit,rows,cols,r - 1,c,visited)
                + countingSteps(limit,rows,cols,r,c - 1,visited)
                + countingSteps(limit,rows,cols,r + 1,c,visited)
                + countingSteps(limit,rows,cols,r,c + 1,visited)
                + 1;
    }
    public int bitSum(int t){
        int count = 0;
        while (t != 0){
            count += t % 10;
            t /= 10;
        }
        return  count;
    }

    public static void main(String[] args) {
        TestmovingCount testmovingCount = new TestmovingCount();
//        System.out.println(testmovingCount.getSum(35,376));
    }




}
