package Xml.SAX;
import Xml.SAX.SaxService;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by daiwei on 2017/10/24.
 */
public class XmlSaxTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Map<String, String>> list=(ArrayList<Map<String, String>>) SaxService.ReadXML("D:\\myClass.xml","class");
//        for(int i=0;i<list.size();i++){
//            HashMap<String, String> temp=(HashMap<String, String>) list.get(i);
//                Iterator<String> iterator=temp.keySet().iterator();
//                while(iterator.hasNext()){
//                    String key=iterator.next().toString();
//                    String value=temp.get(key);
//                    System.out.print(key+" "+value+"--");
//                }
//        }
        System.out.println(list.toString());
    }
}
