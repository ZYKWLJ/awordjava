import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new
        HashMap<>(); //加入哈希表时想一想是不是如果他的倍数或者约数已经存在了，那就不加入，这样保证是第一个最先的
        Scanner in = new Scanner(System.in);
        // Scanner in = new Scanner(System.in);
        int n = in.nextInt(), a = in.nextInt(), b = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            
        }

        int[] dp = new int[n];
        dp[0] = 0;
        map.put(arr[0], 0);
        for (int i = 1; i < n; i++) {
            int before=-1;
            for(Integer k:map.keySet()){
                if((k % arr[i] == 0 || arr[i] % k == 0)){
                    before=map.get(k);
                    break;
                }
            }
            map.put(arr[i],i); //添加到哈希表中的全是有效的，找到最早的即可
            if (before==-1) {
                dp[i] = dp[i - 1] + a;
            } else {
                dp[i] = Math.min(dp[i - 1] + a, dp[before] + b);
            }
        }
        System.out.println(dp[n - 1]);
    }
}

