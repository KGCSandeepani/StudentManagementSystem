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
public class Session {
    private String SID;
    private String CID;
    private String SEID;
    

    public Session() {
    }

    public Session(String SID, String CID, String SEID) {
        this.SID = SID;
        this.CID = CID;
        this.SEID = SEID;       
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }
    
    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }
    
    public String getSEID() {
        return SEID;
    }

    public void setSEID(String SEID) {
        this.SEID = SEID;
    }
    
    
}
