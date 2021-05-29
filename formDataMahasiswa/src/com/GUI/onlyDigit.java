package com.GUI;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class onlyDigit {
    public PlainDocument getOnlyDigit(){
        PlainDocument filterDigit = new PlainDocument(){
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
            {
                StringBuffer buffer = new StringBuffer();
                int s = 0;
                char[] dataInput = str.toCharArray();
                int len = dataInput.length;

                // Memeriksa semua data yang dimasukkan
                for (int i=0; i < len; i++){
                    // Menyaring apakah data masukkan berupa DIGIT
                    boolean isOnlyDigit = Character.isDigit(dataInput[i]);
                    if (isOnlyDigit == true){
                        dataInput[s] = dataInput[i];
                        s++;
                    }
                }
                buffer.append(dataInput,0,s);
                super.insertString(offs, new String(buffer), a);
            }
        };
        return filterDigit;
    }
}
