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
 * @author Deny SQP
 */
public class KondisiKeamanan extends javax.swing.JFrame {

    /**
     * Creates new form KondisiKeamanan
     */
    RuangKelas kls = new RuangKelas();
    int s = 0, ts = 0, kondisi;
    DatabaseWork da = new DatabaseWork();
    private Integer baris;
    private Connect con = new Connect();
    private JTable Tabelku = new JTable();
    private DefaultTableModel TabelDasar;
    private TableColumn kol;
    private String a, b,c,d,e,f,g;
    private String C,D,E,F,G,kode;
    KondisiKeamanan(String KR) {
        initComponents();
        
        IDKelas.setText(KR);
        FK.setVisible(false);
        FPJ.setVisible(false);
        FB.setVisible(false);
        Save.setVisible(false);
        HasilAnalisa.setVisible(false);
        btnSelesai.setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setResizable(false);
        setTitle("Keamanan Ruang");
        con.koneksi();
        IDKelas.setEditable(false);
        tampilDataKeTabel();
        KondisiAddButton();
        CODE.setVisible(false);
        Delete.setVisible(false);
        Edit.setVisible(false);
        Kokoh.setEnabled(false);
        Tkokoh.setEnabled(false);
        Adakunci.setEnabled(false);
        Tkunci.setEnabled(false);
        Aman.setEnabled(false);
        Bahaya.setEnabled(false);
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
  
 

  }
    
     void KondisiAddButton(){
         try{
            String Sql = "Select id from keamanan ";
            Statement St = con.config.getConnection().createStatement();
            ResultSet Set = St.executeQuery(Sql);
            
            while (Set.next()) {
                String kol12 = Set.getString("id");
                if(kol12.equalsIgnoreCase(IDKelas.getText())){
                    ADD.setVisible(false);
                    //System.out.println(""+IDKelas.getText());
                    break;
                }
                else{
                    ADD.setVisible(true);
                   
                }
             }
         }
         catch(SQLException e){
             JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
         }
     }
    
     private boolean DiEdit() {
        boolean nilai = false;
        IO x = new IO(Kokoh,Tkokoh,Adakunci,Tkunci,Aman,Bahaya);
        Sistem n = new Sistem();
        kls = x.getRuangKelas();
        a = kls.getKekokohan();
        b = kls.getKunciPintuJendela();
        c = kls.getBahaya();
        d = FK.getText();
        e = FPJ.getText();
        f = FB.getText();
       try {
            if (a.equals("") || b.equals("") || c.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                nilai=true;
                clearTEXT();
             
            } else {
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        
                        "update keamanan set "
                        + "kokoh=" + "'" + a + "', "
                        + "kunci=" + "'" + b + "', "
                        + "bahaya=" + "'" + c + "' "
                        + "where id_keamanan ='" + CODE.getText()+"'");

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
        String kol1 = jTabel.getValueAt(baris, 0).toString();
        String kol2 = jTabel.getValueAt(baris, 1).toString();
        String kol3 = jTabel.getValueAt(baris, 2).toString();
        String kol4 = jTabel.getValueAt(baris, 3).toString();
        String kol5 = jTabel.getValueAt(baris, 4).toString();
        String kol6 = jTabel.getValueAt(baris, 5).toString();
        if(IDKelas.getText().equals(kol6)){
        if("Kokoh".equalsIgnoreCase(kol2)){
            Kokoh.setSelected(true);
            Tkokoh.setSelected(false);
        }
        else if("Rapuh".equalsIgnoreCase(kol2)) {
            Kokoh.setSelected(false);
            Tkokoh.setSelected(true);
        }
            if("Terkunci".equalsIgnoreCase(kol3)){
                Adakunci.setSelected(true);
                Tkunci.setSelected(false);
            }
            else {
                Adakunci.setSelected(false);
                Tkunci.setSelected(true);
            }
                if("Aman".equalsIgnoreCase(kol4)){
                    Bahaya.setSelected(false);
                    Aman.setSelected(true);
                }
                else{
                    Aman.setSelected(false);
                    Bahaya.setSelected(true);
                }
        FK.setText(kol2);
        FPJ.setText(kol3);
        FB.setText(kol4);
        Kokoh.setEnabled(false);
        Tkokoh.setEnabled(false);
        Adakunci.setEnabled(false);
        Tkunci.setEnabled(false);
        Aman.setEnabled(false);
        Bahaya.setEnabled(false);
        CODE.setText(kol5);
       // System.out.println(""+CODE.getText());
        Delete.setVisible(true);
        Edit.setVisible(true);
        Save.setVisible(false);
        HasilAnalisa.setVisible(true);
        //ADD.setVisible(true);
        jTabel.enable(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "ID KELAS BERBEDA");
            Delete.setVisible(false);
            Edit.setVisible(false);
            Save.setVisible(false);
            btnSelesai.setVisible(false);
            HasilAnalisa.setVisible(false);
            //ADD.setVisible(true);
        }
    }
    private void tableModel(JTable jTabel1) {
        try {
            Object[] field = {"No", "Kekokohan", "Kunci Pintu Jendela", "Bahaya", "ID","ID RUANG"};
            TabelDasar = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(TabelDasar);

            String sql = "Select * from keamanan ";
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);
            KondisiAddButton();
            int no = 0;
            while (set.next()) {
                no++;
                String kol1 = String.valueOf(no).toString();
                String kol2 = set.getString("kokoh");
                String kol3 = set.getString("kunci");
                String kol4 = set.getString("bahaya");
                String kol5 = set.getString("id_keamanan");
                String kol6 = set.getString("id");
                String[] data = {kol1, kol2, kol3, kol4, kol5,kol6};
                TabelDasar.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            
            kol = jTabel1.getColumnModel().getColumn(0);
            kol.setPreferredWidth(40);
            kol = jTabel1.getColumnModel().getColumn(1);
            kol.setPreferredWidth(145);
            kol = jTabel1.getColumnModel().getColumn(2);
            kol.setPreferredWidth(217);
            kol = jTabel1.getColumnModel().getColumn(3);
            kol.setPreferredWidth(220);
            kol = jTabel1.getColumnModel().getColumn(4);
            kol.setPreferredWidth(0);
            kol.setMinWidth(0);
            kol.setMaxWidth(0);
            kol.setWidth(0);
             kol = jTabel1.getColumnModel().getColumn(5);
            kol.setPreferredWidth(220);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    void clearTEXT() {
        Kokoh.setSelected(false);
            Tkokoh.setSelected(false);
            Adakunci.setSelected(false);
            Tkunci.setSelected(false);
            Bahaya.setSelected(false);
            Aman.setSelected(false);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Kokoh = new javax.swing.JCheckBox();
        Tkokoh = new javax.swing.JCheckBox();
        Adakunci = new javax.swing.JCheckBox();
        Tkunci = new javax.swing.JCheckBox();
        Aman = new javax.swing.JCheckBox();
        Bahaya = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        CODE = new javax.swing.JTextField();
        btnSelesai = new javax.swing.JButton();
        FK = new javax.swing.JTextField();
        FPJ = new javax.swing.JTextField();
        FB = new javax.swing.JTextField();
        IDKelas = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Delete = new javax.swing.JButton();
        HasilAnalisa = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Edit = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Panjang Ruang :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lebar Ruang     :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Jumlah Kursi     :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Jumlah Pintu    :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Jumlah Jendela :");

        jCheckBox5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox5.setText("Ada");

        jCheckBox6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox6.setText("Tidak Ada");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("KEAMANAN RUANG KELAS");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Apakah Bangunan Masih Kokoh ? ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Apakah Ada Kunci Pintu dan Jendela ?");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Apakah Ruangan Tidak Berbahaya ? ");

        Kokoh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Kokoh.setText("Kokoh");
        Kokoh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KokohActionPerformed(evt);
            }
        });

        Tkokoh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tkokoh.setText("Tidak Kokoh");
        Tkokoh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TkokohActionPerformed(evt);
            }
        });

        Adakunci.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Adakunci.setText("Ada");
        Adakunci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdakunciActionPerformed(evt);
            }
        });

        Tkunci.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tkunci.setText("Tidak Ada");
        Tkunci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TkunciActionPerformed(evt);
            }
        });

        Aman.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Aman.setText("Aman");
        Aman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmanActionPerformed(evt);
            }
        });

        Bahaya.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Bahaya.setText("Berbahaya");
        Bahaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BahayaActionPerformed(evt);
            }
        });

        jButton1.setText("Selanjutnya");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Keadaan Baik Semua");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Klik jika selesai edit");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        FK.setText("jTextField1");

        FPJ.setText("jTextField2");

        FB.setText("jTextField3");

        jLabel1.setText("ID RUANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(Kokoh)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Adakunci)
                                .addGap(59, 59, 59)
                                .addComponent(Tkunci))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Aman)
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(29, 29, 29)
                                        .addComponent(jButton3))
                                    .addComponent(Bahaya))
                                .addGap(26, 26, 26)
                                .addComponent(jButton2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelesai)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Tkokoh)
                            .addComponent(jLabel8))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)))
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kokoh)
                    .addComponent(Tkokoh)
                    .addComponent(FK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tkunci)
                    .addComponent(Adakunci)
                    .addComponent(FPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bahaya)
                    .addComponent(Aman)
                    .addComponent(btnSelesai)
                    .addComponent(FB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Delete.setText("Hapus");
        Delete.setToolTipText("Klik untuk Menghapus Data pada Kolom");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        HasilAnalisa.setText("Hasil Analisa");
        HasilAnalisa.setToolTipText("Klik Untuk Pergi Ke Langkah Berikutnya");
        HasilAnalisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HasilAnalisaActionPerformed(evt);
            }
        });

        ADD.setText("Add");
        ADD.setToolTipText("Klik untuk menambahkan ruang");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        Save.setText("Save");
        Save.setToolTipText("Klik Untuk Menyimpan Data");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Edit.setText("Edit");
        Edit.setToolTipText("Klik Untuk Merubah Data");
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
                .addContainerGap()
                .addComponent(Save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(HasilAnalisa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(Delete)
                    .addComponent(ADD)
                    .addComponent(Edit)
                    .addComponent(HasilAnalisa))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            Adakunci.setSelected(true);
            Kokoh.setSelected(true);
            Aman.setSelected(true);
            Tkunci.setSelected(false);
            Tkokoh.setSelected(false);
            Bahaya.setSelected(false);   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            Adakunci.setSelected(false);
            Kokoh.setSelected(false);
            Aman.setSelected(false);
            Tkokoh.setSelected(false);
            Tkunci.setSelected(false);
            Bahaya.setSelected(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void KokohActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KokohActionPerformed
            Tkokoh.setSelected(false);       
    }//GEN-LAST:event_KokohActionPerformed

    private void TkokohActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TkokohActionPerformed
            Kokoh.setSelected(false);
    }//GEN-LAST:event_TkokohActionPerformed

    private void AdakunciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdakunciActionPerformed
        Tkunci.setSelected(false);
    }//GEN-LAST:event_AdakunciActionPerformed

    private void TkunciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TkunciActionPerformed
        Adakunci.setSelected(false);
    }//GEN-LAST:event_TkunciActionPerformed

    private void AmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmanActionPerformed
        Bahaya.setSelected(false);
    }//GEN-LAST:event_AmanActionPerformed

    private void BahayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BahayaActionPerformed
        Aman.setSelected(false);
    }//GEN-LAST:event_BahayaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
            klikTabel(Tabelku);
        Kokoh.setEnabled(false);
        Tkokoh.setEnabled(false);
        Adakunci.setEnabled(false);
        Tkunci.setEnabled(false);
        Aman.setEnabled(false);
        Bahaya.setEnabled(false);
    }//GEN-LAST:event_jTable1MousePressed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        da.kondisiHapus("keamanan","id_keamanan",CODE.getText());
        clearTEXT();
        HasilAnalisa.setVisible(false);
        Delete.setVisible(false);
        Edit.setVisible(false);
        tampilDataKeTabel();
    }//GEN-LAST:event_DeleteActionPerformed

    private void HasilAnalisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HasilAnalisaActionPerformed

        IO x = new IO(Kokoh,Tkokoh,Adakunci,Tkunci,Aman,Bahaya);
        Sistem n = new Sistem();
        kls = x.getRuangKelas();
        n.CheckKondisiKeamanan(kls,IDKelas.getText());
        
        dispose();
            x.IdentitasKelas();
            new FrameOutput(IDKelas.getText()).setVisible(true);
    }//GEN-LAST:event_HasilAnalisaActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        Kokoh.setEnabled(true);
        Tkokoh.setEnabled(true);
        Adakunci.setEnabled(true);
        Tkunci.setEnabled(true);
        Aman.setEnabled(true);
        Bahaya.setEnabled(true);
        clearTEXT();
        Save.setVisible(true);
        Edit.setVisible(false);
        Delete.setVisible(false);
        ADD.setVisible(false);
        HasilAnalisa.setVisible(false);
        jTable1.enable(false);
    }//GEN-LAST:event_ADDActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if(!Kokoh.isSelected()&&!Tkokoh.isSelected()
            || !Adakunci.isSelected()&& !Tkunci.isSelected()  
            || !Aman.isSelected() && !Bahaya.isSelected()    ){
            JOptionPane.showMessageDialog(null, "Semua Data Harus Diisi");
        }
        else{
        IO x = new IO(Kokoh,Tkokoh,Adakunci,Tkunci,Aman,Bahaya);
        kls = x.getRuangKelas();
        da.Save(kls.getKekokohan(),kls.getKunciPintuJendela() ,kls.getBahaya(),IDKelas.getText() );
        tampilDataKeTabel();
        
        }
        Save.setVisible(false);
        ADD.setVisible(false);
        clearTEXT();
        HasilAnalisa.setVisible(false);
        Kokoh.setEnabled(false);
        Tkokoh.setEnabled(false);
        Adakunci.setEnabled(false);
        Tkunci.setEnabled(false);
        Aman.setEnabled(false);
        Bahaya.setEnabled(false);
        jTable1.enable(true);
        
    }//GEN-LAST:event_SaveActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        btnSelesai.setVisible(true);
        Kokoh.setEnabled(true);
        Tkokoh.setEnabled(true);
        Adakunci.setEnabled(true);
        Tkunci.setEnabled(true);
        Aman.setEnabled(true);
        Bahaya.setEnabled(true);
        Delete.setVisible(false);
        ADD.setVisible(false);
        Edit.setVisible(false);
        HasilAnalisa.setVisible(false);
        jTable1.enable(false);
    }//GEN-LAST:event_EditActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        btnSelesai.setVisible(DiEdit());
        jTable1.enable(true);
        Delete.setVisible(false);
        //ADD.setVisible(true);
        Edit.setVisible(false);
        HasilAnalisa.setVisible(false);
        Kokoh.setEnabled(false);
        Tkokoh.setEnabled(false);
        Adakunci.setEnabled(false);
        Tkunci.setEnabled(false);
        Aman.setEnabled(false);
        Bahaya.setEnabled(false);
        
    }//GEN-LAST:event_btnSelesaiActionPerformed

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
            java.util.logging.Logger.getLogger(KondisiKeamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KondisiKeamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KondisiKeamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KondisiKeamanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KondisiKeamanan("1").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JCheckBox Adakunci;
    private javax.swing.JCheckBox Aman;
    private javax.swing.JCheckBox Bahaya;
    private javax.swing.JTextField CODE;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField FB;
    private javax.swing.JTextField FK;
    private javax.swing.JTextField FPJ;
    private javax.swing.JButton HasilAnalisa;
    private javax.swing.JTextField IDKelas;
    private javax.swing.JCheckBox Kokoh;
    private javax.swing.JButton Save;
    private javax.swing.JCheckBox Tkokoh;
    private javax.swing.JCheckBox Tkunci;
    private javax.swing.JButton btnSelesai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
