package sword_offer;


/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。

路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。

如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。

注意：

输入的路径不为空；
所有出现的字符均为大写英文字母；
样例
matrix=
[
  ["A","B","C","E"],
  ["S","F","C","S"],
  ["A","D","E","E"]
]

str="BCCE" , return "true"

str="ASAE" , return "false"
*
*
* 思路
　　首先对所整个矩阵遍历，找到第一个字符，
* 然后向上下左右查找下一个字符，由于每个字符都是相同的判断方法（
* 先判断当前字符是否相等，再向四周查找），因此采用递归函数。
* 由于字符查找过后不能重复进入，所以还要定义一个与字符矩阵大小相同的布尔值矩阵，
* 进入过的格子标记为true。如果不满足的情况下，需要进行回溯，此时，要将当前位置的布尔值标记回false。
* （所谓的回溯无非就是对使用过的字符进行标记和处理后的去标记）
 *
 * @Date 21:33 2019/4/17
 **/
public class TesthasPath {



    /*
    回溯法
创建一个辅助数组来确定每个位置是否是字符串中的字符，如果是，则为true，如果不是，则为false，初始数组都为false；
创建一个变量来储存当前路径的长度，当长度和字符串一样时，说明已经完成了，直接返回true；

先遍历矩阵，找到和字符串第一个字符相同的字符，作为路径的开始；

然后进入函数，进行合法性判断以及当前路径的字符和字符串上对应位置的字符是否相等，
不相等，直接返回false；如果相等，则矩阵路径+1，并将当前位置置为true，
然后对当前位置的上下左右四个位置进行遍历，找寻路径的下一个位置，如果四个位置都没有找到，
则返回false，并将当前位置重新改为false，然后路径-1，因为当前位置不是正确的路径，因为路径-1，所以回到上一位置，重新寻找。

     */
    public boolean hasPath(char[][] matrix, String str) {
        if(matrix == null||str==null){
            return false;}
        int rows = matrix.length;
        if(rows==0)return false;
        int cols = matrix[0].length;

        int pathLength = 0;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(hasPathCore(matrix,rows,cols,i,j,str,pathLength,visited))
                    return true;
            }
        }
        return false;
    }
    public boolean hasPathCore(char[][] matrix,int rows, int cols,int row, int col,
                               String str,int pathLength, boolean[][] visited){
        boolean flag = false;
        if(row>=0&&row<rows&&col>=0&&col<cols&&!visited[row][col]&&matrix[row][col]==str.charAt(pathLength)){
            pathLength++;
            visited[row][col]=true;
            if(pathLength==str.length())
                return true;
            flag = hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited)||
                    hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited)||
                    hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visited)||
                    hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited);
            if(!flag){
                pathLength--;
                visited[row][col]=false;
            }
        }
        return flag;
    }



}
