/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.searchkeyword.bean;

/**
 *
 * @author mayukh
 */
public class CompanyProfileBean {
    private String name;
    private String email;
    private String website;
    private String address;
    private String logo;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
