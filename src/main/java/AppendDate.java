
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by daiwei on 2017/4/11.
 * 日期拼接成连续
 *
 *对结果位数进行保留
 *DecimalFormat df = new DecimalFormat("#.00");
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
@Service("alumYieldFacade")
public class AppendDate {


//    /**
//     * 阳极组装产量统计
//     *
//     * @param alumProceQuery
//     * @return
//     */
//    @Override
//    public ResultData getAnodeProduce(AlumProceQuery alumProceQuery) {
//
//        Map<String, Object> map = new LinkedHashMap<String, Object>();
//
//        List<Map<String, String>> finalList = getFinalList(alumProceQuery);
//        map.put("produceList", finalList);
//
//        //求总和
//        Map<String, Object> querySum = alumYieldService.querySum(alumProceQuery);
//        //最后一次的库存为总库存
//        if(finalList.size()>0){
//            querySum.put("stokQuant", finalList.get(finalList.size() - 1).get("stokQuant"));
//            if (querySum.get("pIronConsumption")!=null&&querySum.get("prodYield")!=null){
//                if (Double.parseDouble(querySum.get("prodYield").toString())==0){
//                    querySum.put("prodnCsmd",null);
//                }else {
//                    //磷生铁单耗
//                    double temp=Double.parseDouble(querySum.get("pIronConsumption").toString())/Double.parseDouble(querySum.get("prodYield").toString());
//                    String format = decimalFormat.format(temp);
//                    querySum.put("prodnCsmd",format);
//                }
//            }
//        }
//        map.put("sum", querySum);
//        //自定义日期时按月求总和
//        if (!StringUtils.isNullOrEmpty(alumProceQuery.getStartDate())
//                || (!StringUtils.isNullOrEmpty(alumProceQuery.getEndDate()))) {
//            //封装用户当前的年月
//            AlumProceQuery nowAlumProceQuery = new AlumProceQuery();
//            StringBuffer stringBuffer = new StringBuffer("0");
//            Calendar now = Calendar.getInstance();
//            int month = now.get(Calendar.MONTH) + 1;
//            int year = now.get(Calendar.YEAR);
//            nowAlumProceQuery.setMonth(stringBuffer.append(String.valueOf(month)).toString());
//            nowAlumProceQuery.setYear(String.valueOf(year));
//            Map<String, Object> querySumMonth = alumYieldService.querySumMonth(nowAlumProceQuery);
//            List<Map<String, String>> nowAlumProceQueryinalList = getFinalList(nowAlumProceQuery);
//            //当前月的最后一天的库存为月库存
//            if(nowAlumProceQueryinalList.size()>0){
//                querySumMonth.put("stokQuant", nowAlumProceQueryinalList.get(nowAlumProceQueryinalList.size() - 1).get("stokQuant"));
//                if (querySumMonth.get("pIronConsumption")!=null&&querySumMonth.get("prodYield")!=null){
//                    if (Double.parseDouble(querySumMonth.get("prodYield").toString())==0){
//                        querySumMonth.put("prodnCsmd",null);
//                    }else {
//                    //磷生铁单耗
//                    double temp=Double.parseDouble(querySumMonth.get("pIronConsumption").toString())/Double.parseDouble(querySumMonth.get("prodYield").toString());
//                    String format = decimalFormat.format(temp);
//                    querySumMonth.put("prodnCsmd",format);
//                    }
//                }
//
//            }
//            map.put("sumMonth", querySumMonth);
//        }
//        return ResultData.newResultData(map);
//
//    }

//    /**
//     * 获取阳极组装产量信息
//     *
//     * @param alumProceQuery
//     * @return
//     */
//    public List<Map<String, String>> getFinalList(AlumProceQuery alumProceQuery) {
//        Map<String, Map<String, String>> result = new LinkedHashMap<>();
//
//        //阳极组装产量（组）
//        List<AlumYieldVO> prodYield = alumYieldService.queryProdYield(alumProceQuery);
//        convertList(prodYield, result, "prodYield");
//
//        //库存（组）
//        List<AlumYieldVO> stokQuant = alumYieldService.queryStokQuant(alumProceQuery);
//        convertList(stokQuant, result, "stokQuant");
//
//        //发极数（组）
//        List<AlumYieldVO> csmdQuant = alumYieldService.queryCsmdQuant(alumProceQuery);
//        convertList(csmdQuant, result, "csmdQuant");
//
//        //炭块入库（块）
//        List<AlumYieldVO> csmdQuantIn = alumYieldService.queryCsmdQuantIn(alumProceQuery);
//        convertList(csmdQuantIn, result, "csmdQuantIn");
//
//        //炭块出库（块）
//        List<AlumYieldVO> csmdQuantOut = alumYieldService.queryCsmdQuantOut(alumProceQuery);
//        convertList(csmdQuantOut, result, "csmdQuantOut");
//
//        //炭块库存（块）
//        List<AlumYieldVO> csmdQuantStore = alumYieldService.queryCsmdQuantStore(alumProceQuery);
//        convertList(csmdQuantStore, result, "csmdQuantStore");
//
//        //磷生铁消耗（kg）
//        List<AlumYieldVO> pIronConsumption = alumYieldService.queryPIronConsumption(alumProceQuery);
//        convertList(pIronConsumption, result, "pIronConsumption");
//
//        //磷生铁单耗（kg/块）
//        List<AlumYieldVO> prodnCsmd = alumYieldService.queryProdnCsmd(alumProceQuery);
//        convertList(prodnCsmd, result, "prodnCsmd");
//
//
//        List<Map<String, String>> finalList = convertToFinalList(result);
//        //对结果按日期排序
//        Collections.sort(finalList, new Comparator() {
//            /**
//             * 升序排序
//             */
//            public int compare(Object obj1, Object obj2) {
//                Map<String, String> map1 = (Map<String, String>) obj1;
//                Map<String, String> map2 = (Map<String, String>) obj2;
//                return Integer.parseInt(map1.get("prodDate")) - Integer.parseInt(map2.get("prodDate"));
//            }
//        });
//
//        //字段为空时，设置初始值为0（并非数据库的实际值）
//        for (int i = 0; i < finalList.size(); i++) {
//            if (finalList.get(i).get("pIronConsumption") == null) {
//                finalList.get(i).put("pIronConsumption", "0");
//            }
//            if (finalList.get(i).get("prodYield") == null) {
//                finalList.get(i).put("prodYield", "0");
//                finalList.get(i).put("prodnCsmd", null);
//            }else {
//                //磷生铁单耗
//                double temp = Double.parseDouble(finalList.get(i).get("pIronConsumption")) / Double.parseDouble(finalList.get(i).get("prodYield"));
//                String format = decimalFormat.format(temp);
//                if (format.equals("0.00")) {
//                    finalList.get(i).put("prodnCsmd", "0");
//                } else {
//                    finalList.get(i).put("prodnCsmd", format);
//                }
//            }
//
//            if (finalList.get(i).get("csmdQuant") == null) {
//                finalList.get(i).put("csmdQuant", "0");
//            }
//
//            if (finalList.get(i).get("csmdQuantIn") == null) {
//                finalList.get(i).put("csmdQuantIn", "0");
//            }
//            if (finalList.get(i).get("csmdQuantOut") == null) {
//                finalList.get(i).put("csmdQuantOut", "0");
//            }
//            if (finalList.get(i).get("csmdQuantStore") == null) {
//                finalList.get(i).put("csmdQuantStore", "0");
//            }
//
//
//            //如果是按年查找的后的结果
//            if (finalList.get(i).get("prodDate").length() == 6) {
//                //重新封装查询条件
//                AlumProceQuery queryByMonth = new AlumProceQuery();
//                String year = finalList.get(i).get("prodDate").substring(0, 4);
//                String month = finalList.get(i).get("prodDate").substring(4, 6);
//                queryByMonth.setYear(year);
//                queryByMonth.setMonth(month);
//                List<Map<String, String>> finalListByMonth = getFinalList(queryByMonth);
//                finalList.get(i).put("stokQuant", finalListByMonth.get(finalListByMonth.size() - 1).get("stokQuant"));
//            }
//            //如果是按月或者自定义时间查找后的结果
//            if (finalList.get(i).get("prodDate").length() == 8) {
//                /**
//                 * 用基准的库存数据+期间产出数量-期间出库数据=库存数据（a+b-c）
//                 * 当天若有库存，则不进行计算
//                 */
//                double temp = 0;
//                if (i == 0) {
//                    if (finalList.get(i).get("stokQuant") == null) {
//                        //当天日期
//                        String prodDate = finalList.get(i).get("prodDate");
//                        //查询最近有库存的日期
//                        String dateBeforeProdDate = alumYieldService.queryDateBeforeProdDate(prodDate);
//
//                        if (dateBeforeProdDate != null) {
//                            //重新封装查询条件
//                            AlumProceQuery query = new AlumProceQuery();
//                            query.setStartDate(dateBeforeProdDate);
//                            query.setEndDate(prodDate);
//                            //递归获得当天的库存
//                            List<Map<String, String>> mapList = getFinalList(query);
//                            finalList.get(i).put("stokQuant", mapList.get(mapList.size() - 1).get("stokQuant"));
//                        } else {
//                            //没有找到有库存的日期,则当天为0
//                            finalList.get(i).put("stokQuant", "0");
//                        }
//                    }
//                } else {
//                    //当天若有库存或者昨天库存为0，则不进行计算
//                    if (finalList.get(i).get("stokQuant") == null && !finalList.get(i - 1).get("stokQuant").equals("0")) {
//                        temp = Double.parseDouble(finalList.get(i - 1).get("stokQuant")) + Double.parseDouble(finalList.get(i).get("prodYield")) - Double.parseDouble(finalList.get(i).get("csmdQuant"));
//                        finalList.get(i).put("stokQuant", String.valueOf(temp));
//                    } else if (finalList.get(i - 1).get("stokQuant").equals("0") && finalList.get(i).get("stokQuant") == null) {
//                        //昨天库存为0且今天也没有库存，则今天库存也为0
//                        finalList.get(i).put("stokQuant", "0");
//                    }
//                }
//            }
//        }
//        return finalList;
 //   }

    /**
     * 将日期拼接。
     * @param
     * @param
     * @param rowName
     */
//   public void convertList(List<AlumYieldVO> list, Map<String, Map<String, String>> result, String rowName) {
//        //1.遍历查询的数据，取日期
//        //2.存到下面的map
//        //3.再遍历map
//        //4.存到resultList
//        if (null == list || list.size() <= 0) {
//            return;
//        }
//        DecimalFormat df = new DecimalFormat("0.00");
//        Map<String, String> valueMap;
//
//        /**
//         * 若日期重复，在当前日期下增加result的value值。
//         * 若日期为新的，在增加result的key-value
//         */
//        for (int i = 0; i < list.size(); i++) {
//            if (!result.containsKey(list.get(i).getProdDate())) {
//                valueMap = new LinkedHashMap<>();
//                valueMap.put(rowName, String.valueOf(getFieldValue(list.get(i), rowName)));
//                //存储日期和对应的时间
//                result.put(list.get(i).getProdDate(), valueMap);
//            } else {
//                //existMap只是一个临时变量未进行实例化，故没有值，
//                // 以下代码等价于：result.get(list.get(i).getProdDate()).put(rowName, String.valueOf(getFieldValue(list.get(i), rowName)))
//                Map<String, String> existMap = result.get(list.get(i).getProdDate());
//                //存储值
//                existMap.put(rowName, String.valueOf(getFieldValue(list.get(i), rowName)));
//            }
//        }
//    }

//    /**
//     * 获取成员变量的值
//     * @param clazz 类的实例名
//     * @param rowName 成员变量名
//     * @return
//     */
//    private Object getFieldValue(AlumYieldVO clazz, String rowName) {
//        Field field = null;
//        Object obj = null;
//        try {
//            field = clazz.getClass().getDeclaredField(rowName);
//            field.setAccessible(true);
//            obj = field.get(clazz);
//        } catch (Exception e) {
//        }
//        return obj;
//    }

    /**
     * 将map集合转为list集合
     * @param
     * @return
     */
//    private List<Map<String, String>> convertToFinalList(Map<String, Map<String, String>> result) {
//        Map<String, List<Map<String, String>>> resultMap = new LinkedHashMap<>();
//        List<Map<String, String>> finalList = new ArrayList<>();
//        for (Entry<String, Map<String, String>> entry : result.entrySet()) {
//            Map<String, String> finalMap = new LinkedHashMap<>();
//            Map<String, String> temp = new LinkedHashMap<>();
//            temp.put("prodDate", entry.getKey());
//            finalMap.putAll(temp);
//            finalMap.putAll(entry.getValue());
//            finalList.add(finalMap);
//        }
//        return finalList;
//    }



}
