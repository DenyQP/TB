/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
proses saving 
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
public class KondisiKenyamanan extends javax.swing.JFrame {

    /**
     * Creates new form KondisiKenyamanan
     */
    RuangKelas kls = new RuangKelas();
    int s = 0, ts = 0, kondisi;
    DatabaseWork da = new DatabaseWork();
    private Integer baris;
    private Connect con = new Connect();
    private JTable Tabelku = new JTable();
    private DefaultTableModel DefaultTabelku;
    private TableColumn kolom;
    private String b,c,d,e,f,g,h,i;
    private String a,E,F,G,H,I;
    private String kode;
    void KondisiAddButton(){
         try{
            String Sql = "Select id from kenyamanan ";
            Statement St = con.config.getConnection().createStatement();
            ResultSet Set = St.executeQuery(Sql);
            
            while (Set.next()) {
                String kolom12 = Set.getString("id");
                if(kolom12.equalsIgnoreCase(IDKelas.getText())){
                    ADD.setVisible(false);
                    //System.out.println(""+IDKelas.getText());
                    break;
                }
                else{
                    ADD.setVisible(true);
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
    void SliderEnable(boolean X){
        Sbising.setEnabled(X);
        Sbau.setEnabled(X);
        Saus.setEnabled(X);
    }
    void cekbok(boolean a){
                    BBanyak.setSelected(a);
                    BSedang.setSelected(a);
                    BSedikit.setSelected(a);
                    BNon.setSelected(a);
                    RBanyak.setSelected(a);
                    RSedang.setSelected(a);
                    RSedikit.setSelected(a);
                    RNon.setSelected(a);
    }
    void cekbokenable(boolean a){
                    BBanyak.setEnabled(a);
                    BSedang.setEnabled(a);
                    BSedikit.setEnabled(a);
                    BNon.setEnabled(a);
                    RBanyak.setEnabled(a);
                    RSedang.setEnabled(a);
                    RSedikit.setEnabled(a);
                    RNon.setEnabled(a);
    }
    public KondisiKenyamanan(String KR) {
        initComponents();
        IDKelas.setText(KR);
        IDKelas.setEditable(false);
        FakeBocor.setVisible(false);
        FakeRusak.setVisible(false);
        setResizable(false);
        PAus.setEditable(false);
        PBau.setEditable(false);
        PBising.setEditable(false);
        SliderEnable(false);
        setResizable(false);
        
        PersenAus.setEditable(false);
        PersenBau.setEditable(false);
        PersenBising.setEditable(false);
        FakeAus.setVisible(false);
        FakeBau.setVisible(false);
        FakeBising.setVisible(false);
        nyeret1();
        nyeret2();
        nyeret3();
        PersenAus.setText(null);
        PersenBau.setText(null);
        PersenBising.setText(null);
        cekbokenable(false);
        Save.setVisible(false);
        Ln.setVisible(false);
        btnSelesai.setVisible(false);
        
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
    public void nyeret1(){
                PersenBising.setEditable(false);	
	        PersenBising.setText(String.valueOf(Sbising.getValue()));	
	        Sbising.setMinorTickSpacing(5);	
	        Sbising.setMajorTickSpacing(20);	
	        Sbising.setPaintTicks(true);	
	        Sbising.setLabelTable(Sbising.getLabelTable());	
	        Sbising.setPaintLabels(true);
                Sbising.addChangeListener (	
	            new ChangeListener() {	 
	                public void stateChanged (ChangeEvent e) {	
	                    PersenBising.setText ( String.valueOf(Sbising.getValue()) );
                            int PBs = Integer.parseInt(PersenBising.getText());
                            if(PBs>=80){
                                PBising.setText("Sangat Bising");
                            }
                            else if(PBs<80&&PBs>=60){
                                PBising.setText("Bising");
                            }
                            else if(PBs<60&&PBs>=30){
                                PBising.setText("Sedikit Bising");
                            }
                            else if(PBs<30&&PBs>=10){
                                PBising.setText("Tidak Bising");
                            }
                            else if(PBs<10){
                                PBising.setText("Sepi/Tenang");
                            }
                        }	
	            }
	        );
    }
     public void nyeret2(){
                PersenBau.setEditable(false);	
	        PersenBau.setText(String.valueOf(Sbau.getValue()));	
	        Sbau.setMinorTickSpacing(5);	
	        Sbau.setMajorTickSpacing(20);	
	        Sbau.setPaintTicks(true);	
	        Sbau.setLabelTable(Sbau.getLabelTable());	
	        Sbau.setPaintLabels(true);
	        Sbau.addChangeListener (	
	            new ChangeListener() {	 
	                public void stateChanged (ChangeEvent e) {	
	                    PersenBau.setText ( String.valueOf(Sbau.getValue()) );	
                            int PBa = Integer.parseInt(PersenBau.getText());
                            if(PBa>=80){
                                PBau.setText("Sangat Bau");
                            }
                            else if(PBa<80&&PBa>=60){
                                PBau.setText("Bau");
                            }
                            else if(PBa<60&&PBa>=30){
                                PBau.setText("Sedikit Bau");
                            }
                            else if(PBa<30&&PBa>=10){
                                PBau.setText("Tidak Bau");
                            }
                            else if(PBa<10){
                                PBau.setText("Wangi");
                            }
                        }	
	            }
	        );
     }
     public void nyeret3(){
         PersenAus.setEditable(false);	
	        PersenAus.setText(String.valueOf(Saus.getValue()));	
	        Saus.setMinorTickSpacing(5);	
	        Saus.setMajorTickSpacing(20);	
	        Saus.setPaintTicks(true);	
	        Saus.setLabelTable(Saus.getLabelTable());	
	        Saus.setPaintLabels(true);
	        Saus.addChangeListener (	
	            new ChangeListener() {	 
	                public void stateChanged (ChangeEvent e) {	
	                    PersenAus.setText ( String.valueOf(Saus.getValue()) );	
                            int PA = Integer.parseInt(PersenAus.getText());
                            if(PA>=80){
                                PAus.setText("Sangat Aus");
                            }
                            else if(PA<80&&PA>=60){
                                PAus.setText("Aus");
                            }
                            else if(PA<60&&PA>=30){
                                PAus.setText("Sedikit Aus");
                            }
                            else if(PA<30){
                                PAus.setText("Tidak Aus");
                            }
                        }	
	            }
	        );
     }
private boolean DiEdit() {
        boolean nilai = false;
        IO x = new IO(PBising,PersenBising,PBau,PersenBau,PAus,PersenAus,BBanyak, BSedang, BSedikit, BNon, RBanyak, RSedang, RSedikit, RNon); 
        Sistem n = new Sistem();
        kls = x.getRuangKelas();
        a = kls.getKebisingan();
        b = kls.getBau();
        c = kls.getKebocoran();
        d = kls.getKerusakan();
        e = kls.getKeausan();       
       
       try {
            if (a.equals("") || b.equals("") || c.equals("")|| d.equals("")|| e.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                nilai=true;
                clearTEXT();
             
            } else {System.out.println(CODE.getText());
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                       
                     "update kenyamanan set "
                        + "bising=" + "'" + a + "', "
                        + "bau=" + "'" + b + "', "
                        + "bocor=" + "'" + c + "', "
                        + "rusak=" + "'" + d + "', " 
                        + "aus=" + "'" + e + "' "
                        + "where id_kenyamanan ='" + CODE.getText() 
//                        +" and " +"kokoh=" + "'" + d + "' "+"and "
//                                + "kunci=" + "'" + e + "' "+"and "
//                                + "bahaya=" + "'" + f 
                                +"'");
                tampilDataKeTabel();
                JOptionPane.showMessageDialog(this, "Data berhasil diperbaharui");
                nilai=false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal diperbaharui! : " + ex);
        }
       return nilai;
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
        if(IDKelas.getText().equals(kolom8)){
            PBising.setText(kolom2);
            PAus.setText(kolom3);
            PBau.setText(kolom4);
            PersenAus.setText(null);
            PersenBau.setText(null);
            PersenBising.setText(null);
                if("Sangat Parah".equalsIgnoreCase(kolom5)){
                    BBanyak.setSelected(true);
                    BSedang.setSelected(false);
                    BSedikit.setSelected(false);
                    BNon.setSelected(false);
                }
                else if("Parah".equalsIgnoreCase(kolom5)){
                    BBanyak.setSelected(false);
                    BSedang.setSelected(true);
                    BSedikit.setSelected(false);
                    BNon.setSelected(false);
                }
                else if("Tidak Begitu Parah".equalsIgnoreCase(kolom5)){
                    BBanyak.setSelected(false);
                    BSedang.setSelected(false);
                    BSedikit.setSelected(true);
                    BNon.setSelected(false);
                }
                else if("Keadaan Baik".equalsIgnoreCase(kolom5)){
                    BBanyak.setSelected(false);
                    BSedang.setSelected(false);
                    BSedikit.setSelected(false);
                    BNon.setSelected(true);
                }
                if("Sangat Parah".equalsIgnoreCase(kolom4)){
                    RBanyak.setSelected(true);
                    RSedang.setSelected(false);
                    RSedikit.setSelected(false);
                    RNon.setSelected(false);
                }
                else if("Parah".equalsIgnoreCase(kolom4)){
                    RBanyak.setSelected(false);
                    RSedang.setSelected(true);
                    RSedikit.setSelected(false);
                    RNon.setSelected(false);
                }
                else if("Tidak Begitu Parah".equalsIgnoreCase(kolom4)){
                    RBanyak.setSelected(false);
                    RSedang.setSelected(false);
                    RSedikit.setSelected(true);
                    RNon.setSelected(false);
                }
                else if("Keadaan Baik".equalsIgnoreCase(kolom4)){
                    RBanyak.setSelected(false);
                    RSedang.setSelected(false);
                    RSedikit.setSelected(false);
                    RNon.setSelected(true);
                }
              cekbokenable(false);
        FakeBising.setText(kolom2);
        FakeAus.setText(kolom3);
        FakeBau.setText(kolom4);
        FakeBocor.setText(kolom5);
        FakeRusak.setText(kolom6);
        Sbising.setEnabled(false);
        Sbau.setEnabled(false);
        Saus.setEnabled(false);
        CODE.setText(kolom7);
       // System.out.println(""+CODE.getText());
        Delete.setVisible(true);
        Edit.setVisible(true);
        Save.setVisible(false);
        Ln.setVisible(true);
        btnSelesai.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "ID KELAS BERBEDA");
            Delete.setVisible(false);
            Edit.setVisible(false);
            Save.setVisible(false);
            btnSelesai.setVisible(false);
            Ln.setVisible(false);
            //ADD.setVisible(true);
        }
    }
    private void tableModel(JTable jTabel1) {
        try {
            Object[] field = {"No", "Kebisingan", "Bau", "Kebocoran", "Kerusakan","Keausan","id","ID RUANG"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from kenyamanan";
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);
            KondisiAddButton();
            int no = 0;
            while (set.next()) {
                no++;
                String kolom1 = String.valueOf(no).toString();
                String kolom2 = set.getString("bising");
                String k3 = set.getString("bau");
//                String kolom3 = Integer.toString(k3);
                String k4 = set.getString("bocor");
//                String kolom4 = Integer.toString(k4);
                String k5 = set.getString("rusak");
//                String kolom5 = Integer.toString(k5);
                String kolom6 = set.getString("aus");
                String kolom7 = set.getString("id_kenyamanan");
                String kolom8 = set.getString("id");
                String[] data = {kolom1, kolom2, k3, k4, k5, kolom6,kolom7,kolom8};
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
            kolom.setPreferredWidth(200);
            
            kolom = jTabel1.getColumnModel().getColumn(6);
            kolom.setPreferredWidth(0);
            kolom.setMinWidth(0);
            kolom.setMaxWidth(0);
            kolom.setWidth(0);
           
            kolom = jTabel1.getColumnModel().getColumn(7);
            kolom.setPreferredWidth(200);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    void clearTEXT() {
        
        
        PersenAus.setText(null);
       PersenBau.setText(null);
       PersenBising.setText(null);
       PAus.setText(null);
       PBising.setText(null);
       PBau.setText(null);
       BBanyak.setSelected(false);
       BSedang.setSelected(false);
       BSedikit.setSelected(false);
       BNon.setSelected(false);
       RBanyak.setSelected(false);
       RSedang.setSelected(false);
       RSedikit.setSelected(false);
       RNon.setSelected(false); 
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

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Sbau = new javax.swing.JSlider();
        Sbising = new javax.swing.JSlider();
        BBanyak = new javax.swing.JCheckBox();
        BSedang = new javax.swing.JCheckBox();
        BSedikit = new javax.swing.JCheckBox();
        BNon = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        RBanyak = new javax.swing.JCheckBox();
        RSedang = new javax.swing.JCheckBox();
        RSedikit = new javax.swing.JCheckBox();
        RNon = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        Saus = new javax.swing.JSlider();
        PersenBising = new javax.swing.JTextField();
        PersenBau = new javax.swing.JTextField();
        PersenAus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PBising = new javax.swing.JTextField();
        PBau = new javax.swing.JTextField();
        PAus = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Ln = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        btnSelesai = new javax.swing.JButton();
        FakeBising = new javax.swing.JTextField();
        FakeBau = new javax.swing.JTextField();
        FakeAus = new javax.swing.JTextField();
        CODE = new javax.swing.JTextField();
        FakeBocor = new javax.swing.JTextField();
        FakeRusak = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        IDKelas = new javax.swing.JTextField();

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Apakah Bangunan Masih Kokoh ? ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Apakah Ada Kunci Pintu dan Jendela ?");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Apakah Ruangan Tidak Berbahaya ? ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("KENYAMANAN RUANG KELAS");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Persentase Kebisingan Kelas                : ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Presentase Bau di Kelas                       : ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Kebocoran dalam Kelas                        :");

        BBanyak.setText("Banyak");
        BBanyak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBanyakActionPerformed(evt);
            }
        });

        BSedang.setText("Sedang");
        BSedang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSedangActionPerformed(evt);
            }
        });

        BSedikit.setText("Sedikit");
        BSedikit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSedikitActionPerformed(evt);
            }
        });

        BNon.setText("Tidak Ada");
        BNon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNonActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Kerusakan  dalam Kelas                        :");

        RBanyak.setText("Banyak");
        RBanyak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBanyakActionPerformed(evt);
            }
        });

        RSedang.setText("Sedang");
        RSedang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RSedangActionPerformed(evt);
            }
        });

        RSedikit.setText("Sedikit");
        RSedikit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RSedikitActionPerformed(evt);
            }
        });

        RNon.setText("Tidak Ada");
        RNon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RNonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Persentase Keausan Permukaan Kelas  :");

        PersenBising.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        PersenBau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PersenBau.setText(" ");
        PersenBau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersenBauActionPerformed(evt);
            }
        });

        PersenAus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("%");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("%");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("%");

        PBising.setText("Parameter");

        PBau.setText("Parameter");

        PAus.setText("Parameter");
        PAus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PAusActionPerformed(evt);
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Ln.setText("Selanjutnya");
        Ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LnActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(Delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Save)
                .addGap(10, 10, 10)
                .addComponent(Edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Ln)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Edit)
                    .addComponent(Save)
                    .addComponent(Delete)
                    .addComponent(Ln)
                    .addComponent(ADD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Klik jika selesai edit");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        FakeBising.setText("jTextField1");

        FakeBau.setText("jTextField2");

        FakeAus.setText("jTextField3");

        CODE.setText("jTextField1");

        FakeBocor.setText("jTextField1");

        FakeRusak.setText("jTextField2");

        jLabel16.setText("ID RUANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(341, 341, 341)
                        .addComponent(PersenAus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(100, 100, 100)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14))
                            .addGap(49, 49, 49)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(BBanyak)
                                    .addGap(18, 18, 18)
                                    .addComponent(BSedang)
                                    .addGap(18, 18, 18)
                                    .addComponent(BSedikit)
                                    .addGap(18, 18, 18)
                                    .addComponent(BNon)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(FakeBocor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(Saus, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(PBau, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addComponent(FakeBau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(PAus, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(FakeAus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(PBising, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(FakeBising, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(RBanyak)
                                        .addGap(18, 18, 18)
                                        .addComponent(RSedang)
                                        .addGap(18, 18, 18)
                                        .addComponent(RSedikit)
                                        .addGap(18, 18, 18)
                                        .addComponent(RNon)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(FakeRusak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Sbau, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Sbising, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(21, 21, 21)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PersenBau, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PersenBising, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(Sbising, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PersenBising, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PBising, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FakeBising, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sbau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PersenBau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PBau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FakeBau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(PersenAus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Saus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PAus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FakeAus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(BBanyak)
                    .addComponent(BSedang)
                    .addComponent(BSedikit)
                    .addComponent(BNon)
                    .addComponent(FakeBocor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(RBanyak)
                    .addComponent(RSedang)
                    .addComponent(RSedikit)
                    .addComponent(RNon)
                    .addComponent(FakeRusak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(btnSelesai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PersenBauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersenBauActionPerformed
       
    }//GEN-LAST:event_PersenBauActionPerformed

    private void PAusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PAusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PAusActionPerformed

    private void BBanyakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBanyakActionPerformed
        BSedang.setSelected(false);
        BSedikit.setSelected(false);
        BNon.setSelected(false);
    }//GEN-LAST:event_BBanyakActionPerformed

    private void BSedangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSedangActionPerformed
        BBanyak.setSelected(false);
        BSedikit.setSelected(false);
        BNon.setSelected(false);
    }//GEN-LAST:event_BSedangActionPerformed

    private void BSedikitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSedikitActionPerformed
        BBanyak.setSelected(false);
        BSedang.setSelected(false);
        BNon.setSelected(false);
    }//GEN-LAST:event_BSedikitActionPerformed

    private void BNonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNonActionPerformed
        BBanyak.setSelected(false);
        BSedang.setSelected(false);
        BSedikit.setSelected(false);
    }//GEN-LAST:event_BNonActionPerformed

    private void RBanyakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBanyakActionPerformed
       RSedang.setSelected(false);
       RSedikit.setSelected(false);
       RNon.setSelected(false);               
    }//GEN-LAST:event_RBanyakActionPerformed

    private void RSedangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RSedangActionPerformed
       RBanyak.setSelected(false);
       RSedikit.setSelected(false);
       RNon.setSelected(false); 
    }//GEN-LAST:event_RSedangActionPerformed

    private void RSedikitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RSedikitActionPerformed
       RBanyak.setSelected(false);
       RSedang.setSelected(false);
       RNon.setSelected(false); 
    }//GEN-LAST:event_RSedikitActionPerformed

    private void RNonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RNonActionPerformed
       RBanyak.setSelected(false);
       RSedang.setSelected(false);
       RSedikit.setSelected(false);
    }//GEN-LAST:event_RNonActionPerformed
    //JTextField Bising,JTextField PersenBising,JTextField Bau,JTextField PersenBau,JTextField Aus,JTextField PersenAus
    private void LnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LnActionPerformed
        IO x = new IO(PBising,PersenBising,PBau,PersenBau,PAus,PersenAus,BBanyak, BSedang, BSedikit, BNon, RBanyak, RSedang, RSedikit, RNon);
        Sistem n = new Sistem();
        kls = x.getRuangKelas();
        //String Kebisingan, String Bau, String Kebocoran, String Kerusakan, String Keausan, String x
        x.output(kls.getKebisingan(),kls.getBau(),kls.getKebocoran(),kls.getKerusakan(),kls.getKerusakan(),null);
        n.CheckKondisiKenyamanan(kls,IDKelas.getText());
        dispose();
        x.inputKondisiKeamanan(IDKelas.getText());
    }//GEN-LAST:event_LnActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        IO x = new IO(PBising,PersenBising,PBau,PersenBau,PAus,PersenAus,BBanyak, BSedang, BSedikit, BNon, RBanyak, RSedang, RSedikit, RNon);
        kls = x.getRuangKelas();
        da.Save(IDKelas.getText(),PBising,PBau,PAus,kls.getKebocoran(),kls.getKerusakan() );
        tampilDataKeTabel();
        Save.setVisible(false);
        //ADD.setVisible(true);
        clearTEXT();
        Ln.setVisible(false);
        SliderEnable(false);
        cekbok(false);
        cekbokenable(false);
        jTable1.enable(true);
    }//GEN-LAST:event_SaveActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        da.kondisiHapus("kenyamanan","id_kenyamanan",CODE.getText());
        clearTEXT();
        Ln.setVisible(false);
        Delete.setVisible(false);
        Edit.setVisible(false);
        tampilDataKeTabel();
        cekbok(false);
        cekbokenable(false);
        SliderEnable(false);
                ADD.setVisible(true);

    }//GEN-LAST:event_DeleteActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        cekbok(true);
        cekbokenable(true);
        SliderEnable(true);
        clearTEXT();
        Save.setVisible(true);
        Edit.setVisible(false);
        Delete.setVisible(false);
        ADD.setVisible(false);
        Ln.setVisible(false);
        jTable1.enable(false);
    }//GEN-LAST:event_ADDActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        btnSelesai.setVisible(true);
        //jTable1.setEnabled(false);
        cekbokenable(true);
        SliderEnable(true);
        Delete.setVisible(false);
        ADD.setVisible(false);
        Edit.setVisible(false);
        Ln.setVisible(false);
        //jTable1.enable(false);
    }//GEN-LAST:event_EditActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        btnSelesai.setVisible(DiEdit());
       // jTable1.setEnabled(true);
        Delete.setVisible(false);
        KondisiAddButton();
        Edit.setVisible(false);
        Ln.setVisible(false);
        cekbok(false);
        cekbokenable(false);
        SliderEnable(false);

    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         klikTabel(Tabelku);
         cekbokenable(false);
         SliderEnable(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MousePressed

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
            java.util.logging.Logger.getLogger(KondisiKenyamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KondisiKenyamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KondisiKenyamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KondisiKenyamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KondisiKenyamanan("4").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JCheckBox BBanyak;
    private javax.swing.JCheckBox BNon;
    private javax.swing.JCheckBox BSedang;
    private javax.swing.JCheckBox BSedikit;
    private javax.swing.JTextField CODE;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField FakeAus;
    private javax.swing.JTextField FakeBau;
    private javax.swing.JTextField FakeBising;
    private javax.swing.JTextField FakeBocor;
    private javax.swing.JTextField FakeRusak;
    private javax.swing.JTextField IDKelas;
    private javax.swing.JButton Ln;
    private javax.swing.JTextField PAus;
    private javax.swing.JTextField PBau;
    private javax.swing.JTextField PBising;
    private javax.swing.JTextField PersenAus;
    private javax.swing.JTextField PersenBau;
    private javax.swing.JTextField PersenBising;
    private javax.swing.JCheckBox RBanyak;
    private javax.swing.JCheckBox RNon;
    private javax.swing.JCheckBox RSedang;
    private javax.swing.JCheckBox RSedikit;
    private javax.swing.JSlider Saus;
    private javax.swing.JButton Save;
    private javax.swing.JSlider Sbau;
    private javax.swing.JSlider Sbising;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
