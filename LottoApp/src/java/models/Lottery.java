/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Heshan
 */
public class Lottery {
    private int lotteryId;
    private String name;
    private String authority;
    private int validNos;
    private boolean hasBonusNo;
    private boolean hasBonusChar;
    private boolean hasBonusSymbol;
    private boolean hasBonusFactor;
    private int authNo1;
    private String url;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * @param authority the authority to set
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * @return the validNos
     */
    public int getValidNos() {
        return validNos;
    }

    /**
     * @param validNos the validNos to set
     */
    public void setValidNos(int validNos) {
        this.validNos = validNos;
    }

    /**
     * @return the hasBonusNo
     */
    public boolean isHasBonusNo() {
        return hasBonusNo;
    }

    /**
     * @param hasBonusNo the hasBonusNo to set
     */
    public void setHasBonusNo(boolean hasBonusNo) {
        this.hasBonusNo = hasBonusNo;
    }

    /**
     * @return the hasBonusChar
     */
    public boolean isHasBonusChar() {
        return hasBonusChar;
    }

    /**
     * @param hasBonusChar the hasBonusChar to set
     */
    public void setHasBonusChar(boolean hasBonusChar) {
        this.hasBonusChar = hasBonusChar;
    }

    /**
     * @return the hasBonusSymbol
     */
    public boolean isHasBonusSymbol() {
        return hasBonusSymbol;
    }

    /**
     * @param hasBonusSymbol the hasBonusSymbol to set
     */
    public void setHasBonusSymbol(boolean hasBonusSymbol) {
        this.hasBonusSymbol = hasBonusSymbol;
    }

    /**
     * @return the hasBonusFactor
     */
    public boolean isHasBonusFactor() {
        return hasBonusFactor;
    }

    /**
     * @param hasBonusFactor the hasBonusFactor to set
     */
    public void setHasBonusFactor(boolean hasBonusFactor) {
        this.hasBonusFactor = hasBonusFactor;
    }

    /**
     * @return the authNo1
     */
    public int getAuthNo1() {
        return authNo1;
    }

    /**
     * @param authNo1 the authNo1 to set
     */
    public void setAuthNo1(int authNo1) {
        this.authNo1 = authNo1;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
