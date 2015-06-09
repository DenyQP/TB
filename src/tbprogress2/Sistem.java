/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tbprogress2;

import java.util.Scanner;

/**
 *
 * @author Eko Ari Irawan (167)
 */
public class Sistem extends Proses{

    IO inop = new IO();
    RuangKelas kls = new RuangKelas();
    DatabaseWork con = new DatabaseWork();
    Scanner in = new Scanner(System.in);
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

    double CheckKondisiRuang(RuangKelas kls,String IDKelas) {

        String arasio,bentuk,apintu,ajendela;
        Luas = kls.getPanjangRuang() * kls.getLebarRuang();
        if (kls.getLebarRuang() == kls.getPanjangRuang()) {
            
            bentuk = "Bentuk Tidak Sesuai";
           
            ts++;
        } else {
            System.out.println("Luas = "+Luas);
            bentuk = "Bentuk Sesuai";
            s++;
        }
        RasioLuas = Luas / kls.getJumlahKursi();
        System.out.println("Rasio : " + RasioLuas);
        if(RasioLuas<=0.5){
            arasio ="Tidak Sesuai";
        }
        else{
            arasio = "Sesuai";
            s++;
        }
        if (kls.getJumlahPintu() >= 2) {
            apintu = "Sesuai";
            s++;
        } else {
            apintu = "Tidak Sesuai";
           // System.out.println("Jumlah Pintu Tidak Sesuai");
            ts++;
        }
        if (kls.getJumlahJendela() >= 1) {
            ajendela = "Sesuai";
            s++;
        } else {
            ajendela = "Tidak Sesuai";
            ts++;
        }
        con.analisisSave(persentaseKondisiRuang(s),IDKelas, Luas, bentuk, RasioLuas,arasio, apintu, ajendela);
        
        return s;
    } 
   @Override
   double persentaseKondisiRuang(int s){
        double total = s*25;
     return total;
    }

    double CheckKondisiSarana(RuangKelas kls,String IDRuang) {
        String ajstopkontak,akstopkontak,apstopkontak;
        String ajlcd,aklcd,aplcd;
        String ajlampu,aklampu,aplampu;
        
        if (kls.getJumlahStopKontak() >= 4) {
            ajstopkontak = "Sesuai";
            s++;
        } else {
            ajstopkontak = "Tidak Sesuai";
            ts++;
        }
        if (kls.getKondisiStopKontak().equalsIgnoreCase("baik")){
            akstopkontak = "Sesuai";
            s++;
        } else {
            akstopkontak = "Tidak Sesuai";
        }
        if (kls.getPosisiStopKontak().equalsIgnoreCase("DekatDosen") || kls.getPosisiStopKontak().equalsIgnoreCase("PojokKelas")) {
            apstopkontak = "Sesuai";
            s++;
        } else {
            apstopkontak = "Tidak Sesuai";
            ts++;
        }
        if(kls.getJumlahKabelLCD()>=1){
            ajlcd = "Sesuai";
            s++;

        } else {
             ajlcd = "Tidak Sesuai";
            ts++;
        }
        if(kls.getKondisiKabelLCD().equalsIgnoreCase("baik")|| kls.getKondisiKabelLCD().equalsIgnoreCase("berfungsi")){
            aklcd = "Sesuai";
            s++;
        }else{
           aklcd = "Tidak Sesuai";
            ts++;
        }
        if(kls.getPosisiKabelLCD().equalsIgnoreCase("dekatdosen")){
            aplcd = "Sesuai";
            s++;
        }else{
            aplcd = "Tidak Sesuai";
            ts++;
        }
        if(kls.getJumlahLampu()>=18){
            ajlampu = "Sesuai";
            s++;
        }else{
            ajlampu = "Tidak Sesuai";
            ts++;
        }
        if(kls.getKondisiLampu().equalsIgnoreCase("baik")){
            aklampu = "Sesuai";
            s++;
        }else{
            aklampu = "Tidak Sesuai";
            ts++;
        }
        if(kls.getPosisiLampu().equalsIgnoreCase("atapruangan")){
            aplampu = "Sesuai";
            s++;
        } else {
            aplampu = "Tidak Sesuai";
            ts++;
        }
        con.analisisSave(persentaseKondisiSarana(s),IDRuang, ajstopkontak, akstopkontak, apstopkontak, ajlcd, aklcd, aplcd, ajlampu, aklampu, aplampu);
      
        return s;
    }
    @Override
    double persentaseKondisiSarana(int s){
        double total = s*11;
       return total;
    }
    double CheckKondisiSarana2(RuangKelas kls,String IDKelas) {

        String ajkipasangin, akkipasangin, apkipasangin, ajac, akac, apac,assid,abandwidth, ajcctv, akcctv, apcctv;
         if(kls.getJumlahKipasAngin()>=2){
          
            ajkipasangin = "Sesuai";
             s++;
        } else {
            
            ajkipasangin = "Tidak Sesuai";
             ts++;
        }
        if(kls.getPosisiKipasAngin().equalsIgnoreCase("Baik")){
            //System.out.println("PosisiKipasAngin : s");
            akkipasangin = "Sesuai";
            s++;
        } else {
            //System.out.println("Tidak s");
            akkipasangin = "Tidak Sesuai";
            ts++;
        }
        if(kls.getKondisiKipasAngin().equalsIgnoreCase("Atap Ruangan")){
            //System.out.println("KondisiKipasAngin : s");
            apkipasangin = "Sesuai";
            s++;
        }else {
            apkipasangin = "Tidak Sesuai";
           // System.out.println("Tidak s");
            ts++;
        }
        if(kls.getJumlahAC()>=1){
            //System.out.println("JumlahAC : s");
            ajac = "Sesuai";
            s++;
        } else {
           // System.out.println("Tidak s");
            ajac = "Tidak Sesuai";
            ts++;
        }
        if(kls.getKondisiAC().equalsIgnoreCase("Baik")){
            //System.out.println("KondisiAC : s");
            akac = "Sesuai";
            s++;
        } else {
            //System.out.println("Tidak s");
            akac = "Tidak Sesuai";
            s++;
        }
        if(kls.getPosisiAC().equalsIgnoreCase("Samping/Belakang")){
            //System.out.println("PosisiAC : s");
            apac = "Sesuai";
            s++;
        } else {
            //System.out.println("Tidak s");
            apac = "Tidak Sesuai";
            ts++;
        }
        if(kls.getSSID().equalsIgnoreCase("UMMHotspot")){
            //System.out.println("getSSID : s");
            assid = "Sesuai";
            s++;
        } else {
           // System.out.println("Tidak s");
            assid = "Tidak Sesuai";
            ts++;
        }
        if(kls.getBandwidth().equalsIgnoreCase("Bisa")){
            //System.out.println("Bandwidth : s");
            abandwidth = "Sesuai";
            s++;
        } else {
            abandwidth = "Tidak Sesuai";
            //System.out.println("Tidak s");
            ts++;
        }
        if (kls.getJumlahCCTV()>=2){
           // System.out.println("JumlahCCTV : s");
            ajcctv = "Sesuai";
            s++;
        } else {
           // System.out.println("Tidak s");
            ajcctv = "Tidak Sesuai";
            ts++;
        }
        if(kls.getKondisiCCTV().equalsIgnoreCase("Baik")){
           // System.out.println("KondisiCCTV : s");
            akcctv = "Sesuai";
            s++;
        } else {
           // System.out.println("Tidak s");
            akcctv = "Tidak Sesuai";
            ts++;
        }
        if(kls.getPosisiCCTV().equalsIgnoreCase("Depan/Belakang")){
           // System.out.println("PosisiCCTV : s");
            apcctv = "Sesuai";
            s++;
        } else {
           // System.out.println("Tidak s");
            apcctv = "Tidak Sesuai";
            ts++;
        }
        
        con.analisisSave(persentaseKondisiSarana2(s),IDKelas, ajkipasangin, akkipasangin, apkipasangin, ajac, akac, apac, assid, abandwidth, ajcctv, akcctv, apcctv);
        //inop.output(kls.getJumlahKipasAngin(), kls.getKondisiKipasAngin(), kls.getPosisiKipasAngin() , kls.getJumlahAC(), kls.getKondisiAC(), kls.getPosisiAC(), kls.getSSID(), kls.getBandwidth(), kls.getJumlahCCTV(), kls.getKondisiCCTV(), kls.getPosisiCCTV());
    return s;
    }
    @Override
    double persentaseKondisiSarana2(int s){
        double total = s*9;
 
       return total;
    }
    int CheckKondisiLingkungan(RuangKelas kls,String IDKelas) {
    String asirkulasiudara,acahaya="",alembab="",asuhu="";
        if ("Lancar".equalsIgnoreCase(kls.getSirkulasiUdara())) {
            //System.out.println("Sirkulasi Udara : Sesuai");
            asirkulasiudara = "Sesuai";
            s++;
        } else {
           // System.out.println("Sirkulasi Udara : Tidak Sesuai");
            asirkulasiudara = "Tidak Sesuai";
            ts++;
        }
        if (kls.getNilaiPencahayaan() >= 60&&kls.getNilaiPencahayaan() < 80) {
            acahaya = "Sesuai";
            s++;
        } else {
            //System.out.println("Nilai Pencahayaan : Tidak Sesuai");
            acahaya = "Tidak Sesuai";
            ts++;
        }
        if (kls.getKelembaban() >= 70&&kls.getKelembaban() <= 80) {
               alembab = "Sesuai";
            
            s++;
        } else {
            //System.out.println("Kelembaban : Tidak Sesuai");
            alembab = "Tidak Sesuai";
            ts++;
        }
        
        if (kls.getSuhu() >= 25&&kls.getSuhu() <= 35) {
                //System.out.println("Suhu : Sesuai");
                asuhu = "Sesuai";
                s++;
        } else {
            //System.out.println("Suhu : Tidak Sesuai");
                asuhu = "Tidak Sesuai";
                ts++;
        }
        con.analisisSave(persentaseKondisiLingkungan(s),IDKelas, asirkulasiudara, acahaya, alembab, asuhu);
        
        return s;
    }
    @Override
    double persentaseKondisiLingkungan(int s){
        double total = s*20;
        System.out.println("persentase KOndisi Lingkungan : "+total+"%");
        System.out.println("======================================");
        System.out.println("::Anda Masuk CheckKondisiKebersihan::");
        return total;
    }
    
    int CheckKondisiKebersihan(RuangKelas kls,String IDRuang) {
        String alantai,adinding,aatap,apintu,ajendela;
        System.out.println("==============Analisis=================="); 
        if (kls.getKondisiLantai().equalsIgnoreCase("Lantai Bersih")) {
            //System.out.println("Kondisi Lantai : Sesuai");
            alantai = "Sesuai";
            s++;
        } else {
            //System.out.println("Kondisi Lantai : Tidak Sesuai");
            alantai = "Tidak Sesuai";
            ts++;
        }
        if (kls.getKondisiDinding().equalsIgnoreCase("Dinding Bersih/Baik")){
            //System.out.println("Kondisi Dinding : Sesuai");
            adinding = "Sesuai";
            s++;
        }else {
            ts++;
            adinding = "Tidak Sesuai";
            //System.out.println("Kondisi Dinding : Tidak Sesuai");
        }
        if (kls.getKondisiAtap().equalsIgnoreCase("Atap Bersih")){
            //System.out.println("Kondisi Atap : Sesuai");
            aatap = "Sesuai";
            s++;
        }else{
            //System.out.println("Kondisi Atap : Tidak Sesuai");
            aatap = "Tidak Sesuai";
            ts++;
        }
        if (kls.getKondisiPintu().equalsIgnoreCase("Pintu Bersih/Baik")){
           // System.out.println("Kondisi Pintu : Sesuai");
            apintu = "Sesuai";
            s++;
        }else {
            //System.out.println("Kondisi Pintu : Tidak Sesuai");
            apintu = "Tidak Sesuai";
            ts++;
        }
        if (kls.getKondisiJendela().equalsIgnoreCase("Jendela Bersih/Baik")){
            //System.out.println("Kondisi Jendela : Sesuai");
            ajendela = "Sesuai";
            s++;
        } else {
            //System.out.println("Kondisi Jendela : Tidak Sesuai");
            ajendela = "Tidak Sesuai";
            ts++;
        }
        con.analisisSave(persentaseKondisiLingkungan(s),IDRuang, alantai, adinding, aatap, apintu, ajendela);
        
        return s;
    }
    @Override
    double persentaseKondisiKebersihan(int s){
    double total = s*25;

    return total;
    }
  
    int CheckKondisiKenyamanan(RuangKelas kls,String IDKelas) {
//        int kon;
//        System.out.println("==============Analisis==================");
       String abising,abau,abocor,arusak,aaus;
       if ("Tidak Bising".equalsIgnoreCase(kls.getKebisingan())||"Sepi/Tenang".equalsIgnoreCase(kls.getKebisingan())) {
            //System.out.println("Kebisingan : Tidak Bising");
            abising = "Sesuai";
            s++;
        } else {
            //System.out.println("Kebisingan : Bising");
           abising = "Tidak Sesuai"; 
           ts++;
        }
        if ("Tidak Bau".equalsIgnoreCase(kls.getBau())||"Wangi".equalsIgnoreCase(kls.getBau())) {
            //System.out.println("Bau : Enak");
            abau = "Sesuai";
            s++;
        } else {
            //System.out.println("Bau : Tidak Sedap");
            abau = "Tidak Sesuai";
            ts++;
        }
        if ("Tidak Begitu Parah".equalsIgnoreCase(kls.getKebocoran())||"Keadaan Baik".equalsIgnoreCase(kls.getKebocoran())) {
            //System.out.println("Kerusakan : Tidak Rusak");
            abocor = "Sesuai";
            s++;
        } else {
            abocor = "Tidak Sesuai";
            System.out.println("Kerusakan : Rusak");
            ts++;
        }
        if ("Tidak Begitu Parah".equalsIgnoreCase(kls.getKerusakan())||"Keadaan Baik".equalsIgnoreCase(kls.getKerusakan())) {
            //System.out.println("Kerusakan : Tidak Rusak");
            arusak = "Sesuai";
            s++;
        } else {
            arusak = "Tidak Sesuai";
            System.out.println("Kerusakan : Rusak");
            ts++;
        }
        if ("Tidak Aus".equalsIgnoreCase(kls.getKeausan())) {
           // System.out.println("Keausan : Tidak Ada");
            aaus = "Sesuai";
            s++;
        } else {
            //System.out.println("Keausan : Ada");
            aaus = "Tidak Sesuai";
            ts++;
        }

        con.analisisSave(persentaseKenyamanan(s),IDKelas, abising, abau, abocor, arusak, aaus, 0);
        
        return s;
    }
    @Override
    double persentaseKenyamanan(int s){
     double total = s*25;

    return total;
    }

    int CheckKondisiKeamanan(RuangKelas kls,String IDRuang) {

        String akekokohan,akuncipintujendela,abahaya;
        System.out.println("==============Analisis==================");
        if ("Kokoh".equalsIgnoreCase(kls.getKekokohan())) {
            akekokohan = "Sesuai";
            s++;
        } else {
            akekokohan = "Tidak Sesuai";
            ts++;
        }
        if ("Terkunci".equalsIgnoreCase(kls.getKunciPintuJendela())) {
            akuncipintujendela = "Sesuai";
            s++;
        } else {
            akuncipintujendela = "Tidak Sesuai";
            ts++;
        }
        if ("Aman".equalsIgnoreCase(kls.getBahaya())) {
            abahaya = "Sesuai";
            s++;
        } else {
            abahaya = "Tidak Sesuai";
            ts++;
        }
        con.analisisSave(persentaseKeamanan(s),IDRuang, akekokohan, akuncipintujendela, abahaya);
        
        return s;
    }
    @Override
    double persentaseKeamanan(int s){
    double total = s*100/3;

    return total;
    }
    
}
