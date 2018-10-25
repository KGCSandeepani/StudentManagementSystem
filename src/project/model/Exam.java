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
public class Exam {
    private String EID;
    private String Exam_name;
    private String Date;
    private ArrayList<Result>resultList=new ArrayList<>();
    public Exam() {
    }

    public Exam(String EID, String Exam_name, String Date) {
        this.EID = EID;
        this.Exam_name = Exam_name;
        this.Date = Date;       
    }

    public String getEID() {
        return EID;
    }

    public void setEID(String EID) {
        this.EID = EID;
    }

    public String getExam_name() {
        return Exam_name;
    }

    public void setExam_name(String Exam_name) {
        this.Exam_name = Exam_name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
    public void setResultList(ArrayList<Result> resultList){
        this.resultList=resultList;
    }
    
    public ArrayList<Result> getResultList(){
        return resultList;
    }
}
