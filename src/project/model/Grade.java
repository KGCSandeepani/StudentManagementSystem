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
public class Grade {
    private String GID;
    private int grade;

    public Grade() {
    }

    public Grade(String GID, int grade) {
        this.GID = GID;
        this.grade = grade;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
}
