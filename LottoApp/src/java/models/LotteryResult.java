/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Heshan
 */
public class LotteryResult {
    private int historyId;
    private int lotteryId;
    private int drawNo;
    private String date;
    private String No1;
    private String No2;
    private String No3;
    private String No4;
    private String No5;
    private String No6;
    private String bonusFactor1;
    private String bonusFactor2;
    private String bonusFactor3;

    public LotteryResult() {
    }

    public LotteryResult(int lotteryId, int drawNo, String date, String No1, String No2, String No3, String No4, String No5, String No6, String bonusFactor1, String bonusFactor2, String bonusFactor3) {
        this.lotteryId = lotteryId;
        this.drawNo = drawNo;
        this.date = date;
        this.No1 = No1;
        this.No2 = No2;
        this.No3 = No3;
        this.No4 = No4;
        this.No5 = No5;
        this.No6 = No6;
        this.bonusFactor1 = bonusFactor1;
        this.bonusFactor2 = bonusFactor2;
        this.bonusFactor3 = bonusFactor3;
    }

    public LotteryResult(int historyId, int lotteryId, int drawNo, String date, String No1, String No2, String No3, String No4, String No5, String No6, String bonusFactor1, String bonusFactor2, String bonusFactor3) {
        this.historyId = historyId;
        this.lotteryId = lotteryId;
        this.drawNo = drawNo;
        this.date = date;
        this.No1 = No1;
        this.No2 = No2;
        this.No3 = No3;
        this.No4 = No4;
        this.No5 = No5;
        this.No6 = No6;
        this.bonusFactor1 = bonusFactor1;
        this.bonusFactor2 = bonusFactor2;
        this.bonusFactor3 = bonusFactor3;
    }

    
    
    /**
     * @return the historyId
     */
    public int getHistoryId() {
        return historyId;
    }

    /**
     * @param historyId the historyId to set
     */
    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    /**
     * @return the lotteryId
     */
    public int getLotteryId() {
        return lotteryId;
    }

    /**
     * @param lotteryId the lotteryId to set
     */
    public void setLotteryId(int lotteryId) {
        this.lotteryId = lotteryId;
    }

    /**
     * @return the drawNo
     */
    public int getDrawNo() {
        return drawNo;
    }

    /**
     * @param drawNo the drawNo to set
     */
    public void setDrawNo(int drawNo) {
        this.drawNo = drawNo;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the No1
     */
    public String getNo1() {
        return No1;
    }

    /**
     * @param No1 the No1 to set
     */
    public void setNo1(String No1) {
        this.No1 = No1;
    }

    /**
     * @return the No2
     */
    public String getNo2() {
        return No2;
    }

    /**
     * @param No2 the No2 to set
     */
    public void setNo2(String No2) {
        this.No2 = No2;
    }

    /**
     * @return the No3
     */
    public String getNo3() {
        return No3;
    }

    /**
     * @param No3 the No3 to set
     */
    public void setNo3(String No3) {
        this.No3 = No3;
    }

    /**
     * @return the No4
     */
    public String getNo4() {
        return No4;
    }

    /**
     * @param No4 the No4 to set
     */
    public void setNo4(String No4) {
        this.No4 = No4;
    }

    /**
     * @return the No5
     */
    public String getNo5() {
        return No5;
    }

    /**
     * @param No5 the No5 to set
     */
    public void setNo5(String No5) {
        this.No5 = No5;
    }

    /**
     * @return the No6
     */
    public String getNo6() {
        return No6;
    }

    /**
     * @param No6 the No6 to set
     */
    public void setNo6(String No6) {
        this.No6 = No6;
    }

    /**
     * @return the bonusFactor1
     */
    public String getBonusFactor1() {
        return bonusFactor1;
    }

    /**
     * @param bonusFactor1 the bonusFactor1 to set
     */
    public void setBonusFactor1(String bonusFactor1) {
        this.bonusFactor1 = bonusFactor1;
    }

    /**
     * @return the bonusFactor2
     */
    public String getBonusFactor2() {
        return bonusFactor2;
    }

    /**
     * @param bonusFactor2 the bonusFactor2 to set
     */
    public void setBonusFactor2(String bonusFactor2) {
        this.bonusFactor2 = bonusFactor2;
    }

    /**
     * @return the bonusFactor3
     */
    public String getBonusFactor3() {
        return bonusFactor3;
    }

    /**
     * @param bonusFactor3 the bonusFactor3 to set
     */
    public void setBonusFactor3(String bonusFactor3) {
        this.bonusFactor3 = bonusFactor3;
    }

    

    
}
