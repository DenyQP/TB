/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TB_Java;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author Deny SQP
 */
public class DatabaseWork {

DatabaseWork(){
    con.koneksi();
}
     
     Integer baris;
     Connect con = new Connect();
     JTable Tabelku = new JTable();
     DefaultTableModel DefaultTabelku;
     TableColumn kolom;
     String a, b,c,d,e,f,g;
//     DataAwal DA = new DataAwal();
     
    void Save(JTextField NM,JTextField LK,JTextField JR, JTextField FK) {
        
        String a,b,C,D;
        a = NM.getText();
        b = JR.getText();
        C = LK.getText();
        D = FK.getText();
        
        try {
            if (a.equals("") || C.equals("") || b.equals("") || D.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                
            } else {
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into identitas"
                        + "(nama, lokasi, prodi, fakultas) values ('" + a + "','" + C + "','" + b + "','" + D + "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
        NM.setEditable(false);
        FK.setEditable(false);
        LK.setEditable(false);
        JR.setEditable(false);
    }
    void Save(JTextField txtValue1,JTextField txtValue2,JTextField kursi,JTextField pintu,JTextField jendela) {
        
        a = txtValue1.getText();
        b = txtValue2.getText();
        c = kursi.getText();
        d = pintu.getText();
        e = jendela.getText();
        try {
            if (a.equals("") || c.equals("") || b.equals("") || d.equals("") || e.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                
            } else {
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into kondisi"
                        + "(panjang, lebar, kursi, pintu, jendela) values ('" + a + "','" + b + "','" + c + "','" + d + "','" + e + "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
        txtValue1.setEditable(false);
        txtValue2.setEditable(false);
        kursi.setEditable(false);
        pintu.setEditable(false);
        jendela.setEditable(false);
    }

    void Save(String Kokoh,String Adakunci,String Aman) {
       
        try {
            if (Kokoh.equals("") || Adakunci.equals("") || Aman.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                
            } else {
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into kondisi"
                        + "(kokoh, kunci, bahaya) values ('" +  Kokoh+ "','" + Adakunci + "','" + Aman + "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
    }
     void kondisiHapus(String Tabel,String Arrow,String id) {
        //g = id.getText();
        try {
            Statement st = con.config.getConnection().createStatement();
            st.executeUpdate(
                    " delete from "+Tabel+" where "+Arrow+" ='" + id + "'");
            
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal dihapus: " + ex);
        }
    }
}  
//