import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 类名遵循大驼峰命名法
public class Server {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {//通过套接字监听一个端口的网络包
            System.out.println("Server started and listening on port: " + PORT + "....");
            while (true) {// 阻塞等待客户端连接
                Socket socket = serverSocket.accept();//读取到端口的相关内容
                System.out.println("New Client Connected:" + socket.getInetAddress()+":"+socket.getPort()+"\t"+socket.getRemoteSocketAddress());
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String inputLine;
            // 阻塞读取客户端消息
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from client: " + inputLine);
                // 模拟耗时操作
                System.out.println("正在处理....");
                Thread.sleep(5000);
                out.println("Server received: " + inputLine);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}