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
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author eko
 */
public class KondisiSarana2 extends javax.swing.JFrame {
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
   
    public KondisiSarana2(String KR) {
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
        
        kondisiKA.setEnabled(x);
        kondisiAC.setEnabled(x);
        kondisiCCTV.setEnabled(x);
        
        posisiKA.setEnabled(x);
        posisiAC.setEnabled(x);
        posisiCCTV.setEnabled(x);
    
    }
    void Enable_TextField2(boolean x){
        
        jka.setEnabled(x);
        pkab.setEnabled(x);
        pkar.setEnabled(x);
        kkab.setEnabled(x);
        kkar.setEnabled(x);
        jac.setEnabled(x);
        
        pacs.setEnabled(x);
        pacd.setEnabled(x);
        pacb.setEnabled(x);
        kacb.setEnabled(x);
        kacr.setEnabled(x);
        ssid.setEnabled(x);
        
        bb.setEnabled(x);
        bt.setEnabled(x);
        jcctv.setEnabled(x);
        kcctvb.setEnabled(x);
        kcctvr.setEnabled(x);
        pcctvb.setEnabled(x);
        pcctvr.setEnabled(x);
        
        
    }
private boolean DiEdit() {
//        RuangKelas kls = new RuangKelas();
//        RuangKelas rk;
        IO x = new IO( jka, pkab,pkar, kkab, kkar, jac, pacs, pacd, pacb, kacb, kacr, ssid,bb, bt,jcctv, kcctvb, kcctvr, pcctvb, pcctvr);
        //Sistem nn = new Sistem();
        kls = x.getRuangKelas();
        boolean nilai = false;
        
        a = jka.getText();
        b = kkab.getText();
        c = kkar.getText();
        d = pkab.getText();
        e = pkar.getText();
        f = jac.getText();
        
        g = kacb.getText();
        String h = kacr.getText();
        String i = pacs.getText();
        String j = pacd.getText();
        String k = pacb.getText();
        String l = ssid.getText();
//        
//        String m = bb.getText();
//        String n = bt.getText();
        String o = jcctv.getText();
        String p = kcctvb.getText();
        String q = kcctvr.getText();
        String r = pcctvb.getText();
        String s = pcctvr.getText();
        
//        int A = Integer.parseInt(kkab.getText());
//        int B = Integer.parseInt(kkar.getText());
//        if(A>=B){
//            kls.setKondisiKipasAngin("Baik");
//        }
//        else{
//            kls.setKondisiKipasAngin("Rusak");
//        }
//        int C,D;
//        C = Integer.parseInt(pkab.getText());
//        D = Integer.parseInt(pkar.getText());
//        
//        if(C>=D){
//            kls.setPosisiKipasAngin("Atap Ruangan");
//        }
//        else{
//            kls.setPosisiKipasAngin("Samping Ruangan");
//        }
//        int E = Integer.parseInt(jac.getText());
//        int F,G;
//        F = Integer.parseInt(kacb.getText());
//        G = Integer.parseInt(kacr.getText());
//        if(F>=G){
//            kls.setKondisiAC("Baik");
//        }
//        else{
//            kls.setKondisiAC("Rusak");
//        }
//        String BND = kls.getBandwidth();
//        int H,I,J;
//        H = Integer.parseInt(pacs.getText());
//        I = Integer.parseInt(pacd.getText());
//        J = Integer.parseInt(pacb.getText());
//        if(H>=I || J>=I){
//            kls.setPosisiAC("DSamping/Belakang");
//        }
//        else{
//            kls.setPosisiAC("Depan");
//        }
//        int K = Integer.parseInt(ssid.getText());
//        int L,M;
//        K = Integer.parseInt(bb.getText());
//        L = Integer.parseInt(bt.getText());
//        if(K>=L){
//            kls.setKondisiLampu("Baik");
//        }
//        else{
//            kls.setKondisiLampu("Rusak");
//        }
//        int M,N;
//        M = Integer.parseInt(klb.getText());
//        N = Integer.parseInt(klr.getText());
//        if(M>=N){
//            kls.setPosisiLampu("Atap Ruangan");
//        }
//        else{
//            kls.setPosisiLampu("Selain Atap Ruangan");
//        }

       try {
            if (a.equals("") || b.equals("") || c.equals("") || d.equals("")||e.equals("") || f.equals("") || g.equals("") || h.equals("")||i.equals("") || j.equals("") || k.equals("") || l.equals("")||(!bb.isSelected() && !bt.isSelected()) || o.equals("") || p.equals("")||q.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                nilai=true;
                clearTEXT();
//            } else if (a.equals(c) && E.equals(e) && b.equals(d) && F.equals(f)) {
//                JOptionPane.showMessageDialog(null, "Tidak ada data yang di perbaharui!");
//                nilai = false;
            } else {
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "update jkp_sarana2 set "
                        + "JKipasAngin=" + "'" + a + "', "
                        + "KKipasAngin=" + "'" + kls.getKondisiKipasAngin()+ "', "
                        + "PKipasAngin=" + "'" + kls.getPosisiKipasAngin() + "', "
                        + "JAC=" + "'" + g + "', "
                        + "KAC=" + "'" + kls.getKondisiAC() + "', "
                        + "PAC=" + "'" + kls.getPosisiAC()+ "', "
                        + "SSID=" + "'" + kls.getSSID() + "', "
                        + "bandwidth=" + "'" + kls.getBandwidth() + "', "
                        + "JCCTV=" + "'" + o + "', "
                        + "KCCTV=" + "'" + kls.getKondisiCCTV() + "', "
                        + "PCCTV=" + "'" + kls.getPosisiCCTV() + "' "
                        + "where id_sarana2 ='" + CODE.getText() + "'");

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
       lbl_acb.setEnabled(x);
       lbl_acbaik.setEnabled(x);
       lbl_acd.setEnabled(x);
       lbl_acrsk.setEnabled(x);
       lbl_acs.setEnabled(x);
       lbl_ar.setEnabled(x);
       lbl_kab.setEnabled(x);
       lbl_kar.setEnabled(x);
       lbl_kcb.setEnabled(x);
       lbl_kcr.setEnabled(x);
       lbl_pcdb.setEnabled(x);
       lbl_pcs.setEnabled(x);
       lbl_sr.setEnabled(x);
       
       
        pkab.setEnabled(x);
        pkar.setEnabled(x);
        kkab.setEnabled(x);
        kkar.setEnabled(x);
        pacs.setEnabled(x);
        pacd.setEnabled(x);
        pacb.setEnabled(x);
        kacb.setEnabled(x);
        kacr.setEnabled(x);
        
        kcctvb.setEnabled(x);
        kcctvr.setEnabled(x);
        pcctvb.setEnabled(x);
        pcctvr.setEnabled(x); 
   }
   void ken(boolean x){
        pkab.setEnabled(x);
        pkar.setEnabled(x);
        kkab.setEnabled(x);
        kkar.setEnabled(x);
        pacs.setEnabled(x);
        pacd.setEnabled(x);
        pacb.setEnabled(x);
        kacb.setEnabled(x);
        kacr.setEnabled(x);
        
        kcctvb.setEnabled(x);
        kcctvr.setEnabled(x);
        pcctvb.setEnabled(x);
        pcctvr.setEnabled(x); 
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
        String kolom13 = jTabel.getValueAt(baris, 12).toString();
        String kolom14 = jTabel.getValueAt(baris, 13).toString();
        if(IDKelas.getText().equals(kolom14)){
                jka.setEditable(false);
                jac.setEditable(false);
                jcctv.setEditable(false);
        kondisiklik(false);
        kondisiKA.setEditable(false);
        kondisiAC.setEditable(false);
        kondisiCCTV.setEditable(false);
        
        posisiKA.setEditable(false);
        posisiAC.setEditable(false);
        posisiCCTV.setEditable(false);
        
        kondisiKA.setEnabled(true);
        kondisiAC.setEnabled(true);
        kondisiCCTV.setEnabled(true);
        
        posisiKA.setEnabled(true);
        posisiAC.setEnabled(true);
        posisiCCTV.setEnabled(true);
        
        jka.setEnabled(true);
        jac.setEnabled(true);
        jcctv.setEnabled(true);
        
        jka.setText(kolom2);
        
        kondisiKA.setText(kolom3);
        posisiKA.setText(kolom4);
        
        
        
        jac.setText(kolom5);
        kondisiAC.setText(kolom6);
        posisiAC.setText(kolom7);
        ssid.setText(kolom8);
        if(kolom9.equalsIgnoreCase("Bisa")){
            bb.setSelected(true);
            bt.setSelected(false);
        }
        else{
            bb.setSelected(false);
            bt.setSelected(true);
        }
        jcctv.setText(kolom10);
        kondisiCCTV.setText(kolom11);
        posisiCCTV.setText(kolom12);
        
       
        
       pkab.setText("");
        pkar.setText("");
        kkab.setText("");
        kkar.setText("");
        pacs.setText("");
        pacd.setText("");
        pacb.setText("");
        kacb.setText("");
        kacr.setText("");
       
        kcctvb.setText("");
        kcctvr.setText("");
        pcctvb.setText("");
        pcctvr.setText("");
        
        jka.setEnabled(true);
        pkab.setEnabled(false);
        pkar.setEnabled(false);
        kkab.setEnabled(false);
        kkar.setEnabled(false);
        pacs.setEnabled(false);
        pacd.setEnabled(false);
        pacb.setEnabled(false);
        kacb.setEnabled(false);
        kacr.setEnabled(false);
      
        kcctvb.setEnabled(false);
        kcctvr.setEnabled(false);
        pcctvb.setEnabled(false);
        pcctvr.setEnabled(false);
        CODE.setText(kolom13);
        IDKelas.setText(kolom14);
            System.out.println(""+CODE.getText());
       // System.out.println(""+CODE.getText());
        Delete.setVisible(true);
        Edit.setVisible(true);
        Save.setVisible(false);
        Next.setVisible(true);
        ssid.setEnabled(true);
        bb.setEnabled(false);
        bt.setEnabled(false);
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
            jka.setEditable(false);
            jac.setEditable(false);
            jcctv.setEditable(false);
            
        //ken(false);
        kondisiKA.setText("");
        kondisiAC.setText("");
        kondisiCCTV.setText("");
        posisiKA.setText("");
        posisiAC.setText("");
        posisiCCTV.setText("");
        
        kondisiKA.setEnabled(false);
        kondisiAC.setEnabled(false);
        kondisiCCTV.setEnabled(false);
        
        posisiKA.setEnabled(false);
        posisiKA.setEnabled(false);
        posisiCCTV.setEnabled(false);
        }
    }
    private void tableModel(JTable jTabel1) {
        try {
            Object[] field = {"No", "Jumlah Kipas Angin", "Kondisi Kipas Angin", "Posisi Kipas Angin","Jumlah AC","Kondisi AC","Posisi AC","SSID","Bandwidth","Jumlah CCTV","Kondisi CCTV","Posisi CCTV","ID","ID RUANG"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);
//Batas
            String sql = "Select * from jkp_sarana2 ";
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            String Sql = "Select id from jkp_sarana2 ";
            Statement St = con.config.getConnection().createStatement();
            ResultSet Set = St.executeQuery(Sql);
            
            while (Set.next()) {
                String kolom14 = Set.getString("id");
                if(kolom14.equalsIgnoreCase(IDKelas.getText())){
                    Add.setVisible(false);
                    break;
                }
                else{
                    Add.setVisible(true);
                    
                }
                System.out.println(""+IDKelas.getText());
              //  String[] data = {kolom1, kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8,kolom9,kolom10,kolom11,kolom12};
                //DefaultTabelku.addRow(data);
            }
            int no = 0;
            while (set.next()) {
                no++;
                String kolom1 = String.valueOf(no).toString();
                String kolom2 = set.getString("JKipasAngin");
                String kolom3 = set.getString("KKipasAngin");
                String kolom4 = set.getString("PKipasAngin");
                String kolom5 = set.getString("JAC");
                String kolom6 = set.getString("KAC");
                String kolom7 = set.getString("PAC");
                String kolom8 = set.getString("SSID");
                String kolom9 = set.getString("bandwidth");
                String kolom10 = set.getString("JCCTV");
                String kolom11 = set.getString("KCCTV");
                String kolom12 = set.getString("PCCTV");
                String kolom13 = set.getString("id_sarana2");
                String kolom14 = set.getString("id");
                
//                if(kolom12.equals(IDKelas.getText())){
//                    ADD.setVisible(false);
//                }
//                else{
//                    ADD.setVisible(false);
//                }
                String[] data = {kolom1, kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8,kolom9,kolom10,kolom11,kolom12,kolom13,kolom14};
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
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(11);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(12);
            kolom.setPreferredWidth(0);
            kolom.setMinWidth(0);
            kolom.setMaxWidth(0);
            kolom.setWidth(0);
            kolom = jTabel1.getColumnModel().getColumn(13);
            kolom.setPreferredWidth(220);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    void clearTEXT() {
        kondisiKA.setText("");
        kondisiAC.setText("");
        kondisiCCTV.setText("");
        posisiKA.setText("");
        posisiAC.setText("");
        posisiCCTV.setText("");
        
        jka.setText("");
        pkab.setText("");
        pkar.setText("");
        kkab.setText("");
        kkar.setText("");
        jac.setText("");
        pacs.setText("");
        pacd.setText("");
        pacb.setText("");
        kacb.setText("");
        kacr.setText("");
        jcctv.setText("");
        
        kcctvb.setText("");
        kcctvr.setText("");
        pcctvb.setText("");
        pcctvr.setText("");
        
        ssid.setText("");
        bb.setSelected(false);
        bt.setSelected(false);
    }
    void clearTEXT2() {
        kondisiKA.setText("");
        kondisiAC.setText("");
        kondisiCCTV.setText("");
        posisiKA.setText("");
        posisiAC.setText("");
        posisiCCTV.setText("");
        
   
        pkab.setText("");
        pkar.setText("");
        kkab.setText("");
        kkar.setText("");
   
        pacs.setText("");
        pacd.setText("");
        pacb.setText("");
        kacb.setText("");
        kacr.setText("");
  
        
        kcctvb.setText("");
        kcctvr.setText("");
        pcctvb.setText("");
        pcctvr.setText("");      
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ssid = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        bb = new javax.swing.JCheckBox();
        bt = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jcctv = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jac = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jka = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbl_ar = new javax.swing.JLabel();
        pkab = new javax.swing.JTextField();
        lbl_sr = new javax.swing.JLabel();
        pkar = new javax.swing.JTextField();
        kkab = new javax.swing.JTextField();
        lbl_kar = new javax.swing.JLabel();
        lbl_kab = new javax.swing.JLabel();
        kkar = new javax.swing.JTextField();
        lbl_acb = new javax.swing.JLabel();
        pacb = new javax.swing.JTextField();
        lbl_acs = new javax.swing.JLabel();
        pacs = new javax.swing.JTextField();
        lbl_acd = new javax.swing.JLabel();
        pacd = new javax.swing.JTextField();
        lbl_acbaik = new javax.swing.JLabel();
        kacb = new javax.swing.JTextField();
        lbl_acrsk = new javax.swing.JLabel();
        kacr = new javax.swing.JTextField();
        lbl_kcb = new javax.swing.JLabel();
        lbl_kcr = new javax.swing.JLabel();
        kcctvb = new javax.swing.JTextField();
        kcctvr = new javax.swing.JTextField();
        lbl_pcdb = new javax.swing.JLabel();
        pcctvb = new javax.swing.JTextField();
        lbl_pcs = new javax.swing.JLabel();
        pcctvr = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Delete = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        CODE = new javax.swing.JTextField();
        btnSelesai = new javax.swing.JButton();
        IDKelas = new javax.swing.JTextField();
        Edit = new javax.swing.JButton();
        kondisiKA = new javax.swing.JTextField();
        kondisiAC = new javax.swing.JTextField();
        kondisiCCTV = new javax.swing.JTextField();
        posisiKA = new javax.swing.JTextField();
        posisiAC = new javax.swing.JTextField();
        posisiCCTV = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("KONDISI SARANA");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("SSID ?");

        ssid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ssid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssidActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Bandwidth ?");

        bb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bb.setText("Bisa");
        bb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbActionPerformed(evt);
            }
        });

        bt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bt.setText("Tidak");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Jumlah CCTV ?");

        jcctv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcctv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcctvActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Kondisi CCTV ?");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Posisi CCTV ?");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Posisi AC ?");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Kondisi AC ?");

        jac.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jacActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Jumlah AC ?");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Kondisi Kipas Angin ?");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Posisi Kipas Angin ?");

        jka.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jkaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Jumlah Kipas Angin ?");

        lbl_ar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_ar.setText("Atap Ruangan");

        pkab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pkab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pkabActionPerformed(evt);
            }
        });

        lbl_sr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_sr.setText("Samping Ruangan");

        pkar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pkar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pkarActionPerformed(evt);
            }
        });

        kkab.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kkab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kkabActionPerformed(evt);
            }
        });

        lbl_kar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_kar.setText("Rusak");

        lbl_kab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_kab.setText("Baik");

        kkar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kkar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kkarActionPerformed(evt);
            }
        });

        lbl_acb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_acb.setText("Belakang");

        pacb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pacb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacbActionPerformed(evt);
            }
        });

        lbl_acs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_acs.setText("Samping");

        pacs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pacs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacsActionPerformed(evt);
            }
        });

        lbl_acd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_acd.setText("Depan");

        pacd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pacd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacdActionPerformed(evt);
            }
        });

        lbl_acbaik.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_acbaik.setText("Baik");

        kacb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kacb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kacbActionPerformed(evt);
            }
        });

        lbl_acrsk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_acrsk.setText("Rusak");

        kacr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kacr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kacrActionPerformed(evt);
            }
        });

        lbl_kcb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_kcb.setText("Baik");

        lbl_kcr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_kcr.setText("Rusak");

        kcctvb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kcctvb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kcctvbActionPerformed(evt);
            }
        });

        kcctvr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kcctvr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kcctvrActionPerformed(evt);
            }
        });

        lbl_pcdb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_pcdb.setText("Depan/Belakang");

        pcctvb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pcctvb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcctvbActionPerformed(evt);
            }
        });

        lbl_pcs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_pcs.setText("Samping");

        pcctvr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pcctvr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcctvrActionPerformed(evt);
            }
        });

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

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Next.setText("Selanjutnya");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        btnSelesai.setText("Selesai");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        IDKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDKelasActionPerformed(evt);
            }
        });

        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        kondisiKA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        kondisiAC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        kondisiCCTV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        posisiKA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        posisiAC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        posisiCCTV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jka, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_kar)
                                        .addComponent(lbl_kab))
                                    .addGap(100, 100, 100)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(kkab, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(kkar)
                                            .addGap(32, 32, 32)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_sr)
                                    .addComponent(lbl_ar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pkab, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(pkar)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(kondisiKA, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(posisiKA, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(18, 18, 18)
                                    .addComponent(jac))
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbl_acrsk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_acbaik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel7))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ssid, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(kacr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                        .addComponent(kacb, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(lbl_acb)
                                    .addComponent(jLabel17)
                                    .addComponent(lbl_acs)
                                    .addComponent(lbl_acd))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pacd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pacb, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pacs, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(posisiAC, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(kondisiAC))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(lbl_kcr)
                                    .addComponent(lbl_kcb)
                                    .addComponent(jLabel21)
                                    .addComponent(lbl_pcs))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kondisiCCTV, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kcctvb, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kcctvr, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(posisiCCTV, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(pcctvr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                        .addComponent(pcctvb, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(bb)
                                        .addGap(18, 18, 18)
                                        .addComponent(bt))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcctv, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbl_pcdb, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(275, 275, 275))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnSelesai)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Add)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Next))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17)
                    .addComponent(bb)
                    .addComponent(bt)
                    .addComponent(posisiAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kondisiKA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pacs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_acs)
                            .addComponent(pkab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ar)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcctv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_sr)
                            .addComponent(pkar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_acd)
                            .addComponent(pacd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbl_acb, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pacb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(kondisiAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_kcr)
                                            .addComponent(kcctvr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(lbl_kcb)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kacb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_acbaik, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kkar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_kar)
                                    .addComponent(jLabel21)
                                    .addComponent(posisiCCTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(posisiKA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kkab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_kab))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pcctvb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_pcdb)
                            .addComponent(kacr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_acrsk))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_pcs)
                            .addComponent(pcctvr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ssid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(kondisiCCTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kcctvb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnSelesai)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(Save)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Next)
                    .addComponent(Edit))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        
        //IO x = new IO( jka, pkab,pkar, kkab, kkar, jac, pacs, pacd, pacb, kacb, kacr, ssid,bb, bt,jcctv, kcctvb, kcctvr, pcctvb, pcctvr);
        IO x = new IO( jka, posisiKA, kondisiKA, jac, kondisiAC, posisiAC, ssid, bb, bt,jcctv,kondisiCCTV , posisiCCTV);
        Sistem n = new Sistem();
        kls = x.getRuangKelas();
        
//        x.output(kls.getJumlahKipasAngin(),kls.getPosisiKipasAngin(),kls.getKondisiKipasAngin(),kls.getJumlahAC(),
//            kls.getKondisiAC(),kls.getPosisiAC(),kls.getSSID(),kls.getBandwidth(),kls.getJumlahCCTV(),
//            kls.getKondisiCCTV(),kls.getPosisiCCTV());
//       
       // n.persentaseKondisiSarana();
         n.CheckKondisiSarana2(kls,IDKelas.getText());
         dispose();
         x.inputKondisiLingkungan(IDKelas.getText());
        
    }//GEN-LAST:event_NextActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        kondisiklik(true);
        da.kondisiHapus("jkp_sarana2","id_sarana2",CODE.getText());
        clearTEXT();
        Enable_TextField2(false);
        Enable_TextField1(false);
        Next.setVisible(false);
        Delete.setVisible(false);
        Edit.setVisible(false);
        
        tampilDataKeTabel();
        Add.setVisible(true);
//        try{
//            String Sql = "Select id from jkp_sarana2 ";
//            Statement St = con.config.getConnection().createStatement();
//            ResultSet Set = St.executeQuery(Sql);
//            
//            while (Set.next()) {
//                String kolom14 = Set.getString("id");
//                if(kolom14.equalsIgnoreCase(IDKelas.getText())){
//                    Add.setVisible(false);
//                    System.out.println("asd");
//                    break;
//                }
//                else if(kolom14.equalsIgnoreCase(null)){
//                    Add.setVisible(true);
//                    System.out.println("goood");
//                }
//            }
//         }
//        catch(SQLException e){
//            JOptionPane.showMessageDialog(null, "Koneksi gagal : "+e);
//        }
//        jka.setText(null);
//        pkab.setText(null);
//        pkar.setText(null);
//        kkab.setText(null);
//        kkar.setText(null);
//        jac.setText(null);
//        kacb.setText(null);
//        kacr.setText(null);
//        pacb.setText(null);
//        pacs.setText(null);
//        pacd.setText(null);
//        ssid.setAction(null);
//        bb.setText(null);
//        bt.setText(null);
//        jcctv.setText(null);
//        kcctvb.setText(null);
//        kcctvr.setText(null);
//        pcctvb.setText(null);
//        pcctvr.setText(null);
    }//GEN-LAST:event_DeleteActionPerformed

    private void pcctvrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcctvrActionPerformed
        pcctvr.setText("");
    }//GEN-LAST:event_pcctvrActionPerformed

    private void pcctvbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcctvbActionPerformed
        pcctvb.setText("");
    }//GEN-LAST:event_pcctvbActionPerformed

    private void kcctvrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kcctvrActionPerformed
        kcctvr.setText("");
    }//GEN-LAST:event_kcctvrActionPerformed

    private void kcctvbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kcctvbActionPerformed
        kcctvb.setText("");
    }//GEN-LAST:event_kcctvbActionPerformed

    private void kacrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kacrActionPerformed
        kacr.setText("");
    }//GEN-LAST:event_kacrActionPerformed

    private void kacbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kacbActionPerformed
        kacb.setText("");
    }//GEN-LAST:event_kacbActionPerformed

    private void pacdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacdActionPerformed
        pacd.setText("");
    }//GEN-LAST:event_pacdActionPerformed

    private void pacsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacsActionPerformed
        pacs.setText("");
    }//GEN-LAST:event_pacsActionPerformed

    private void pacbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacbActionPerformed
        pacb.setText("");
    }//GEN-LAST:event_pacbActionPerformed

    private void kkarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kkarActionPerformed
        kkar.setText("");
    }//GEN-LAST:event_kkarActionPerformed

    private void kkabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kkabActionPerformed
        kkab.setText("");
    }//GEN-LAST:event_kkabActionPerformed

    private void pkarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pkarActionPerformed
        pkar.setText("");
    }//GEN-LAST:event_pkarActionPerformed

    private void pkabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pkabActionPerformed
        pkab.setText("");
    }//GEN-LAST:event_pkabActionPerformed

    private void jkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jkaActionPerformed

    }//GEN-LAST:event_jkaActionPerformed

    private void jacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jacActionPerformed

    private void jcctvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcctvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcctvActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        bb.setSelected(false);
    }//GEN-LAST:event_btActionPerformed

    private void bbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbActionPerformed
        bt.setSelected(false);
    }//GEN-LAST:event_bbActionPerformed

    private void ssidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ssidActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
           IO x = new IO(jka,pkab,pkar,kkab,kkar,jac,pacs,pacd,pacb,kacb,kacr,ssid,bb,bt,jcctv,kcctvb,kcctvr,pcctvb,pcctvr);
        kls = x.getRuangKelas();
        System.out.println(""+IDKelas.getText()+jka.getText()+kls.getPosisiKipasAngin()+kls.getKondisiKipasAngin()+jac.getText()+kls.getPosisiAC()+kls.getKondisiAC()+ssid.getText()+kls.getBandwidth()+jcctv.getText()+kls.getKondisiCCTV()+kls.getPosisiCCTV());
        /////////String KodeR,JTextField jka,String pka,String kka,JTextField jac,String pac,String kac,JTextField ssid,String bw,JTextField jcctv,String kcctv,String pcctv
       //////////String KodeR,JTextField jka,String pka,String kka,JTextField jac,String pac,String kac,JTextField ssid,String bw,JTextField jcctv,String kcctv,String pcctv){
        
        da.Save(IDKelas.getText(),jka,kls.getPosisiKipasAngin(),kls.getKondisiKipasAngin(),jac,kls.getPosisiAC(),kls.getKondisiAC(),ssid,kls.getBandwidth(),jcctv,kls.getKondisiCCTV(),kls.getPosisiCCTV());
        tampilDataKeTabel();
        Save.setVisible(false);
        Add.setVisible(true);
        clearTEXT();
        kondisiklik(true);
        Next.setVisible(false);
//        jka.setEnabled(false);
//        pkab.setEnabled(false);
//        pkar.setEnabled(false);
//        kkab.setEnabled(false);
//        kkar.setEnabled(false);
//        pacs.setEnabled(false);
//        pacd.setEnabled(false);
//        pacb.setEnabled(false);
//        kacb.setEnabled(false);
//        kacr.setEnabled(false);
//       
//        kcctvb.setEnabled(false);
//        kcctvr.setEnabled(false);
//        pcctvb.setEnabled(false);
//        pcctvr.setEnabled(false);
        Enable_TextField2(false);
        Enable_TextField1(false);
        jTable1.enable(true);
        try{
            String Sql = "Select id from jkp_sarana2 ";
            Statement St = con.config.getConnection().createStatement();
            ResultSet Set = St.executeQuery(Sql);
            
            while (Set.next()) {
                String kolom12 = Set.getString("id");
                if(kolom12.equalsIgnoreCase(IDKelas.getText())){
                    Add.setVisible(false);
                    break;
                }
                else{
                    Add.setVisible(true);
                    
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

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        kondisiklik(true);
        jka.setEditable(true);
        jac.setEditable(true);
        jcctv.setEditable(true);
        jcctv.setEnabled(true);    
        jka.setEnabled(true);
        pkab.setEnabled(true);
        pkar.setEnabled(true);
        kkab.setEnabled(true);
        kkar.setEnabled(true);
        jac.setEnabled(true);
        pacs.setEnabled(true);
        pacd.setEnabled(true);
        pacb.setEnabled(true);
        kacb.setEnabled(true);
        kacr.setEnabled(true);
      
        ssid.setEnabled(true);
        bb.setEnabled(true);
        bt.setEnabled(true);
        kcctvb.setEnabled(true);
        kcctvr.setEnabled(true);
        pcctvb.setEnabled(true);
        pcctvr.setEnabled(true);
        clearTEXT();
        Save.setVisible(true);
        Edit.setVisible(false);
        Delete.setVisible(false);
        Add.setVisible(false);
        Next.setVisible(false);
        jTable1.enable(false);
    }//GEN-LAST:event_AddActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
                btnSelesai.setVisible(DiEdit());
        jTable1.enable(true);
        clearTEXT();
         try{String Sql = "Select id from jkp_sarana2 ";
            Statement St = con.config.getConnection().createStatement();
            ResultSet Set = St.executeQuery(Sql);
            
            while (Set.next()) {
                String kolom12 = Set.getString("id");
                if(kolom12.equalsIgnoreCase(IDKelas.getText())){
                    Add.setVisible(false);
                    break;
                }
                else{
                    Add.setVisible(true);
                    
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
        jka.setEnabled(false);
        pkab.setEnabled(false);
        pkar.setEnabled(false);
        kkab.setEnabled(false);
        kkar.setEnabled(false);
        pacs.setEnabled(false);
        pacd.setEnabled(false);
        pacb.setEnabled(false);
        kacb.setEnabled(false);
        kacr.setEnabled(false);
       
        kcctvb.setEnabled(false);
        kcctvr.setEnabled(false);
        pcctvb.setEnabled(false);
        pcctvr.setEnabled(false);
        
        jac.setEnabled(false);
        ssid.setEnabled(false);
        bb.setEnabled(false);
        bt.setEnabled(false);
        jcctv.setEnabled(false);
        Delete.setVisible(false);
        Add.setVisible(false);
        Edit.setVisible(false);
        Next.setVisible(false);
        jTable1.enable(true);
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void IDKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDKelasActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
            kondisiklik(true);
        clearTEXT2();
            jka.setEditable(true);
            jac.setEditable(true);
            jcctv.setEditable(true);
            
        Enable_TextField1(false);
        btnSelesai.setVisible(true);
        bb.setEnabled(true);
        bt.setEnabled(true);
        jka.setEnabled(true);
        
        pkab.setEnabled(true);
        pkar.setEnabled(true);
        kkab.setEnabled(true);
        kkar.setEnabled(true);
        pacs.setEnabled(true);
        pacd.setEnabled(true);
        pacb.setEnabled(true);
        kacb.setEnabled(true);
        kacr.setEnabled(true);
       
        kcctvb.setEnabled(true);
        kcctvr.setEnabled(true);
        pcctvb.setEnabled(true);
        pcctvr.setEnabled(true);
        Delete.setVisible(false);
        Add.setVisible(false);
        Edit.setVisible(false);
        Next.setVisible(false);
        jTable1.enable(false);
    }//GEN-LAST:event_EditActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        klikTabel(Tabelku);
        //kontak.setEnabled(false);
        pkab.setEnabled(false);
        pkar.setEnabled(false);
        kkab.setEnabled(false);
        kkar.setEnabled(false);
        pacs.setEnabled(false);
        pacd.setEnabled(false);
        pacb.setEnabled(false);
        kacb.setEnabled(false);
        kacr.setEnabled(false);
       
        kcctvb.setEnabled(false);
        kcctvr.setEnabled(false);
        pcctvb.setEnabled(false);
        pcctvr.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(KondisiSarana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KondisiSarana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KondisiSarana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KondisiSarana2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KondisiSarana2("4").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField CODE;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField IDKelas;
    private javax.swing.JButton Next;
    private javax.swing.JButton Save;
    private javax.swing.JCheckBox bb;
    private javax.swing.JCheckBox bt;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jac;
    private javax.swing.JTextField jcctv;
    private javax.swing.JTextField jka;
    private javax.swing.JTextField kacb;
    private javax.swing.JTextField kacr;
    private javax.swing.JTextField kcctvb;
    private javax.swing.JTextField kcctvr;
    private javax.swing.JTextField kkab;
    private javax.swing.JTextField kkar;
    private javax.swing.JTextField kondisiAC;
    private javax.swing.JTextField kondisiCCTV;
    private javax.swing.JTextField kondisiKA;
    private javax.swing.JLabel lbl_acb;
    private javax.swing.JLabel lbl_acbaik;
    private javax.swing.JLabel lbl_acd;
    private javax.swing.JLabel lbl_acrsk;
    private javax.swing.JLabel lbl_acs;
    private javax.swing.JLabel lbl_ar;
    private javax.swing.JLabel lbl_kab;
    private javax.swing.JLabel lbl_kar;
    private javax.swing.JLabel lbl_kcb;
    private javax.swing.JLabel lbl_kcr;
    private javax.swing.JLabel lbl_pcdb;
    private javax.swing.JLabel lbl_pcs;
    private javax.swing.JLabel lbl_sr;
    private javax.swing.JTextField pacb;
    private javax.swing.JTextField pacd;
    private javax.swing.JTextField pacs;
    private javax.swing.JTextField pcctvb;
    private javax.swing.JTextField pcctvr;
    private javax.swing.JTextField pkab;
    private javax.swing.JTextField pkar;
    private javax.swing.JTextField posisiAC;
    private javax.swing.JTextField posisiCCTV;
    private javax.swing.JTextField posisiKA;
    private javax.swing.JTextField ssid;
    // End of variables declaration//GEN-END:variables
}
