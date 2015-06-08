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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Reinka
 */
public class KondisiKebersihan extends javax.swing.JFrame {

    /**
     * Creates new form KondisiLingkungan
     */
   
    RuangKelas kls = new RuangKelas();
    int s = 0, ts = 0, kondisi;
    DatabaseWork da = new DatabaseWork();
    private Integer baris;
    private Connect con = new Connect();
    private JTable Tabelku = new JTable();
    private DefaultTableModel DefaultTabelku;
    private TableColumn kolom;
    private String a, b,c,d,e,f,g,h,i,j;
    private String C,D,E,F,G,kode;
    public KondisiKebersihan(String KR) {
      initComponents();
       IDKelas.setText(KR);
        IDKelas.setEditable(false);
        Save.setVisible(false);
        Next.setVisible(false);
        btnselesai.setVisible(false);
        KL.setVisible(false);
        KD.setVisible(false);
        KA.setVisible(false);
        KP.setVisible(false);
        KJ.setVisible(false);
        baik.setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setResizable(false);
        setTitle("Kebersihan Ruang");
        con.koneksi();
        tampilDataKeTabel();
//        enableBtn(false);
//        enviBtnSave(true);
//        enviBtnSave2(false);
//        enviBtnNew(false);
        CODE.setVisible(false);
        Delete.setVisible(false);
        Edit.setVisible(false);
        LB.setEnabled(false);
        LBR.setEnabled(false);
        DB.setEnabled(false);
        DBR.setEnabled(false);
        AB.setEnabled(false);
        ABR.setEnabled(false);
        PB.setEnabled(false);
        PBR.setEnabled(false);
        JB.setEnabled(false);
        JBR.setEnabled(false);
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
            String Sql = "Select id from kebersihan ";
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
        IO x = new IO(LB,LBR,DB,DBR,AB,ABR,PB,PBR,JB,JBR);
        Sistem n = new Sistem();
        kls = x.getRuangKelas();
        a = kls.getKondisiLantai();
        b = kls.getKondisiDinding();
        c = kls.getKondisiAtap();
        d = kls.getKondisiPintu();
        e = kls.getKondisiJendela();
        f = KL.getText();
        g = KD.getText();
        h = KA.getText();
        i = KP.getText();
        j = KJ.getText();
       try {
            if (a.equals("") || b.equals("") || c.equals("")|| d.equals("") || e.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                nilai=true;
                clearTEXT();
             
            } else {
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        
                     "update kebersihan set "
                        + "lantai=" + "'" + a + "', "
                        + "dinding=" + "'" + b + "', "
                        + "atap=" + "'" + c + "', "
                        + "pintu=" + "'" + d + "', "
                        + "jendela=" + "'" + e + "' "
                        + "where id_kebersihan ='" + CODE.getText() 
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
      if(kolom8.equalsIgnoreCase(IDKelas.getText())){
        if("Lantai Bersih".equalsIgnoreCase(kolom2)){
            LB.setSelected(true);
            LBR.setSelected(false);
        }
        else if("Lantai Kotor".equalsIgnoreCase(kolom2)) {
            LB.setSelected(false);
            LBR.setSelected(true);
        }
            if("Dinding Bersih/Baik".equalsIgnoreCase(kolom3)){
                DB.setSelected(true);
                DBR.setSelected(false);
            }
            else {
                DB.setSelected(false);
                DBR.setSelected(true);
            }
           
                if("Atap Bersih".equalsIgnoreCase(kolom4)){
                    AB.setSelected(true);
                    ABR.setSelected(false);
                }
                else{
                    AB.setSelected(false);
                    ABR.setSelected(true);
                }
                 if("Pintu Bersih/Baik".equalsIgnoreCase(kolom5)){
                    PB.setSelected(true);
                    PBR.setSelected(false);
                }
                else{
                    PB.setSelected(false);
                    PBR.setSelected(true);
                }
                  if("Jendela Bersih/Baik".equalsIgnoreCase(kolom6)){
                    JB.setSelected(true);
                    JBR.setSelected(false);
                }
                else{
                    JB.setSelected(false);
                    JBR.setSelected(true);
                }
        KL.setText(kolom2);
        KD.setText(kolom3);
        KA.setText(kolom4);
        KP.setText(kolom5);
        KJ.setText(kolom6);
        LB.setEnabled(false);
        LBR.setEnabled(false);
        DB.setEnabled(false);
        DBR.setEnabled(false);
        AB.setEnabled(false);
        ABR.setEnabled(false);
        PB.setEnabled(false);
        PBR.setEnabled(false);
        JB.setEnabled(false);
        JBR.setEnabled(false);
        CODE.setText(kolom7);
       // System.out.println(""+CODE.getText());
        Delete.setVisible(true);
        Edit.setVisible(true);
        Save.setVisible(false);
        Next.setVisible(true);
      }else{
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
            Object[] field = {"No", "Lantai", "Dinding", "Atap", "Pintu", "Jendela", "ID", "ID RUANG"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from kebersihan";
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);
            KondisiAddButton();
            int no = 0;
            while (set.next()) {
                no++;
                String kolom1 = String.valueOf(no).toString();
                String kolom2 = set.getString("Lantai");
                String kolom3 = set.getString("Dinding");
                String kolom4 = set.getString("Atap");
                String kolom5 = set.getString("Pintu");
                String kolom6 = set.getString("Jendela");
                String kolom7 = set.getString("id_kebersihan");
                String kolom8 = set.getString("id");
                String[] data = {kolom1, kolom2, kolom3, kolom4, kolom5, kolom6, kolom7, kolom8};
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
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(6);
            kolom.setPreferredWidth(0);
            kolom.setMinWidth(0);
            kolom.setMaxWidth(0);
            kolom.setWidth(0);
            kolom = jTabel1.getColumnModel().getColumn(7);
            kolom.setPreferredWidth(220);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    void clearTEXT() {
            LB.setSelected(false);
            LBR.setSelected(false);
            DB.setSelected(false);
            DBR.setSelected(false);
            AB.setSelected(false);
            ABR.setSelected(false);
            PB.setSelected(false);
            PBR.setSelected(false);
            JB.setSelected(false);
            JBR.setSelected(false);
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

        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        LB = new javax.swing.JCheckBox();
        LBR = new javax.swing.JCheckBox();
        DB = new javax.swing.JCheckBox();
        DBR = new javax.swing.JCheckBox();
        AB = new javax.swing.JCheckBox();
        ABR = new javax.swing.JCheckBox();
        JB = new javax.swing.JCheckBox();
        JBR = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        PB = new javax.swing.JCheckBox();
        PBR = new javax.swing.JCheckBox();
        KL = new javax.swing.JTextField();
        KD = new javax.swing.JTextField();
        KA = new javax.swing.JTextField();
        KP = new javax.swing.JTextField();
        KJ = new javax.swing.JTextField();
        btnselesai = new javax.swing.JButton();
        CODE = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        baik = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        IDKelas = new javax.swing.JTextField();

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Persentase Kebisingan Kelas                : ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Presentase Bau di Kelas                       : ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Persentase Keausan Permukaan Kelas  :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("KEBERSIHAN RUANG KELAS");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Kondisi Lantai      :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Kondisi Dinding   :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Kondisi Atap       :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Kondisi Pintu      :");

        LB.setText("Bersih");
        LB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LBActionPerformed(evt);
            }
        });

        LBR.setText("Kotor");
        LBR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LBRActionPerformed(evt);
            }
        });

        DB.setText("Bersih");
        DB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBActionPerformed(evt);
            }
        });

        DBR.setText("Kotor");
        DBR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBRActionPerformed(evt);
            }
        });

        AB.setText("Bersih");
        AB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABActionPerformed(evt);
            }
        });

        ABR.setText("Kotor");
        ABR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABRActionPerformed(evt);
            }
        });

        JB.setText("Bersih");
        JB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBActionPerformed(evt);
            }
        });

        JBR.setText("Kotor");
        JBR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Kondisi Jendela   :");

        PB.setText("Bersih");
        PB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PBActionPerformed(evt);
            }
        });

        PBR.setText("Kotor");
        PBR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PBRActionPerformed(evt);
            }
        });

        KL.setText("jTextField1");

        KD.setText("jTextField2");

        KA.setText("jTextField3");

        KP.setText("jTextField4");

        KJ.setText("jTextField5");

        btnselesai.setText("Selesai");
        btnselesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselesaiActionPerformed(evt);
            }
        });

        CODE.setText("jTextField6");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        baik.setText("Baik Semua");
        baik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baikActionPerformed(evt);
            }
        });

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

        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(baik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Next)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(baik)
                    .addComponent(Next)
                    .addComponent(Add)
                    .addComponent(Delete)
                    .addComponent(Edit))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jLabel10.setText("ID RUANG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PB)
                    .addComponent(AB)
                    .addComponent(DB)
                    .addComponent(LB)
                    .addComponent(JB))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DBR)
                            .addComponent(LBR)
                            .addComponent(ABR)
                            .addComponent(PBR)
                            .addComponent(JBR))
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnselesai, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel2))
                    .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB)
                    .addComponent(LBR)
                    .addComponent(jLabel13)
                    .addComponent(KL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DB)
                    .addComponent(DBR)
                    .addComponent(jLabel14)
                    .addComponent(KD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AB)
                    .addComponent(ABR)
                    .addComponent(jLabel16)
                    .addComponent(KA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(PB)
                    .addComponent(PBR)
                    .addComponent(KP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(JB)
                    .addComponent(JBR)
                    .addComponent(KJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnselesai)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
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

    private void LBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LBActionPerformed
        LBR.setSelected(false);
    }//GEN-LAST:event_LBActionPerformed

    private void LBRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LBRActionPerformed
        LB.setSelected(false);
    }//GEN-LAST:event_LBRActionPerformed

    private void DBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBActionPerformed
        DBR.setSelected(false);
    }//GEN-LAST:event_DBActionPerformed

    private void DBRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBRActionPerformed
        DB.setSelected(false);
    }//GEN-LAST:event_DBRActionPerformed

    private void ABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABActionPerformed
        ABR.setSelected(false);
    }//GEN-LAST:event_ABActionPerformed

    private void ABRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABRActionPerformed
        AB.setSelected(false);
    }//GEN-LAST:event_ABRActionPerformed

    private void JBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBActionPerformed
        JBR.setSelected(false);
    }//GEN-LAST:event_JBActionPerformed

    private void JBRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRActionPerformed
        JB.setSelected(false);
    }//GEN-LAST:event_JBRActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        IO x = new IO(LB,LBR,DB,DBR,AB,ABR,PB,PBR,JB,JBR);
        kls = x.getRuangKelas();
        Sistem n = new Sistem();
        int kon;
        x.output(kls.getKondisiLantai(), kls.getKondisiDinding(), kls.getKondisiAtap(), kls.getKondisiPintu(), kls.getKondisiJendela());
        n.CheckKondisiKebersihan(kls,IDKelas.getText());
        dispose();
        x.inputKondisiLingkungan(IDKelas.getText());
    }//GEN-LAST:event_NextActionPerformed

    private void baikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baikActionPerformed

        LB.setSelected(true);
        DB.setSelected(true);
        AB.setSelected(true);
        PB.setSelected(true);
        JB.setSelected(true);
        JBR.setSelected(false);
        LBR.setSelected(false);
        DBR.setSelected(false);
        ABR.setSelected(false);
        PBR.setSelected(false);
    }//GEN-LAST:event_baikActionPerformed

    private void PBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PBActionPerformed
       PBR.setSelected(false);
    }//GEN-LAST:event_PBActionPerformed

    private void PBRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PBRActionPerformed
        PB.setSelected(false);
    }//GEN-LAST:event_PBRActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        IO x = new IO(LB,LBR,DB,DBR,AB,ABR,PB,PBR,JB,JBR);
        kls = x.getRuangKelas();
        da.Save(IDKelas.getText(),kls.getKondisiLantai(),kls.getKondisiDinding(),kls.getKondisiAtap(),kls.getKondisiPintu(),kls.getKondisiJendela());
        tampilDataKeTabel();
        Save.setVisible(false);
        Add.setVisible(false);
        clearTEXT();
        Next.setVisible(false);
        LB.setEnabled(false);
        LBR.setEnabled(false);
        DB.setEnabled(false);
        DBR.setEnabled(false);
        AB.setEnabled(false);
        ABR.setEnabled(false);
        PB.setEnabled(false);
        PBR.setEnabled(false);
        JB.setEnabled(false);
        JBR.setEnabled(false);
        
    }//GEN-LAST:event_SaveActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
     LB.setEnabled(true);
        LBR.setEnabled(true);
        DB.setEnabled(true);
        DBR.setEnabled(true);
        AB.setEnabled(true);
        ABR.setEnabled(true);
        PB.setEnabled(true);
        PBR.setEnabled(true);
        JB.setEnabled(true);
        JBR.setEnabled(true);
        clearTEXT();
        Save.setVisible(true);
        Edit.setVisible(false);
        Delete.setVisible(false);
        Add.setVisible(false);
        Next.setVisible(false);
    }//GEN-LAST:event_AddActionPerformed

    private void btnselesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselesaiActionPerformed
       btnselesai.setVisible(DiEdit());
        jTable1.enable(true);
        Delete.setVisible(false);
        //Add.setVisible(true);
        Edit.setVisible(false);
        Next.setVisible(false);
        LB.setEnabled(false);
        LBR.setEnabled(false);
        DB.setEnabled(false);
        DBR.setEnabled(false);
        AB.setEnabled(false);
        ABR.setEnabled(false);
        PB.setEnabled(false);
        PBR.setEnabled(false);
        JB.setEnabled(false);
        JBR.setEnabled(false);
        clearTEXT();
    }//GEN-LAST:event_btnselesaiActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        klikTabel(Tabelku);
        LB.setEnabled(false);
        LBR.setEnabled(false);
        DB.setEnabled(false);
        DBR.setEnabled(false);
        AB.setEnabled(false);
        ABR.setEnabled(false);
        PB.setEnabled(false);
        PBR.setEnabled(false);
        JB.setEnabled(false);
        JBR.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        da.kondisiHapus("kebersihan","id_kebersihan",CODE.getText());
        clearTEXT();
        KondisiAddButton();
        Delete.setVisible(false);
        Edit.setVisible(false);
        Next.setVisible(false);
        tampilDataKeTabel();
        Add.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_DeleteActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        btnselesai.setVisible(true);
        LB.setEnabled(true);
        LBR.setEnabled(true);
        DB.setEnabled(true);
        DBR.setEnabled(true);
        AB.setEnabled(true);
        ABR.setEnabled(true);
        PB.setEnabled(true);
        PBR.setEnabled(true);
        JB.setEnabled(true);
        JBR.setEnabled(true);
        Delete.setVisible(false);
        Add.setVisible(false);
        Edit.setVisible(false);
        Next.setVisible(false);
        jTable1.enable(false);
    }//GEN-LAST:event_EditActionPerformed

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
                new KondisiKebersihan("4").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AB;
    private javax.swing.JCheckBox ABR;
    private javax.swing.JButton Add;
    private javax.swing.JTextField CODE;
    private javax.swing.JCheckBox DB;
    private javax.swing.JCheckBox DBR;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField IDKelas;
    private javax.swing.JCheckBox JB;
    private javax.swing.JCheckBox JBR;
    private javax.swing.JTextField KA;
    private javax.swing.JTextField KD;
    private javax.swing.JTextField KJ;
    private javax.swing.JTextField KL;
    private javax.swing.JTextField KP;
    private javax.swing.JCheckBox LB;
    private javax.swing.JCheckBox LBR;
    private javax.swing.JButton Next;
    private javax.swing.JCheckBox PB;
    private javax.swing.JCheckBox PBR;
    private javax.swing.JButton Save;
    private javax.swing.JButton baik;
    private javax.swing.JButton btnselesai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
