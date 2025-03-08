import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[][] index=new int[n][2];
        int mxx=Integer.MIN_VALUE;
        int mxy=Integer.MIN_VALUE;
        int mnx=Integer.MAX_VALUE;
        int mny=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            index[i][0]=in.nextInt();
            index[i][1]=in.nextInt();
            mxx=Math.max(mxx, index[i][0]);
            mxy=Math.max(mxy, index[i][1]);
            mnx=Math.min(mnx, index[i][0]);
            mny=Math.min(mny, index[i][1]);
        }
        int[][] col=new int[mxx-mnx][mxy-mny];
        
        for(int i=0;i<col.length;i++){
            for(int j=0;j<col[0].length;j++){
                
            }
        }

    }
}