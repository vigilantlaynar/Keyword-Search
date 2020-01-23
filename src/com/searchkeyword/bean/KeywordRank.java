/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.searchkeyword.bean;

/**
 *
 * @author mayukh
 */
public class KeywordRank {
    private String keyword=null;

    private int inTop10;

    private int inTop20;

    private int inTop30;

    private int inTop100;

    public int getInTop10() {
        return inTop10;
    }

    public void setInTop10(int inTop10) {
        this.inTop10 = inTop10;
    }

    public int getInTop100() {
        return inTop100;
    }

    public void setInTop100(int inTop100) {
        this.inTop100 = inTop100;
    }

    public int getInTop20() {
        return inTop20;
    }

    public void setInTop20(int inTop20) {
        this.inTop20 = inTop20;
    }

    public int getInTop30() {
        return inTop30;
    }

    public void setInTop30(int inTop30) {
        this.inTop30 = inTop30;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}
