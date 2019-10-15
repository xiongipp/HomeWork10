package JSONSTUDY;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {

    public static void main(String[] args) {
        System.out.println(getTodayT());
    }
    public  static String getTodayT(){
        String code=getCityCode.getCodeByName("仙桃");
        String url="http://t.weather.sojson.com/api/weather/city/"+code;
        String info=NetUtil.get(url);
        JSONObject obj=JSONObject.fromObject(info);
        return "查询城市为:"+obj.getString("cityInfo")+'\n'+"当前时间是"+obj.getString("date")+"当前天气信息："+obj.getString("data") ;
    }

}
