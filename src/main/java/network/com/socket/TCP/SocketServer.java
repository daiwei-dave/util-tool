package network.com.socket.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by daiwei on 2017/4/1.
 */
public class SocketServer {
    public static void main(String[] args) {
        try {
            /** 1.创建ServerSocket*/


            // 创建一个ServerSocket在端口2013监听客户请求
            ServerSocket serverSocket=new ServerSocket(8888);
            while (true){
                // 侦听并接受到此Socket的连接,请求到来则产生一个Socket对象，并继续执行
                Socket socket = serverSocket.accept();

                /** 2.获取客户端传来的信息 */

                // 由Socket对象得到输入流，读取的是客户端传入的信息
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 获取从客户端读入的字符串
                String result = bufferedReader.readLine();
                System.out.println("Client say : " + result);

                /** 3.发送服务端准备传输的 */
                // 由Socket对象得到输出流，并构造PrintWriter对象
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.print("hello Client, I am Server!");
                printWriter.flush();

                /** 4.关闭Socket*/

                printWriter.close();
                bufferedReader.close();
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
