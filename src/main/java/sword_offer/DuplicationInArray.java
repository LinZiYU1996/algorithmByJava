package sword_offer;


import java.util.HashMap;

/*
*
 * @Author Mr.Lin
 * @Description //
 *
 *
 * 数组中重复的数字
 *
 * 在长度为n的数组里所有数字都在 0 - n-1 范围内
 * 某些数字是重复的，不知道有几个数字重复了，也不知每个数字重复了几次
 * 请找出数组中任意一个重复的数字、
 * 如长度为7的数组{2,3,1,0,2,5,3}
 * 那么对应输出的是重复的数字2 或者 3
 * @Date 21:08 2019/4/14
 **/
public class DuplicationInArray {


    //优化思路
    public static int findDuplication(int[] array,int length){
        for(int i = 0 ; i < length ; i++){
            if (array[i] < 0 || array[i] > length - 1){
                return -1;  //数据不合规范，直接返回-1
            }
        }

        for(int j = 0; j < length; j++){
            while (array[j] != j){
                if (array[j] == array[array[j]]){
                    return array[j];
                }
                int temp = array[j];
                array[j] = array[temp];
                array[temp] = temp;
            }
        }
        return -1;//无重复 返回-1
    }


    //AC 优化思路 时间复杂度：O(n)，空间复杂度：O(1)
//    public boolean duplicate(int numbers[],int length,int [] duplication) {
//        for(int i = 0 ; i < length ; i++){
//            if (numbers[i] < 0 || numbers[i] > length - 1){
//                return false;  //数据不合规范，直接返回false
//            }
//        }
//        for(int j = 0; j < length; j++){
//            while (numbers[j] != j){
//                if (numbers[j] == numbers[numbers[j]]){
//                    duplication[0] = numbers[j];
//                    return false;
//                }
//                int temp = numbers[j];
//                numbers[j] = numbers[temp];
//                numbers[temp] = temp;
//            }
//        }
//        return false;//无重复 返回-1
//    }


    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i = 0 ; i < length ; i++){
            if (numbers[i] < 0 || numbers[i] > length - 1){
                return false;  //数据不合规范，直接返回false
            }
        }
        HashMap<Integer,Integer>  record = new HashMap<Integer, Integer>();
        for(int j = 0; j < length ; j++){
            if (record.containsKey(numbers[j])){
                duplication[0] = numbers[j];
                return true;
            }
            record.put(numbers[j],numbers[j]);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] aray = {2,3,4,1,2};
        System.out.println(findDuplication(aray,aray.length));
    }




}
