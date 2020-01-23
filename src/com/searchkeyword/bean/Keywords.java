/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.searchkeyword.bean;

/**
 *
 * @author Euphern_Java
 */
public class Keywords {

    private int keywordid;

    private String keyword=null;

    private int rank;

    private int localrank;

    private int internalRank;
    /**
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * @return the keywordid
     */
    public int getKeywordid() {
        return keywordid;
    }

    /**
     * @param keywordid the keywordid to set
     */
    public void setKeywordid(int keywordid) {
        this.keywordid = keywordid;
    }

    public int getLocalrank() {
        return localrank;
    }

    public void setLocalrank(int localrank) {
        this.localrank = localrank;
    }

    public int getInternalRank() {
        return internalRank;
    }

    public void setInternalRank(int internalRank) {
        this.internalRank = internalRank;
    }

    

}
