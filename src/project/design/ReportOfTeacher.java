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
import project.controller.ClassController;
import project.controller.ClassDetailController;
import project.controller.TeacherController;
import project.model.ClassDetail;
import project.model.Classes;
import project.model.Teacher;

/**
 *
 * @author 
 */
public class ReportOfTeacher extends javax.swing.JPanel {

    /**
     * Creates new form ReportOfTeacher
     */
    public ReportOfTeacher() {
        initComponents();
        loadAllTeachersDetail();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneTeacherDetail = new javax.swing.JScrollPane();
        tableTeacherDetail = new javax.swing.JTable();
        scrollPaneClassDetail = new javax.swing.JScrollPane();
        tableClassDetail = new javax.swing.JTable();
        labelViewClassDetail = new javax.swing.JLabel();
        labelAllTeachersDetail = new javax.swing.JLabel();
        labelAllClassDetail = new javax.swing.JLabel();
        labelPrintAllTeachersDetail = new javax.swing.JLabel();
        labelPrintClassDetail = new javax.swing.JLabel();

        setOpaque(false);

        tableTeacherDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher ID", "Name", "Address", "NIC", "Tele. No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableTeacherDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTeacherDetailMouseClicked(evt);
            }
        });
        scrollPaneTeacherDetail.setViewportView(tableTeacherDetail);
        if (tableTeacherDetail.getColumnModel().getColumnCount() > 0) {
            tableTeacherDetail.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableTeacherDetail.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

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
            tableClassDetail.getColumnModel().getColumn(2).setPreferredWidth(150);
            tableClassDetail.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableClassDetail.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        labelViewClassDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Entypo_e75c(1)_64.png"))); // NOI18N
        labelViewClassDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelViewClassDetailMouseClicked(evt);
            }
        });

        labelAllTeachersDetail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelAllTeachersDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAllTeachersDetail.setText("All Teacher's Detail");

        labelAllClassDetail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelAllClassDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAllClassDetail.setText("All Class Detail");

        labelPrintAllTeachersDetail.setBackground(new java.awt.Color(255, 0, 0));
        labelPrintAllTeachersDetail.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelPrintAllTeachersDetail.setForeground(new java.awt.Color(255, 255, 255));
        labelPrintAllTeachersDetail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrintAllTeachersDetail.setText("Print");
        labelPrintAllTeachersDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelPrintAllTeachersDetail.setOpaque(true);
        labelPrintAllTeachersDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPrintAllTeachersDetailMouseClicked(evt);
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
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPaneTeacherDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollPaneClassDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(494, 494, 494)
                        .addComponent(labelViewClassDetail)
                        .addGap(241, 241, 241)
                        .addComponent(labelPrintAllTeachersDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(438, 438, 438)
                        .addComponent(labelAllClassDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(433, 433, 433)
                        .addComponent(labelAllTeachersDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelPrintClassDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAllTeachersDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneTeacherDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelViewClassDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPrintAllTeachersDetail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(labelAllClassDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneClassDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPrintClassDetail)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void labelViewClassDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelViewClassDetailMouseClicked
        try{
            searchAllClass();
        } catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "Select row.");
        }
    }//GEN-LAST:event_labelViewClassDetailMouseClicked

    private void tableTeacherDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTeacherDetailMouseClicked
        DefaultTableModel defaultTableModel=(DefaultTableModel) tableClassDetail.getModel();
        defaultTableModel.setRowCount(0);
    }//GEN-LAST:event_tableTeacherDetailMouseClicked

    private void labelPrintAllTeachersDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPrintAllTeachersDetailMouseClicked
        printAllTeachersDetail();
    }//GEN-LAST:event_labelPrintAllTeachersDetailMouseClicked

    private void labelPrintClassDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPrintClassDetailMouseClicked
        try{
            printClassDetail();
        } catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "Select Teacher!");
        }
    }//GEN-LAST:event_labelPrintClassDetailMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelAllClassDetail;
    private javax.swing.JLabel labelAllTeachersDetail;
    private javax.swing.JLabel labelPrintAllTeachersDetail;
    private javax.swing.JLabel labelPrintClassDetail;
    private javax.swing.JLabel labelViewClassDetail;
    private javax.swing.JScrollPane scrollPaneClassDetail;
    private javax.swing.JScrollPane scrollPaneTeacherDetail;
    private javax.swing.JTable tableClassDetail;
    private javax.swing.JTable tableTeacherDetail;
    // End of variables declaration//GEN-END:variables

    private void loadAllTeachersDetail() {
        ArrayList<Teacher> allTeachersList;
        DefaultTableModel defaultTableModel=(DefaultTableModel) tableTeacherDetail.getModel();
        defaultTableModel.setRowCount(0);
        try {
            allTeachersList=TeacherController.viewTeacher();
            for (Teacher teacher : allTeachersList) {
                Object[] rowData={teacher.getTID(), teacher.getName(), teacher.getAddress(), teacher.getNIC(), teacher.getTeleNo()};
                defaultTableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportOfTeacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportOfTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void searchAllClass() {
        int rowNumber=tableTeacherDetail.getSelectedRow();
        DefaultTableModel defaultTableModelTeacherDetail=(DefaultTableModel) tableTeacherDetail.getModel();
        String teacherId=(String) defaultTableModelTeacherDetail.getValueAt(rowNumber, 0);
        DefaultTableModel defaultTableModelClassDetail=(DefaultTableModel) tableClassDetail.getModel();
        defaultTableModelClassDetail.setRowCount(0);
        ArrayList<Classes> allClassesList;
        try {
            allClassesList=ClassController.searchClassByTID(teacherId);
            for (Classes classes : allClassesList) {
                String classId=classes.getCID();
                viewClassDetail(classId);               
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportOfTeacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportOfTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void viewClassDetail(String classId) {
        try {
            ClassDetail classDetail=ClassDetailController.searchClassDetail(classId);            
            DefaultTableModel defaultTableModel=(DefaultTableModel) tableClassDetail.getModel();
            Object[] rowData={classId, classDetail.getSuject(), classDetail.getTeacher(), classDetail.getGrade(), classDetail.getDay(), classDetail.getPeriod()};
            defaultTableModel.addRow(rowData);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportOfTeacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReportOfTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printAllTeachersDetail() {
        InputStream inputStream = getClass().getResourceAsStream("allTeachersDetail.jrxml");
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<String, Object>(), new JRTableModelDataSource(tableTeacherDetail.getModel()));
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            PrintDialog printDialog = new PrintDialog(new Report(), true);
            printDialog.setContentPane(jasperViewer.getContentPane());
            printDialog.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReportOfTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void printClassDetail() {
        InputStream inputStream = getClass().getResourceAsStream("classDetailOfTeacher.jrxml");
        int rowNumber=tableTeacherDetail.getSelectedRow();
        DefaultTableModel defaultTableModel=(DefaultTableModel) tableTeacherDetail.getModel();
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String teacherId = (String) defaultTableModel.getValueAt(rowNumber, 0);
            String teacherName = (String) defaultTableModel.getValueAt(rowNumber, 1);
            String address = (String) defaultTableModel.getValueAt(rowNumber, 2);
            String nic = (String) defaultTableModel.getValueAt(rowNumber, 3);
            int teleNo = Integer.parseInt(String.valueOf(defaultTableModel.getValueAt(rowNumber, 4)));
            
            hashMap.put("teacherId", teacherId);
            hashMap.put("teacherName", teacherName);
            hashMap.put("address", address);
            hashMap.put("nic", nic);
            hashMap.put("teleNo", teleNo);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hashMap, new JRTableModelDataSource(tableClassDetail.getModel()));            
            JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            PrintDialog printDialog = new PrintDialog(new Report(), true);
            printDialog.setContentPane(jasperViewer.getContentPane());
            printDialog.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReportOfTeacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
