/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tbprogress2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Deny SQP
 */
public class FrameOutput extends javax.swing.JFrame {

    /**
     * Creates new form FrameOutput
     */
    DatabaseWork da = new DatabaseWork();
    private Integer baris;
    private Connect con = new Connect();
    private JTable Tabelku = new JTable();
    private DefaultTableModel DefaultTabelku;
    private TableColumn kolom;
    public FrameOutput(String id) {
        initComponents();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.koneksi();
        tableModel(tabelkondisi,id);
        tableModel1(tabelidentitas, id);
        tableModel2(sarana1,id);
        tableModel3(sarana2, id);
        tableModel7(tabelkebersihan, id);
        tableModel8(tabelkeamanan,id);
        tableModel6(tabelkenyamanan, id);
        tableModel5(tabellingkungan, id);
    }

    private void tableModel(JTable jTabel1,String KR) {
        try {
            Object[] field = { "Luas", "Bentuk", "Rasio", "Analisis Rasio","Jumlah Kursi","Jumlah Jendel","Persentase"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from analisis_kondisi where id="+KR;
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            
            while (set.next()) {  
                String kolom2 = set.getString("luas");
                String kolom3 = set.getString("bentuk");
                String kolom4 = set.getString("rasio");
                String kolom5 = set.getString("arasio");
                String kolom6 = set.getString("apintu");
                String kolom7 = set.getString("ajendela");
                String kolom8 = set.getString("persenkondisi");
                String kolom9 = set.getString("id");
                String[] data = { kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8,kolom9};
                DefaultTabelku.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            
            kolom = jTabel1.getColumnModel().getColumn(0);
            kolom.setPreferredWidth(140);
            kolom = jTabel1.getColumnModel().getColumn(1);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(2);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(3);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(4);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(5);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(6);
            kolom.setPreferredWidth(240);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    private void tableModel1(JTable jTabel1,String KR) {
        try {
            Object[] field = { "Nama", "Lokasi", "Prodi", "Fakultas","ID"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from identitas where id="+KR;
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            int no = 0;
            while (set.next()) {
                String kolom2 = set.getString("nama");
                String kolom3 = set.getString("lokasi");
                String kolom4 = set.getString("prodi");
                String kolom5 = set.getString("fakultas");
                String kolom6 = set.getString("id");
                String[] data = { kolom2, kolom3, kolom4, kolom5,kolom6};
                DefaultTabelku.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            
            
            kolom = jTabel1.getColumnModel().getColumn(0);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(1);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(2);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(3);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(4);
            kolom.setPreferredWidth(0);
            kolom.setMinWidth(0);
            kolom.setMaxWidth(0);
            kolom.setWidth(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    private void tableModel2(JTable jTabel1,String KR) {
        try {
            Object[] field = { "Jumlah Stop Kontak", "Kondisi Stop Kontak", "Posisi Stopkontak", "Jumlah Kabel LCD", "Kondisi Kabel LCD", "Posisi Kabel LCD","Jumlah Lampu ", "Kondisi Lampu", "Posisi Lampu","ID","Presentase"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from analisis_jkp_sarana where id="+KR;
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            int no = 0;
            while (set.next()) {
                String kolom2 = set.getString("ajstopkontak");
                String kolom3 = set.getString("akstopkontak");
                String kolom4 = set.getString("apstopkontak");
                String kolom5 = set.getString("ajlcd");
                String kolom6 = set.getString("aklcd");
                String kolom7 = set.getString("aplcd");
                String kolom8 = set.getString("ajlampu");
                String kolom9 = set.getString("aklampu");
                String kolom10 = set.getString("aplampu");
                String kolom11 = set.getString("id");
                String kolom12 = set.getString("persensarana");
                String[] data = { kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8,kolom9,kolom10,kolom11,kolom12};
                DefaultTabelku.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

            kolom = jTabel1.getColumnModel().getColumn(0);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(1);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(2);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(3);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(4);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(5);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(6);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(7);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(8);
            kolom.setPreferredWidth(220);
            
            kolom = jTabel1.getColumnModel().getColumn(9);
             kolom.setPreferredWidth(0);
            kolom.setMinWidth(0);
            kolom.setMaxWidth(0);
            kolom.setWidth(0);
            kolom = jTabel1.getColumnModel().getColumn(10);
            kolom.setPreferredWidth(220);
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    private void tableModel3(JTable jTabel1,String KR) {
        try {
            Object[] field = { "Jumlah Kipas Angin", "Kondisi Kipas Angin", "Posisi Kipas Angin", "Jumlah AC", "Kondisi AC", "Posisi AC","SSID","Bandwidth","Jumlah CCTV ", "Kondisi CCTV", "Posisi CCTV","ID","Presentase"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from analisis_jkp_sarana2 where id="+KR;
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            int no = 0;
            while (set.next()) {
                String kolom2 = set.getString("ajkipasangin");
                String kolom3 = set.getString("akkipasangin");
                String kolom4 = set.getString("apkipasangin");
                String kolom5 = set.getString("ajac");
                String kolom6 = set.getString("akac");
                String kolom7 = set.getString("apac");
                String kolom8 = set.getString("assid");
                String kolom9 = set.getString("abandwidth");
                String kolom10 = set.getString("ajcctv");
                String kolom11 = set.getString("akcctv");
                String kolom12 = set.getString("apcctv");
                String kolom13 = set.getString("id");
                String kolom14 = set.getString("persensarana2");

                String[] data = { kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8,kolom9,kolom10,kolom11,kolom12,kolom13,kolom14};
                DefaultTabelku.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

            kolom = jTabel1.getColumnModel().getColumn(0);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(1);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(2);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(3);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(4);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(5);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(6);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(7);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(8);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(9);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(10);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(12);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(11);
            kolom.setPreferredWidth(0);
            kolom.setMinWidth(0);
            kolom.setMaxWidth(0);
            kolom.setWidth(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    private void tableModel8(JTable jTabel1,String KR) {
        try {
            Object[] field = { "Kekokohan", "Kunci Pintu Jendela", "Kebahayaan","Presentase"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from analisis_keamanan where id="+KR;
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            
            while (set.next()) {  
                String kolom2 = set.getString("akekokohan");
                String kolom3 = set.getString("akuncipintujendela");
                String kolom4 = set.getString("abahaya");
                String kolom5 = set.getString("persenaman");
                 String kolom6 = set.getString("id");
                String[] data = { kolom2, kolom3, kolom4, kolom5,kolom6};
                DefaultTabelku.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            
            kolom = jTabel1.getColumnModel().getColumn(0);
            kolom.setPreferredWidth(140);
            kolom = jTabel1.getColumnModel().getColumn(1);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(2);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(3);
            kolom.setPreferredWidth(217);
          
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
    }
    private void tableModel7(JTable jTabel1,String KR) {
        try {
            Object[] field = { "Lantai", "Dinding", "Atap", "Pintu","Jendela","ID","Presentase"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from analisis_kebersihan where id="+KR;
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            int no = 0;
            while (set.next()) {
                String kolom2 = set.getString("alantai");
                String kolom3 = set.getString("adinding");
                String kolom4 = set.getString("aatap");
                String kolom5 = set.getString("apintu");
                String kolom6 = set.getString("ajendela");
                String kolom7 = set.getString("id");
                String kolom8 = set.getString("persenbersih");
                String[] data = { kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8};
                DefaultTabelku.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            
            
            kolom = jTabel1.getColumnModel().getColumn(0);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(1);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(2);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(3);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(4);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(6);
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
    private void tableModel6(JTable jTabel1,String KR) {
        try {
            Object[] field = { "Kebisingan", "Bau", "Bocor", "Rusak","Aus","ID","Presentase"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from analisis_kenyamanan where id="+KR;
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            int no = 0;
            while (set.next()) {
                String kolom2 = set.getString("abising");
                String kolom3 = set.getString("abau");
                String kolom4 = set.getString("abocor");
                String kolom5 = set.getString("arusak");
                String kolom6 = set.getString("aaus");
                String kolom7 = set.getString("id");
                 String kolom8 = set.getString("persennyaman");
                String[] data = { kolom2, kolom3, kolom4, kolom5,kolom6,kolom7,kolom8};
                DefaultTabelku.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            
            
            kolom = jTabel1.getColumnModel().getColumn(0);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(1);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(2);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(3);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(4);
            kolom.setPreferredWidth(240);
            kolom = jTabel1.getColumnModel().getColumn(6);
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
    private void tableModel5(JTable jTabel1,String KR) {
        try {
            Object[] field = { "Sirkulasi Udara", "Pencahayaan", "Kelembaban", "Suhu","ID","Presentase"};
            DefaultTabelku = new DefaultTableModel(null, field){
                public boolean isCellEditable(int row, int column) {
                return false;
            }
    };
            
            jTabel1.setModel(DefaultTabelku);

            String sql = "Select * from analisis_lingkungan where id="+KR;
            Statement st = con.config.getConnection().createStatement();
            ResultSet set = st.executeQuery(sql);

            int no = 0;
            while (set.next()) {
                String kolom2 = set.getString("asirkulasiudara");
                String kolom3 = set.getString("acahaya");
                String kolom4 = set.getString("alembab");
                String kolom5 = set.getString("asuhu");
                String kolom6 = set.getString("id");
                String kolom7 = set.getString("persenlingkungan");
                String[] data = { kolom2, kolom3, kolom4, kolom5,kolom6,kolom7};
                DefaultTabelku.addRow(data);
            }

            jTabel1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            
            
            kolom = jTabel1.getColumnModel().getColumn(0);
            kolom.setPreferredWidth(145);
            kolom = jTabel1.getColumnModel().getColumn(1);
            kolom.setPreferredWidth(217);
            kolom = jTabel1.getColumnModel().getColumn(2);
            kolom.setPreferredWidth(220);
            kolom = jTabel1.getColumnModel().getColumn(3);
            kolom.setPreferredWidth(240);
            
            kolom = jTabel1.getColumnModel().getColumn(5);
            kolom.setPreferredWidth(240);
             kolom = jTabel1.getColumnModel().getColumn(4);
            kolom.setPreferredWidth(0);
            kolom.setMinWidth(0);
            kolom.setMaxWidth(0);
            kolom.setWidth(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e);
        }
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelidentitas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelkebersihan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelkondisi = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabellingkungan = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        sarana1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkenyamanan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelkeamanan = new javax.swing.JTable();
        back = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        sarana2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Identitas Kelas"));

        tabelidentitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "lolo", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelidentitas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Kebersihan Kelas"));

        tabelkebersihan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabelkebersihan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Kondisi Kelas"));

        tabelkondisi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tabelkondisi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Lingkungan Kelas"));

        tabellingkungan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tabellingkungan);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Sarana Kelas"));

        sarana1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(sarana1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Kenyamanan Kelas"));

        tabelkenyamanan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelkenyamanan);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Keamanan Kelas"));

        tabelkeamanan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tabelkeamanan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        back.setText("Kembali");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Sarana Kelas 2"));

        sarana2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(sarana2);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Data Kebersihan Kelas\n");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        new DataAwal().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(FrameOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameOutput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameOutput("1").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable sarana1;
    private javax.swing.JTable sarana2;
    private javax.swing.JTable tabelidentitas;
    private javax.swing.JTable tabelkeamanan;
    private javax.swing.JTable tabelkebersihan;
    private javax.swing.JTable tabelkenyamanan;
    private javax.swing.JTable tabelkondisi;
    private javax.swing.JTable tabellingkungan;
    // End of variables declaration//GEN-END:variables
}
