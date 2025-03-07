import java.util.concurrent.Exchanger;

public class testExchanger {
    static Exchanger<String> exchanger=new Exchanger<>();
    public static void main(String[] args) throws Exception{
        new Thread(()->{
            String date1="data1";
            System.out.println("Before exchange "+Thread.currentThread().getName()+"'s date : "+date1);
            String exchange="";
            try {
               exchange = exchanger.exchange(date1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("After exchange "+Thread.currentThread().getName()+"'s date : "+exchange);

        },"线程1").start();

        new Thread(()->{
            String date1="data2";
            System.out.println("Before exchange "+Thread.currentThread().getName()+"'s date : "+date1);
            String exchange="";
            try {
               exchange = exchanger.exchange(date1);
            } catch (InterruptedException e) {
                 e.printStackTrace();
             }
            System.out.println("After exchange "+Thread.currentThread().getName()+"'s date : "+exchange);

        },"线程2").start();
        
    }
}
