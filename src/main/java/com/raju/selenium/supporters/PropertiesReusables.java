package com.raju.selenium.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class PropertiesReusables {
 public String filePath;
 public FileInputStream fip;
 public Properties pr;
 public PropertiesReusables(String filePath) throws IOException {
	this. filePath=filePath;
	fip = new FileInputStream(filePath);
	pr = new Properties();
	pr.load(fip);
 }
 public String getPropertyValue(String key) {
	String value = null;
	if (pr!=null) {
		value=pr.getProperty(key);
	}
	else {
		System.out.println("PROPERTIES VALUES POINTING TO NULL....");
	}
	 return value;
	 
 }
 public void setPropertyValue(String key,String value) throws IOException  {
	if (pr!=null) {
		pr.setProperty(key, value);
		FileOutputStream fop = new FileOutputStream(filePath);
		pr.store(fop, "SAVED SUCCESSFULLY...");
	}
		else {
			System.out.println("PROPERTY VALUE POINTING TO NULL...");
	}
	
	 
 }
public void removeValue(String key) throws IOException {
	if (pr!=null) {
		pr.remove(key);
		FileOutputStream fop = new FileOutputStream(filePath);
		pr.store(fop, "SAVED SUCCESSFULLY");
	}
	else {
		System.out.println("PROPERTY VALUE POINTING TO NULL.....");
	}	
	}
public Map<String, String> getAllProperties(){
	Map<String, String> map = new LinkedHashMap();
	if (pr!=null) {
		Set<Object> keys = pr.keySet();
		for(Object obj:keys) {
			String key = (String)obj;
			String value = pr.getProperty(key);
			map.put(key, value);
			}
	}
	return map;
	
}
}

