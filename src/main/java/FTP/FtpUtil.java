package FTP;


import FTP.constants.FtpInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.*;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Description ftp工具
 * @Author daiwei
 * @Date 2017/8/7
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public class FtpUtil {

    // 服务器ip
    private String ip;

    // 服务器端口
    private Integer port;

    // 用户名
    private String userName;

    // 用户密码
    private String userPwd;

    public FtpUtil(String ip, Integer port, String userName, String userPwd) {
        this.ip = ip;
        this.port = port;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public FtpUtil() {

    }

    public static void main(String[] args) {
        //     downloadFile(FtpInfo.MODULE_DIRECTORY, "竞争力模型-标准值-201731.xlsx");

        FtpUtil ftpUtil=new FtpUtil("10.122.2.43",21,"daiwei","dw916624");
 //       ftpUtil.downloadFile("/temp/","test.txt");
 //       ftpUtil.uploadFile("")


       ftpUtil.copyFile("/temp/","test.txt","/StoreModel/","2017");
    }


    /**
     * Description: 向FTP服务器上传文件
     *
     * @param basePath FTP服务器基础目录  如temp
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
     * @param filename 上传到FTP服务器上的文件名
     * @param input    输入流
     * @return 成功返回true，否则返回false
     */
    public boolean uploadFile(String basePath, String filePath, String filename, InputStream input) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(ip, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(userName, userPwd);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            // 切换到上传目录
            if (!ftp.changeWorkingDirectory(basePath + filePath)) {
                // 如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) {
                        continue;
                    }
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            return result;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            // 设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.setControlEncoding("GBK");
            // 上传文件,一定要以new String(filename.getBytes("GBK"),"iso-8859-1")这种形式，否则会出错
            if (!ftp.storeFile(new String(filename.getBytes("GBK"), "iso-8859-1"), input)) {
                return result;
            }
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();

            try {
                //如果上传失败，则30分钟后重试
                Thread.sleep(FtpInfo.SLEEP_TIME);
                //             Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            long currentTimeMillisEnd = System.currentTimeMillis();
            //如果重试时间大于1d,则停止重试
            if (currentTimeMillisEnd - FtpInfo.currentTimeMillisStart > 86400000) {
                return false;
            }
            uploadFile(basePath, filePath, filename, input);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
            if (input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 删除指定路径的文件
     *
     * @param basePath FTP服务器基础目录  如temp
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
     * @param filename FTP服务器上的文件名
     * @param
     * @return 成功返回true，否则返回false
     */
    public boolean deleteFile(String basePath, String filePath, String filename) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(ip, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(userName, userPwd);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            //如果基础目录下有文件夹
            if (!StringUtils.isEmpty(filePath)) {
                // 切换到上传目录
                if (!ftp.changeWorkingDirectory(basePath + filePath)) {
                    // 如果目录不存在创建目录
                    String[] dirs = filePath.split("/");
                    String tempPath = basePath;
                    for (String dir : dirs) {
                        if (null == dir || "".equals(dir)) {
                            continue;
                        }
                        tempPath += "/" + dir;
                        if (!ftp.changeWorkingDirectory(tempPath)) {
                            if (!ftp.makeDirectory(tempPath)) {
                                return result;
                            } else {
                                ftp.changeWorkingDirectory(tempPath);
                            }
                        }
                    }
                }
            } else {
                boolean b = ftp.changeWorkingDirectory(basePath);
            }
            boolean flag = ftp.deleteFile(new String(filename.getBytes("GBK"), "iso-8859-1"));
            if (flag) {
                result = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            //如果删除失败，则30分钟后重试
            try {
                Thread.sleep(FtpInfo.SLEEP_TIME);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            //              Thread.sleep(2000);
            long currentTimeMillisEnd = System.currentTimeMillis();
            //如果重试时间大于1d,则停止重试
            if (currentTimeMillisEnd - FtpInfo.currentTimeMillisStart > 86400000) {
                return false;
            }
            deleteFile(basePath, filePath, filename);
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    /**
     * ftp文件下载
     *
     * @param remotePath 文件路径
     * @param fileName   服务器上保存的文件名
     * @return
     * @paramresponse
     */
    public String downloadFile(String remotePath, String fileName) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        FileOutputStream fos = null;
        InputStream inputStream=null;
        try {
            int reply;
            ftp.connect(ip, port);
            ftp.setControlEncoding("GBK");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");
            ftp.login(userName, userPwd);// 登录
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return null;
            }
            //返回为false则说明ftp下没有父目录
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles(); // 得到目录的相应文件列表
            for (int i = 0; i < fs.length; i++) {
                FTPFile ff = fs[i];
                String name = ff.getName();
                if (name.equals(fileName)) {
                    //文件名要进行编码
                    inputStream = ftp.retrieveFileStream(new String(name.getBytes("GBK"), "ISO-8859-1"));
                    System.out.println("当前路径为"+System.getProperty("user.dir"));//user.dir指定了当前的路径
                    String s = System.getProperty("user.dir") + "\\" + name;
                    //            File file = new File("G:/Temp/竞争力模型-标准值-201731.xlsx");
                    File file = new File(s);
                    if (!file.exists()) {
                        file.getParentFile().mkdir();
                        file.createNewFile();
                    }
                    byte[] bytes = new byte[1024];
                    fos = new FileOutputStream(file);
                    while ((i = inputStream.read(bytes)) != -1) {
                        fos.write(bytes, 0, i);
                    }
                    System.out.println(fileName + "下载成功!!");
                    ftp.logout();
                    return s;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
//            return FtpInfo.DOWNLOAD_FAIL;
            return "";
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * 文件复制
     * @param remotePath 被复制的远程目录
     * @param fileName 被复制的文件名
     * @param basePath 要复制的基础目录
     * @param filePath 要复制的路径
     * @return
     */
    public boolean copyFile(String remotePath, String fileName,String basePath, String filePath) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(ip, port);
            ftp.setControlEncoding("GBK");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");
            ftp.login(userName,userPwd);// 登录
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            //返回为false则说明ftp下没有父目录
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles(); // 得到目录的相应文件列表
            for (int i = 0; i < fs.length; i++) {
                FTPFile ff = fs[i];
                String name = ff.getName();
                FileOutputStream fos = null;
                if (name.equals(fileName)) {
                    //文件名要进行编码
                    InputStream inputStream = ftp.retrieveFileStream(new String(name.getBytes("GBK"), "ISO-8859-1"));
                    boolean flag = uploadFile(basePath, filePath, name, inputStream);
                    return flag;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }




    /**
     * ftp文件下载
     *
     * @param remotePath 文件路径
     * @param downName   下载文件名
     * @param fileName   服务器上保存的文件名
     * @return 返回文件输入流
     * @paramresponse
     */
    public InputStream downloadFileReturnInputStream(String remotePath, String downName, String fileName) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        FileOutputStream fos = null;
        InputStream inputStream = null;
        try {
            int reply;
            ftp.connect(ip, port);
            ftp.setControlEncoding("GBK");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");
            ftp.login(userName, userPwd);// 登录
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return null;
            }
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles(); // 得到目录的相应文件列表
            for (int i = 0; i < fs.length; i++) {
                FTPFile ff = fs[i];
                String name = ff.getName();
                if (ff.getName().equals(fileName)) {
                    inputStream = ftp.retrieveFileStream(new String(fileName.getBytes("GBK"), "ISO-8859-1"));
                    return inputStream;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }

        return null;
    }






    /**
     * ftp文件下载
     *
     * @param remotePath 文件路径
     * @param
     * @return
     * @paramresponse
     */
    public List<String> downloadFiles(String remotePath) {
        List<String> stringList = new ArrayList();
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(ip, port);
            ftp.setControlEncoding("GBK");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");
            ftp.login(userName, userPwd);// 登录
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return null;
            }
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles(); // 得到目录的相应文件列表
            String lastName = "";
            for (int i = 0; i < fs.length; i++) {
                FTPFile ff = fs[i];
                String name = ff.getName();
                FileOutputStream fos = null;
                if (name.indexOf("竞争力模型") != -1) {

                    if (lastName.equals(name)) {
                        continue;
                    }
                    InputStream inputStream = ftp.retrieveFileStream(new String(name.getBytes("GBK"), "ISO-8859-1"));
                    System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
                    String s = System.getProperty("user.dir") + "\\" + name;
                    //            File file = new File("G:/Temp/竞争力模型-标准值-201731.xlsx");
                    File file = new File(s);
                    if (!file.exists()) {
                        file.getParentFile().mkdir();
                        file.createNewFile();
                    }
                    byte[] bytes = new byte[1024];
                    fos = new FileOutputStream(file);
                    while ((i = inputStream.read(bytes)) != -1) {
                        fos.write(bytes, 0, i);
                    }
                    System.out.println("download success!!");
                    inputStream.close();
                    lastName = name;
                    stringList.add(s);
                }
            }
            ftp.logout();
            return stringList;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return null;
    }

    /**
     * ftp文件在线预览
     *
     * @param remotePath 文件路径
     * @param fileName   服务器上保存的文件名
     * @return
     * @paramdownName 下载文件名
     * @paramresponse
     */
    public boolean isExistFile(String remotePath, String fileName) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(ip, port);
            ftp.setControlEncoding("GBK");
            FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
            conf.setServerLanguageCode("zh");
            ftp.login(userName, userPwd);// 登录
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles(fileName);
            if (fs != null && fs.length > 0) {
                success = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }

        return success;
    }


    /**
     * 删除指定路径的文件
     *
     * @param filePaths
     */
    public void deleteFiles(List<String> filePaths) {
        // TODO Auto-generated method stub
        FTPClient ftp = getftpclient();
        try {
            for (String path : filePaths) {
                //path = path.substring(path.indexOf("upload/"));
                ftp.deleteFile(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeFtpClient(ftp);
        }

    }


    /**
     * @param file 上传的文件或文件夹
     * @throws Exception
     */
    public void upload(File file, FTPClient ftp) throws Exception {
        if (file.isDirectory()) {
            ftp.makeDirectory(file.getName());
            ftp.changeWorkingDirectory(file.getName());
            String[] files = file.list();
            for (int i = 0; i < files.length; i++) {
                File file1 = new File(file.getPath() + "\\" + files[i]);
                if (file1.isDirectory()) {
                    upload(file1, ftp);
                    ftp.changeToParentDirectory();
                } else {
                    File file2 = new File(file.getPath() + "\\" + files[i]);
                    FileInputStream input = new FileInputStream(file2);
                    ftp.storeFile(file2.getName(), input);
                    input.close();
                }
            }
        } else {
            File file2 = new File(file.getPath());
            FileInputStream input = new FileInputStream(file2);
            ftp.storeFile(file2.getName(), input);
            input.close();
        }
    }

    /**
     * <li>方法名：validType
     * <li>@param type
     * <li>@param allowTypes
     * <li>@return
     * <li>返回类型：boolean
     * <li>说明：判断是都允许的上传类型
     * <li>创建人：yanwen3
     * <li>创建时间：2016年12月14日 下午2:51:18
     * <li>修改人：
     * <li>修改时间：
     */
    public boolean validType(String type, String[] allowTypes) {
        List<String> list = Arrays.asList(allowTypes);

        return list.contains(type);
    }


    /**
     * <li>方法名：getftpclient
     * <li>@return
     * <li>返回类型：FTPClient
     * <li>说明：获取ftp连接
     * <li>创建人：yanwen3
     * <li>创建时间：2017年1月11日 下午3:42:16
     * <li>修改人：
     * <li>修改时间：
     */
    public FTPClient getftpclient() {
        FTPClient ftp = new FTPClient();
        int reply;

        try {
            ftp.connect(ip, port);
        } catch (SocketException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } // 连接FTP服务器
        // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
        try {
            ftp.login(userName, userPwd);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } // 登录
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            try {
                ftp.disconnect();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ftp;
    }

    /**
     * <li>方法名：closeFtpClient
     * <li>@param ftp
     * <li>返回类型：void
     * <li>说明：关闭连接
     * <li>创建人：yanwen3
     * <li>创建时间：2017年1月11日 下午3:41:55
     * <li>修改人：
     * <li>修改时间：
     */
    public void closeFtpClient(FTPClient ftp) {
        try {
            ftp.logout();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                ftp.disconnect();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public InputStream getFile(String path) {
        FTPClient ftp = getftpclient();
        InputStream in = null;
        try {
            in = ftp.retrieveFileStream(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeFtpClient(ftp);
        }
        return in;
    }
}
