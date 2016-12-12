package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.LotteryController;
import controllers.LotteryResultController;
import database.Testing;
import static database.Testing.getDate;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Lottery;
import models.LotteryResult;

/**
 *
 * @author Heshan
 */
@WebServlet(urlPatterns = {"/RetrieveLotteryResults"})
public class RetrieveLotteryResults extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public static Date getDate() throws IOException, ParseException {
        Date remoteDate = null; 
        URL url = new URL("http://sv2.ideamarthosting.dialog.lk:9027/LottoApp/index.jsp");
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
    
    public static boolean AddTodayResults() throws SQLException, IOException, ClassNotFoundException, ParseException {
        boolean res = false;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Mon",1);
        map.put("Tue",2);
        map.put("Wed",3);
        map.put("Thu",4);
        map.put("Fri",5);
        map.put("Sat",6);
        map.put("Sun",7);
        
        Date today;
        today = getDate();
        SimpleDateFormat df = new SimpleDateFormat("E");
        String formattedDate = df.format(today);
        //System.out.println("Day : "+formattedDate);
        String dayNo = String.valueOf(map.get(formattedDate));
        //System.out.println("DayNo : "+dayNo);

        SimpleDateFormat df2 = new SimpleDateFormat("yy-MM-dd");
        String formattedDate2 = df2.format(today);
        //System.out.println("Day(yy-MM-dd) : "+formattedDate2);

        List<String[]> lotteryResults =LotteryResultController.getLotteries(dayNo);

        for (String[] lotteryResult : lotteryResults) {
          //  System.out.println("Auth code : "+lotteryResult[0]+" ");
          //  System.out.println("Lot ID    : "+lotteryResult[1]+" ");
          //  System.out.println("Authority : "+lotteryResult[2]+" ");
          //  System.out.println("Name      : "+lotteryResult[3]+" ");

            Lottery lottery = LotteryController.getLottery(lotteryResult[0]);

            int expectCount = lottery.getValidNos() + ((lottery.hasBonusFactor1()) ? 1 : 0) + ((lottery.hasBonusFactor2()) ? 1 : 0) + ((lottery.hasBonusFactor3()) ? 1 : 0) + 1;
           // System.out.println(expectCount);

            List<String> results;
            LotteryResult ls = new LotteryResult(); 

            if(lotteryResult[2].equals("NLB")){
                results = NLBResults.getNLBResults(lotteryResult[0], formattedDate2);                    

                if(results != null){
                    int len = results.size();
                    if(len == expectCount){
                       // System.out.println("Passed");

                        ls.setLotteryId(Integer.valueOf(lotteryResult[1]));

                        ls.setDrawNo(Integer.valueOf(results.get(0)));                            

                        ls.setDate(formattedDate2);                         

                        // results
                        List<String> resultNos = results.subList(len-lottery.getValidNos(), len);
                        ls.setNo1(resultNos.get(0));
                        ls.setNo2((resultNos.size()>1)?resultNos.get(1):null);
                        ls.setNo3((resultNos.size()>2)?resultNos.get(2):null);
                        ls.setNo4((resultNos.size()>3)?resultNos.get(3):null);
                        ls.setNo5((resultNos.size()>4)?resultNos.get(4):null);
                        ls.setNo6((resultNos.size()>5)?resultNos.get(5):null);


                        // bonus
                        List<String> bonusList =  results.subList(1, len - lottery.getValidNos());
                        ls.setBonusFactor1((bonusList.size()>0)?bonusList.get(0):null);
                        ls.setBonusFactor2((bonusList.size()>1)?bonusList.get(1):null);
                        ls.setBonusFactor3((bonusList.size()>2)?bonusList.get(2):null);


                    }
                }
            }else{
                results =DLBResults.getDLBResults(lotteryResult[0], formattedDate2);

                 if(results != null){
                    int len = results.size();
                    if(lotteryResult[0].equals("sb")){
                        results.remove(len-2);
                        len = results.size();
                    }
                    if(len == expectCount){
                       // System.out.println("Passed");

                        ls.setLotteryId(Integer.valueOf(lotteryResult[1]));

                        ls.setDrawNo(Integer.valueOf(results.get(0))); 

                        ls.setDate(formattedDate2);

                        // Results
                        List<String> resultNos = results.subList(1, lottery.getValidNos()+1);
                        ls.setNo1(resultNos.get(0));
                        ls.setNo2((resultNos.size()>1)?resultNos.get(1):null);
                        ls.setNo3((resultNos.size()>2)?resultNos.get(2):null);
                        ls.setNo4((resultNos.size()>3)?resultNos.get(3):null);
                        ls.setNo5((resultNos.size()>4)?resultNos.get(4):null);
                        ls.setNo6((resultNos.size()>5)?resultNos.get(5):null);


                        // Bonus 
                        List<String> bonusList =  results.subList(lottery.getValidNos()+1,len);
                        ls.setBonusFactor1((bonusList.size()>0)?bonusList.get(0):null);
                        ls.setBonusFactor2((bonusList.size()>1)?bonusList.get(1):null);
                        ls.setBonusFactor3((bonusList.size()>2)?bonusList.get(2):null);

                    }

                 }

            }

//                System.out.println(ls.getLotteryId());
//                System.out.println(ls.getDate());
//                System.out.println(ls.getDrawNo());
//                System.out.println(ls.getNo1());
//                System.out.println(ls.getNo2());
//                System.out.println(ls.getNo3());
//                System.out.println(ls.getNo4());
//                System.out.println(ls.getNo5());
//                System.out.println(ls.getNo6());
//                System.out.println(ls.getBonusFactor1());
//                System.out.println(ls.getBonusFactor2());
//                System.out.println(ls.getBonusFactor3());
//                
//                System.out.println();

            res = LotteryResultController.addLotteryResult(ls);
            if(res){
                System.out.println("Done");
                
            }
        }
        
        return res;
       
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       
        try (PrintWriter out = response.getWriter()) {
           
            try {
                if(AddTodayResults())
                    out.print("Updated");
                else
                    out.print("Not Updated");
            } catch (SQLException ex) {
                Logger.getLogger(RetrieveLotteryResults.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RetrieveLotteryResults.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(RetrieveLotteryResults.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
