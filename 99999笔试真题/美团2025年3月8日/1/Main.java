import java.util.HexFormat;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // // 注意 hasNext 和 hasNextLine 的区别
        // int n=in.nextInt();
        // String[] strs=new String[n];
        // for (int i = 0; i < n; i++) {
        //     strs[i]=in.next();
        // }
        // for (int i = 0; i < n; i++) {
        //     System.out.println(helper(strs[i]));
        // }
        String[] strs={"meRD2o","D0ame3"};
        for (String string : strs) {
            System.out.println(helper(string));
        }
    }
    private static String helper(String str){
        String t="";
        for (int i = 0,p=0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                if(p==0){
                    p=str.charAt(i)-'0';
                }else{
                    p=p*10+str.charAt(i)-'0';
                }
            }else{
                int p1=p;
                if(t.length()!=0){
                   p1%=t.length(); 
                }
                t=t.substring(p1)+t.substring(0,p1);
                p=0;
                String s="";
                if (str.charAt(i)=='R') {
                    for (int j = t.length()-1; j >=0; j--) {
                        s+=t.charAt(j);
                    }
                    t=s;
                }else{
                    t+=str.charAt(i);
                }
            }
        }
        return t;
    }
}