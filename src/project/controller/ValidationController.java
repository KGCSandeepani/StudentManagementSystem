/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;


import java.awt.event.KeyEvent;

/**
 *
 * @author 
 */
public class ValidationController {
    public static void decimalNumbersOnlyTextFiled(KeyEvent evt){
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || evt.getKeyChar() == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }        
    }
    
    public static void NumbersOnlyTextFiled(KeyEvent evt){
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) ) {
            evt.consume();
        }        
    }
    
//    public static void decimalNumbers(TextField text){
//        String textNum=text.getText();
//        int caretPosition=text.getCaretPosition();
//        if(!(textNum.matches("^[0-9]{0,9}$"))){
//            textNum=textNum.substring(0, caretPosition-1)+textNum.substring(caretPosition);
//            text.setText(textNum);
//            text.setCaretPosition(caretPosition-1);
//        }
//        
//    }
}
