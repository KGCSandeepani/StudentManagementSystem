/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model;

/**
 *
 * @author Chamodi Sandeepani
 */
public class Attendance {
    private String SEID;
    private String AID;
    private String Date;

    public Attendance() {
    }

    public Attendance(String SEID, String AID, String Date) {
        this.SEID = SEID;
        this.AID = AID;
        this.Date = Date;
    }

    public String getSEID() {
        return SEID;
    }

    public void setSEID(String SEID) {
        this.SEID = SEID;
    }
    
    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }
    
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
}
