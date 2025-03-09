import java.util.Scanner;

// 动态规划
// 设 dp[i][j] 表示经过前 i 个传送门，且累计使用反转技能的次数为j次时，到初始位置的最大距离。
// 最最核心的是累计的使用次数，这一点尤为重要，在dp定义时！
public class Ans2 {
    public static void main(String[] args) {
        // 这里可以根据实际情况修改输入方式，使用 Scanner 读取输入
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = scanner.nextInt();
        // }
        int n = 5;
        int[] arr = {2, -20, -4, -9, 1};
        int[][] dp = new int[n][2];
        // 初始化
        dp[0][0] = arr[0];
        dp[0][1] = -arr[0];

        int maxDist = Math.max(Math.abs(dp[0][0]), Math.abs(dp[0][1]));
        for (int i = 1; i < n; i++) {
            // 不使用反转技能，只能从前一个未使用反转技能的状态转移过来
            dp[i][0] = dp[i - 1][0] + arr[i];

            // 使用一次反转技能
            // 在第 i 个传送门使用反转技能
            int useNow = -(dp[i - 1][0] + arr[i]);
            // 在之前的传送门已经使用了反转技能
            int usedBefore = dp[i - 1][1] + arr[i];
            dp[i][1] = Math.abs(useNow)>Math.abs(usedBefore)?useNow:usedBefore;//更新最大距离，肯定选最远的！

            // 更新最大距离
            maxDist = Math.max(maxDist, Math.max(Math.abs(dp[i][0]), Math.abs(dp[i][1])));
        }

        System.out.println(maxDist);
    }
}
