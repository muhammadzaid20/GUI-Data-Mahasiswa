package com.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class formDataMahasiswa extends JFrame implements ActionListener{
    // Deklarasi JTabel tanpa initial objek
    JTable tb_mahasiswa;

    // Deklarasi tambahan, agar JTabel bisa dinamis
    DefaultTableModel DftTabMode;

    // Deklarasi JScrollPane tanpa initial objek
    JScrollPane spane;

    String[] pilJurusan = {"Pilih Jurusan"};

    public int pilihan;

    String[] semSatu = { "Bahasa Indonesia ", "Dasar-Dasar Pemrograman",
            "Matematika Dasar 1","Matematika Diskrit", "Pancasila",
            "Pengantar Studi Islam","Praktikum Ibadah", "Bahasa Arab"};

    String[] semDua = { "Aljabar Linier", "Bahasa Inggris", "Kewarganegaraan",
            "Pengantar Sistem Digital","Praktikum Qiroaah", "Sistem Basis Data",
            "Statistika Dan Probabilitas","Struktur Data Dan Algoritma"};

    String[] semTiga = { "Analisis Dan Desain Sistem", "Komunikasi Data", "Matematika Dasar 2",
            "Metode Numerik","Pengantar Organisasi Komputer ", "Pemrograman Web",
            "Rekayasa Perangkat Lunak"};

    String[] opsiSemester = { "Pilih Semester", "Satu ", "Dua","Tiga"};

    String kolom[] = {"NIM","Nama","Smstr","MK","Frmtf","UTS","UAS","N Akhir","Grade"};

    SpinnerModel spinnerMdl_formatif = new SpinnerNumberModel(0,0,100,1);
    SpinnerModel spinnerMdl_uts= new SpinnerNumberModel(0,0,100,1);
    SpinnerModel spinnerMdl_uas= new SpinnerNumberModel(0,0,100,1);
    JLabel lbl_judul = new JLabel();
    JLabel lbl_cariNama = new JLabel();
    JLabel lbl_nim = new JLabel();
    JLabel lbl_nama = new JLabel();
    JLabel lbl_semester = new JLabel();
    JLabel lbl_mk = new JLabel();
    JLabel lbl_formatif = new JLabel();
    JLabel lbl_uts = new JLabel();
    JLabel lbl_uas = new JLabel();
    JTextField txt_cariNama = new JTextField();
    JTextField txt_nama = new JTextField();
    JTextField txt_nim = new JTextField();
    JComboBox<String> cb_semester;
    JComboBox<String> cb_mk;
    JSpinner spinner_formatif;
    JSpinner spinner_uts;
    JSpinner spinner_uas;
    JButton btn_hitung = new JButton();
    JButton btn_refresh= new JButton();

    public formDataMahasiswa(){
        //membuat background


        this.getContentPane().setLayout(null);
        this.setTitle("Data Mahasiswa");

        //Label Judul
        lbl_judul.setFont(new Font("Tahoma", Font.BOLD,16));
        lbl_judul.setText("Form Data Mahasiswa");
        lbl_judul.setBounds(10, 5, 226, 22);
        this.getContentPane().add(lbl_judul);


        //Label Cari Nama
        lbl_cariNama.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbl_cariNama.setText("Cari Nama");
        lbl_cariNama.setBounds(10, 50, 70, 22);
        this.getContentPane().add(lbl_cariNama);


        //Text Field Cari Nama
        txt_cariNama.setFont(new Font("Tahoma", Font.PLAIN,12));
        txt_cariNama.setText(" ");
        txt_cariNama.setBounds(80, 52, 200, 22);
        //menambah listener text field
        txt_cariNama.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                txt_cariNamaKeyReleased(evt);
            }
            //membuat keyreleased textfield
            public void txt_cariNamaKeyReleased(KeyEvent evt){
                DftTabMode = (DefaultTableModel)tb_mahasiswa.getModel();
                String search = txt_cariNama.getText();
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(DftTabMode);
                tb_mahasiswa.setRowSorter(tr);
                tr.setRowFilter((RowFilter.regexFilter(search)));
            }
        });
        this.getContentPane().add(txt_cariNama);


        // Initialsiasi objek Jtable serta memasukan value table
        DftTabMode = new DefaultTableModel(kolom,0);
        tb_mahasiswa = new JTable(DftTabMode);
        // Memasukan Table dalam ScrollPane. Agar bisa discroll
        spane = new JScrollPane(tb_mahasiswa);
        spane.setBounds(10,80, 780, 120);
        //membuat item didalam table tidak bisa di edit
        tb_mahasiswa.setDefaultEditor(Object.class, null);
        //menentukan size per column
        tb_mahasiswa.getColumnModel().getColumn(0).setPreferredWidth(200);
        tb_mahasiswa.getColumnModel().getColumn(1).setPreferredWidth(270);
        tb_mahasiswa.getColumnModel().getColumn(3).setPreferredWidth(400);
        // Memasukan Table dalam ScrollPane
        this.getContentPane().add(spane);


        //Label NIM
        lbl_nim.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbl_nim.setText("NIM");
        lbl_nim.setBounds(10, 220, 70, 22);
        this.getContentPane().add(lbl_nim);

        //Text Field NIM
        txt_nim.setFont(new Font("Tahoma", Font.PLAIN,12));
        txt_nim.setText(" ");
        txt_nim.setBounds(80, 220, 200, 22);
        txt_nim.setDocument(new onlyDigit().getOnlyDigit());
        this.getContentPane().add(txt_nim);


        //Label Nama
        lbl_nama.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbl_nama.setText("Nama");
        lbl_nama.setBounds(10, 245, 70, 22);
        this.getContentPane().add(lbl_nama);

        //Text Field Nama
        txt_nama.setFont(new Font("Tahoma", Font.PLAIN,12));
        txt_nama.setText("");
        txt_nama.setBounds(80, 245, 200, 22);
        txt_nama.setDocument(new onlyLetter().getOnlyLetter());
        this.getContentPane().add(txt_nama);


        //Label Semester
        lbl_semester.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbl_semester.setText("Semester");
        lbl_semester.setBounds(10, 270, 150, 22);
        this.getContentPane().add(lbl_semester);

        //Combo Box Semester
        cb_semester = new JComboBox<>();
        cb_semester.setFont(new Font("Tahoma", 1, 11));
        cb_semester.setModel(new DefaultComboBoxModel<>(opsiSemester));
        //Membuat listener Option Cb Semester bisa aktif
        cb_semester.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                this.cb_semesteritemStateChanged(evt);
            }
            //membuat item state change
            public void cb_semesteritemStateChanged(ItemEvent evt) {
                pilihan = cb_semester.getSelectedIndex();

                if(pilihan == 0){
                    cb_mk.setModel(new DefaultComboBoxModel<>(pilJurusan));
                }
                if(pilihan == 1){
                    cb_mk.setModel(new DefaultComboBoxModel<>(semSatu));
                }
                if(pilihan == 2){
                    cb_mk.setModel(new DefaultComboBoxModel<>(semDua));
                }
                if(pilihan == 3){
                    cb_mk.setModel(new DefaultComboBoxModel<>(semTiga));
                }
            }
        });
        cb_semester.setBounds(80, 270, 200, 22);
        this.getContentPane().add(this.cb_semester);


        //Label MK
        lbl_mk.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbl_mk.setText("MK");
        lbl_mk.setBounds(10, 295, 150, 22);
        this.getContentPane().add(lbl_mk);

        //Combo Box MK
        cb_mk = new JComboBox<>(pilJurusan);
        cb_mk.setFont(new Font("Tahoma", 1, 11));
        cb_mk.setBounds(80, 295, 200, 22);
        this.getContentPane().add(this.cb_mk);


        //Label Formatif
        lbl_formatif.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbl_formatif.setText("Formatif");
        lbl_formatif.setBounds(340, 220, 150, 22);
        this.getContentPane().add(lbl_formatif);

        //Spinner Formatif
        this.spinner_formatif = new JSpinner(spinnerMdl_formatif);
        this.spinner_formatif.setBounds(410, 220, 200, 22);
        this.getContentPane().add(this.spinner_formatif);


        //Label UTS
        lbl_uts.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbl_uts.setText("UTS");
        lbl_uts.setBounds(340, 245, 150, 22);
        this.getContentPane().add(lbl_uts);

        //Spinner UTS
        spinner_uts = new JSpinner(spinnerMdl_uts);
        spinner_uts.setBounds(410, 245, 200, 22);
        this.getContentPane().add(this.spinner_uts);


        //Label UAS
        lbl_uas.setFont(new Font("Tahoma", Font.PLAIN,12));
        lbl_uas.setText("UAS");
        lbl_uas.setBounds(340, 270, 150, 22);
        this.getContentPane().add(lbl_uas);

        //Spinner UAS
        spinner_uas = new JSpinner(spinnerMdl_uas);
        spinner_uas.setBounds(410, 270, 200, 22);
        this.getContentPane().add(this.spinner_uas);


        //Button Hitung
        btn_hitung.setFont(new Font("Tahoma", 1, 11));
        btn_hitung.setText("HITUNG");
        btn_hitung.setBounds(410, 295, 95, 22);
        btn_hitung.addActionListener(this);
        this.getContentPane().add(this.btn_hitung);


        //Button Refresh
        btn_refresh.setFont(new Font("Tahoma", 1, 11));
        btn_refresh.setText("REFRESH");
        btn_refresh.setBounds(515, 295, 95, 22);
        btn_refresh.addActionListener(this);
        this.getContentPane().add(this.btn_refresh);
    }

    public String cekkosong(){
        String hasil = "";
        if(txt_nim.getText().trim().equals("")){
            hasil = "NIM harus diisi";
        }
        else if(txt_nama.getText().trim().equals("")){
            hasil = "Nama harus diisi";
        }
        else if(pilihan == 0){
            hasil = "Harus pilih semester";
        }
        else{
            hasil = "valid";
        }
        return hasil;
    }

    public void actionPerformed(ActionEvent ae) {
        String nim = txt_nim.getText().trim();
        String nama = txt_nama.getText().trim();
        String semester = (String)cb_semester.getSelectedItem();
        String mataKuliah = (String)cb_mk.getSelectedItem();
        int formatif = (Integer)spinner_formatif.getValue();
        int uts = (Integer)spinner_uts.getValue();
        int uas = (Integer)spinner_uas.getValue();
        hitungNilai calculate = new hitungNilai();

        String cek = cekkosong();

        if(ae.getSource().equals(btn_hitung)){
            calculate.hitung(formatif,uts,uas);

            JOptionPane.showMessageDialog(null,"Nilai berhasil di hitung");
        }

        if(ae.getSource().equals(btn_refresh)){
            if(calculate.grade == ""){
                JOptionPane.showMessageDialog(null,"Anda belum menekan hitung");
            }
            else{
                if(cek.equals("valid")){
                    String tabelNim = nim;
                    String tabelNama = nama;
                    String tabelMataKuliah = mataKuliah;
                    String tabelSemester = semester;
                    String tabelFormatif = String.valueOf(formatif);
                    String tabelUts = String.valueOf(uts);
                    String tabelUas = String.valueOf(uas);
                    String tabelNAkhir = String.valueOf(calculate.nAkhir);
                    String tabelGrade = String.valueOf(calculate.grade);

                    String[] item = {tabelNim, tabelNama, tabelSemester,
                            tabelMataKuliah,tabelFormatif
                            ,tabelUts,tabelUas,tabelNAkhir,tabelGrade};
                    DftTabMode.addRow(item);
                }
                else{
                    JOptionPane.showMessageDialog(null,cek);
                }
            }
        }
    }

    public static void main(String[] args) {
        formDataMahasiswa a = new formDataMahasiswa();
        a.setSize(815, 380);
        a.setLocationRelativeTo(null);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
