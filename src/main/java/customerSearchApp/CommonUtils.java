package customerSearchApp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;

public class CommonUtils {

    public static HashMap<String,String> headers = new HashMap<>();


    public void setUpHeaders(String key, String value){
        headers.put(key,value);
    }

    public void clearHeader(){
        headers.clear();
    }

    public String convertJSONTORequestString(String filePath){
        try{
            org.json.simple.parser.JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(filePath);
            JSONObject actualObject = (JSONObject)parser.parse(reader);
            String requestBody = actualObject.toJSONString();
            System.out.println("RequestBody is : "+requestBody);
            return requestBody;
        }catch (Exception e){
            System.out.println("Exception in convertJSONTORequestString : " + e);
        }
        return null;
    }
}
