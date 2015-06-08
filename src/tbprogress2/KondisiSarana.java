/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tbprogress2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author eko
 */
public class KondisiSarana extends javax.swing.JFrame {

    int s = 0, ts = 0, kondisi;
    RuangKelas kls = new RuangKelas();
    DatabaseWork da = new DatabaseWork();
    private Integer baris;
    private Connect con = new Connect();
    private JTable Tabelku = new JTable();
    private DefaultTableModel DefaultTabelku;
    private TableColumn kolom;
    private String a, b,c,d,e,f,g;
    private String C,D,E,F,G,kode;
    public KondisiSarana(String KR) {
        initComponents();
        Save.setVisible(false);
        Next.setVisible(false);
        btnSelesai.setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Sarana Ruang");
        con.koneksi();
        IDKelas.setEditable(false);
        IDKelas.setText(KR);
        tampilDataKeTabel();
//        enableBtn(false);
//        enviBtnSave(true);
//        enviBtnSave2(false);
//        enviBtnNew(false);
        CODE.setVisible(false);
        Delete.setVisible(false);
        Edit.setVisible(false);
        
        Enable_TextField2(false);
        Enable_TextField1(false);
//        for(int x=0;x<1000;x++){
//            if(IDKelas.getText().equals(x)){
//            
//            }
//        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
     setDefaultCloseOperation(HIDE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentHidden(java.awt.event.ComponentEvent evt) {
            formComponentHidden(evt);
        }
    });
    }
     private static void formComponentHidden(java.awt.event.ComponentEvent evt) {
    somefunction();
    }
 public static void somefunction()
 {
    int selectedOption = javax.swing.JOptionPane.showConfirmDialog(null,"Apakah anda akan menutup system?", "Tutup Aplikasi", javax.swing.JOptionPane.YES_NO_OPTION);
        if (selectedOption == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        else{
           new DataAwal().setVisible(true);
        }
  
  //System.out.println("hii!! i am hidden!!");

  }
    void Enable_TextField1(boolean x){
        
        KondisiSK.setEnabled(x);
        KondisiKL.setEnabled(x);
        KondisiL.setEnabled(x);
        
        PosisiKL.setEnabled(x);
        PosisiL.setEnabled(x);
        PosisiSK.setEnabled(x);
    
    }
    void Enable_TextField2(boolean x){
        
        kontak.setEnabled(x);
        kskb.setEnabled(x);
        kskr.setEnabled(x);
        pskb.setEnabled(x);
        Pojok.setEnabled(x);
        pskr.setEnabled(x);
        
        jlcd.setEnabled(x);
        kklb.setEnabled(x);
        kklr.setEnabled(x);
        pklb.setEnabled(x);
        Pojok1.setEnabled(x);
        pklr.setEnabled(x);
        
        jlampu.setEnabled(x);
        plb.setEnabled(x);
        plr.setEnabled(x);
        klb.setEnabled(x);
        klr.setEnabled(x);        
    }
private boolean DiEdit() {
//        RuangKelas kls = new RuangKelas();
//        RuangKelas rk;
       boolean nilai = false;
        a = kontak.getText();
        b = kskb.getText();
        c = kskr.getText();
        d = pskb.getText();
        e = Pojok.getText();
        f = pskr.getText();
        
        g = jlcd.getText();
        String h = kklb.getText();
        String i = kklr.getText();
        String j = pklb.getText();
        String k = Pojok1.getText();
        String l = pklr.getText();
        
        String m = jlampu.getText();
        String n = plb.getText();
        String o = plr.getText();
        String p = klb.getText();
        String q = klr.getText();
        
        int A = Integer.parseInt(kskb.getText());
        int B = Integer.parseInt(kskr.getText());
        if(A>=B){
            kls.setKondisiStopKontak("Baik");
        }
        else{
            kls.setKondisiStopKontak("Rusak");
        }
        int C,D,E;
        C = Integer.parseInt(pskb.getText());
        D = Integer.parseInt(Pojok.getText());
        E = Integer.parseInt(pskr.getText());
        if(C>=E || D>=E){
            kls.setPosisiStopKontak("Dekat Dosen/Pojok Kelas");
        }
        else{
            kls.setPosisiStopKontak("Samping Kelas");
        }
        int F,G;
        F = Integer.parseInt(kklb.getText());
        G = Integer.parseInt(kklr.getText());
        if(F>=G){
            kls.setKondisiKabelLCD("Baik");
        }
        else{
            kls.setKondisiKabelLCD("Rusak");
        }
        int H,I,J;
        H = Integer.parseInt(pklb.getText());
        I = Integer.parseInt(Pojok1.getText());
        J = Integer.parseInt(pklr.getText());
        if(H>=J || I>=J){
            kls.setPosisiKabelLCD("Dekat Dosen/Pojok Kelas");
        }
        else{
            kls.setPosisiKabelLCD("Samping Kelas");
        }
        int K,L;
        K = Integer.parseInt(plb.getText());
        L = Integer.parseInt(plr.getText());
        if(K>=L){
            kls.setKondisiLampu("Baik");
        }
        else{
            kls.setKondisiLampu("Rusak");
        }
          int M,N;
        M = Integer.parseInt(klb.getText());
        N = Integer.parseInt(klr.getText());
        if(M>=N){
            kls.setPosisiLampu("Atap Ruangan");
        }
        else{
            kls.setPosisiLampu("Selain Atap Ruangan");
        }

       try {
            if (a.equals("") || b.equals("") || c.equals("") || d.equals("")||e.equals("") || f.equals("") || g.equals("") || h.equals("")||i.equals("") || j.equals("") || k.equals("") || l.equals("")||m.equals("") || n.equals("") || o.equals("") || p.equals("")||q.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                nilai=true;
                clearTEXT();
//            } else if (a.equals(c) && E.equals(e) && b.equals(d) && F.equals(f)) {
//                JOptionPane.showMessageDialog(null, "Tidak ada data yang di perbaharui!");
//                nilai = false;
            } else {
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "update jkp_sarana set "
                        + "JStopKontak=" + "'" + a + "', "
                        + "KStopKontak=" + "'" + kls.getKondisiStopKontak() + "', "
                        + "PStopKontak=" + "'" + kls.getPosisiStopKontak() + "', "
                        + "JKabelLCD=" + "'" + g + "', "
                        + "KKabelLCD=" + "'" + kls.getKondisiKabelLCD() + "', "
                        + "PKabelLCD=" + "'" + kls.getPosisiKabelLCD() + "', "
                        + "JLampu=" + "'" + m + "', "
                        + "KLampu=" + "'" + kls.getKondisiLampu() + "', "
                        + "PLampu=" + "'" + kls.getPosisiLampu() + "' "
                        + "where id_sarana ='" + CODE.getText() + "'");

                tampilDataKeTabel();
                JOptionPane.showMessageDialog(this, "Data berhasil diperbaharui");
                nilai=false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal diperbaharui! : " + ex);
        }
       return nilai;
   }
   void kondisiklik(boolean x){
       label_bsk.setEnabled(x);
       label_rsk.setEnabled(x);
       label_bkl.setEnabled(x);
       label_rkl.setEnabled(x);
       label_bl.setEnabled(x);
       label_rl.setEnabled(x);
       label_DosenSK.setEnabled(x);
       label_sampingsk.setEnabled(x);
       label_pojoksk.setEnabled(x);
       label_dosenlcd.setEnabled(x);
       KLPS.setEnabled(x);
       label_pojoklcd.setEnabled(x);
       label_atap.setEnabled(x);
       label_exatap.setEnabled(x);
       
       kskb.setEnabled(x);
       kskr.setEnabled(x);
       kklb.setEnabled(x);
       kklr.setEnabled(x);
       plb.setEnabled(x);
       plr.setEnabled(x);
       pskb.setEnabled(x);
       Pojok.setEnabled(x);
       pskr.setEnabled(x);
       pklb.setEnabled(x);
       pklr.setEnabled(x);
       Pojok1.setEnabled(x);
       klb.setEnabled(x);
       klr.setEnabled(x);
       
   }
   void ken(boolean x){
       kskb.setEnabled(x);
       kskr.setEnabled(x);
       kklb.setEnabled(x);
       kklr.setEnabled(x);
       plb.setEnabled(x);
       plr.setEnabled(x);
       pskb.setEnabled(x);
       Pojok.setEnabled(x);
       pskr.setEnabled(x);
       pklb.setEnabled(x);
       pklr.setEnabled(x);
       Pojok1.setEnabled(x);
       klb.setEnabled(x);
       klr.setEnabled(x);
   }
    private void klikTabel(JTable jTabel) {
        jTabel.setRowSelectionAllowed(true);
        baris = jTabel.getSelectedRow();
        String kolom1 = jTabel.getValueAt(baris, 0).toString();
        String kolom2 = jTabel.getValueAt(baris, 1).toString();
        String kolom3 = jTabel.getValueAt(baris, 2).toString();
        String kolom4 = jTabel.getValueAt(baris, 3).toString();
        String kolom5 = jTabel.getValueAt(baris, 4).toString();
        String kolom6 = jTabel.getValueAt(baris, 5).toString();
        String kolom7 = jTabel.getValueAt(baris, 6).toString();
        String kolom8 = jTabel.getValueAt(baris, 7).toString();
        String kolom9 = jTabel.getValueAt(baris, 8).toString();
        String kolom10 = jTabel.getValueAt(baris, 9).toString();
        String kolom11 = jTabel.getValueAt(baris, 10).toString();
        String kolom12 = jTabel.getValueAt(baris, 11).toString();
        
        if(IDKelas.getText().equals(kolom12)){
        
        kondisiklik(false);
        KondisiSK.setEditable(false);
        KondisiKL.setEditable(false);
        KondisiL.setEditable(false);
        
        PosisiKL.setEditable(false);
        PosisiL.setEditable(false);
        PosisiSK.setEditable(false);
        
        KondisiSK.setEnabled(true);
        KondisiKL.setEnabled(true);
        KondisiL.setEnabled(true);
        
        PosisiKL.setEnabled(true);
        PosisiL.setEnabled(true);
        PosisiSK.setEnabled(true);
        
        kontak.setEnabled(true);
        jlcd.setEnabled(true);
        jlampu.setEnabled(true);
        
        kontak.setText(kolom2);
        
        KondisiSK.setText(kolom3);
        PosisiSK.setText(kolom4);
        
        jlcd.setText(kolom5);
        KondisiKL.setText(kolom6);
        PosisiKL.setText(kolom7);
        
        jlampu.setText(kolom8);
        KondisiL.setText(kolom9);
        PosisiL.setText(kolom10);
        
        IDKelas.setText(kolom11);
        
        pskb.setText("");
        Pojok.setText("");
        pskr.setText("");
        
        //jlcd.setText(kolom4);
        kklb.setText("");
        kklr.setText("");
        pklb.setText("");
        Pojok1.setText("");
        pklr.setText("");
        
       // jlampu.setText(kolom7);
        plb.setText("");
        plr.setText("");
        klb.setText("");
        klr.setText("");
        
        kontak.setEnabled(true);
        kskb.setEnabled(false);
        kskr.setEnabled(false);
        pskb.setEnabled(false);
        Pojok.setEnabled(false);
        pskr.setEnabled(false);
        
        //jlcd.setEnabled(true);
        kklb.setEnabled(false);
        kklr.setEnabled(false);
        pklb.setEnabled(false);
        Pojok1.setEnabled(false);
        pklr.setEnabled(false);
        
        //jlampu.setEnabled(true);
        plb.setEnabled(false);
        plr.setEnabled(false);
        klb.setEnabled(false);
        klr.setEnabled(false);
        CODE.setText(kolom11);
        IDKelas.setText(kolom12);
            System.out.println(""+CODE.getText());
       // System.out.println(""+CODE.getText());
        Delete.setVisible(true);
        Edit.setVisible(true);
        Save.setVisible(false);
        Next.setVisible(true);
        //ADD.setVisible(false);
        jTabel.enable(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "ID KELAS BERBEDA");
            Delete.setVisible(false);
            Edit.setVisible(false);
            Save.setVisible(false);
            btnSelesai.setVisible(false);
            Next.setVisible(false);
           // ADD.setVisible(true);
            clearTEXT();
            Enable_TextField2(false);
            kontak.setEditable(false);
            jlcd.setEditable(false);
            jlampu.setEditable(false);
            
        //ken(false);
        KondisiKL.setText("");
        KondisiL.setText("");
        KondisiSK.setText("");
        PosisiKL.setText("");
        PosisiL.setText("");
        PosisiSK.setText("");
        
        KondisiSK.setEnabled(false);
        KondisiKL.setEnabled(false);
        KondisiL.setEnabled(false);
        
        PosisiKL.setEnabled(false);
        PosisiL.setEnabled(false);
        PosisiSK.setEnabled(false);
        }
    }
    private void tableModel(JTable jTabel1) {
        try {
            Object[] field = {"No", "Jumlah Stop Kontak", "Kondisi Stop Kontak", "Posisi Stop Kontak","Jumlah Kabel LCD","Kondisi Kabel LCD","Posisi Kabel LCD","Jumlah Lampu","Kondisi Lampu","Posisi Lampu","ID","ID RUANG"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);
//Batas
            String sql = "Select * from jkp_sarana ";
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            String Sql = "Select id from jkp_sarana ";
            Statement St = con.config.getConnection().createStatement();
            ResultSet Set = St.executeQuery(Sql);
            
            while (Set.next()) {
                String kolom12 = Set.getString("id");
                if(kolom12.equalsIgnoreCase(IDKelas.getText())){
                    ADD.setVisible(false);
                    break;
                }
                else{
                    ADD.setVisible(true);
                    
                }
                System.out.println(""+IDKelas.getText());
              //  String[] data = {kolom1, kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8,kolom9,kolom10,kolom11,kolom12};
                //DefaultTabelku.addRow(data);
            }
            int no = 0;
            while (set.next()) {
                no++;
                String kolom1 = String.valueOf(no).toString();
                String kolom2 = set.getString("JStopKontak");
                String kolom3 = set.getString("KStopKontak");
                String kolom4 = set.getString("PStopKontak");
                String kolom5 = set.getString("JKabelLCD");
                String kolom6 = set.getString("KKabelLCD");
                String kolom7 = set.getString("PKabelLCD");
                String kolom8 = set.getString("JLampu");
                String kolom9 = set.getString("KLampu");
                String kolom10 = set.getString("PLampu");
                String kolom11 = set.getString("id_sarana");
                String kolom12 = set.getString("id");
//                if(kolom12.equals(IDKelas.getText())){
//                    ADD.setVisible(false);
//                }
//                else{
//                    ADD.setVisible(false);
//                }
                String[] data = {kolom1, kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8,kolom9,kolom10,kolom11,kolom12};
                DefaultTabelku.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            
            kolom = jTabel1.getColumnModel().getColumn(0);
            kolom.setPreferredWidth(40);
            kolom = jTabel1.getColumnModel().getColumn(1);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(2);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(3);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(4);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(5);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(6);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(7);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(8);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(9);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(10);
            kolom.setPreferredWidth(0);
            kolom.setMinWidth(0);
            kolom.setMaxWidth(0);
            kolom.setWidth(0);
            kolom = jTabel1.getColumnModel().getColumn(11);
            kolom.setPreferredWidth(220);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    void clearTEXT() {
        KondisiKL.setText("");
        KondisiL.setText("");
        KondisiSK.setText("");
        PosisiKL.setText("");
        PosisiL.setText("");
        PosisiSK.setText("");
        
        kontak.setText("");
        kskb.setText("");
        kskr.setText("");
        pskb.setText("");
        Pojok.setText("");
        pskr.setText("");
        
        jlcd.setText("");
        kklb.setText("");
        kklr.setText("");
        pklb.setText("");
        Pojok1.setText("");
        pklr.setText("");
        
        jlampu.setText("");
        plb.setText("");
        plr.setText("");
        klb.setText("");
        klr.setText("");        
    }
    void clearTEXT2() {
        KondisiKL.setText("");
        KondisiL.setText("");
        KondisiSK.setText("");
        PosisiKL.setText("");
        PosisiL.setText("");
        PosisiSK.setText("");
        
       // kontak.setText("");
        kskb.setText("");
        kskr.setText("");
        pskb.setText("");
        Pojok.setText("");
        pskr.setText("");
        
       // jlcd.setText("");
        kklb.setText("");
        kklr.setText("");
        pklb.setText("");
        Pojok1.setText("");
        pklr.setText("");
        
        //jlampu.setText("");
        plb.setText("");
        plr.setText("");
        klb.setText("");
        klr.setText("");        
    }
     private void tampilDataKeTabel() {
        Tabelku = jTable1;
        tableModel(Tabelku);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlcd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        kontak = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlampu = new javax.swing.JTextField();
        label_bsk = new javax.swing.JLabel();
        kskb = new javax.swing.JTextField();
        label_rsk = new javax.swing.JLabel();
        kskr = new javax.swing.JTextField();
        pskb = new javax.swing.JTextField();
        label_sampingsk = new javax.swing.JLabel();
        pskr = new javax.swing.JTextField();
        label_rkl = new javax.swing.JLabel();
        label_bkl = new javax.swing.JLabel();
        kklb = new javax.swing.JTextField();
        kklr = new javax.swing.JTextField();
        KLPS = new javax.swing.JLabel();
        pklb = new javax.swing.JTextField();
        pklr = new javax.swing.JTextField();
        label_atap = new javax.swing.JLabel();
        plb = new javax.swing.JTextField();
        label_exatap = new javax.swing.JLabel();
        plr = new javax.swing.JTextField();
        label_bl = new javax.swing.JLabel();
        klb = new javax.swing.JTextField();
        label_rl = new javax.swing.JLabel();
        klr = new javax.swing.JTextField();
        label_DosenSK = new javax.swing.JLabel();
        label_dosenlcd = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        label_pojoksk = new javax.swing.JLabel();
        label_pojoklcd = new javax.swing.JLabel();
        Pojok = new javax.swing.JTextField();
        Pojok1 = new javax.swing.JTextField();
        IDKelas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSelesai = new javax.swing.JButton();
        CODE = new javax.swing.JTextField();
        KondisiSK = new javax.swing.JTextField();
        KondisiKL = new javax.swing.JTextField();
        KondisiL = new javax.swing.JTextField();
        PosisiSK = new javax.swing.JTextField();
        PosisiKL = new javax.swing.JTextField();
        PosisiL = new javax.swing.JTextField();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Kondisi Kabel Lcd ?");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Kondisi Lampu ?");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Jumlah Kabel Lcd ?");

        jlcd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlcd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlcdActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Posisi Stop Kontak ?");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Kondisi Stop Kontak ?");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("KONDISI SARANA");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Jumlah Stop Kontak ?");

        kontak.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kontak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontakActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Posisi Lampu ? ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Jumlah Lampu ?");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Posisi Kabel Lcd ?");

        jlampu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlampu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlampuActionPerformed(evt);
            }
        });

        label_bsk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_bsk.setText("Baik");

        kskb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kskb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kskbActionPerformed(evt);
            }
        });

        label_rsk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_rsk.setText("Rusak");

        kskr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kskr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kskrActionPerformed(evt);
            }
        });

        pskb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pskb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pskbActionPerformed(evt);
            }
        });

        label_sampingsk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_sampingsk.setText("Samping kelas");

        pskr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pskr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pskrActionPerformed(evt);
            }
        });

        label_rkl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_rkl.setText("Rusak");

        label_bkl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_bkl.setText("Baik");

        kklb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kklb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kklbActionPerformed(evt);
            }
        });

        kklr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kklr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kklrActionPerformed(evt);
            }
        });

        KLPS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        KLPS.setText("Samping kelas");

        pklb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pklb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pklbActionPerformed(evt);
            }
        });

        pklr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pklr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pklrActionPerformed(evt);
            }
        });

        label_atap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_atap.setText("Atap Ruangan");

        plb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        plb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plbActionPerformed(evt);
            }
        });

        label_exatap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_exatap.setText("Selain Atap Ruangan");

        plr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        plr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plrActionPerformed(evt);
            }
        });

        label_bl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_bl.setText("Baik");

        klb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        klb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klbActionPerformed(evt);
            }
        });

        label_rl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_rl.setText("Rusak");

        klr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        klr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                klrActionPerformed(evt);
            }
        });

        label_DosenSK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_DosenSK.setText("Dekat Dosen");

        label_dosenlcd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_dosenlcd.setText("Dekat Dosen");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Save.setText("Save");
        Save.setToolTipText("Klik Untuk Menyimpan Data");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Delete.setText("Hapus");
        Delete.setToolTipText("Klik untuk Menghapus Data pada Kolom");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        ADD.setText("Add");
        ADD.setToolTipText("Klik untuk menambahkan ruang");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        Edit.setText("Edit");
        Edit.setToolTipText("Klik Untuk Merubah Data");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Next.setText("Selanjutnya");
        Next.setToolTipText("Klik Untuk Pergi Ke Langkah Berikutnya");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Save)
                .addGap(16, 16, 16)
                .addComponent(ADD)
                .addGap(18, 18, 18)
                .addComponent(Edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Next)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Next)
                    .addComponent(Edit)
                    .addComponent(ADD)
                    .addComponent(Save)
                    .addComponent(Delete))
                .addContainerGap())
        );

        label_pojoksk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_pojoksk.setText("Pojok Kelas");

        label_pojoklcd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_pojoklcd.setText("Pojok Kelas");

        Pojok.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Pojok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PojokActionPerformed(evt);
            }
        });

        Pojok1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Pojok1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pojok1ActionPerformed(evt);
            }
        });

        IDKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDKelasActionPerformed(evt);
            }
        });

        jLabel7.setText("ID RUANG");

        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Klik jika selesai edit");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        KondisiSK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        KondisiKL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        KondisiL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        PosisiSK.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        PosisiKL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        PosisiL.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(label_pojoksk, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(label_bsk, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel4)
                                                    .addComponent(label_rsk)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(label_DosenSK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addComponent(label_sampingsk))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(kontak, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(KondisiSK, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(kskb, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(kskr, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(pskr, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(pskb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(PosisiSK, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(Pojok, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(9, 9, 9))))
                                    .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_rkl)
                                    .addComponent(label_bkl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_dosenlcd)
                                    .addComponent(label_pojoklcd)
                                    .addComponent(KLPS))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pklb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Pojok1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pklr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PosisiKL, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(kklb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(kklr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(43, 43, 43)
                                .addComponent(jlcd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KondisiKL, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(70, 70, 70)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(label_exatap))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel13)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(label_bl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel12)
                                                            .addComponent(label_rl)
                                                            .addComponent(jLabel10)
                                                            .addComponent(label_atap))
                                                        .addGap(15, 15, 15)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(plr, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(plb, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(KondisiL, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                    .addComponent(klb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(PosisiL)
                                                    .addComponent(jlampu)))
                                            .addComponent(klr, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 105, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(kontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pskr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KLPS))
                            .addComponent(label_sampingsk, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlcd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(KondisiSK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(KondisiKL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(KondisiL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_bkl)
                                    .addComponent(label_bl)
                                    .addComponent(plb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_bsk)
                                    .addComponent(kklb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kskb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_rkl)
                                    .addComponent(kklr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_rl)
                                    .addComponent(plr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kskr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_rsk))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5)
                                    .addComponent(PosisiSK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PosisiKL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PosisiL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jlampu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pklb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_dosenlcd)
                            .addComponent(label_atap)
                            .addComponent(klb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pskb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_DosenSK))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_pojoklcd)
                            .addComponent(Pojok1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pojok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_pojoksk))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_exatap)
                            .addComponent(klr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pklr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addComponent(btnSelesai)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        btnSelesai.setVisible(DiEdit());
        jTable1.enable(true);
        clearTEXT();
         try{String Sql = "Select id from jkp_sarana ";
            Statement St = con.config.getConnection().createStatement();
            ResultSet Set = St.executeQuery(Sql);
            
            while (Set.next()) {
                String kolom12 = Set.getString("id");
                if(kolom12.equalsIgnoreCase(IDKelas.getText())){
                    ADD.setVisible(false);
                    break;
                }
                else{
                    ADD.setVisible(true);
                    
                }
                System.out.println(""+IDKelas.getText());
              //  String[] data = {kolom1, kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8,kolom9,kolom10,kolom11,kolom12};
                //DefaultTabelku.addRow(data);
            }
         }
         catch(SQLException e){
             JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
         }
        Delete.setVisible(false);
        //ADD.setVisible(true);
        Edit.setVisible(false);
        Next.setVisible(false);
        kontak.setEnabled(false);
        kskb.setEnabled(false);
        kskr.setEnabled(false);
        pskb.setEnabled(false);
        Pojok.setEnabled(false);
        pskr.setEnabled(false);

        jlcd.setEnabled(false);
        kklb.setEnabled(false);
        kklr.setEnabled(false);
        pklb.setEnabled(false);
        Pojok1.setEnabled(false);
        pklr.setEnabled(false);

        jlampu.setEnabled(false);
        plb.setEnabled(false);
        plr.setEnabled(false);
        klb.setEnabled(false);
        klr.setEnabled(false);
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void Pojok1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pojok1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pojok1ActionPerformed

    private void PojokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PojokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PojokActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
          IO x = new IO(kontak,KondisiSK,PosisiSK,jlcd,KondisiKL,PosisiKL,jlampu,KondisiL,PosisiL);
//        IO x = new IO(kontak, kskb, kskr, pskb,Pojok, pskr,jlcd,kklb,kklr,pklb,Pojok1,pklr,jlampu,plb,plr,klb,klr);
        Sistem n = new Sistem();
        kls = x.getRuangKelas();
        x.output(kls.getJumlahStopKontak(),kls.getKondisiStopKontak() ,kls.getPosisiStopKontak(),kls.getJumlahKabelLCD(),kls.getKondisiKabelLCD(),kls.getPosisiKabelLCD(),kls.getJumlahLampu(),kls.getKondisiLampu(),kls.getLokasiRuang() );
        n.CheckKondisiSarana(kls,IDKelas.getText());
//            int a,b,c;
//            a = Integer.parseInt(kontak.getText());
//            b = Integer.parseInt(jlcd.getText());
//            c = Integer.parseInt(jlampu.getText());
//        x.output(a, KondisiSK.getText(), PosisiSK.getText(), b, KondisiKL.getText(), PosisiKL, c, KondisiL.getText(), PosisiL.getText());
        dispose();
        x.inputKondisiSarana2(IDKelas.getText());
    }//GEN-LAST:event_NextActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        kondisiklik(true);
        clearTEXT2();
            kontak.setEditable(true);
            jlcd.setEditable(true);
            jlampu.setEditable(true);
        Enable_TextField1(false);
        btnSelesai.setVisible(true);
        kontak.setEnabled(true);
        kskb.setEnabled(true);
        kskr.setEnabled(true);
        pskb.setEnabled(true);
        Pojok.setEnabled(true);
        pskr.setEnabled(true);

        jlcd.setEnabled(true);
        kklb.setEnabled(true);
        kklr.setEnabled(true);
        pklb.setEnabled(true);
        Pojok1.setEnabled(true);
        pklr.setEnabled(true);

        jlampu.setEnabled(true);
        plb.setEnabled(true);
        plr.setEnabled(true);
        klb.setEnabled(true);
        klr.setEnabled(true);
        Delete.setVisible(false);
        ADD.setVisible(false);
        Edit.setVisible(false);
        Next.setVisible(false);
        jTable1.enable(false);
    }//GEN-LAST:event_EditActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        kondisiklik(true);
        kontak.setEditable(true);
            jlcd.setEditable(true);
            jlampu.setEditable(true);
            
        kontak.setEnabled(true);
        kskb.setEnabled(true);
        kskr.setEnabled(true);
        pskb.setEnabled(true);
        Pojok.setEnabled(true);
        pskr.setEnabled(true);

        jlcd.setEnabled(true);
        kklb.setEnabled(true);
        kklr.setEnabled(true);
        pklb.setEnabled(true);
        Pojok1.setEnabled(true);
        pklr.setEnabled(true);

        jlampu.setEnabled(true);
        plb.setEnabled(true);
        plr.setEnabled(true);
        klb.setEnabled(true);
        klr.setEnabled(true);
        clearTEXT();
        Save.setVisible(true);
        Edit.setVisible(false);
        Delete.setVisible(false);
        ADD.setVisible(false);
        Next.setVisible(false);
        jTable1.enable(false);
    }//GEN-LAST:event_ADDActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        kondisiklik(true);
        da.kondisiHapus("jkp_sarana","id_sarana",CODE.getText());
        clearTEXT();
        Enable_TextField2(false);
        Enable_TextField1(false);
        Next.setVisible(false);
        Delete.setVisible(false);
        Edit.setVisible(false);
        tampilDataKeTabel();
    }//GEN-LAST:event_DeleteActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        IO x = new IO(kontak,kskb, kskr, pskb,Pojok, pskr,jlcd,kklb,kklr,pklb,Pojok1,pklr,jlampu,plb,plr,klb,klr);
        kls = x.getRuangKelas();
        da.Save(IDKelas.getText(),kontak,kls.getKondisiStopKontak() ,kls.getPosisiStopKontak(),jlcd,kls.getKondisiKabelLCD(),kls.getPosisiKabelLCD(),jlampu,kls.getKondisiLampu(),kls.getPosisiLampu());
        tampilDataKeTabel();
        Save.setVisible(false);
        ADD.setVisible(true);
        clearTEXT();
        kondisiklik(true);
        Next.setVisible(false);
        kontak.setEnabled(false);
        kskb.setEnabled(false);
        kskr.setEnabled(false);
        pskb.setEnabled(false);
        Pojok.setEnabled(false);
        pskr.setEnabled(false);

        jlcd.setEnabled(false);
        kklb.setEnabled(false);
        kklr.setEnabled(false);
        pklb.setEnabled(false);
        Pojok1.setEnabled(false);
        pklr.setEnabled(false);

        jlampu.setEnabled(false);
        plb.setEnabled(false);
        plr.setEnabled(false);
        klb.setEnabled(false);
        klr.setEnabled(false);
        jTable1.enable(true);
        try{
            String Sql = "Select id from jkp_sarana ";
            Statement St = con.config.getConnection().createStatement();
            ResultSet Set = St.executeQuery(Sql);
            
            while (Set.next()) {
                String kolom12 = Set.getString("id");
                if(kolom12.equalsIgnoreCase(IDKelas.getText())){
                    ADD.setVisible(false);
                    break;
                }
                else{
                    ADD.setVisible(true);
                    
                }
                System.out.println(""+IDKelas.getText());
              //  String[] data = {kolom1, kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8,kolom9,kolom10,kolom11,kolom12};
                //DefaultTabelku.addRow(data);
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        klikTabel(Tabelku);
        //kontak.setEnabled(false);
        kskb.setEnabled(false);
        kskr.setEnabled(false);
        pskb.setEnabled(false);
        Pojok.setEnabled(false);
        pskr.setEnabled(false);

     //   jlcd.setEnabled(false);
        kklb.setEnabled(false);
        kklr.setEnabled(false);
        pklb.setEnabled(false);
        Pojok1.setEnabled(false);
        pklr.setEnabled(false);

       // jlampu.setEnabled(false);
        plb.setEnabled(false);
        plr.setEnabled(false);
        klb.setEnabled(false);
        klr.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void klrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klrActionPerformed
        klr.setText("");
    }//GEN-LAST:event_klrActionPerformed

    private void klbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_klbActionPerformed
        klb.setText("");
    }//GEN-LAST:event_klbActionPerformed

    private void plrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plrActionPerformed
        plr.setText("");
    }//GEN-LAST:event_plrActionPerformed

    private void plbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plbActionPerformed
        plb.setText("");
    }//GEN-LAST:event_plbActionPerformed

    private void pklrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pklrActionPerformed
        pklr.setText("");
    }//GEN-LAST:event_pklrActionPerformed

    private void pklbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pklbActionPerformed
        pklb.setText("");
    }//GEN-LAST:event_pklbActionPerformed

    private void kklrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kklrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kklrActionPerformed

    private void kklbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kklbActionPerformed
        kklb.setText("");
    }//GEN-LAST:event_kklbActionPerformed

    private void pskrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pskrActionPerformed
        pskr.setText("");
    }//GEN-LAST:event_pskrActionPerformed

    private void pskbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pskbActionPerformed
        pskb.setText("");
    }//GEN-LAST:event_pskbActionPerformed

    private void kskrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kskrActionPerformed
        kskr.setText("");
    }//GEN-LAST:event_kskrActionPerformed

    private void kskbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kskbActionPerformed
        kskb.setText("");
    }//GEN-LAST:event_kskbActionPerformed

    private void jlampuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlampuActionPerformed
        jlampu.setText("2");
    }//GEN-LAST:event_jlampuActionPerformed

    private void kontakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontakActionPerformed
        kontak.setText("2");
    }//GEN-LAST:event_kontakActionPerformed

    private void jlcdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlcdActionPerformed
        jlcd.setText("2");
    }//GEN-LAST:event_jlcdActionPerformed

    private void IDKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDKelasActionPerformed

    /** 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KondisiSarana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KondisiSarana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KondisiSarana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KondisiSarana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KondisiSarana("2").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JTextField CODE;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField IDKelas;
    private javax.swing.JLabel KLPS;
    private javax.swing.JTextField KondisiKL;
    private javax.swing.JTextField KondisiL;
    private javax.swing.JTextField KondisiSK;
    private javax.swing.JButton Next;
    private javax.swing.JTextField Pojok;
    private javax.swing.JTextField Pojok1;
    private javax.swing.JTextField PosisiKL;
    private javax.swing.JTextField PosisiL;
    private javax.swing.JTextField PosisiSK;
    private javax.swing.JButton Save;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jlampu;
    private javax.swing.JTextField jlcd;
    private javax.swing.JTextField kklb;
    private javax.swing.JTextField kklr;
    private javax.swing.JTextField klb;
    private javax.swing.JTextField klr;
    private javax.swing.JTextField kontak;
    private javax.swing.JTextField kskb;
    private javax.swing.JTextField kskr;
    private javax.swing.JLabel label_DosenSK;
    private javax.swing.JLabel label_atap;
    private javax.swing.JLabel label_bkl;
    private javax.swing.JLabel label_bl;
    private javax.swing.JLabel label_bsk;
    private javax.swing.JLabel label_dosenlcd;
    private javax.swing.JLabel label_exatap;
    private javax.swing.JLabel label_pojoklcd;
    private javax.swing.JLabel label_pojoksk;
    private javax.swing.JLabel label_rkl;
    private javax.swing.JLabel label_rl;
    private javax.swing.JLabel label_rsk;
    private javax.swing.JLabel label_sampingsk;
    private javax.swing.JTextField pklb;
    private javax.swing.JTextField pklr;
    private javax.swing.JTextField plb;
    private javax.swing.JTextField plr;
    private javax.swing.JTextField pskb;
    private javax.swing.JTextField pskr;
    // End of variables declaration//GEN-END:variables
}
