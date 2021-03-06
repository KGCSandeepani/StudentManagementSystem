/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.design;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import project.controller.ClassDetailController;
import project.controller.ExamController;
import project.controller.ResultController;
import project.controller.SessionController;
import project.controller.StudentController;
import project.model.ClassDetail;
import project.model.Exam;
import project.model.Result;
import project.model.Session;
import project.model.Student;

/**
 *
 * @author 
 */
public class ReportOfExam extends javax.swing.JPanel {

    /**
     * Creates new form ReportOfExam
     */
    public ReportOfExam() {
        initComponents();
        loadAllExamDetail();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneExam = new javax.swing.JScrollPane();
        tableExam = new javax.swing.JTable();
        labelExamDetail = new javax.swing.JLabel();
        scrollPaneExamResult = new javax.swing.JScrollPane();
        tableExamResult = new javax.swing.JTable();
        scrollPaneClassDetail = new javax.swing.JScrollPane();
        tableClassDetail = new javax.swing.JTable();
        labelExamResult = new javax.swing.JLabel();
        labelClassDetail = new javax.swing.JLabel();
        labelViewExamDetail = new javax.swing.JLabel();
        labelPrintExamDetail = new javax.swing.JLabel();
        labelPrintExamResult = new javax.swing.JLabel();
        labelPrintClassDetail = new javax.swing.JLabel();

        setOpaque(false);

        tableExam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam ID", "Exam Name", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableExam.setGridColor(new java.awt.Color(204, 204, 204));
        tableExam.setSelectionBackground(new java.awt.Color(0, 0, 102));
        tableExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableExamMouseClicked(evt);
            }
        });
        scrollPaneExam.setViewportView(tableExam);
        if (tableExam.getColumnModel().getColumnCount() > 0) {
            tableExam.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableExam.getColumnModel().getColumn(1).setPreferredWidth(120);
        }

        labelExamDetail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelExamDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelExamDetail.setText("Exam Detail");

        tableExamResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Marks", "State"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollPaneExamResult.setViewportView(tableExamResult);

        tableClassDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class ID", "Subject", "Teacher", "Grade", "Day", "Period"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollPaneClassDetail.setViewportView(tableClassDetail);
        if (tableClassDetail.getColumnModel().getColumnCount() > 0) {
            tableClassDetail.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableClassDetail.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableClassDetail.getColumnModel().getColumn(3).setPreferredWidth(40);
            tableClassDetail.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        labelExamResult.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelExamResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelExamResult.setText("Exam Result");

        labelClassDetail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelClassDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClassDetail.setText("Class Detail");

        labelViewExamDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Entypo_e75e(0)_64.png"))); // NOI18N
        labelViewExamDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelViewExamDetailMouseClicked(evt);
            }
        });

        labelPrintExamDetail.setBackground(new java.awt.Color(255, 0, 0));
        labelPrintExamDetail.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelPrintExamDetail.setForeground(new java.awt.Color(255, 255, 255));
        labelPrintExamDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrintExamDetail.setText("Print");
        labelPrintExamDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelPrintExamDetail.setOpaque(true);
        labelPrintExamDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPrintExamDetailMouseClicked(evt);
            }
        });

        labelPrintExamResult.setBackground(new java.awt.Color(255, 0, 0));
        labelPrintExamResult.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelPrintExamResult.setForeground(new java.awt.Color(255, 255, 255));
        labelPrintExamResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrintExamResult.setText("Print");
        labelPrintExamResult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelPrintExamResult.setOpaque(true);
        labelPrintExamResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPrintExamResultMouseClicked(evt);
            }
        });

        labelPrintClassDetail.setBackground(new java.awt.Color(255, 0, 0));
        labelPrintClassDetail.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelPrintClassDetail.setForeground(new java.awt.Color(255, 255, 255));
        labelPrintClassDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrintClassDetail.setText("Print");
        labelPrintClassDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelPrintClassDetail.setOpaque(true);
        labelPrintClassDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPrintClassDetailMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(labelExamDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(labelPrintExamDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPaneExamResult, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollPaneClassDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelClassDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(246, 246, 246))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPaneExam, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelViewExamDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelPrintExamResult, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelExamResult, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(226, 226, 226))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelPrintClassDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(235, 235, 235))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelExamDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneExam, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPrintExamDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelExamResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneExamResult, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelViewExamDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrintExamResult, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(labelClassDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneClassDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPrintClassDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labelViewExamDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelViewExamDetailMouseClicked
        try{
            searchExamDetail();
        } catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "Select row.");
        }
    }//GEN-LAST:event_labelViewExamDetailMouseClicked

    private void tableExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableExamMouseClicked
        DefaultTableModel defaultTableModelExamResult=(DefaultTableModel) tableExamResult.getModel();
        defaultTableModelExamResult.setRowCount(0);
        DefaultTableModel defaultTableModelClassDetail=(DefaultTableModel) tableClassDetail.getModel();
        defaultTableModelClassDetail.setRowCount(0);
    }//GEN-LAST:event_tableExamMouseClicked

    private void labelPrintExamDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPrintExamDetailMouseClicked
        printAllExamDetail();
    }//GEN-LAST:event_labelPrintExamDetailMouseClicked

    private void labelPrintExamResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPrintExamResultMouseClicked
        try{
            printStudentExamResult();
        } catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "Select Exam.");
        }
    }//GEN-LAST:event_labelPrintExamResultMouseClicked

    private void labelPrintClassDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPrintClassDetailMouseClicked
        try{
            printExamClassDetail();
        } catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "Select Exam.");
        }
    }//GEN-LAST:event_labelPrintClassDetailMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelClassDetail;
    private javax.swing.JLabel labelExamDetail;
    private javax.swing.JLabel labelExamResult;
    private javax.swing.JLabel labelPrintClassDetail;
    private javax.swing.JLabel labelPrintExamDetail;
    private javax.swing.JLabel labelPrintExamResult;
    private javax.swing.JLabel labelViewExamDetail;
    private javax.swing.JScrollPane scrollPaneClassDetail;
    private javax.swing.JScrollPane scrollPaneExam;
    private javax.swing.JScrollPane scrollPaneExamResult;
    private javax.swing.JTable tableClassDetail;
    private javax.swing.JTable tableExam;
    private javax.swing.JTable tableExamResult;
    // End of variables declaration//GEN-END:variables

    private void loadAllExamDetail() {
        ArrayList<Exam> allExams;
        DefaultTableModel defaultTableModel=(DefaultTableModel) tableExam.getModel();
        defaultTableModel.setRowCount(0);
        try {
            allExams=ExamController.viewExam();
            for (Exam exam : allExams) {
                Object[] rowData={exam.getEID(), exam.getExam_name(), exam.getDate()};
                defaultTableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchExamDetail() {
        int rowNumber=tableExam.getSelectedRow();
        DefaultTableModel defaultTableModel=(DefaultTableModel) tableExam.getModel();
        String examId=(String) defaultTableModel.getValueAt(rowNumber, 0);
        DefaultTableModel defaultTableModelExamResult=(DefaultTableModel) tableExamResult.getModel();
        defaultTableModelExamResult.setRowCount(0);
        DefaultTableModel defaultTableModelClassDetail=(DefaultTableModel) tableClassDetail.getModel();
        defaultTableModelClassDetail.setRowCount(0);
        try {
            ArrayList<Result> allResults=ResultController.searchResult(examId);
            for (Result result : allResults) {
                String sessionId=result.getSEID();
                searchStudent(sessionId, result.getMark(), result.getState());
                searchClassOfExam(sessionId);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchStudent(String sessionId, String mark, String state) {
        DefaultTableModel defaultTableModel=(DefaultTableModel) tableExamResult.getModel();
        try {
            Session session=SessionController.searchSessionFromSEID(sessionId);
            String studentId=session.getSID();
            Student student=StudentController.searchStudent(studentId);
            Object[] rowData={student.getSID(), student.getName(), mark, state};
            defaultTableModel.addRow(rowData);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchClassOfExam(String sessionId) {
        DefaultTableModel defaultTableModel=(DefaultTableModel) tableClassDetail.getModel();
        if (defaultTableModel.getRowCount()==0) {
            try {
                Session session=SessionController.searchSessionFromSEID(sessionId);
                String classId=session.getCID();
                ClassDetail classDetail=ClassDetailController.searchClassDetail(classId);
                Object[] rowData={classId, classDetail.getSuject(), classDetail.getTeacher(), classDetail.getGrade(), classDetail.getDay(), classDetail.getPeriod()};
                defaultTableModel.addRow(rowData);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Session session=SessionController.searchSessionFromSEID(sessionId);
                String classId=session.getCID();
                String[] classIdList=new String[defaultTableModel.getRowCount()];
                for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
                    classIdList[i]=(String) defaultTableModel.getValueAt(i, 0);
                }
                boolean notEquals=true;
                for (int i = 0; i < defaultTableModel.getRowCount(); i++) {                                       
                    if (classId.equals(classIdList[i])) {
                        notEquals=false;
                        break;
                    }
                }
                if (notEquals) {
                        ClassDetail classDetail=ClassDetailController.searchClassDetail(classId);
                        Object[] rowData={classId, classDetail.getSuject(), classDetail.getTeacher(), classDetail.getGrade(), classDetail.getDay(), classDetail.getPeriod()};
                        defaultTableModel.addRow(rowData);
                    }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    private void printAllExamDetail() {
        InputStream inputStream = getClass().getResourceAsStream("allExamDetail.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<String, Object>(), new JRTableModelDataSource(tableExam.getModel()));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            PrintDialog printDialog = new PrintDialog(new Report(), true);
            printDialog.setContentPane(jasperViewer.getContentPane());
            printDialog.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printStudentExamResult() {
        InputStream inputStream = getClass().getResourceAsStream("studentExamResult.jrxml");
        int rowNumber=tableExam.getSelectedRow();
        DefaultTableModel defaultTableModel=(DefaultTableModel) tableExam.getModel();
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String examName = (String) defaultTableModel.getValueAt(rowNumber, 1);
            String examDate = (String) defaultTableModel.getValueAt(rowNumber, 2);
            
            hashMap.put("examName", examName);
            hashMap.put("examDate", examDate);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hashMap, new JRTableModelDataSource(tableExamResult.getModel()));            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            PrintDialog printDialog = new PrintDialog(new Report(), true);
            printDialog.setContentPane(jasperViewer.getContentPane());
            printDialog.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printExamClassDetail() {
        InputStream inputStream = getClass().getResourceAsStream("examClassDetail.jrxml");
        int rowNumber=tableExam.getSelectedRow();
        DefaultTableModel defaultTableModel=(DefaultTableModel) tableExam.getModel();
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String examName = (String) defaultTableModel.getValueAt(rowNumber, 1);
            String examDate = (String) defaultTableModel.getValueAt(rowNumber, 2);
            
            hashMap.put("examName", examName);
            hashMap.put("examDate", examDate);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hashMap, new JRTableModelDataSource(tableClassDetail.getModel()));            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            PrintDialog printDialog = new PrintDialog(new Report(), true);
            printDialog.setContentPane(jasperViewer.getContentPane());
            printDialog.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReportOfExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
