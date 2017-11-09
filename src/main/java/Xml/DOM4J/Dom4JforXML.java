package Xml.DOM4J;
import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * Created by daiwei on 2017/11/9.
 */
public class Dom4JforXML {



    /**
     * 遍历当前节点下的所有节点
     * @param node
     */
    public static void listNodes(Element node){
        System.out.println("当前节点的名称：" + node.getName());
        //首先获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        //遍历属性节点
        for(Attribute attribute : list){
            System.out.println("属性"+attribute.getName() +":" + attribute.getValue());
        }
        //如果当前节点内容不为空，则输出
        if(!(node.getTextTrim().equals(""))){
            System.out.println( node.getName() + "：" + node.getText());
        }
        //同时迭代当前节点下面的所有子节点
        //使用递归
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            listNodes(e);
        }
    }

    public static void operate(Element root){
        System.out.println("-------添加属性前------");
        Element userElement = root.element("user");
        //遍历
        listNodes(userElement);
        //获取其属性
        Attribute idAttribute = userElement.attribute("id");
        //删除其属性
        userElement.remove(idAttribute);
        listNodes(userElement);
    }


    public static void main(String[] args) throws DocumentException {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        Document document = reader.read(new File("d:/users.xml"));
        //获取根节点元素对象
        Element root = document.getRootElement();
        //遍历
        listNodes(root);
    }



}
