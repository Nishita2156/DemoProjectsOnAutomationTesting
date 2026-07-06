package com.osa.utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {
	
	private static Logger log=Utils.getLog(Utils.class);
	
	public static Logger getLog(Class clazz) {
		Logger log=Logger.getLogger(clazz);
		PropertyConfigurator.configure("src/test/resources/properties/log4j.properties");
		return log;
		}
	
	
	
	public static JsonPath getRes(Response res) {//this on method for json path
		System.out.println(res.asPrettyString());
		return res.getBody().jsonPath();
	}
	public static Properties setProp(String filePath) {//this on method for prperties file 
		Properties prop=new Properties();
		try {
		FileInputStream fs=new FileInputStream(filePath);
			prop.load(fs);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return prop;
	}
	
}
