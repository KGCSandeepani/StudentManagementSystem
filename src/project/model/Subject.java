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
public class Subject {
    private String SUID;
    private String subjctName;

    public Subject() {
    }

    public Subject(String SUID, String subjctName) {
        this.SUID = SUID;
        this.subjctName = subjctName;
    }

    public String getSUID() {
        return SUID;
    }

    public void setSUID(String SUID) {
        this.SUID = SUID;
    }
    
    public String getSubjctName() {
        return subjctName;
    }

    public void setSubjctName(String subjctName) {
        this.subjctName = subjctName;
    }
    
}
