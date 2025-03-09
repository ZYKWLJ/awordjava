import java.util.Arrays;

public class testArray {
    public static void main(String[] args) {
        int[] arr={0,2,2,2,3,3,3,3};
        System.out.println(Arrays.binarySearch(arr,1));//-2
        // 返回值负数 index=-插入位置-1
    }
}
