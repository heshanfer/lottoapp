package main;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Heshan
 */
public class DLBResults {
    private static Map<String, String> map = new HashMap<String, String>();
    
    private static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    
    private static List<String> getData(String pageContent){
        List<String> dataList = new ArrayList<String>();
        String patternString1 = "<tr class=\"alt\">";
        Pattern pattern1 = Pattern.compile(patternString1);
        Matcher matcher1 = pattern1.matcher(pageContent);
        if(matcher1.find()){
            //System.out.println(matcher1.group());
            String filteredStr = pageContent.substring(matcher1.end()).trim();
            //System.out.println(filteredStr);
            
            
            String patternString2 = "<td><div align=\"right\">";
            Pattern pattern2 = Pattern.compile(patternString2);
            Matcher matcher2 = pattern2.matcher(filteredStr);
            
            while(matcher2.find()){
                String filteredStr2 = filteredStr.substring(matcher2.end()).trim();
                String data = filteredStr2.split("&nbsp")[0];
                //System.out.println(data);
                dataList.add(data);
            }
            
           // System.out.println(filteredStr);
            
            String patternString3 = "<img src=\"/dlb/images/stories/signs/";
            Pattern pattern3 = Pattern.compile(patternString3);
            Matcher matcher3 = pattern3.matcher(filteredStr);
            
            while(matcher3.find()){
                String filteredStr3 = filteredStr.substring(matcher3.end()).trim();
                String data = filteredStr3.split(".jpg")[0];
                //System.out.println(map.get(data));
                dataList.add(map.get(data));
            }
            

        }
        return dataList;
    }
        
    public static List<String> getDLBResults(String lotteryCode,String date) throws UnsupportedEncodingException, IOException{ //  16/11/17
        map.put("1","Makara");
        map.put("2","Kumba");
        map.put("3","meena");
        map.put("4","mesha");
        map.put("5","wrushabha");
        map.put("6","mithuna");
        map.put("7","kataka");
        map.put("8","sinha");
        map.put("9","kanya");
        map.put("10","thula");
        map.put("11","dhanu");
        map.put("12","Thula");
        
        
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://dlb.today/dlb/index.php?option=com_jumi&amp;fileid=31&amp;Itemid=31");

        // Request parameters and other properties.
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>(2);

        params.add(new BasicNameValuePair("db", lotteryCode));
        params.add(new BasicNameValuePair("dn", ""));
        params.add(new BasicNameValuePair("ename", date));

        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        //Execute and get the response.
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream instream = entity.getContent();
            try {
                String content = convertStreamToString(instream); 
                //System.out.println(content);
                List<String> dataList =getData(content); 
                
               // for (String data : dataList) {
                 //   System.out.println(data);
               // }
                return dataList;
            } finally {
                instream.close();
            }
        }
        return null;
    }
}
