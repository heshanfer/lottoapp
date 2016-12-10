/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static testingproject.TestingProjectNLB.getNLBResults;

/**
 *
 * @author Heshan
 */
public class NLBResluts {
    
    
     public static List<String> getNLBResults(String lotteryId,String date) throws IOException{

        List<String> results = new ArrayList<String>();
        
        URL oracle = new URL("http://www.nlb.lk/show-results.php?lott="+lotteryId+"&date="+date); // 16-11-21
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        String patternString1 = "<strong class=\"title\"><span class=\"title2\">";
        while ((inputLine = in.readLine()) != null){
            Pattern pattern1 = Pattern.compile(patternString1);
            Matcher matcher1 = pattern1.matcher(inputLine);
            if(matcher1.find()){
                // get draw no
                while((inputLine = in.readLine()) != null){
                    // draw no
                    String patternString3 = "Results for draw no";
                    Pattern pattern3 = Pattern.compile(patternString3);
                    Matcher matcher3 = pattern3.matcher(inputLine);
                    if(matcher3.find()){
                        String line = inputLine.trim();
                        String filteredStr = inputLine.substring(matcher3.end()).trim();
                        String drawNo = filteredStr.split("</span>")[0];
                        System.out.println(drawNo);
                    }
                    
                    // results
                    String patternString4 = "<td width=\"150\" height=\"25\" align=\"center\" class=\"bodyText\">Winning Numbers</td>";
                    Pattern pattern4 = Pattern.compile(patternString4);
                    Matcher matcher4 = pattern4.matcher(inputLine);
                    if(matcher4.find()){ 
                        while((inputLine = in.readLine()) != null){
                            String patternString2 ="</table>";
                            Pattern pattern2 = Pattern.compile(patternString2);
                            Matcher matcher2 = pattern2.matcher(inputLine);
                            if(matcher2.find()){
                                break;
                            }
                            
                            String patternString5 ="</td>";
                            Pattern pattern5 = Pattern.compile(patternString5);
                            Matcher matcher5 = pattern5.matcher(inputLine);
                            if(matcher5.find()){
                                //String data = inputLine.replaceAll("\\s","");
                                String data =inputLine.trim();
                                String no = data.split("<")[0];
                                System.out.println(no);
                                //results.add(no);
                            }
                        }
                    }
               }     
            }
        }
        in.close();
        return null;
    }
     
     public static void main(String[] args) {
          List<String> results;
        try {
            results = getNLBResults("42", "16-12-09");
            
//            for(String res : results){
 //               System.out.println(res);
 //           }
        } catch (IOException ex) {
            Logger.getLogger(NLBResluts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
