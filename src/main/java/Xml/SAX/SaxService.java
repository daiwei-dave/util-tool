package Xml.SAX;
import Xml.SAX.Myhandler;

import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



/**
 * Created by daiwei on 2017/10/24.
 */
public class SaxService {
    public static List<Map<String,String>> ReadXML(String uri,String NodeName){
        try {
            //创建一个解析XML的工厂对象
            SAXParserFactory parserFactory=SAXParserFactory.newInstance();
            //创建一个解析XML的对象
            SAXParser parser=parserFactory.newSAXParser();
            //创建一个解析助手类
            Myhandler myhandler=new Myhandler("stu");
            parser.parse(uri, myhandler);
            return myhandler.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

        }
        return null;

    }
}
