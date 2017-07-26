package network.com.socket.fileTransfer;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * 客户端
 * Created by daiwei on 2017/7/26.
 */
public class Client extends Socket{
    private static final String SERVER_IP ="127.0.0.1";
    private static final int SERVER_PORT =2013;

    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;
    public Client(){
        try {
            try {
                client =new Socket(SERVER_IP, SERVER_PORT);
                //向服务端传送文件
                File file =new File("g:/test.doc");
                fis =new FileInputStream(file);
                dos =new DataOutputStream(client.getOutputStream());
                //文件名和长度
                //以UTF-8编码进行写操作
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();
            }catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(fis !=null)
                    fis.close();
                if(dos !=null)
                    dos.close();
                client.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)throws Exception {
        new Client();
    }
}
