package test;
import java.net.URLEncoder;
import java.util.Random;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.UnsupportedEncodingException;

public class MD5 {
	public static int i=0;
	private static String data,urlString,consume;
	
		public static String geturl(){
		  data ="{"+data+"}";

		ReturnMD5();
		String url=urlString;
		urlString=null;
		return url;
	}
		public static String geturl_nomd5(){
			data ="{"+data+"}";
			try{
				 data=URLEncoder.encode(data,"UTF-8");
				}
			catch(UnsupportedEncodingException ex) 
			{throw new RuntimeException("1");}
			urlString="?"+"data="+data;
			String url=urlString;
			urlString=null;
			data=null;
			i=0;
			return url;
		}
		
	
	public static String ReturnMD5(){
		
		//System.out.println("data="+data);		
		String msgServer=null;
		if(consume==null)
		{
		data=null;
		i=0;
		}
		else
		{
		msgServer = DigestUtils.md5Hex(consume + "_key_" +data);
		
		try{
			 data=URLEncoder.encode(data,"UTF-8");
			}
		catch(UnsupportedEncodingException ex) 
		{throw new RuntimeException("1");}
		urlString=urlString+"&data="+data;
		
		data=null;
		i=0;
		urlString=urlString+"&"+"msg="+msgServer;
		}
		
		//System.out.println("md5="+msgServer);
		return msgServer;
	}
	
	public static String addParameters(String key,String value){

			if(key.equals("consume"))
			{
				consume=value;
				urlString="?"+key+"="+value+"&"+"time="+System.currentTimeMillis();
			}
			else
			{	
				if(i<=0)
				{
					data ="\""+key+"\""+":"+"\""+value+"\"";
				}
				else
				{
					data =data+","+"\""+key+"\""+":"+"\""+value+"\"";
				}
				i++;
				//urlString=urlString+"&"+key+"="+value;
			//data="\""+key+"\""+":"+"\""+value+"\"";
			}

		return data;
	}
	
	public static String addParameters_nomd5(String key,String value){

			if(i<=0)
			{
				data ="\""+key+"\""+":"+"\""+value+"\"";
			}
			else
			{
				data =data+","+"\""+key+"\""+":"+"\""+value+"\"";
			}
			i++;
			//urlString=urlString+"&"+key+"="+value;
		//data="\""+key+"\""+":"+"\""+value+"\"";
		

	return data;
}
	
	public static String addParameters(String key,String value,int strnum){
		value=value+getRandomString(strnum);
		data =data+","+"\""+key+"\""+":"+"\""+value+"\"";
		i++;
		return data;
	}
	
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sj=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sj.append(str.charAt(number));
	     }
	     return sj.toString();
	 }

	public static void main(String[] args){
		/*
	addParameters("consume","123");
	addParameters("key","value");
	addParameters("key2","value2",5);
	System.out.println("URL="+geturl());
	
		addParameters_nomd5("userid","123");
		System.out.println("URL="+geturl_nomd5());	
		*/
	}
}
