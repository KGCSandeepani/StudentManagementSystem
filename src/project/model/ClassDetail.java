/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model;

/**
 *
 * @author 
 */
public class ClassDetail {
    private String suject;
    private String teacher;
    private String grade;
    private String CID;
    private String Day;
    private String Period;

    public ClassDetail() {
    }

    public ClassDetail(String suject, String teacher, String grade, String CID, String Day, String Period) {
        this.suject = suject;
        this.teacher = teacher;
        this.grade = grade;
        this.CID = CID;
        this.Day = Day;
        this.Period = Period;
    }

    public String getCID() {
        return CID;
    }

    public String getDay() {
        return Day;
    }

    public String getGrade() {
        return grade;
    }

    public String getPeriod() {
        return Period;
    }

    public String getSuject() {
        return suject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public void setDay(String Day) {
        this.Day = Day;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setPeriod(String Period) {
        this.Period = Period;
    }

    public void setSuject(String suject) {
        this.suject = suject;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    
}
