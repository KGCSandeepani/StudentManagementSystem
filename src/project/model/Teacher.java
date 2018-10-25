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
public class Teacher {
    private String TID;
    private String Name;
    private String Address;
    private String NIC;
    private int TeleNo;

    public Teacher() {
    }

    public Teacher(String TID, String Name, String Address, String NIC, int TeleNo) {
        this.TID = TID;
        this.Name = Name;
        this.Address = Address;
        this.NIC = NIC;
        this.TeleNo = TeleNo;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public int getTeleNo() {
        return TeleNo;
    }

    public void setTeleNo(int TeleNo) {
        this.TeleNo = TeleNo;
    }
    
}

