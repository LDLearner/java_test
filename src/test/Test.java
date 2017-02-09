package test;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

/*import org.json.JSONArray;    
import org.json.JSONException;    
import org.json.JSONObject;    
import org.json.JSONTokener; */  
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map map = new HashMap();
	    map.put("consume","1100002");
	    map.put("userId","1100002");
	    map.put("headImg","123");
	    map.put("nickName","123");
	    map.put("star","value");
	    map.put("personSign","value");
	    map.put("feeling","value");
	    map.put("job","value");
	    map.put("province","Beijing");
	    map.put("city","Beijing");
	    map.put("backGround","123");
	    map.put("birthday","1983-03-17");
	    map.put("sex","1");
	    map.put("age","18");
//	    JsonObject obj =json.parse(map);
	    
	    JSONArray json = JSONArray.fromObject(map); 
	    System.out.println(json.toString());
	    //obj.toString();
	    
	   // MD5.
	    
	    
	    
	    

	}

}
