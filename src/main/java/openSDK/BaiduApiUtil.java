package openSDK;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Configuration;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * 百度地图api
 * @sees https://blog.csdn.net/ljj821061514/article/details/52121995
 * @author daiwei
 * @date 2018/6/11 20:34
 */
@Configuration
public class BaiduApiUtil {
     double x_pi = 3.14159265358979324 * 3000.0 / 180.0;


    protected Logger logger = LoggerFactory.getLogger(BaiduApiUtil.class);



    /**
     * 百度的经纬度是BD-09 坐标
     * @param addr
     * 查询的地址
     * @return
     * @throws IOException
     */
    public Map<String,Double> getLngAndLat(String addr){
        logger.info("从百度地图获取经度与纬度开始,地理位置为:{}",addr);
        Double lng = null;//经度
        Double lat = null;//纬度
        Map<String,Double> map=new HashMap<String, Double>();
        String address = null;
        try {
            address = java.net.URLEncoder.encode(addr, "UTF-8");
        }catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }


        String key="f247cdb592eb43ebac6ccd27f796e2d2";
        String sretCoordtype="bd09ll";
        String url = String .format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s&sret_coordtype=%s", address, key,sretCoordtype);
        JSONObject jsonObject=null;
        try {
            String json = loadJSON(url);
            jsonObject= JSON.parseObject(json);

            lng = jsonObject.getJSONObject("result").getJSONObject("location").getDouble("lng");
            lat = jsonObject.getJSONObject("result").getJSONObject("location").getDouble("lat");

            System.out.println("经度：" + lng + "---纬度：" + lat);
        } catch (Exception e) {
            logger.error("未获取到相匹配的经纬度，调用百度地图api的返回结果为{}",jsonObject);
        }
        map.put("lng", lng);
        map.put("lat", lat);
        logger.info("从百度地图获取经度与纬度结束");
        return map;
    }


    /**
     * 调用百度地图api
     * <P>
     *     urlConnection.getInputStream():读取返回的输入流
     * </P>
     * @param url
     * @return
     */
    public String loadJSON (String url){
        StringBuilder json = new StringBuilder();
        try {
            URL baiduMapURL = new URL(url);
            URLConnection urlConnection = baiduMapURL.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream(),"UTF-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            logger.error("调用百度地图api异常",e);
        }
        return json.toString();
    }


    public static void main(String[] args) throws Exception {

        BaiduApiUtil baiduApiUtil=new BaiduApiUtil();





        Map<String,Double> map = baiduApiUtil.getLngAndLat("四川省成都市高新区萃华路科技大厦");

        System.out.println(map.get("lng"));
        System.out.println(map.get("lat"));



        Double bd_lon = map.get("lng");
        Double bd_lat = map.get("lat");
        if (bd_lon==null||bd_lat==null){
            return;
        }


        double[] doubles = baiduApiUtil.bd_decrypt(bd_lon, bd_lat);
        System.out.println(doubles[0]);
        System.out.println(doubles[1]);


    }



    /**
     *  BD-09 坐标转换成GCJ-02 坐标
     *  <P>
     *      在线坐标转换工具参考：http://mapclub.cn/archives/2168
     *  </P>
     *
     * @param bd_lon  经度
     * @param bd_lat  纬度
     * @return
     */
    public  double[] bd_decrypt(double bd_lon,double bd_lat) {

        double[] d=new double[2];

        double x = bd_lon-0.0065;
        double y = bd_lat-0.006;

        double z = Math.sqrt(x * x + y * y)- 0.00002 * Math.sin(y * x_pi);

        double theta = Math.atan2(y, x)-0.000003 * Math.cos(x * x_pi);

        double gg_lon = z * Math.cos(theta);

        double gg_lat = z * Math.sin(theta);

        d[0]=gg_lon;
        d[1]=gg_lat;
        return d;
    }




}

