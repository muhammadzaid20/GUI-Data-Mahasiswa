package com.GUI;

public class hitungNilai {
    static int formatif,uts,uas,nAkhir;
    static String grade ="";

    public void hitung(int formatif, int uts, int uas){
        this.formatif = formatif;
        this.uts = uts;
        this.uas = uas;

        this.nAkhir = (int) ((0.3*this.formatif)+(0.3*this.uts)+(0.4*this.uas));

        if(this.nAkhir >= 80){
            grade = "A";
        }
        if(this.nAkhir < 80 && this.nAkhir >= 70){
            grade = "B";
        }
        if(this.nAkhir < 70 && this.nAkhir >= 60){
            grade = "C";
        }
        if(this.nAkhir < 60 && this.nAkhir >= 50){
            grade = "D";
        }
        if(this.nAkhir < 50){
            grade = "E";
        }
    }

}
