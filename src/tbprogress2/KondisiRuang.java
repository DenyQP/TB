/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//SLIDER BELUM FIXXXX
package tbprogress2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Deny SQP
 */
public class KondisiRuang extends javax.swing.JFrame {

    /**
     * Creates new form KondisiRuang
     */
    DatabaseWork da = new DatabaseWork();
    private Integer baris;
    private Connect con = new Connect();
    private JTable Tabelku = new JTable();
    private DefaultTableModel TabelDasar;
    private TableColumn kol;
    private String a, b,c,d,e,f,g;
    private String C,D,E,F,G;
    RuangKelas kls = new RuangKelas();
    int s = 0, ts = 0, kondisi;
    private double Luas, RasioLuas;
    public double getLuas() {
        return Luas;
    }

    public void setLuas(double Luas) {
        this.Luas = Luas;
    }

    public double getRasioLuas() {
        return RasioLuas;
    }

    public void setRasioLuas(double RasioLuas) {
        this.RasioLuas = RasioLuas;
    }

    double HitungLuas() {
        Luas = kls.getPanjangRuang() * kls.getLebarRuang();
        return Luas;
    }

    double HitungRasioLuas() {
        RasioLuas = Luas / kls.getJumlahKursi();
        return RasioLuas;
    }
    KondisiRuang(String KR) {
        initComponents();
        IDKelas.setText(KR);
                IDKelas.setEditable(false);
        CODE.setVisible(false);
        Save.setVisible(false);
        btnSelesai.setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setResizable(false);
        setTitle("Identitas Ruang");
        con.koneksi();
        tampilDataKeTabel();
        gerak(false);
        Lanjut.setVisible(false);
        Delete.setVisible(false);
        Edit.setVisible(false);
        txtValue.setEditable(false);
        txtValue2.setEditable(false);
        txtValue1.setVisible(false);
        txtValue3.setVisible(false);
        kursi.setEditable(false);
        pintu.setEditable(false);
        jendela.setEditable(false);
        kursi1.setVisible(false);
        pintu1.setVisible(false);
        jendela1.setVisible(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    
                setResizable(false);
                pintu.setText("");
                jendela.setText("");
                kursi.setText("");
	        nyeret1();
                nyeret2();
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
    public void nyeret1(){
                txtValue.setEditable(false);	
	        txtValue.setText(null);	
	        slider.setMinorTickSpacing(5);	
	        slider.setMajorTickSpacing(20);	
	        slider.setPaintTicks(true);	
	        slider.setLabelTable(slider.getLabelTable());	
	        slider.setPaintLabels(true);
                slider.addChangeListener (	
	            new ChangeListener() {	 
	                public void stateChanged (ChangeEvent e) {	
	                    txtValue.setText ( String.valueOf(slider.getValue()) );	
                        }	
	            }
	        );
                
    }
     public void nyeret2(){
                txtValue2.setEditable(false);	
	        txtValue2.setText(null);	
	        slider2.setMinorTickSpacing(5);	
	        slider2.setMajorTickSpacing(20);	
	        slider2.setPaintTicks(true);	
	        slider2.setLabelTable(slider.getLabelTable());	
	        slider2.setPaintLabels(true);
                slider2.addChangeListener (	
	            new ChangeListener() {	 
	                public void stateChanged (ChangeEvent e) {	
	                    txtValue2.setText ( String.valueOf(slider2.getValue()) );	
                        }	
	            }
	        );
	        
     }
     void KondisiAddButton(){
         try{
            String Sql = "Select id from lingkungan ";
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
        a = txtValue.getText();
        b = txtValue2.getText();
        c = txtValue1.getText();
        d = txtValue3.getText();
        e = pintu.getText();
        f = pintu1.getText();
        g = kursi.getText();
        C = kursi1.getText();
        D = jendela.getText();
        E = jendela1.getText();
        String H = CODE.getText();
          System.out.println(H);
       try {
            if (a.equals("") || b.equals("") || e.equals("") || g.equals("")||D.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                nilai=true;
                clearTEXT();
            } else if (a.equals(c) && e.equals(f) && b.equals(d) && g.equals(C)&&D.equals(E)) {
                JOptionPane.showMessageDialog(null, "Tidak ada data yang di perbaharui!");
                nilai = false;
            } else {
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "update kondisi set "
                        + "panjang=" + "'" + a + "', "
                        + "lebar=" + "'" + b + "', "
                        + "kursi=" + "'" + g + "', "
                        + "pintu=" + "'" + e + "', "
                        + "jendela=" + "'" + D + "' "
                        + "where id_kondisi ='" + H + "'");

                tampilDataKeTabel();
                JOptionPane.showMessageDialog(this, "Data berhasil diperbaharui");
                nilai=false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal diperbaharui! : " + ex);
        }
       return nilai;
    }
     void gerak(boolean bisa){
         slider.setEnabled(bisa);
         slider2.setEnabled(bisa);
    }
         
     void clearTEXT(){
        txtValue.setText(null);
        txtValue2.setText(null);
        pintu.setText(null);
        jendela.setText(null);
        kursi.setText(null);
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
        String kol7 = jTabel.getValueAt(baris, 6).toString();
        String kol8 = jTabel.getValueAt(baris, 7).toString();
        
        if(kol8.equalsIgnoreCase(IDKelas.getText())){
        txtValue.setText(kol2);
        //txt_nama2.setText(kol2);
        txtValue2.setText(kol3);

        pintu.setText(kol5);
        //cmb_fakultas.setSelectedItem(kol5);
        kursi.setText(kol4);
        jendela.setText(kol6);
                
        pintu1.setText(kol4);
        kursi1.setText(kol5);
        jendela1.setText(kol6);
        Delete.setVisible(true);
        Edit.setVisible(true);
        Save.setVisible(false);
        btnSelesai.setVisible(false);
        Lanjut.setVisible(true);
        CODE.setText(kol7);
        }
        else{
          JOptionPane.showMessageDialog(null, "ID KELAS BERBEDA");
            Delete.setVisible(false);
            Edit.setVisible(false);
            Save.setVisible(false);
            btnSelesai.setVisible(false);
            Lanjut.setVisible(false);
            ADD.setVisible(true);
        }
    }
    private void tableModel(JTable jTabel1) {
        try {
            Object[] field = {"No", "Panjang", "Lebar", "Kursi", "Pintu","Jendela","ID","ID Ruang"};
            TabelDasar = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(TabelDasar);

            String sql = "Select * from kondisi";
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);
            KondisiAddButton();
            int no = 0;
            while (set.next()) {
                no++;
                String kol1 = String.valueOf(no).toString();
                String kol2 = set.getString("panjang");
                String kol3 = set.getString("lebar");
                String kol4 = set.getString("kursi");
                String kol5 = set.getString("pintu");
                String kol6 = set.getString("jendela");
                String kol7 = set.getString("id_kondisi");
                String kol8 = set.getString("id");
                String[] data = {kol1, kol2, kol3, kol4, kol5, kol6,kol7,kol8};
                TabelDasar.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            kol = jTabel1.getColumnModel().getColumn(0);
            kol.setPreferredWidth(40);
            kol = jTabel1.getColumnModel().getColumn(1);
            kol.setPreferredWidth(85);
            kol = jTabel1.getColumnModel().getColumn(2);
            kol.setPreferredWidth(90);
            kol = jTabel1.getColumnModel().getColumn(3);
            kol.setPreferredWidth(90);
            kol = jTabel1.getColumnModel().getColumn(3);
            kol.setPreferredWidth(100);
            kol = jTabel1.getColumnModel().getColumn(5);
            kol.setPreferredWidth(100);
            kol = jTabel1.getColumnModel().getColumn(6);
            kol.setPreferredWidth(0);
            kol.setMinWidth(0);
            kol.setMaxWidth(0);
            kol.setWidth(0);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
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

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jendela = new javax.swing.JTextField();
        pintu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kursi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        slider2 = new javax.swing.JSlider();
        txtValue2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtValue = new javax.swing.JTextField();
        slider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jendela1 = new javax.swing.JTextField();
        kursi1 = new javax.swing.JTextField();
        pintu1 = new javax.swing.JTextField();
        btnSelesai = new javax.swing.JButton();
        txtValue1 = new javax.swing.JTextField();
        txtValue3 = new javax.swing.JTextField();
        CODE = new javax.swing.JTextField();
        IDKelas = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        Lanjut = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        ADD = new javax.swing.JButton();

        jLabel4.setText("Panjang Ruang");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Jumlah Jendela :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Jumlah Pintu    :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Jumlah Kursi     :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Lebar Ruang     :");

        jLabel9.setText("Meter");

        jLabel8.setText("Meter");

        txtValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValueActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Panjang Ruang :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("KONDISI RUANG KELAS");

        kursi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kursi1ActionPerformed(evt);
            }
        });

        btnSelesai.setText("Selesai");
        btnSelesai.setToolTipText("Klik Jika Selesai Dirubah");
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        txtValue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValue1ActionPerformed(evt);
            }
        });

        jLabel10.setText("ID RUANG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kursi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pintu, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jendela, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kursi1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pintu1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jendela1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(slider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtValue3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(39, 39, 39))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IDKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtValue1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(slider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtValue2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txtValue3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(kursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(pintu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jendela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(kursi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(pintu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jendela1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CODE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(btnSelesai, javax.swing.GroupLayout.Alignment.TRAILING)))
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Lanjut.setText("Selanjutnya");
        Lanjut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LanjutActionPerformed(evt);
            }
        });

        Delete.setText("Hapus");
        Delete.setToolTipText("Klik untuk Menghapus Data pada Kolom");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
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

        ADD.setText("Add");
        ADD.setToolTipText("Klik untuk menambahkan ruang");
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(Save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lanjut)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save)
                    .addComponent(Delete)
                    .addComponent(ADD)
                    .addComponent(Edit)
                    .addComponent(Lanjut))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValueActionPerformed

    }//GEN-LAST:event_txtValueActionPerformed

    private void LanjutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LanjutActionPerformed
        IO x = new IO(txtValue,txtValue2,kursi,pintu,jendela);
        Sistem n = new Sistem();
        kls = x.getRuangKelas();
        n.CheckKondisiRuang(kls,IDKelas.getText());
        dispose();
        x.inputKondisiSarana(IDKelas.getText());
    }//GEN-LAST:event_LanjutActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        da.kondisiHapus("kondisi","id_kondisi",CODE.getText());
        clearTEXT();
        tampilDataKeTabel();
        Delete.setVisible(false);
        ADD.setVisible(true);
        Edit.setVisible(false);
        Lanjut.setVisible(false);
        btnSelesai.setVisible(false);
    }//GEN-LAST:event_DeleteActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        da.Save(IDKelas.getText(),txtValue, txtValue2, kursi, pintu, jendela);
        tampilDataKeTabel();
        Save.setVisible(false);
        ADD.setVisible(false);
        clearTEXT();
        gerak(false);
    }//GEN-LAST:event_SaveActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        gerak(true);
        btnSelesai.setVisible(true);
        kursi.setEditable(true);
        pintu.setEditable(true);
        jendela.setEditable(true);
        Delete.setVisible(false);
        ADD.setVisible(false);
        Edit.setVisible(false);
        Lanjut.setVisible(false);

    }//GEN-LAST:event_EditActionPerformed

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        gerak(true);
        kursi.setEditable(true);
        pintu.setEditable(true);
        jendela.setEditable(true);
        clearTEXT();
        Save.setVisible(true);
        Edit.setVisible(false);
        Delete.setVisible(false);
        ADD.setVisible(false);
    }//GEN-LAST:event_ADDActionPerformed

    private void kursi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kursi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kursi1ActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        gerak(false);
        btnSelesai.setVisible(DiEdit());
        Delete.setVisible(false);
        ADD.setVisible(true);
        Edit.setVisible(false);
        Lanjut.setVisible(false);
        clearTEXT();
        KondisiAddButton();
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        klikTabel(Tabelku);
        gerak(false);
        kursi.setEditable(false);
        pintu.setEditable(false);
        jendela.setEditable(false);
    }//GEN-LAST:event_jTable1MousePressed

    private void txtValue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValue1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValue1ActionPerformed

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
            java.util.logging.Logger.getLogger(KondisiRuang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KondisiRuang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KondisiRuang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KondisiRuang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KondisiRuang("1").setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JTextField CODE;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField IDKelas;
    private javax.swing.JButton Lanjut;
    private javax.swing.JButton Save;
    private javax.swing.JButton btnSelesai;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jendela;
    private javax.swing.JTextField jendela1;
    private javax.swing.JTextField kursi;
    private javax.swing.JTextField kursi1;
    private javax.swing.JTextField pintu;
    private javax.swing.JTextField pintu1;
    private javax.swing.JSlider slider;
    private javax.swing.JSlider slider2;
    private javax.swing.JTextField txtValue;
    private javax.swing.JTextField txtValue1;
    private javax.swing.JTextField txtValue2;
    private javax.swing.JTextField txtValue3;
    // End of variables declaration//GEN-END:variables
}
