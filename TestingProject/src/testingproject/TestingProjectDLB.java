/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;





public class TestingProjectDLB {

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
    
    static List<String> getData(String pageContent){
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
            

        }
        return dataList;
    }
        
    static List<String> getDLBResults(String lotteryCode,String date) throws UnsupportedEncodingException, IOException{ //  16/11/17
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

    public static void main(String[] args) {
        try {
           // List<String> dataList =getDLBResults("j","16/11/17");     // jayoda
           // List<String> dataList =getDLBResults("sf","16/11/19");       // shanida
           // List<String> dataList =getDLBResults("jj","16/11/16");           // Galaxy Star
          //  List<String> dataList =getDLBResults("nj","16/11/18");               // Niyath Jaya
         //   List<String> dataList =getDLBResults("df","16/11/18");             // Lagna Vasana ? lagne enne naa
          //  List<String> dataList =getDLBResults("sb","16/11/17");               // super ball
          //  List<String> dataList =getDLBResults("l","16/11/14");               // sanwardana lakshapathi
            List<String> dataList =getDLBResults("ks","16/11/18");             // Kotipathi Shanida

            for (String data : dataList) {
                System.out.println(data);
            }} catch (IOException ex) {
            Logger.getLogger(TestingProjectDLB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}