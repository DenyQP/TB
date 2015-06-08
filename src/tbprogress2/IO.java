/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tbprogress2;
import javax.swing.*;
import java.util.Scanner;
/**ASLDKLSAKDL
 *
 * @author Deny Qutara Putra (175)
 */
public class IO extends Proses implements View{
    
    Scanner in = new Scanner(System.in);
    RuangKelas kls = new RuangKelas();
    RuangKelas rk;
    public IO(JTextField nama,JTextField lokasi,JTextField fakultas,JTextField jurusan){
        kls.setNamaRuang(nama.getText());
        kls.setLokasiRuang(lokasi.getText());
        kls.setFakultas(fakultas.getText());
        kls.setProgramStudi(jurusan.getText());
        rk = new RuangKelas(kls.getNamaRuang(),kls.getLokasiRuang(),kls.getFakultas(),kls.getProgramStudi()); 
    }
    public IO(JTextField panjang,JTextField lebar,JTextField kursi,JTextField pintu,JTextField jendela){
        kls.setPanjangRuang(Integer.parseInt(panjang.getText()));
        kls.setLebarRuang(Integer.parseInt(lebar.getText()));
        kls.setJumlahPintu(Integer.parseInt(pintu.getText()));
        kls.setJumlahKursi(Integer.parseInt(kursi.getText()));
        kls.setJumlahJendela(Integer.parseInt(jendela.getText()));
        System.out.println(""+kls.getPanjangRuang());
        rk = new RuangKelas(kls.getPanjangRuang(),kls.getLebarRuang(),kls.getJumlahKursi(),kls.getJumlahPintu(),kls.getJumlahJendela()); 
    }
    
    public IO(JTextField kontak,JTextField kskb,JTextField kskr,JTextField pskb,JTextField pskp,JTextField pskr,JTextField jlcd,JTextField kklb,JTextField kklr,JTextField pklb,JTextField Pojok1,JTextField pklr,JTextField jlampu,JTextField plb,JTextField plr,JTextField klb,JTextField klr){
     kls.setJumlahStopKontak(Integer.parseInt(kontak.getText()));
        int a,b;
        a = Integer.parseInt(kskb.getText());
        b = Integer.parseInt(kskr.getText());
        if(a>=b){
            kls.setKondisiStopKontak("Baik");
        }
        else{
            kls.setKondisiStopKontak("Rusak");
        }
        int c,d,e;
        c = Integer.parseInt(pskb.getText());
        d = Integer.parseInt(pskp.getText());
        e = Integer.parseInt(pskr.getText());
        if(c>=e || d>=e){
            kls.setPosisiStopKontak("Dekat Dosen/Pojok Kelas");
        }
        else{
            kls.setPosisiStopKontak("Samping Kelas");
        }
        kls.setJumlahKabelLCD(Integer.parseInt(jlcd.getText()));
         int f,g;
        f = Integer.parseInt(kklb.getText());
        g = Integer.parseInt(kklr.getText());
        if(f>=g){
            kls.setKondisiKabelLCD("Baik");
        }
        else{
            kls.setKondisiKabelLCD("Rusak");
        }
          int h,i,j;
        h = Integer.parseInt(pklb.getText());
        i = Integer.parseInt(Pojok1.getText());
        j = Integer.parseInt(pklr.getText());
        if(h>=j || i>=j){
            kls.setPosisiKabelLCD("Dekat Dosen/Pojok Kelas");
        }
        else{
            kls.setPosisiKabelLCD("Samping Kelas");
        }
          kls.setJumlahLampu(Integer.parseInt(jlampu.getText()));
         int k,l;
        k = Integer.parseInt(plb.getText());
        l = Integer.parseInt(plr.getText());
        if(k>=l){
            kls.setKondisiLampu("Baik");
        }
        else{
            kls.setKondisiLampu("Rusak");
        }
          int m,n;
        m = Integer.parseInt(klb.getText());
        n = Integer.parseInt(klr.getText());
        if(m>=n){
            kls.setPosisiLampu("Atap Ruangan");
        }
        else{
            kls.setPosisiLampu("Selain Atap Ruangan");
        }
        rk = new RuangKelas(kls.getJumlahStopKontak(),kls.getKondisiStopKontak(),kls.getPosisiStopKontak(),kls.getJumlahKabelLCD(),kls.getKondisiKabelLCD(),kls.getPosisiKabelLCD(),kls.getJumlahLampu(),kls.getKondisiLampu(),kls.getPosisiLampu()); 
    }
     
       public IO(JTextField jka,JTextField pkab,JTextField pkar,JTextField kkab,JTextField kkar,JTextField jac,JTextField pacs,JTextField pacd,JTextField pacb,JTextField kacb,JTextField kacr,JTextField ssid,JCheckBox bb,JCheckBox bt,JTextField jcctv,JTextField kcctvb,JTextField kcctvr,JTextField pcctvb,JTextField pcctvr){
     kls.setJumlahKipasAngin(Integer.parseInt(jka.getText()));
        int a,b;
        a = Integer.parseInt(pkab.getText());
        b = Integer.parseInt(pkar.getText());
        if(a>=b){
            kls.setKondisiKipasAngin("Atap Ruangan");
        }
        else{
            kls.setKondisiKipasAngin("Samping Ruangan");
        }
        int c,d;
        c = Integer.parseInt(kkab.getText());
        d = Integer.parseInt(kkar.getText());
        if(c>=d){
            kls.setPosisiKipasAngin("Baik");
        }
        else{
            kls.setPosisiKipasAngin("Rusak");
        }
        kls.setJumlahAC(Integer.parseInt(jac.getText()));
         int e,f,g;
        e = Integer.parseInt(pacs.getText());
        f = Integer.parseInt(pacd.getText());
        g = Integer.parseInt(pacb.getText());
        if((e+g)>=f){
            kls.setPosisiAC("Samping/Belakang");
        }
        else{
            kls.setPosisiAC("Depan");
        }
        int h,i;
        h = Integer.parseInt(kacb.getText());
        i = Integer.parseInt(kacr.getText());
        
        if(h>=i){
            kls.setKondisiAC("Baik");
        }
        else{
            kls.setKondisiAC("Rusak");
        }
        kls.setSSID(ssid.getText());
        if(bb.isSelected()){
            kls.setBandwidth("Bisa");
        }
        else if(bt.isSelected()){
            kls.setBandwidth("Tidak Bisa");
        }
        
          kls.setJumlahCCTV(Integer.parseInt(jcctv.getText()));
         int k,l;
        k = Integer.parseInt(kcctvb.getText());
        l = Integer.parseInt(kcctvr.getText());
        if(k>=l){
            kls.setKondisiCCTV("Baik");
        }
        else{
            kls.setKondisiCCTV("Rusak");
        }
          int m,n;
        m = Integer.parseInt(pcctvb.getText());
        n = Integer.parseInt(pcctvr.getText());
        if(m>=n){
            kls.setPosisiCCTV("Depan/Belakang");
        }
        else{
            kls.setPosisiCCTV("Samping");
        }
       rk = new RuangKelas(kls.getJumlahKipasAngin(),kls.getKondisiKipasAngin(),kls.getPosisiKipasAngin(),kls.getJumlahAC(),kls.getKondisiAC(),kls.getPosisiAC(),kls.getSSID(),kls.getBandwidth(),kls.getJumlahCCTV(),kls.getKondisiCCTV(),kls.getPosisiCCTV());
     }
     
     
    public IO(JCheckBox Kokoh,JCheckBox TKokoh,JCheckBox Adakunci,JCheckBox Tkunci,JCheckBox Aman,JCheckBox Bahaya){
        if(Kokoh.isSelected()){
            kls.setKekokohan("Kokoh");
        }
        else if(TKokoh.isSelected()){
            kls.setKekokohan("Rapuh");
        }
        if(Adakunci.isSelected()){
            kls.setKunciPintuJendela("Terkunci");
        }
        else if(Tkunci.isSelected()){
            kls.setKunciPintuJendela("Terbuka");
        }
        if(Aman.isSelected()){
            kls.setBahaya("Aman");
        }
        else if(Bahaya.isSelected()){
            kls.setBahaya("Berbahaya");
        }
        rk = new RuangKelas(kls.getKekokohan(),kls.getKunciPintuJendela(),kls.getBahaya()); 
    
    }
    public IO(JTextField Bising,JTextField PBising,JTextField Bau,JTextField PBau,JTextField Aus,JTextField PAus,JCheckBox BBanyak,JCheckBox BSedang,JCheckBox BSedikit,JCheckBox BNon,JCheckBox RBanyak,JCheckBox RSedang,JCheckBox RSedikit,JCheckBox RNon){
        if(BBanyak.isSelected()){
            kls.setKebocoran("Sangat Parah");
        }
        else if(BSedang.isSelected()){
            kls.setKebocoran("Parah");
        }
        else if(BSedikit.isSelected()){
            kls.setKebocoran("Tidak Begitu Parah");
        }
        else if(BNon.isSelected()){
            kls.setKebocoran("Keadaan Baik");
        }
            if(RBanyak.isSelected()){
                kls.setKerusakan("Sangat Parah");
            }
            else if(RSedang.isSelected()){
                kls.setKerusakan("Parah");
            }
            else if(RSedikit.isSelected()){
                kls.setKerusakan("Tidak Begitu Parah");
            }
            else if(RNon.isSelected()){
                kls.setKerusakan("Keadaan Baik");
            }
        kls.setKebisingan(Bising.getText());
        kls.setKeausan(Aus.getText());
        kls.setBau(Bau.getText());
        //String Kebisingan, String Bau, String Kebocoran, String Kerusakan, String Keausan, String x
        rk = new RuangKelas(kls.getKebisingan(),kls.getBau(),kls.getKebocoran(),kls.getKerusakan(),kls.getKeausan(),null); 
    }
    public IO(JCheckBox LB,JCheckBox LBR,JCheckBox DB,JCheckBox DBR,JCheckBox AB,JCheckBox ABR,JCheckBox PB,JCheckBox PBR,JCheckBox JB,JCheckBox JBR){
        if(LB.isSelected()){
            kls.setKondisiLantai("Lantai Bersih");
        }
        else if(LBR.isSelected()){
            kls.setKondisiLantai("Lantai Kotor");
        }
        if(DB.isSelected()){
            kls.setKondisiDinding("Dinding Bersih/Baik");
        }
        else if(DBR.isSelected()){
            kls.setKondisiDinding("Dinding Kotor");
        }
        if(AB.isSelected()){
            kls.setKondisiAtap("Atap Bersih");
        }
        else if(ABR.isSelected()){
            kls.setKondisiAtap("Atap Kotor");
        }
        if(PB.isSelected()){
            kls.setKondisiPintu("Pintu Bersih/Baik");
        }
        else if(PBR.isSelected()){
            kls.setKondisiPintu("Pintu Kotor");
        }
        if(JB.isSelected()){
            kls.setKondisiJendela("Jendela Bersih/Baik");
        }
        else if(JBR.isSelected()){
            kls.setKondisiJendela("Jendela Kotor");
        }
        rk = new RuangKelas(kls.getKondisiLantai(),kls.getKondisiDinding(),kls.getKondisiAtap(),kls.getKondisiPintu(),kls.getKondisiJendela()); 
    }
    public IO(JCheckBox SUL,JCheckBox SUT,JTextField PC  ,JTextField PL ,JTextField PS ){
        if(SUL.isSelected()){
            kls.setSirkulasiUdara("Lancar");
        }
        else if(SUT.isSelected()){
            kls.setSirkulasiUdara("Tidak Lancar");
        }
        int cahaya = Integer.parseInt(PC.getText());
        int lembab = Integer.parseInt(PL.getText());
        int suhu = Integer.parseInt(PC.getText());
        kls.setNilaiPencahayaan(cahaya);
        kls.setKelembaban(lembab);
        kls.setSuhu(suhu);
        rk = new RuangKelas(kls.getSirkulasiUdara(),kls.getNilaiPencahayaan(),kls.getKelembaban(),kls.getSuhu()); 
    
    }
    public IO(JTextField kontak,JTextField KondisiSK,JTextField PosisiSK,JTextField jlcd,JTextField KondisiKL, JTextField PosisiKL,JTextField jlampu,JTextField KondisiL,JTextField PosisiL){
            kls.setJumlahStopKontak(Integer.parseInt(kontak.getText()));    
            kls.setKondisiStopKontak(KondisiSK.getText());
            kls.setPosisiStopKontak(PosisiSK.getText());
            kls.setJumlahKabelLCD(Integer.parseInt(jlcd.getText()));
            kls.setKondisiKabelLCD(KondisiKL.getText());
            kls.setPosisiKabelLCD(PosisiKL.getText());
            kls.setJumlahLampu(Integer.parseInt(jlampu.getText()));
            kls.setKondisiLampu(KondisiL.getText());
            kls.setPosisiLampu(PosisiL.getText());  
        rk = new RuangKelas(kls.getJumlahStopKontak(),kls.getKondisiStopKontak(),kls.getPosisiStopKontak(),kls.getJumlahKabelLCD(),kls.getKondisiKabelLCD(),kls.getPosisiKabelLCD(),kls.getJumlahLampu(),kls.getKondisiLampu(),kls.getPosisiLampu()); 
    }
    public IO(JTextField jka,JTextField kondisiKA,JTextField posisiKA,JTextField jac,JTextField kondisiAC,JTextField posisiAC,JTextField ssid,JCheckBox bb,JCheckBox bt,JTextField jcctv,JTextField kondisiCCTV ,JTextField posisiCCTV){
        kls.setJumlahKipasAngin(Integer.parseInt(jka.getText()));
            kls.setKondisiKipasAngin(kondisiKA.getText());
            kls.setPosisiKipasAngin(posisiKA.getText());
        
        kls.setJumlahAC(Integer.parseInt(jac.getText()));
          kls.setPosisiAC(kondisiAC.getText());
          kls.setKondisiAC(posisiAC.getText());
        
        kls.setSSID(ssid.getText());
        if(bb.isSelected()){   
        kls.setBandwidth("Bisa");
        }
        else if(bt.isSelected()){
            kls.setBandwidth("Tidak");
        }
          kls.setJumlahCCTV(Integer.parseInt(jcctv.getText()));
          kls.setPosisiCCTV(posisiCCTV.getText());
          kls.setKondisiCCTV(kondisiCCTV.getText());
          rk = new RuangKelas(kls.getJumlahKipasAngin(),kls.getKondisiKipasAngin(),kls.getPosisiKipasAngin(),kls.getJumlahAC(),kls.getKondisiAC(),kls.getPosisiAC(),kls.getSSID(),kls.getBandwidth(),kls.getJumlahCCTV(),kls.getKondisiCCTV(),kls.getPosisiCCTV());
     }
    public IO(){
        
    }
    
    
    public RuangKelas getRuangKelas(){
    return rk;
    }
    
    @Override
    public void inputIdentitasKelas(){
        new DataAwal().setVisible(true);
        
    }
    @Override
    public void InputKondisiRuang(String Kode){
       new KondisiRuang(Kode).setVisible(true);
//        System.out.println("Masukkan Panjang Ruang : ");
//        kls.setPanjangRuang(in.nextInt());
//        System.out.println("Masukkan Lebar Ruang : ");
//        kls.setLebarRuang(in.nextInt());
//        System.out.println("Masukkan Jumlah Kursi : ");
//        kls.setJumlahKursi(in.nextInt());
//        System.out.println("Masukkan Jumlah Pintu : ");
//        kls.setJumlahPintu(in.nextInt());
//        System.out.println("Masukkan Jumlah Jendela : ");
//        kls.setJumlahJendela(in.nextInt());
//        rk = new RuangKelas(kls.getPanjangRuang(),kls.getLebarRuang(),kls.getJumlahKursi(),kls.getJumlahPintu(),kls.getJumlahJendela());
//        
    }
    @Override
    public void inputKondisiSarana(String Kode){
        new KondisiSarana(Kode).setVisible(true);
//        System.out.println("Masukkan Jumlah Stop Kontak : ");
//        kls.setJumlahStopKontak(in.nextInt());
//        System.out.println("Masukkan Kondisi Stop Kontak : ");
//        kls.setKondisiStopKontak(in.next());
//        System.out.println("Masukkan Posisi Stop Kontak : ");
//        kls.setPosisiStopKontak(in.next());
//        System.out.println("Masukkan Jumlah Kabel LCD : ");
//        kls.setJumlahKabelLCD(in.nextInt());
//        System.out.println("Masukkan Kondisi Kabel LCD : ");
//        kls.setKondisiKabelLCD(in.next());
//        System.out.println("Masukkan Posisi Kabel LCD : ");
//        kls.setPosisiKabelLCD(in.next());
//        System.out.println("Masukkan Jumlah Lampu : ");
//        kls.setJumlahLampu(in.nextInt());
//        System.out.println("Masukkan Kondisi Lampu : ");
//        kls.setKondisiLampu(in.next());
//        System.out.println("Masukkan Posisi Lampu : ");
//        kls.setPosisiLampu(in.next());
//        
        //rk = new RuangKelas(kls.getJumlahStopKontak(),kls.getKondisiStopKontak(),kls.getPosisiStopKontak(),kls.getJumlahKabelLCD(),kls.getKondisiKabelLCD(),kls.getPosisiKabelLCD(),kls.getJumlahLampu(),kls.getKondisiLampu(),kls.getPosisiLampu());
    }
     @Override
     public void inputKondisiSarana2(String Kode){
          new KondisiSarana2(Kode).setVisible(true);
     
//        System.out.println("Masukkan Jumlah Kipas Angin : ");
//        kls.setJumlahKipasAngin(in.nextInt());
//        System.out.println("Masukkan Kondisi Kipas Angin : ");
//        kls.setKondisiKipasAngin(in.next());
//        System.out.println("Masukkan Posisi Kipas Angin : ");
//        kls.setPosisiKipasAngin(in.next());
//        System.out.println("Masukkan Jumlah AC : ");
//        kls.setJumlahAC(in.nextInt());
//        System.out.println("Masukkan Kondisi AC : ");
//        kls.setKondisiAC(in.next());
//        System.out.println("Masukkan Posisi AC : ");
//        kls.setPosisiAC(in.next());
//        System.out.println("Masukkan SSID : ");
//        kls.setSSID(in.next());
//        System.out.println("Masukkan Bandwidth : ");
//        kls.setBandwidth(in.next());
//        System.out.println("Masukkan Jumlah CCTV : ");
//        kls.setJumlahCCTV(in.nextInt());
//        System.out.println("Masukkan Kondisi CCTV : ");
//        kls.setKondisiCCTV(in.next());
//        System.out.println("Masukkan Posisi CCTV : ");
//        kls.setPosisiCCTV(in.next());
//        rk = new RuangKelas (kls.getJumlahKipasAngin(),kls.getKondisiKipasAngin(),kls.getPosisiKipasAngin(),kls.getJumlahAC(),kls.getKondisiAC(),kls.getPosisiAC(),kls.getSSID(),kls.getBandwidth(),kls.getJumlahCCTV(),kls.getKondisiCCTV(),kls.getPosisiCCTV());
         }
    
    @Override
    public void inputKondisiKebersihan(String Kode){
        new KondisiKebersihan(Kode).setVisible(true);
    
//        System.out.println("Masukkan Kondisi Lantai : ");
//        kls.setKondisiLantai(in.next());
//        System.out.println("Masukkan Kondisi Dinding : ");
//        kls.setKondisiDinding(in.next());
//        System.out.println("Masukkan Kondisi Atap : ");
//        kls.setKondisiAtap(in.next());
//        System.out.println("Masukkan Kondisi Pintu : ");
//        kls.setKondisiPintu(in.next());
//        System.out.println("Masukkan Kondisi Jendela : ");
//        kls.setKondisiJendela(in.next());
//        rk = new RuangKelas(kls.getKondisiLantai(),kls.getKondisiDinding(),kls.getKondisiAtap(),kls.getKondisiPintu(),kls.getKondisiJendela());
    }
    
    @Override
    public void inputKondisiLingkungan(String Kode){
        new KondisiLingkungan(Kode).setVisible(true);
//        System.out.println("Masukkan Sirkulasi Udara: ");
//        kls.setSirkulasiUdara(in.next());
//        System.out.println("Masukkan Nilai Pencahayaan : ");
//        kls.setNilaiPencahayaan(in.nextInt());
//        System.out.println("Masukkan Kelembaban (%) : ");
//        kls.setKelembaban(in.nextInt());
//        System.out.println("Masukkan Suhu (celcius) : ");
//        kls.setSuhu(in.nextInt());
//        rk = new RuangKelas(kls.getSirkulasiUdara(),kls.getNilaiPencahayaan(),kls.getKelembaban(),kls.getSuhu());   
//    }
    }
    @Override
      public void inputKondisiKenyamanan(String Kode){
          new KondisiKenyamanan(Kode).setVisible(true);
//        System.out.println("Masukkan Kebisingan : ");
//        kls.setKebisingan(in.next());
//        System.out.println("Masukkan Bau : ");
//        kls.setBau(in.next());
//        System.out.println("Masukkan Kebocoran : ");
//        kls.setKebocoran(in.next());
//        System.out.println("Masukkan Kerusakan : ");
//        kls.setKerusakan(in.next());
//        System.out.println("Masukkan Keausan (Rusaknya Permukaan Kelas): ");
//        kls.setKeausan(in.next());
//        rk = new RuangKelas(kls.getKebisingan(),kls.getBau(),kls.getKebocoran(),kls.getKerusakan(),kls.getKeausan());
//        
    }
    
    @Override
    public void inputKondisiKeamanan(String KR){
                new KondisiKeamanan(KR).setVisible(true);
        
        //new KondisiKeamanan().setVisible(true);
//        System.out.println("Apakah Bangunan Masih Kokoh ? : ");
//        kls.setKekokohan(in.next());
//        System.out.println("Apakah Ada Kunci Pintu dan Jendela ? : ");
//        kls.setKunciPintuJendela(in.next());
//        System.out.println("Apakah Ruangan Tidak Berbahaya ? : ");
//        kls.setBahaya(in.next());
//        rk = new RuangKelas(kls.getKekokohan(),kls.getKunciPintuJendela(),kls.getBahaya());

    }
    
    @Override
    public void IdentitasKelas(){ 
        System.out.println("=========Identitas Kelas=========");
        System.out.println("Nama Ruang : "+kls.getNamaRuang());
        System.out.println("klskasi Ruang : "+kls.getLokasiRuang());  
        System.out.println("Fakultas : "+kls.getFakultas());
        System.out.println("Program Studi : "+kls.getProgramStudi());
    }
    @Override
    public void output(int PanjangRuang,int LebarRuang,int JumlahKursi,int JumlahPintu,int JumlahJendela){
        //System.out.println("==============Hasil===============");
        System.out.println("=========Kondisi Ruang Kelas=========");
        System.out.println("Panjang Ruang : "+PanjangRuang);
        System.out.println("Lebar Ruang : "+LebarRuang);
        System.out.println("Jumlah Kursi : "+JumlahKursi);
        System.out.println("Jumlah Pintu : "+JumlahPintu);
        System.out.println("Jumlah Jendela : "+JumlahJendela);
    }
    @Override
    public void output(int JumlahStopKontak,String KondisiStopKontak,String PosisiStopKontak,int JumlahKabelLCD,String KondisiKabelLCD,String PosisiKabelLCD,int JumlahLampu,String KondisiLampu,String PosisiLampu) {
        System.out.println("=========Kondisi Sarana=========");
        System.out.println("Jumlah Stop Kontak : "+JumlahStopKontak);
        System.out.println("Kondisi Stop Kontak : "+KondisiStopKontak);
        System.out.println("Posisi Stop Kontak : "+PosisiStopKontak);
        System.out.println("Jumlah Kabel LCD : "+JumlahKabelLCD);
        System.out.println("Kondisi Kabel LCD : "+KondisiKabelLCD);
        System.out.println("Posisi Kabel LCD : "+PosisiKabelLCD);
        System.out.println("Jumlah Lampu : "+JumlahLampu);
        System.out.println("Kondisi Lampu : "+KondisiLampu);
        System.out.println("Posisi Lampu : "+PosisiLampu);
        
 }   
    @Override
    public void output (int JumlahKipasAngin,String KondisiKipasAngin,String PosisiKipasAngin,int JumlahAC,String KondisiAC,String PosisiAC,String SSID,String Bandwidth,int JumlahCCTV,String KondisiCCTV,String PosisiCCTV){
        System.out.println("Jumlah Kipas Angin : "+JumlahKipasAngin);
        System.out.println("Kondisi Kipas Angin : "+KondisiKipasAngin);
        System.out.println("Posisi Kipas Angin : "+PosisiKipasAngin);
        System.out.println("Jumlah AC : "+JumlahAC);
        System.out.println("Kondisi AC : "+KondisiAC);
        System.out.println("Posisi AC : "+PosisiAC);
        System.out.println("SSID : "+SSID);
        System.out.println("Bandwidth : "+Bandwidth);
        System.out.println("Jumlah CCTV : "+JumlahCCTV);
        System.out.println("Kondisi CCTV : "+KondisiCCTV);
        System.out.println("Posisi CCTV : "+PosisiCCTV);
    
    
    
    }
    @Override
    public void output(String KondisiLantai,String KondisiDinding, String KondisiAtap, String KondisiPintu, String KondisiJendela){
          System.out.println("===============Kondisi Lingkungan=================");
          System.out.println("Kondisi Lantai : "+KondisiLantai); 
          System.out.println("Kondisi Dinding : "+KondisiDinding);
          System.out.println("Kondisi Atap : "+KondisiAtap);
          System.out.println("Kondisi Pintu : "+KondisiPintu);
          System.out.println("Kondisi Jendela : "+KondisiJendela);
  }

    @Override
    public void output(String SirkulasiUdara, int NilaiPencahayaan, int Kelembaban, int Suhu){
        System.out.println("===============Kenyamanan================");
        System.out.println("Sirkulasi Udara : "+SirkulasiUdara);
        System.out.println("Nilai Pencahayaan "+NilaiPencahayaan+" %");
        System.out.println("Kelembaban : "+Kelembaban+" %");
        System.out.println("Suhu : "+Suhu+" Celcius");
 }
 
    @Override
    public void output(String Kebisingan, String Bau, String Kebocoran, String Kerusakan, String Keausan, String x){
        System.out.println("===============Kenyamanan===============");
        System.out.println("Kebisingan : "+Kebisingan);
        System.out.println("Bau : "+Bau);
        System.out.println("Kebocoran : "+Kebocoran);
        System.out.println("Kerusakan : "+Kerusakan);
        System.out.println("Keausan : "+Keausan);
    }

    @Override
    public void output (String Kekokohan,String KunciPintuJendela,String Bahaya){
        System.out.println("===============Keamanan===============");
        System.out.println("Kekokohan : "+Kekokohan);
        System.out.println("Kunci Pintu dan Jendela : "+KunciPintuJendela);
        System.out.println("Bahaya : "+Bahaya); 
    } 

    @Override
    double persentaseKondisiRuang(int s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    double persentaseKondisiSarana(int s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    double persentaseKondisiSarana2(int s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    double persentaseKondisiLingkungan(int s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    double persentaseKondisiKebersihan(int s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    double persentaseKenyamanan(int s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    double persentaseKeamanan(int s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}