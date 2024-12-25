package util;

import java.util.Map;

import javax.naming.ServiceUnavailableException;

import org.neo4j.driver.*;
import org.neo4j.driver.types.Node;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class test {
	
	public static final Gson GSON= new Gson();
	public  static Driver getdriver() {
		return GraphDatabase.driver("neo4j://localhotst:7687", AuthTokens.basic("neo4j","12345678"));
				
	}
	public static <T> T nodetoPOJO(Node node, Class<T> clazz) {
		Map<String, Object> pro= node.asMap();
		String json=GSON.toJson(pro);
		T obj=GSON.fromJson(json, clazz);
		return obj;
	}
	public static <T> Map<String , Object> getProperties(T t){
		
		String json=GSON.toJson(t);
		Map<String , Object> map= GSON.fromJson(json, new TypeToken<Map<String, Object>>(){});
		return map;
	}
	public static void main(String[] args) {
		Driver driver =null;
		try {
			driver=AppUtils.getDriver();
			System.out.println("thanh cong");
		}
		finally {
			if(driver !=null)
				driver.close();
		}
	}
}
