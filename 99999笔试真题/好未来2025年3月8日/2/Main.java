import java.util.*;

import javax.smartcardio.TerminalFactory;

public class Main {

    List<List<Integer>> list = new LinkedList<List<Integer>>();
    List<Integer> temp = new LinkedList<Integer>();
// 1.integer[][]=>int[][]? 
    public int[][] combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        // write code here
        // 显然是包含重复的组合问题，回溯法
        dfs(nums, target, list, temp, used, 0);
        list.sort((List<Integer> a, List<Integer> b) -> {
            int n1 = a.size(), n2 = b.size();
            for (int i = 0; i < a.size() && i < b.size(); i++) {
                int x=a.get(i),y=b.get(i);
                if(x!=y){
                    return x-y;
                }
            }
            return n1-n2;
        });

        int[][] ans=new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ans[i]= list.get(i).stream().mapToInt(Integer::intValue).toArray();
            // for (int j = 0; j <ans[i].length; j++) {
            //     System.out.println(ans[i][j]+"\t");
            // }
            // System.out.println();
        }
        return ans;
    }

    public void dfs(int[] nums, int target, List<List<Integer>> list, List<Integer> temp, int[] used, int startIndex) {
        if (startIndex > nums.length) {
            return;
        }
        if (startIndex == nums.length && target == 0) {
            list.add(new LinkedList<>(temp));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && used[i - 1] == 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            target -= nums[i];
            dfs(nums, target, list, temp, used, i + 1);
            temp.removeLast();
            target += nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 2, 1, 2 };
        int target = 5;
        Main solution = new Main();
        System.out.println(solution.combinationSum2(nums, target));
    }
}