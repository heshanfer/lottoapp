/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Heshan
 */
public class LotteryResult {
    private int historyId;
    private int lotteryId;
    private int drawNo;
    private String date;
    private int no1;
    private int no2;
    private int no3;
    private int no4;
    private int no5;
    private int no6;
    private int bonusNo;
    private String bonusLetter;
    private String bonusFactor1;
    private String bonusFactor2;

    public LotteryResult(int historyId, int lotteryId, int drawNo, String date, int no1, int no2, int no3, int no4, int no5, int no6, int bonusNo, String bonusLetter, String bonusFactor1, String bonusFactor2) {
        this.historyId = historyId;
        this.lotteryId = lotteryId;
        this.drawNo = drawNo;
        this.date = date;
        this.no1 = no1;
        this.no2 = no2;
        this.no3 = no3;
        this.no4 = no4;
        this.no5 = no5;
        this.no6 = no6;
        this.bonusNo = bonusNo;
        this.bonusLetter = bonusLetter;
        this.bonusFactor1 = bonusFactor1;
        this.bonusFactor2 = bonusFactor2;
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
     * @return the no1
     */
    public int getNo1() {
        return no1;
    }

    /**
     * @param no1 the no1 to set
     */
    public void setNo1(int no1) {
        this.no1 = no1;
    }

    /**
     * @return the no2
     */
    public int getNo2() {
        return no2;
    }

    /**
     * @param no2 the no2 to set
     */
    public void setNo2(int no2) {
        this.no2 = no2;
    }

    /**
     * @return the no3
     */
    public int getNo3() {
        return no3;
    }

    /**
     * @param no3 the no3 to set
     */
    public void setNo3(int no3) {
        this.no3 = no3;
    }

    /**
     * @return the no4
     */
    public int getNo4() {
        return no4;
    }

    /**
     * @param no4 the no4 to set
     */
    public void setNo4(int no4) {
        this.no4 = no4;
    }

    /**
     * @return the no5
     */
    public int getNo5() {
        return no5;
    }

    /**
     * @param no5 the no5 to set
     */
    public void setNo5(int no5) {
        this.no5 = no5;
    }

    /**
     * @return the no6
     */
    public int getNo6() {
        return no6;
    }

    /**
     * @param no6 the no6 to set
     */
    public void setNo6(int no6) {
        this.no6 = no6;
    }

    /**
     * @return the bonusNo
     */
    public int getBonusNo() {
        return bonusNo;
    }

    /**
     * @param bonusNo the bonusNo to set
     */
    public void setBonusNo(int bonusNo) {
        this.bonusNo = bonusNo;
    }

    /**
     * @return the bonusLetter
     */
    public String getBonusLetter() {
        return bonusLetter;
    }

    /**
     * @param bonusLetter the bonusLetter to set
     */
    public void setBonusLetter(String bonusLetter) {
        this.bonusLetter = bonusLetter;
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
    
    
}
