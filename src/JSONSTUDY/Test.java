package JSONSTUDY;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<Integer,Map<String,String>> test;
        test=getSearchinfoUtils.getWeatherINFO(getXmlStr());
        Map<String, String> cityInfMap = test.get(0);//拿到城市信息。
        System.out.println("城市名称:"+cityInfMap.get("cityName"));
        Map<String, String> day1 = test.get(1);//拿到当天的天气信息。
        Map<String, String> day2=test.get(2);//这是未来一天的预报信息。
        System.out.println("今天是："+day1.get("ymd")+day1.get("week"));
        System.out.println("天气情况：");
        System.out.println("最高温度:"+day1.get("high"));
        System.out.println("最低温度:"+day1.get("low"));
        System.out.println("温馨提示："+day1.get("notice"));
    }
    public  static String getXmlStr() {
        String code=getCityCode.getCodeByName("仙桃");
        String url="http://t.weather.sojson.com/api/weather/city/"+code;
        String info=NetUtil.get(url);
        XMLSerializer xmlSerializer=new XMLSerializer();
        //json字符串转为xml字符串
        String xml = xmlSerializer.write(JSONSerializer.toJSON(info));
        return xml;
    }
}
