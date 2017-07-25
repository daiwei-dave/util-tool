package IO;

import java.io.*;

/**
 * io流工具包
 * Created by daiwei on 2017/7/25.
 */
public class IoUtil {
    /**
     * 将读取的数据进行写操作
     * @param inputStream
     * @param outputStream
     */
    public static void write(InputStream inputStream, OutputStream outputStream) {
        if (null == inputStream) {
            return;
        }
        try {
            byte[] buf = new byte[1024];
            int flag = 0;
            while ((flag = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, flag);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(inputStream);
            close(outputStream);
        }
    }

    public static void close(OutputStream outputStream) {
        try {
            if (null != outputStream) {
                outputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(InputStream inputStream) {
        try {
            if (null != inputStream) {
                inputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(inputStream, byteArrayOutputStream);
        close(inputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream fileInputStream(File file) {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static InputStream fileInputStream(String file) {
        try {
            new File(file).getParentFile().mkdirs();

            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static FileOutputStream fileOutputStream(String file) {
        try {
            new File(file).getParentFile().mkdirs();

            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static FileOutputStream fileOutputStream(File file) {
        try {
            file.getParentFile().mkdirs();

            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
