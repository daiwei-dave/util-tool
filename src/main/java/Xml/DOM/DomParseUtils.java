package Xml.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by daiwei on 2017/10/26.
 */
public class DomParseUtils {

    public static List<User> getUsers(InputStream inputStream) throws Exception {
        List<User> userList=new ArrayList<User>();
        // 2. 得到文档构建工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // 3. 通过构建工厂生产构建类
        DocumentBuilder newDocumentBuilder = factory.newDocumentBuilder();
        // 4. 那这个构建类将XML资源解析得到Document对象
        Document doc = newDocumentBuilder.parse(inputStream);

        // 得到根节点
        Element root = doc.getDocumentElement();
        // 根据指定的标签名称得到相应的节点集合
        NodeList userNodes = root.getElementsByTagName("user");
        for (int i = 0; i < userNodes.getLength(); i++) {
            // 依次解析每个user节点
            Element userElement = (Element) userNodes.item(i);
            // 获取user节点的属性
            int id = Integer.valueOf(userElement.getAttribute("id"));
            User user = new User();
            user.setId(id);
            // 接下来解析子元素
            NodeList childNodes = userElement.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                Node childNode = childNodes.item(j);
                if (childNode.getNodeType() == Node.ELEMENT_NODE) { // 判断是不是元素节点
                    String nodeName = childNode.getNodeName(); // 得到节点名称
                    String value = childNode.getFirstChild().getNodeValue(); // 得到第一个子节点的值，这里为TextNode
                    if ("name".equals(nodeName)) { // 如果当前的节点为name，那么它的值就是user的name
                        user.setName(value);
                    } else if ("password".equals(nodeName)) { // 如果当前的节点为password，那么它的值就是user的password
                        user.setPassword(value);
                    }
                }
            }
            userList.add(user);
        }
        return userList;
    }
}
