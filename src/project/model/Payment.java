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
public class Payment {
    private String SEID;
    private String PID;
    private double Fee;
    private String Date;

    public Payment() {
    }

    public Payment(String SEID, String PID, double Fee, String Date) {
        this.SEID = SEID;
        this.PID = PID;
        this.Fee = Fee;
        this.Date = Date;
    }

    public String getSEID() {
        return SEID;
    }
    
    public void setSEID(String SEID) {
        this.SEID = SEID;
    }
    
    public String getPID() {
        return PID;
    }
    
    public void setPID(String PID) {
        this.PID = PID;
    }

    public double getFee() {
        return Fee;
    }

    public void setFee(double Fee) {
        this.Fee = Fee;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
}
