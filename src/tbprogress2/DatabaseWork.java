/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tbprogress2;

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
     String a, b,c,d,e,f,g,h,i,j,k,l;
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
     void Save(String KodeR,JTextField txtValue1,JTextField txtValue2,JTextField kursi,JTextField pintu,JTextField jendela) {
        
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
                        + "(id ,panjang, lebar, kursi, pintu, jendela) values ('" + KodeR + "','" + a + "','" + b + "','" + c + "','" + d + "','" + e + "')");

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
     
    void Save(String KodeR,JTextField kontak,String Kkontak,String Pkontak,JTextField jlcd,String KLCD,String PLCD,JTextField jlampu,String klampu,String plampu){
     //void Save(JTextField kontak,JTextField kskb,JTextField kskr,JTextField pskb,JTextField pskp,JTextField pskr,JTextField jlcd,JTextField kklb,JTextField kklr,JTextField pklb,JTextField Pojok1,JTextField pklr,JTextField jlampu,JTextField plb,JTextField plr,JTextField klb,JTextField klr){
//    a = kontak.getText();
//        b = kskb.getText();
//        c = kskr.getText();
//        d = pskb.getText();
//        e = pskp.getText();
//        f = kontak.getText();
//        g = kskb.getText();
//        h = kskr.getText();
//        i = pskb.getText();
//        j = pskp.getText();
//        k = pskr.getText();
//        l = jlcd.getText();
//        m = kklb.getText();
//        n = kklr.getText();
//        o = pklb.getText();
//        p = Pojok1.getText();
//        q = pklr.getText();
//        r = jlampu.getText();
//        s = plb.getText();
//        t = plr.getText();
//        u = klb.getText();
//        v = klr.getText();
        a = kontak.getText();
        b = Kkontak;
        c = Pkontak;
        d = jlcd.getText();
        e = KLCD;
        f = PLCD;
        g = jlampu.getText();
        h = klampu;
        i = plampu;
        try {
            if (a.equals("") || c.equals("") || b.equals("") || d.equals("") || e.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                
            } else {
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into jkp_sarana"
                        + "(id ,JStopKontak, KStopKontak, PStopKontak, JKabelLCD, KKabelLCD, PKabelLCD, JLampu, KLampu, PLampu) values ('" + KodeR + "','" + a + "','" + b + "','" + c + "','" + d + "','" + e + "','" + f + "','" + g + "','" + h + "','" + i + "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
       
    }
     void Save(String KodeR,JTextField jka,String pka,String kka,JTextField jac,String pac,String kac,JTextField ssid,String bw,JTextField jcctv,String kcctv,String pcctv){
        a = jka.getText();
        b = kka;
        c = pka;
        d = jac.getText();
        e = kac;
        g = pac;
        h = ssid.getText();
        i = bw;
        j = jcctv.getText();
        k = kcctv;
        l = pcctv;
        //jumlah total 11
        try {
            if (a.equals("") || c.equals("") || b.equals("") || d.equals("") || e.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                
            } else {
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into jkp_sarana2"
                        + "(id, JKipasAngin, KKipasAngin, PKipasAngin, JAC, KAC, PAC, SSID, bandwidth, JCCTV, KCCTV, PCCTV) values ('" 
                                + KodeR + "','" + a + "','" + b + "','" 
                                + c + "','" + d + "','" + e + "','" + g + "','" 
                                + h + "','" + i + "','" + j + "','" + k + "','" + l + "')");//jumlah total 12+ koder

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
       
    }

    void Save(String Kokoh,String Adakunci,String Aman,String KodeR) {
       
        try {
            if (Kokoh.equals("") || Adakunci.equals("") || Aman.equals("")) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                
            } else {
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into keamanan"
                        + "(id,kokoh, kunci, bahaya) values ('" +  KodeR+ "','"+  Kokoh+ "','" + Adakunci + "','" + Aman + "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
    }
    
    
      void Save(String id,String LB,String DB,String AB,String PB,String JB) {
        //  System.out.println(""+LB+DB+AB);
        try {
            if (LB.equals("") || DB.equals("") || AB.equals("") || PB.equals("") || JB.equals("") ) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                
            } else {
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into kebersihan"
                        + "(id,lantai, dinding, atap, pintu, jendela) values ('" +  id+ "','" +  LB+ "','" + DB + "','" + AB + "','" + PB + "','"+ JB + "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
    }
    
      
       void Save(String id,JTextField PBising,JTextField PBau,JTextField PAus,String BBanyak,String RBanyak) {
           
           try {
            if (PBising.equals("") || PBau.equals("") || PAus.equals("") || BBanyak.equals("") || RBanyak.equals("") ) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                
            } else {
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into kenyamanan"
                        + "(id,bising, bau, bocor, rusak, aus) values ('" + id + "','" + PBising.getText() + "','" + PBau.getText() + "','" + BBanyak + "','" + RBanyak  + "','"+ PAus.getText() + "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
       
       }
      
       
       
         void Save(String KodeR,int PRC,int PRL,int PSR,String SUL) {
             System.out.println(""+SUL);
             System.out.println(""+PSR);
           try {
            if (SUL.equals("") ) {
                JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
                
            } else {
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into lingkungan"
                        + "(id,udara, cahaya, lembab, suhu) values ('" + KodeR + "','" + SUL + "','" + PRC + "','" + PRL + "','" + PSR +  "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
       
       }
         
         
         
     void kondisiHapus(String id){
          try {
            Statement st = con.config.getConnection().createStatement();
            Statement stk = con.config.getConnection().createStatement();
            Statement st1 = con.config.getConnection().createStatement();
            Statement st2 = con.config.getConnection().createStatement();
            Statement st3 = con.config.getConnection().createStatement();
            Statement st4 = con.config.getConnection().createStatement();
            st.executeUpdate(
                    " delete from "+"identitas"+" where "+"id"+" ='" + id + "'");
            stk.executeUpdate(
                    " delete from "+"keamanan"+" where "+"id"+" ='" + id + "'"); 
            st1.executeUpdate(
                    " delete from "+"kebersihan"+" where "+"id"+" ='" + id + "'"); 
            st2.executeUpdate(
                    " delete from "+"kondisi"+" where "+"id"+" ='" + id + "'"); 
            st3.executeUpdate(
                    " delete from "+"kenyamanan"+" where "+"id"+" ='" + id + "'"); 
            st4.executeUpdate(
                    " delete from "+"lingkungan"+" where "+"id"+" ='" + id + "'"); 
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal dihapus: " + ex);
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
     void analisisSave(double persen,String id,double luas,String bentuk,double rasio,String arasio,String apintu,String ajendela){
         try {
            
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into analisis_kondisi"
                        + "(persenkondisi,id,luas,bentuk, rasio,arasio, apintu, ajendela) values ('"+ persen + "','" + id + "','" + luas + "','" + bentuk + "','" + rasio+ "','" + arasio  + "','" + apintu + "','"+ ajendela + "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
     }
     void analisisSave(double persen,String id,String ajstopkontak,String akstopkontak,String apstopkontak,String ajlcd,String aklcd,String aplcd,String ajlampu,String aklampu,String aplampu){
         try {
            
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into analisis_jkp_sarana"
                        + "( persensarana,id, ajstopkontak, akstopkontak, apstopkontak, ajlcd, aklcd, aplcd, ajlampu, aklampu, aplampu) values ('"+ persen + "','" + id + "','" + ajstopkontak + "','" + akstopkontak + "','" + apstopkontak + "','" + ajlcd  + "','" + aklcd + "','"+ aplcd + "','" + ajlampu +"','" + aklampu+"','" + aplampu+"')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
     }
     void analisisSave(double persen,String id,String ajkipasangin,String akkipasangin,String apkipasangin,String ajac,String akac,String apac,String ssid,String bandwidth,String ajcctv,String akcctv,String apcctv){
         try {
            
                
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into analisis_jkp_sarana2"
                        + "( persensarana2,id, ajkipasangin, akkipasangin, apkipasangin, ajac, akac, apac,assid,abandwidth, ajcctv, akcctv, apcctv) values ('"+ persen + "','" + id + "','" + ajkipasangin + "','" + akkipasangin + "','" + apkipasangin + "','" + ajac  + "','" + akac + "','"+ apac + "','" + ssid +"','" + bandwidth +"','" + ajcctv +"','" + akcctv+"','" + apcctv+"')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
     }
     void analisisSave(double persen,String id,String akekokohan,String akuncipintujendela,String abahaya) {
             
           try {
       
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into analisis_keamanan"
                        + "(persenaman,id, akekokohan, akuncipintujendela, abahaya) values ('"+ persen + "','" + id + "','" + akekokohan + "','" + akuncipintujendela + "','" + abahaya +  "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
       
       }
     void analisisSave(double persen,String id,String alantai,String adinding,String aatap,String apintu,String ajendela) {
             
           try {
       
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into analisis_kebersihan"
                        + "(persenbersih, id, alantai,adinding,aatap ,apintu ,ajendela) values ('"+ persen + "','" + id + "','" + alantai + "','" + adinding +"','" + aatap + "','" + apintu + "','" + ajendela +  "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
       
       }
     void analisisSave(double persen,String id,String abising,String abau,String abocor,String arusak,String aaus,int x) {
             
           try {
       
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into analisis_kenyamanan"
                        + "(persennyaman,id, abising,abau,abocor ,arusak ,aaus) values ('"+ persen + "','" + id + "','" + abising + "','" + abau +"','" + abocor + "','" + arusak + "','" + aaus +  "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
       
       }
       void analisisSave(double persen,String id,String asirkulasiudara,String acahaya,String alembab ,String asuhu) {
             
           try {
       
                Statement st = con.config.getConnection().createStatement();
                st.executeUpdate(
                        "insert into analisis_lingkungan"
                        + "(persenlingkungan,id, asirkulasiudara,acahaya,alembab ,asuhu ) values ('"+ persen + "','" + id + "','" + asirkulasiudara + "','" + acahaya +"','" + alembab + "','" + asuhu +  "')");

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan! : " + ex);
        }
       
       }
}  
//
