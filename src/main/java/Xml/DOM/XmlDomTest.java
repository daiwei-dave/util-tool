package Xml.DOM;


import java.io.FileInputStream;
import java.util.List;

/**
 * Created by daiwei on 2017/10/26.
 */
public class XmlDomTest {
    public static void main(String[] args) throws Exception {
        // 1. 加载XML资源,这里和SAX一样，也可以是File或者Uri
        String filepath = "d:/users.xml";
        FileInputStream fileInputStream=new FileInputStream(filepath);
        List<User> users = DomParseUtils.getUsers(fileInputStream);
        System.out.println(users.toString());
    }
}
