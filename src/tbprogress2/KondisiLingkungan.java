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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Deny SQP
 */
public class KondisiLingkungan extends javax.swing.JFrame {

    /**
     * Creates new form KondisiLingkunga
     */
      
    RuangKelas kls = new RuangKelas();
    int s = 0, ts = 0, kondisi;
    DatabaseWork da = new DatabaseWork();
    private Integer baris;
    private Connect con = new Connect();
    private JTable Tabelku = new JTable();
    private DefaultTableModel DefaultTabelku;
    private TableColumn kolom;
    private int b,c,d,e,f,g,h,i;
    private String a,E,F,G,H,I;
    private String kode;
    
    public KondisiLingkungan(String KR) {
        initComponents();  
        IDKelas.setEditable(false);
        IDKelas.setText(KR);
        SC.setEnabled(false);
        SS.setEnabled(false);
        SL.setEnabled(false);
        setResizable(false);
        PC.setEditable(false);
        PL.setEditable(false);
        PS.setEditable(false);
        PRC.setEditable(false);
        PRL.setEditable(false);
        PSR.setEditable(false);
        nyeret1();
        nyeret2();
        nyeret3();
        
         Save.setVisible(false);
        Next.setVisible(false);
        btnselesai.setVisible(false);
        NP.setVisible(false);
        K.setVisible(false);
        S.setVisible(false);
        SU.setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setResizable(false);
        setTitle("Kondisi Lingkungan");
        con.koneksi();
       tampilDataKeTabel();
       // System.out.println("klololo");
//        enableBtn(false);
//        enviBtnSave(true);
//        enviBtnSave2(false);
//        enviBtnNew(false);
        CODE.setVisible(false);
        Delete.setVisible(false);
        Edit.setVisible(false);
        PC.setEnabled(false);
        PL.setEnabled(false);
        PS.setEnabled(false);
        SUL.setEnabled(false);
        SUT.setEnabled(false);
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
     void KondisiAddButton(){
         try{
            String Sql = "Select id from lingkungan ";
            Statement St = con.config.getConnection().createStatement();
            ResultSet Set = St.executeQuery(Sql);
            
            while (Set.next()) {
                String kolom12 = Set.getString("id");
                if(kolom12.equalsIgnoreCase(IDKelas.getText())){
                    Add.setVisible(false);
                    //System.out.println(""+IDKelas.getText());
                    break;
                }
                else{
                    Add.setVisible(true);
                    //System.out.println(""+IDKelas.getText());
                }
                //System.out.println(""+IDKelas.getText());
              //  String[] data = {kolom1, kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8,kolom9,kolom10,kolom11,kolom12};
                //DefaultTabelku.addRow(data);
            }
         }
         catch(SQLException e){
             JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
         }
     } 
     private boolean DiEdit() {
        boolean nilai = false;
        IO x = new IO(SUL,SUT, PC,PL,PS);
        Sistem n = new Sistem();
        kls = x.getRuangKelas();
        a = kls.getSirkulasiUdara();
        b = kls.getNilaiPencahayaan();
        c = kls.getKelembaban();
        d = kls.getSuhu();
        E = SUL.getText();
        //int e = Integer.parseInt(E);
        F = SUT.getText();
        //int f = Integer.parseInt(F);
        G = NP.getText();
        //int g = Integer.parseInt(G);
        H = K.getText();
        //int h = Integer.parseInt(H);
        I = S.getText();
       // int i = Integer.parseInt(I);System.out.println("iiigg");
       
       try {System.out.println("gnmmg");
            if (PC.getText().equals("") || PL.getText().equals("") || PS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                nilai=true;
                clearTEXT();
             
            } else {System.out.println(CODE.getText());
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                       
                     "update lingkungan set "
                        + "udara=" + "'" + a + "', "
                        + "cahaya=" + "'" + b + "', "
                        + "lembab=" + "'" + c + "', "
                        + "suhu=" + "'" + d + "' "
                        + "where id_lingkungan ='" + CODE.getText() 
//                        +" and " +"kokoh=" + "'" + d + "' "+"and "
//                                + "kunci=" + "'" + e + "' "+"and "
//                                + "bahaya=" + "'" + f 
                                +"'");
                tampilDataKeTabel();//System.out.println("gklg");
                JOptionPane.showMessageDialog(this, "Data berhasil diperbaharui");
                nilai=false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal diperbaharui! : " + ex);
        }
       return nilai;
    }
    private void klikTabel(JTable jTabel) {
          System.out.println("vvv");
        jTabel.setRowSelectionAllowed(true);
          System.out.println("vvqqv");
        baris = jTabel.getSelectedRow();
        String kolom1 = jTabel.getValueAt(baris, 0).toString();
        String kolom2 = jTabel.getValueAt(baris, 1).toString();
        String kolom3 = jTabel.getValueAt(baris, 2).toString();
        String kolom4 = jTabel.getValueAt(baris, 3).toString();
        String kolom5 = jTabel.getValueAt(baris, 4).toString();
        String kolom6 = jTabel.getValueAt(baris, 5).toString();
        String kolom7 = jTabel.getValueAt(baris, 6).toString();
      if(kolom7.equalsIgnoreCase(IDKelas.getText())){
        
            PC.setText(kolom3);
            PL.setText(kolom4);
            PS.setText(kolom5);
            
                if("Lancar".equalsIgnoreCase(kolom2)){
                    SUL.setSelected(true);
                    SUT.setSelected(false);
                }
                else{
                    SUL.setSelected(false);
                    SUT.setSelected(true);
                }
              
        PC.setText(kolom3);
        PL.setText(kolom4);
        PS.setText(kolom5);
        
        PC.setEnabled(false);
        PL.setEnabled(false);
        PS.setEnabled(false);
        CODE.setText(kolom6);
       // System.out.println(""+CODE.getText());
        Delete.setVisible(true);
        Edit.setVisible(true);
        Save.setVisible(false);
        Next.setVisible(true);
      }
      else{
            JOptionPane.showMessageDialog(null, "ID KELAS BERBEDA");
            Delete.setVisible(false);
            Edit.setVisible(false);
            Save.setVisible(false);
            btnselesai.setVisible(false);
            Next.setVisible(false);
            //Add.setVisible(true);
      }
        
    }
    private void tableModel(JTable jTabel1) {
        try {
            Object[] field = {"No", "Sirkulasi Udara", "Pencahayaan", "Kelembaban", "Suhu","id","ID Ruang"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from lingkungan";
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);
            KondisiAddButton();
            int no = 0;
            while (set.next()) {
                no++;
                String kolom1 = String.valueOf(no).toString();
                String kolom2 = set.getString("udara");
                String k3 = set.getString("cahaya");
//                String kolom3 = Integer.toString(k3);
                String k4 = set.getString("lembab");
//                String kolom4 = Integer.toString(k4);
                String k5 = set.getString("suhu");
//                String kolom5 = Integer.toString(k5);
                String kolom6 = set.getString("id_lingkungan");
                String kolom7 = set.getString("id");
                String[] data = {kolom1, kolom2, k3, k4, k5, kolom6,kolom7};
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
            kolom.setPreferredWidth(200);
           
            kolom = jTabel1.getColumnModel().getColumn(5);
            kolom.setPreferredWidth(0);
            kolom.setMinWidth(0);
            kolom.setMaxWidth(0);
            kolom.setWidth(0);
            
            kolom = jTabel1.getColumnModel().getColumn(6);
            kolom.setPreferredWidth(200);
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    void clearTEXT() {
        PC.setText("");
        PL.setText("");
        PS.setText("");
        SUL.setSelected(false);
        SUT.setSelected(false);
    }
     private void tampilDataKeTabel() {
        Tabelku = jTable1;
        tableModel(Tabelku);
    }
    public void nyeret1(){
                PC.setEditable(false);	
	        PC.setText(String.valueOf(SC.getValue()));	
	        SC.setMinorTickSpacing(5);	
	        SC.setMajorTickSpacing(20);	
	        SC.setPaintTicks(true);	
	        SC.setLabelTable(SC.getLabelTable());	
	        SC.setPaintLabels(true);
                SC.addChangeListener (	
	            new ChangeListener() {	 
	                public void stateChanged (ChangeEvent e) {	
	                    PC.setText ( String.valueOf(SC.getValue()) );
                            int PBs = Integer.parseInt(PC.getText());
                            if(PBs>=80){
                                PRC.setText("Sangat Terang");
                            }
                            else if(PBs<80&&PBs>=60){
                                PRC.setText("Terang");
                            }
                            else if(PBs<60&&PBs>=30){
                                PRC.setText("Redup");
                            }
                            else if(PBs<30&&PBs>=10){
                                PRC.setText("Remang Remang");
                            }
                            else if(PBs<10){
                                PRC.setText("Gelap");
                            }
                        }	
	            }
	        );
    }
     public void nyeret2(){
                PL.setEditable(false);	
	        PL.setText(String.valueOf(SL.getValue()));	
	        SL.setMinorTickSpacing(5);	
	        SL.setMajorTickSpacing(20);	
	        SL.setPaintTicks(true);	
	        SL.setLabelTable(SL.getLabelTable());	
	        SL.setPaintLabels(true);
	        SL.addChangeListener (	
	            new ChangeListener() {	 
	                public void stateChanged (ChangeEvent e) {	
	                    PL.setText ( String.valueOf(SL.getValue()) );	
                            int PBa = Integer.parseInt(PL.getText());
                            if(PBa>=80){
                                PRL.setText("Basah");
                            }
                            else if(PBa<80&&PBa>=70){
                                PRL.setText("Lembab");
                            }
                            else if(PBa<70&&PBa>=30){
                                PRL.setText("Biasa");
                            }
                            else if(PBa<30&&PBa>=10){
                                PRL.setText("Agak Kering");
                            }
                            else if(PBa<10){
                                PRL.setText("Kering");
                            }
                        }	
	            }
	        );
     }
     public void nyeret3(){
         PS.setEditable(false);	
	        PS.setText(String.valueOf(SS.getValue()));	
	        SS.setMinorTickSpacing(5);	
	        SS.setMajorTickSpacing(20);	
	        SS.setPaintTicks(true);	
	        SS.setLabelTable(SS.getLabelTable());	
	        SS.setPaintLabels(true);
	        SS.addChangeListener (	
	            new ChangeListener() {	 
	                public void stateChanged (ChangeEvent e) {	
	                    PS.setText ( String.valueOf(SS.getValue()) );	
                            int PA = Integer.parseInt(PS.getText());
                            if(PA>=80){
                                PSR.setText("Mendidih");
                            }
                            else if(PA<80&&PA>=60){
                                PSR.setText("Sangat Panas");
                            }
                            else if(PA<60&&PA>35){
                                PSR.setText("Panas");
                            }
                            else if(PA<=35&&PA>=25){
                                PSR.setText("Hangat");
                            }
                            else if(PA<25&&PA>=10){
                                PSR.setText("Dingin");
                            }
                            else if(PA<10){
                                PSR.setText("Beku");
                            }
                        }	
	            }
	        );
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SC = new javax.swing.JSlider();
        SL = new javax.swing.JSlider();
        SS = new javax.swing.JSlider();
        PRL = new javax.swing.JTextField();
        PRC = new javax.swing.JTextField();
        PC = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PS = new javax.swing.JTextField();
        SUT = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        SUL = new javax.swing.JCheckBox();
        PSR = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnselesai = new javax.swing.JButton();
        NP = new javax.swing.JTextField();
        K = new javax.swing.JTextField();
        S = new javax.swing.JTextField();
        SU = new javax.swing.JTextField();
        CODE = new javax.swing.JTextField();
        IDKelas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Next = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        Edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("LINGKUNGAN RUANG KELAS");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nilai Pencahayaan");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Kelembaban");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Suhu");

        PRL.setText("Parameter");

        PRC.setText("Parameter");

        PC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("%");

        PL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PL.setText(" ");
        PL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PLActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("%");

        PS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SUT.setText("Terhambat");
        SUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUTActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Sirkulasi Udara");

        SUL.setText("Lancar");
        SUL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SULActionPerformed(evt);
            }
        });

        PSR.setText("Parameter");

        jLabel1.setText("o");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("C");

        btnselesai.setText("Selesai");
        btnselesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselesaiActionPerformed(evt);
            }
        });

        NP.setText("jTextField1");

        K.setText("jTextField2");

        S.setText("jTextField3");

        SU.setText("jTextField4");

        CODE.setText("jTextField1");

        jLabel4.setText("ID RUANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PRC, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PRL, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PSR, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(S, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SL, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SC, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PC)
                                    .addComponent(PL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(SUL)
                                    .addGap(34, 34, 34)
                                    .addComponent(SUT)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(btnselesai))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(SU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(SS, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(PS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(PSR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(S, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SUL)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SUT)
                                        .addComponent(SU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(PS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(btnselesai))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

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

        Next.setText("Selanjutnya");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        Delete.setText("Hapus");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
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

        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Add)
                        .addGap(18, 18, 18)
                        .addComponent(Save)
                        .addGap(18, 18, 18)
                        .addComponent(Delete)
                        .addGap(18, 18, 18)
                        .addComponent(Edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Next)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Next)
                    .addComponent(Delete)
                    .addComponent(Save)
                    .addComponent(Add)
                    .addComponent(Edit))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PLActionPerformed

    }//GEN-LAST:event_PLActionPerformed

    private void SUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUTActionPerformed
        SUL.setSelected(false);
        
    }//GEN-LAST:event_SUTActionPerformed

    private void SULActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SULActionPerformed
        SUT.setSelected(false);
        
    }//GEN-LAST:event_SULActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        IO x = new IO(SUL,SUT,PC,PL,PS);
        Sistem n = new Sistem();
        kls = x.getRuangKelas();
        x.output(kls.getSirkulasiUdara(), kls.getNilaiPencahayaan(), kls.getKelembaban(),kls.getSuhu());
        n.CheckKondisiLingkungan(kls,IDKelas.getText());
        dispose();
        x.inputKondisiKenyamanan(IDKelas.getText());
    }//GEN-LAST:event_NextActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        PC.setEditable(true);
        PL.setEditable(true);
        PS.setEditable(true);
        SUL.setEnabled(true);
        SUT.setEnabled(true);
        SC.setEnabled(true);
        SS.setEnabled(true);
        SL.setEnabled(true);
        jTable1.setEnabled(false);
        clearTEXT();
        Save.setVisible(true);
        Edit.setVisible(false);
        Delete.setVisible(false);
        Add.setVisible(false);
        Next.setVisible(false);
    }//GEN-LAST:event_AddActionPerformed

    private void btnselesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselesaiActionPerformed
        btnselesai.setVisible(DiEdit());
        System.out.println("lopo");
        jTable1.enable(true);
        Delete.setVisible(false);
       // Add.setVisible(true);
        Edit.setVisible(false);
        Next.setVisible(false);
         PC.setEditable(false);
        PL.setEditable(false);
        PS.setEditable(false);
        SUL.setEnabled(false);
        SUT.setEnabled(false);  
    }//GEN-LAST:event_btnselesaiActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
         IO x = new IO(SUL,SUT,PC,PL,PS);
        kls = x.getRuangKelas();
        da.Save(IDKelas.getText(),kls.getNilaiPencahayaan(),kls.getKelembaban(),kls.getSuhu(),kls.getSirkulasiUdara());
        tampilDataKeTabel();
        Save.setVisible(false);
        Add.setVisible(false);
        clearTEXT();
        
        PRC.setText(null);
        PRL.setText(null);
        PSR.setText(null);
        Next.setVisible(false);
        SC.setEnabled(false);
        SS.setEnabled(false);
        SL.setEnabled(false);
        SUL.setEnabled(false);
        SUT.setEnabled(false);
        jTable1.setEnabled(true);
    }//GEN-LAST:event_SaveActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        da.kondisiHapus("lingkungan","id_lingkungan",CODE.getText());
        clearTEXT();
        tampilDataKeTabel();
        Delete.setVisible(false);
        Edit.setVisible(false);
        Next.setVisible(false);
        Add.setVisible(true);
    }//GEN-LAST:event_DeleteActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        btnselesai.setVisible(true);
        PC.setEnabled(true);
        PL.setEnabled(true);
        PS.setEnabled(true);
        SUL.setEnabled(true);
        SUT.setEnabled(true);
        Delete.setVisible(false);
        Add.setVisible(false);
        Edit.setVisible(false);
        Next.setVisible(false);
        jTable1.enable(false);
        SL.setEnabled(true);
        SC.setEnabled(true);
        SS.setEnabled(true);
    }//GEN-LAST:event_EditActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        klikTabel(Tabelku);
        PC.setEnabled(false);
        PL.setEnabled(false);
        PS.setEnabled(false);
        SUL.setEnabled(false);
        SUT.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void PCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PCActionPerformed

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
            java.util.logging.Logger.getLogger(KondisiLingkungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KondisiLingkungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KondisiLingkungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KondisiLingkungan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KondisiLingkungan("4").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTextField CODE;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField IDKelas;
    private javax.swing.JTextField K;
    private javax.swing.JTextField NP;
    private javax.swing.JButton Next;
    private javax.swing.JTextField PC;
    private javax.swing.JTextField PL;
    private javax.swing.JTextField PRC;
    private javax.swing.JTextField PRL;
    private javax.swing.JTextField PS;
    private javax.swing.JTextField PSR;
    private javax.swing.JTextField S;
    private javax.swing.JSlider SC;
    private javax.swing.JSlider SL;
    private javax.swing.JSlider SS;
    private javax.swing.JTextField SU;
    private javax.swing.JCheckBox SUL;
    private javax.swing.JCheckBox SUT;
    private javax.swing.JButton Save;
    private javax.swing.JButton btnselesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
