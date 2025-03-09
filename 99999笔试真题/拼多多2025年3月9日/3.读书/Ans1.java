import java.util.Scanner;

public class Ans1 {
    public static void main(String[] args) {
        // int n = 4, m = 1;
        // double[] a = { 1, 2, 3, 4};
        // int n = 5, m = 4;
        // double[] a = { 1, 2, 3, 3,1};
        int n = 5, m = 4;
        double[] a = { 4, 2, 3, 3, 1 };
        double[][] dp = new double[n + 1][m + 1];
        // 设 dp[i][j] 表示读到第 i 页时，用了 j 分钟能获取的最大知识量。
        // 求什么，设什么！
        // 初始化 dp 数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {// 至少一分钟时间
                // 一分钟一页
                if (i > 0 && dp[i - 1][j - 1] != -1) {// 读到了前面的页数
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + a[i - 1]);
                }
                // 一分钟两页
                if (i > 1 && dp[i - 2][j - 1] != -1) {// 读到了前面的页数
                    double y = dp[i - 2][j - 1] + (a[i - 1] + a[i - 2]) / 2.0;
                    dp[i][j] = Math.max(dp[i][j], y);
                }
            }
        }

        if (dp[n][m] == 0.0) {
            System.out.println("-1");
        } else {
            System.out.printf("%.1f", dp[n][m]);
        }
    }
}