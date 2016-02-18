package com.amk.util.properties;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class CacheProperties extends java.util.Properties {

	    
	/**
	 * 
	 */
	private static final long serialVersionUID = -2602105591649994369L;

	private static final Properties INSTANCE = new Properties();
	
	
	private CacheProperties()
	{
		   
		  Properties cache = CacheProperties.getInstance();
		   
	      InputStream in = this.getClass().getClassLoader().getResourceAsStream("app.properties");

	      try {
	          cache.load(in);
	      } catch (IOException e) {
	          e.printStackTrace();  // Delete this 
	      }
	   }
	   
	   
	   public void setProperties( String property, String value){
	   
		   if(INSTANCE.containsKey(property) == false){
		    INSTANCE.setProperty(property, value);
		   }
		   System.out.println(this.getProperty(property));  
	 
	   }
	   
	  	 
	   public static Properties getInstance()
	   {
	      return INSTANCE;
	   }
	    
	   public String getProperty(String key){
	      return INSTANCE.getProperty(key);
	   }
	    
	   public Set<String> getAllPropertyNames(){
	      return INSTANCE.stringPropertyNames();
	   }
	    
	   public boolean containsKey(String key){
	      return INSTANCE.containsKey(key);
	   }
	   
	   
	   public static void main(String[] args) {

			CacheProperties prop = new CacheProperties();
			
			try{

				System.out.println("Main to test -- delete");
				System.out.println(prop.getProperty("my.key"));
				System.out.println(prop.getProperty("filedbuser"));
				System.out.println(prop.getProperty("dbpassword"));

			} catch (Exception ex) {
				ex.printStackTrace();
			} 

		  }
	   
	}