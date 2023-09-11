package DataDriven;



import org.json.simple.JSONObject;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSonDataReader {

    public String UserName,password;
    public String name,country,city,CardNumber,month,year;
    public void jsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/main/java/DataDriven/UserData.json";
        File srcFile = new File(filePath);
        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));
        for (Object jsonObj : jarray){
            JSONObject person = (JSONObject) jsonObj;
            UserName = (String) person.get("UserName");
            password = (String) person.get("password");
            name = (String) person.get("name");
            country = (String) person.get("country");
            city = (String) person.get("city");
            CardNumber = (String) person.get("CardNumber");
            month = (String) person.get("month");
            year = (String) person.get("year");
        }
    }

}