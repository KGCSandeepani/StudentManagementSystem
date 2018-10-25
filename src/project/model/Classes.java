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
public class Classes {
    private String SUID;
    private String TID;
    private String GID;
    private String CID;
    private String Day;
    private String Period;
    
    public Classes() {
    }

    public Classes(String SUID, String TID, String GID, String CID, String Day, String Period) {
        this.SUID = SUID;
        this.TID = TID;
        this.GID = GID;
        this.CID = CID;
        this.Day = Day;
        this.Period = Period;
    }

    

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getSUID() {
        return SUID;
    }

    public void setSUID(String SUID) {
        this.SUID = SUID;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }
    
    public String getDay() {
        return Day;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }
    
    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String Period) {
        this.Period = Period;
    }
    
}
