/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GUI;

/**
 *
 * @author user
 */

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class onlyLetter {
    
    public onlyLetter(){}
    
    public PlainDocument getOnlyLetter(){
        PlainDocument filterLetter = new PlainDocument(){
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
                StringBuffer buffer = new StringBuffer();
                int s = 0;
                char[] dataInput = str.toCharArray();

                // Memeriksa semua data yang dimasukkan
                for (int i =0; i < dataInput.length; i++){
                    boolean isOnlyLetter = Character.isLetter(dataInput[i]);
                    boolean isSpace = Character.isSpaceChar(dataInput[i]);
                    if (isOnlyLetter == true || isSpace == true){
                        dataInput[s]=dataInput[i];
                        s++;
                    }
                }
                buffer.append(dataInput,0,s);
                super.insertString(offs, new String(buffer), a);
            }
        };
        return filterLetter;
    }
}
