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
public class Result {
    private String SEID;
    private String EID;
    private String REID;
    private String Mark;
    private String State;

    public Result() {
    }

    public Result(String SEID, String EID, String REID, String Mark, String State) {
        this.SEID = SEID;
        this.EID = EID;
        this.REID = REID;
        this.Mark = Mark;
        this.State = State;
    }

    public String getSEID() {
        return SEID;
    }

    public void setSEID(String SEID) {
        this.SEID = SEID;
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getREID() {
        return REID;
    }

    public void setREID(String REID) {
        this.REID = REID;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String Mark) {
        this.Mark = Mark;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }
    
}
