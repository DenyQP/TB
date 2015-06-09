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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Deny SQP
 */
public class DataAwal extends javax.swing.JFrame {
    /**
     * Creates new form DataAwal
     */
    DatabaseWork da = new DatabaseWork();
    private Integer baris;
    private Connect con = new Connect();
    private JTable Tabelku = new JTable();
    private DefaultTableModel DefaultTabelku;
    private TableColumn kolom;
    private String a, b,c,d,e,f,g;
    private String C,D,E,F,G,kode;
    
    
    public DataAwal() {
        initComponents();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        HasilAnalisa.setVisible(false);
        Save.setVisible(false);
        btnSelesai.setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setResizable(false);
        Next.setVisible(false);
        setTitle("Identitas Ruang");
        con.koneksi();
        tampilDataKeTabel();
//        enableBtn(false);
//        enviBtnSave(true);
//        enviBtnSave2(false);
//        enviBtnNew(false);
        
        CODE.setVisible(false);
        Delete.setVisible(false);
        Edit.setVisible(false);
        NM.setEditable(false);
        LK.setEditable(false);
        JR.setEditable(false);
        FK.setEditable(false);
        NM2.setVisible(false);
        LK2.setVisible(false);
        JR2.setVisible(false);
        FK2.setVisible(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        
    }
    private boolean DiEdit() {
        boolean nilai = false;
        a = NM.getText();
        b = JR.getText();
        c = NM2.getText();
        d = JR2.getText();
        E = LK.getText();
        F = FK.getText();
        e = LK2.getText();
        f = FK2.getText();

       try {
            if (a.equals("") || E.equals("") || b.equals("") || F.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                nilai=true;
                clearTEXT();
            } else if (a.equals(c) && E.equals(e) && b.equals(d) && F.equals(f)) {
                JOptionPane.showMessageDialog(null, "Tidak ada data yang di perbaharui!");
                nilai = false;
            } else {
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "update identitas set "
                        + "nama=" + "'" + a + "', "
                        + "lokasi=" + "'" + E + "', "
                        + "prodi=" + "'" + b + "', "
                        + "fakultas=" + "'" + F + "' "
                        + "where id ='" + CODE.getText() + "'");

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
        HasilAnalisa.setVisible(true);
        NM.setText(kolom2);
        //txt_nama2.setText(kolom2);
        LK.setText(kolom3);
       
        JR.setText(kolom4);
        //cmb_fakultas.setSelectedItem(kolom5);
        FK.setText(kolom5);
        NM2.setText(kolom2);
        LK2.setText(kolom3);
        JR2.setText(kolom4);
        FK2.setText(kolom5);
        CODE.setText(kolom6);
        Delete.setVisible(true);
        Edit.setVisible(true);
        Save.setVisible(false);
        btnSelesai.setVisible(false);
        ADD.setVisible(true);
    }
    void KondisiSaveButton(){
         try{
            String Sql = "Select nama , lokasi from identitas ";
            Statement St = con.config.getConnection().createStatement();
            ResultSet Set = St.executeQuery(Sql);
            
            while (Set.next()) {
                String kolom1 = Set.getString("nama");
                String kolom2 = Set.getString("lokasi");
                if(kolom1.equalsIgnoreCase(NM.getText())&&kolom2.equalsIgnoreCase(LK.getText())){
                    JOptionPane.showMessageDialog(null, "Nama Ruang Sudah Ada");
                    //System.out.println(""+IDKelas.getText());
                    break;
                }
                else{
                       da.Save(NM, LK, JR, FK);
                       tampilDataKeTabel();
                       Save.setVisible(false);
                       ADD.setVisible(true);
                       clearTEXT();
                       Next.setVisible(false);
                    
                }
                
            }
         }
         catch(SQLException e){
             JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
         }
    }
    private void tableModel(JTable jTabel1) {
        try {
            Object[] field = {"No", "Nama", "Lokasi", "Prodi", "Fakultas","ID"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from identitas";
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            int no = 0;
            while (set.next()) {
                no++;
                String kolom1 = String.valueOf(no).toString();
                String kolom2 = set.getString("nama");
                String kolom3 = set.getString("lokasi");
                String kolom4 = set.getString("prodi");
                String kolom5 = set.getString("fakultas");
                String kolom6 = set.getString("id");
                String[] data = {kolom1, kolom2, kolom3, kolom4, kolom5,kolom6};
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
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(5);
            kolom.setPreferredWidth(0);
            kolom.setMinWidth(0);
            kolom.setMaxWidth(0);
            kolom.setWidth(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    void clearTEXT() {
        NM.setText("");
        JR.setText("");
        LK.setText("");
        FK.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NM = new javax.swing.JTextField();
        LK = new javax.swing.JTextField();
        FK = new javax.swing.JTextField();
        JR = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSelesai = new javax.swing.JButton();
        NM2 = new javax.swing.JTextField();
        LK2 = new javax.swing.JTextField();
        FK2 = new javax.swing.JTextField();
        JR2 = new javax.swing.JTextField();
        CODE = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Delete = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        HasilAnalisa = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("IDENTITAS KELAS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nama Ruang :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Lokasi           :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Jurusan        :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Fakultas        :");

        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Klik jika selesai edit");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelesai)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FK)
                                    .addComponent(LK)
                                    .addComponent(NM)
                                    .addComponent(JR))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(NM2)
                                        .addContainerGap())))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(NM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(btnSelesai))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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

        Next.setText("Selanjutnya");
        Next.setToolTipText("Klik Untuk Pergi Ke Langkah Berikutnya");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
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

        HasilAnalisa.setText("Hasil Analisa");
        HasilAnalisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HasilAnalisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HasilAnalisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Next)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(Delete)
                    .addComponent(ADD)
                    .addComponent(Edit)
                    .addComponent(Next)
                    .addComponent(HasilAnalisa))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
//         try{
        klikTabel(Tabelku);
        Next.setVisible(true);
        NM.setEditable(false);
        FK.setEditable(false);
        LK.setEditable(false);
        JR.setEditable(false);          
    }//GEN-LAST:event_jTable1MousePressed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        if(NM.getText().equals("") || LK.getText().equals("") || FK.getText().equals("") || JR.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
            ADD.setVisible(true);
            Save.setVisible(false);
        }
        else{
            IO x = new IO(NM,LK,FK,JR);
            x.IdentitasKelas();
            JOptionPane.showMessageDialog(null, "ID Ruang Anda = "+CODE.getText());
            dispose();
            x.InputKondisiRuang(CODE.getText());
        }        
    }//GEN-LAST:event_NextActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        //KondisiSaveButton();
                        da.Save(NM, LK, JR, FK);
                       tampilDataKeTabel();
                       Save.setVisible(false);
                       ADD.setVisible(true);
                       clearTEXT();
                       Next.setVisible(false);
    }//GEN-LAST:event_SaveActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        //da.kondisiHapus("identitas","id",CODE.getText());
        da.kondisiHapus(CODE.getText());
        clearTEXT();
        tampilDataKeTabel();
        Next.setVisible(false);
    }//GEN-LAST:event_DeleteActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
       NM.setEditable(true);
        FK.setEditable(true);
        LK.setEditable(true);
        JR.setEditable(true);
        clearTEXT();
        Save.setVisible(true);
        Edit.setVisible(false);
        Delete.setVisible(false);
        ADD.setVisible(false);
        Next.setVisible(false);
        HasilAnalisa.setVisible(false);
    }//GEN-LAST:event_ADDActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        btnSelesai.setVisible(true);
        NM.setEditable(true);
        FK.setEditable(true);
        LK.setEditable(true);
        JR.setEditable(true);
        Delete.setVisible(false);
        ADD.setVisible(false);
        Edit.setVisible(false);
        Next.setVisible(false);
        HasilAnalisa.setVisible(false);
        
    }//GEN-LAST:event_EditActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        btnSelesai.setVisible(DiEdit());
        Delete.setVisible(false);
        ADD.setVisible(true);
        Edit.setVisible(false);
        Next.setVisible(false);
        clearTEXT();
        NM.setEditable(false);
        FK.setEditable(false);
        LK.setEditable(false);
        JR.setEditable(false);
        HasilAnalisa.setVisible(false);
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void HasilAnalisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HasilAnalisaActionPerformed
        dispose();
        IO ok = new IO();
        ok.output(CODE.getText());
        
    }//GEN-LAST:event_HasilAnalisaActionPerformed
    private void tampilDataKeTabel() {
        Tabelku = jTable1;
        tableModel(Tabelku);
    }
    
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
            java.util.logging.Logger.getLogger(DataAwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataAwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataAwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataAwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataAwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JTextField CODE;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField FK;
    private javax.swing.JTextField FK2;
    private javax.swing.JButton HasilAnalisa;
    private javax.swing.JTextField JR;
    private javax.swing.JTextField JR2;
    private javax.swing.JTextField LK;
    private javax.swing.JTextField LK2;
    private javax.swing.JTextField NM;
    private javax.swing.JTextField NM2;
    private javax.swing.JButton Next;
    private javax.swing.JButton Save;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
