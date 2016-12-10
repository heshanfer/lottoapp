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
    private boolean hasBonusFactor1;
    private boolean hasBonusFactor2;
    private boolean hasBonusFactor3;
    private String authCode;
    private String url;

    public Lottery(int lotteryId, String name, String authority, int validNos, boolean hasBonusFactor1, boolean hasBonusFactor2, boolean hasBonusFactor3, String authCode, String url) {
        this.lotteryId = lotteryId;
        this.name = name;
        this.authority = authority;
        this.validNos = validNos;
        this.hasBonusFactor1 = hasBonusFactor1;
        this.hasBonusFactor2 = hasBonusFactor2;
        this.hasBonusFactor3 = hasBonusFactor3;
        this.authCode = authCode;
        this.url = url;
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
     * @return the hasBonusFactor1
     */
    public boolean hasBonusFactor1() {
        return hasBonusFactor1;
    }

    /**
     * @param hasBonusFactor1 the hasBonusFactor1 to set
     */
    public void setHasBonusFactor1(boolean hasBonusFactor1) {
        this.hasBonusFactor1 = hasBonusFactor1;
    }

    /**
     * @return the hasBonusFactor2
     */
    public boolean hasBonusFactor2() {
        return hasBonusFactor2;
    }

    /**
     * @param hasBonusFactor2 the hasBonusFactor2 to set
     */
    public void setHasBonusFactor2(boolean hasBonusFactor2) {
        this.hasBonusFactor2 = hasBonusFactor2;
    }

    /**
     * @return the hasBonusFactor3
     */
    public boolean hasBonusFactor3() {
        return hasBonusFactor3;
    }

    /**
     * @param hasBonusFactor3 the hasBonusFactor3 to set
     */
    public void setHasBonusFactor3(boolean hasBonusFactor3) {
        this.hasBonusFactor3 = hasBonusFactor3;
    }

    /**
     * @return the authCode
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * @param authCode the authCode to set
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
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
