/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingproject;

//Example to obtain the time from and RFC868 internet server

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



class test{
    
    
    public static Date getDate() throws IOException, ParseException {
         Date remoteDate = null; 
        URL url = new URL("http://sv2.ideamarthosting.dialog.lk:9027/LottoApp/index.html");
        URLConnection urlConn = url.openConnection();
        HttpURLConnection conn = (HttpURLConnection) urlConn;
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(10000);
        conn.setInstanceFollowRedirects( true );
        conn.setRequestProperty( "User-agent", "spider" );
        conn.connect();
        Map<String,List<String>> header = conn.getHeaderFields();
        for (String key : header.keySet()) {
            if (key != null && "Date".equals(key)) {
                List<String> data = header.get(key);
                String dateString = data.get(0);
                SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
                remoteDate = sdf.parse(dateString);

                System.out.println(remoteDate);
                return remoteDate;
           }
        } 
        return null;
    }
    
    public static void main(String[] args) {
        
    }
}