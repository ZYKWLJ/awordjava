import java.util.Scanner;
// 使用前缀+暴力循环
public class Ans1 {
      public static void main(String[] args) {
        int ans=0,s=0;
        // int n=4;
        // int[] arr={1,1,-1,1};
        int n = 5;
        int[] arr = { 2, -20, -4, -9,1 };
        for (int i = 0; i < n; i++) {
            s+=arr[i];
            ans=Math.max(ans,Math.abs(s));
            int temp=-s;//尝试在此处翻转,看看结果
            for(int j=i+1;j<n;j++){
                temp+=arr[j];
                ans=Math.max(ans,Math.abs(temp));
            }
        }
        System.out.println(ans);
    }
}