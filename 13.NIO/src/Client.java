import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private final static String SERVER_HOST = "localhost";
    private final static int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            for (int i = 0; i < 1000; i++) {
                out.println("Hello,sever~~~");// 发消息到服务器，往这个out里面写东西！
                System.out.println("waiting for server...");
                String response = in.readLine();// 读取服务器响应
                System.out.println("Received From server :" + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
