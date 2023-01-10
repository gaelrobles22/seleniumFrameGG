package Functions;



import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;


public class SeleniumFunctions {

    private static Logger log = Logger.getLogger(SeleniumFunctions.class);
    public static String FileName = "";
    public static String PagesFilePath = "src/test/resources/Pages/";
    public static String GetFieldBy = "";
    public static String ValueToFind = "";

    public static Object readJson()throws IOException{
        FileReader reader = new FileReader(PagesFilePath + FileName);
        try{
            if(reader != null){
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(reader);
            }else{
                return null;
            }
        }catch (FileNotFoundException | NullPointerException e){
            log.error("No existe el archivo " + FileName);
            throw new IllegalStateException("No existe el archivo "+FileName, e);
        }
    }

    public static JSONObject ReadEntity(String element) throws Exception{
        JSONObject Entity = null;

        JSONObject jsonObject = (JSONObject) readJson();
        Entity = (JSONObject) jsonObject.get(element);
        log.info(Entity.toJSONString());
        return Entity;
    }

    public static By getCompleteElements(String element)throws Exception{
        By result = null;
        JSONObject Entity = ReadEntity(element);

        GetFieldBy = (String) Entity.get("GetFieldBy");
        ValueToFind = (String) Entity.get("ValueToFind");

        if("className".equalsIgnoreCase(GetFieldBy)){
            result = By.className(ValueToFind);
        }else if("cssSelector".equalsIgnoreCase(GetFieldBy)) {
            result = By.cssSelector(ValueToFind);
        }else if("id".equalsIgnoreCase(GetFieldBy)){
            result = By.id(ValueToFind);
        }else if("linkText".equalsIgnoreCase(GetFieldBy)) {
            result = By.linkText(ValueToFind);
        }else if("name".equalsIgnoreCase(GetFieldBy)) {
            result = By.name(ValueToFind);
        }else if("link".equalsIgnoreCase(GetFieldBy)) {
            result = By.partialLinkText(ValueToFind);
        }else if("tagName".equalsIgnoreCase(GetFieldBy)) {
            result = By.tagName(ValueToFind);
        }else if("xpath".equalsIgnoreCase(GetFieldBy)) {
            result = By.xpath(ValueToFind);
        }
        return result;
    }
}



