/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model;

import java.util.ArrayList;

/**
 *
 * @author Chamodi Sandeepani
 */
public class Student {
    private String SID;
    private String Name;
    private String Address;
    private int Tele_no;
    private String Register_date;
    private double Register_fee;
    private ArrayList<Session>sessionList=new ArrayList<>();
    public Student() {
    }

    public Student(String SID, String Name, String Address, int Tele_no, String Register_date, double Register_fee) {
        this.SID = SID;
        this.Name = Name;
        this.Address = Address;
        this.Tele_no = Tele_no;
        this.Register_date = Register_date;
        this.Register_fee = Register_fee;
    }

    public String getSID() {
        return SID;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public int getTele_no() {
        return Tele_no;
    }

    public String getRegister_date() {
        return Register_date;
    }

    public double getRegister_fee() {
        return Register_fee;
    }
    
    public void setSessionList(ArrayList<Session> sessionList){
        this.sessionList=sessionList;
    }
    
    public ArrayList<Session> getSessionList(){
        return sessionList;
    }
    
}
