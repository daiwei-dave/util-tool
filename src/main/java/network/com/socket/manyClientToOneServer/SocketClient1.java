package network.com.socket.manyClientToOneServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端1
 * Created by daiwei on 2017/4/1.
 */
public class SocketClient1 {
    public static void main(String[] args) {
        try {
            /** 1.创建Socket*/

            //创建一个流套接字并将其连接到指定 IP 地址的指定端口号(本处是本机)
            Socket socket=new Socket("127.0.0.1",2013);
            // 60s超时
            socket.setSoTimeout(60000);

            /** 2.发送客户端准备传输的信息 */

            // 由Socket对象得到输出流，并构造PrintWriter对象
            PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
            // 将输入读入的字符串输出到Server,从控制台读取
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String result ="";
            //result中不含有bye
            while(result.indexOf("bye") == -1){
                BufferedReader sysBuff =new BufferedReader(new InputStreamReader(System.in));
                printWriter.println(sysBuff.readLine());
                printWriter.flush();
                result = bufferedReader.readLine();
                System.out.println("Server say : " + result);
            }
            /** 4. 关闭Socket*/

            printWriter.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
