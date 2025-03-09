import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int ans=0,s=0;
        int[] arr=new int[n];
        int[][]dp=new int[n][2];//第一个维度是坐标，第二个维度是是否使用了，总的dp[][]就是最大距离！
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        dp[0][0]=arr[0];//没反转
        dp[0][1]=-arr[0];//反转了
        for(int i=1;i<n;i++){
            // 动态规划我日你妈！你现在牛逼，老子迟早有一天把你狠狠地踩在脚下！！！！！！！！！！！！！！！
            // 本维度不翻转
            dp[i][0]=Math.max(dp[i-1][1]+arr[i],dp[i-1][0]+arr[i]);
            // 本维度翻转
            dp[i][1]=-(dp[i-1][0]+arr[i]);
            ans=Math.max(dp[i][0],dp[i][1]);
        }
        System.out.println(ans);
    }
}