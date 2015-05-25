/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tbprogress2;
import javax.swing.*;
import java.util.Scanner;
/**ASLDKLSAKDL
 *
 * @author ms Deny Qutara Putra (175)
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
    public void InputKondisiRuang(){
       new KondisiRuang().setVisible(true);
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
    public void inputKondisiSarana(){
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
//        rk = new RuangKelas(kls.getJumlahStopKontak(),kls.getKondisiStopKontak(),kls.getPosisiStopKontak(),kls.getJumlahKabelLCD(),kls.getKondisiKabelLCD(),kls.getPosisiKabelLCD(),kls.getJumlahLampu(),kls.getKondisiLampu(),kls.getPosisiLampu(),kls.getJumlahKipasAngin(),kls.getKondisiKipasAngin(),kls.getPosisiKipasAngin(),kls.getJumlahAC(),kls.getKondisiAC(),kls.getPosisiAC(),kls.getSSID(),kls.getBandwidth(),kls.getJumlahCCTV(),kls.getKondisiCCTV(),kls.getPosisiCCTV());
    }
//    
    @Override
    public void inputKondisiLingkungan(){
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
    public void inputKondisiKebersihan(){
     
//        System.out.println("Masukkan Sirkulasi Udara: ");
//        kls.setSirkulasiUdara(in.next());
//        System.out.println("Masukkan Nilai Pencahayaan : ");
//        kls.setNilaiPencahayaan(in.nextInt());
//        System.out.println("Masukkan Kelembaban (%) : ");
//        kls.setKelembaban(in.nextInt());
//        System.out.println("Masukkan Suhu (celcius) : ");
//        kls.setSuhu(in.nextInt());
//        rk = new RuangKelas(kls.getSirkulasiUdara(),kls.getNilaiPencahayaan(),kls.getKelembaban(),kls.getSuhu());   
    }
    @Override
      public void inputKondisiKenyamanan(){
        System.out.println("Masukkan Kebisingan : ");
        kls.setKebisingan(in.next());
        System.out.println("Masukkan Bau : ");
        kls.setBau(in.next());
        System.out.println("Masukkan Kebocoran : ");
        kls.setKebocoran(in.next());
        System.out.println("Masukkan Kerusakan : ");
        kls.setKerusakan(in.next());
        System.out.println("Masukkan Keausan (Rusaknya Permukaan Kelas): ");
        kls.setKeausan(in.next());
        rk = new RuangKelas(kls.getKebisingan(),kls.getBau(),kls.getKebocoran(),kls.getKerusakan(),kls.getKeausan());
        
    }
    
    @Override
    public void inputKondisiKeamanan(){
        new KondisiKeamanan().setVisible(true);
        
       
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
 public void output(int JumlahStopKontak,String KondisiStopKontak,String PosisiStopKontak,int JumlahKabelLCD,String KondisiKabelLCD,String PosisiKabelLCD,int JumlahLampu,String KondisiLampu,String PosisiLampu,int JumlahKipasAngin,String KondisiKipasAngin,String PosisiKipasAngin,int JumlahAC,String KondisiAC,String PosisiAC,String SSID,String Bandwidth,int JumlahCCTV,String KondisiCCTV,String PosisiCCTV) {
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
        System.out.println("Nilai Pencahayaan "+NilaiPencahayaan);
        System.out.println("Kelembaban : "+Kelembaban);
        System.out.println("Suhu : "+Suhu);
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
    void persentaseKondisiRuang(int s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void persentaseKondisiSarana() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void persentaseKondisiLingkungan() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void persentaseKondisiKebersihan() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void persentaseKenyamanan(int s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void persentaseKeamanan(int s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}