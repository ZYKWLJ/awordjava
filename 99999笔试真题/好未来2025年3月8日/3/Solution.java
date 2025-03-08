import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private static final int TOTAL = 60 * 24;
    public int findMinDifference(List<String> timePoints) {
        List<Integer> arr = new ArrayList<>();
        for (String str : timePoints) {
            int cur = ((str.charAt(0) - '0') * 10 + (str.charAt(1) - '0')) * 60 +
                    (str.charAt(3) - '0') * 10 + (str.charAt(4) - '0');
            if (cur == 0) { // 如果时间为 00:00，将其转换为一天的总分钟数
                cur = TOTAL;
            }
            arr.add(cur);
        }
        Collections.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            int before = (i == 0) ? arr.get(arr.size() - 1) : arr.get(i - 1);
            int after = (i == arr.size() - 1) ? arr.get(0) : arr.get(i + 1);
            ans = Math.min(Math.min(Math.abs(x - before), Math.abs(after - x)), ans);
        }
        return ans;
    }
}