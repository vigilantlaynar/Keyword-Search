/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.searchkeyword.bean;

import java.util.List;
import com.searchkeyword.frame.RankTracker;

/**
 *
 * @author Euphern_Java
 */
public class RankTrackerBean {

    private String websiteurl=null;

    private List keywordList;

    private List resultfoundList;

    private String timeelapsed=null;

    private RankTracker rankTracker;
    

    /**
     * @return the websiteurl
     */
    public String getWebsiteurl() {
        return websiteurl;
    }

    /**
     * @param websiteurl the websiteurl to set
     */
    public void setWebsiteurl(String websiteurl) {
        this.websiteurl = websiteurl;
    }

    /**
     * @return the keywordList
     */
    public List getKeywordList() {
        return keywordList;
    }

    /**
     * @param keywordList the keywordList to set
     */
    public void setKeywordList(List keywordList) {
        this.keywordList = keywordList;
    }

    /**
     * @return the resultfoundList
     */
    public List getResultfoundList() {
        return resultfoundList;
    }

    /**
     * @param resultfoundList the resultfoundList to set
     */
    public void setResultfoundList(List resultfoundList) {
        this.resultfoundList = resultfoundList;
    }

    /**
     * @return the timeelapsed
     */
    public String getTimeelapsed() {
        return timeelapsed;
    }

    /**
     * @param timeelapsed the timeelapsed to set
     */
    public void setTimeelapsed(String timeelapsed) {
        this.timeelapsed = timeelapsed;
    }

    /**
     * @return the rankTracker
     */
    public RankTracker getRankTracker() {
        return rankTracker;
    }

    /**
     * @param rankTracker the rankTracker to set
     */
    public void setRankTracker(RankTracker rankTracker) {
        this.rankTracker = rankTracker;
    }

    
}
