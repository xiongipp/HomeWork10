package JSONSTUDY;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

public class Test {

    public static void main(String[] args) {
        System.out.println(getTodayT());
    }
    public  static String getTodayT(){
        String code=getCityCode.getCodeByName("仙桃");
        String url="http://t.weather.sojson.com/api/weather/city/"+code;
        String info=NetUtil.get(url);
        XMLSerializer xmlSerializer=new XMLSerializer();
        //json字符串转为xml字符串
        String xml = xmlSerializer.write(JSONSerializer.toJSON(info));
        System.out.println(xml);
        //得到json对象，将需要的数据取出。
        JSONObject obj=JSONObject.fromObject(info);
        JSONObject cityName=JSONObject.fromObject(obj.getString("cityInfo"));
        String location=cityName.getString("parent")+cityName.getString("city");
        return "查询城市为:"+location+'\n'+
                "当前时间是"+obj.getString("date")+'\n'+
                "当前天气信息："+obj.getString("data") ;
    }

}
