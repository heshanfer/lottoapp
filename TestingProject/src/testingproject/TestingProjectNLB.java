/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingproject;

/**
 *
 * @author Heshan
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestingProjectNLB {
    public static List<String> getNLBResults(String lotteryId,String date) throws IOException{
        boolean st = false;
        List<String> results = new ArrayList<String>();
        
        URL oracle = new URL("http://www.nlb.lk/show-results.php?lott="+lotteryId+"&date="+date); // 16-11-21
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));

        String inputLine;
        String patternString = "<table border=\"0\" cellpadding=\"4\" cellspacing=\"4\" class=\"lottery-numbers\">";
        while ((inputLine = in.readLine()) != null){
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(inputLine);
            if(matcher.find()){
                
                while((inputLine = in.readLine()) != null){
                    String patternString2 ="</table>";
                    Pattern pattern2 = Pattern.compile(patternString2);
                    Matcher matcher2 = pattern2.matcher(inputLine);
                    if(matcher2.find()){
                        break;
                    }
                    
                    String patternString3 ="</td>";
                    Pattern pattern3 = Pattern.compile(patternString3);
                    Matcher matcher3 = pattern3.matcher(inputLine);
                    if(matcher3.find()){
                        //String data = inputLine.replaceAll("\\s","");
                        String data =inputLine.trim();
                        String no = data.split("<")[0];
                        //System.out.println(no);
                        results.add(no);
                        //break;
                        st = true;
                    }
                }
                if(st){
                    return results;
                }
            }
        }
        in.close();
        return null;
    }
    
    public static void main(String[] args)  {

//        URL oracle = new URL("http://www.nlb.lk/show-results.php?lott=49&date=16-11-21");
//        BufferedReader in = new BufferedReader(
//        new InputStreamReader(oracle.openStream()));
//
//        String inputLine;
//        String patternString = "<table border=\"0\" cellpadding=\"4\" cellspacing=\"4\" class=\"lottery-numbers\">";
//        while ((inputLine = in.readLine()) != null){
//            Pattern pattern = Pattern.compile(patternString);
//            Matcher matcher = pattern.matcher(inputLine);
//            if(matcher.find()){
//                
//                while((inputLine = in.readLine()) != null){
//                    String patternString2 ="</table>";
//                    Pattern pattern2 = Pattern.compile(patternString2);
//                    Matcher matcher2 = pattern2.matcher(inputLine);
//                    if(matcher2.find()){
//                        break;
//                    }
//                    
//                    String patternString3 ="</td>";
//                    Pattern pattern3 = Pattern.compile(patternString3);
//                    Matcher matcher3 = pattern3.matcher(inputLine);
//                    if(matcher3.find()){
//                        String data = inputLine.replaceAll("\\s","");
//                        String no = data.split("<")[0];
//                        System.out.println(no);
//                        //break;
//                    }
//                }
//                
//            }
//        }
//        in.close();
        
        List<String> results;
        try {
            results = getNLBResults("42", "16-12-09");
            
            for(String res : results){
                System.out.println(res);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestingProjectNLB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
