/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tbprogress2;

/**
 *
 * @author Deny QP
 */
public interface View {
    void IdentitasKelas();
    public void inputIdentitasKelas();
    public void InputKondisiRuang(String Kode);
    public void inputKondisiSarana(String kode);
    public void inputKondisiSarana2(String kode);
    public void inputKondisiLingkungan(String kode);
    public void inputKondisiKebersihan(String kode);
    public void inputKondisiKenyamanan(String kode);
    public void inputKondisiKeamanan(String kode);
    
    void output(int PanjangRuang,int LebarRuang,int JumlahKursi,int JumlahPintu,int JumlahJendela);
    void output(int JumlahStopKontak,String KondisiStopKontak,String PosisiStopKontak,int JumlahKabelLCD,String KondisiKabelLCD,String PosisiKabelLCD,int JumlahLampu,String KondisiLampu,String PosisiLampu);
    void output (int JumlahKipasAngin,String KondisiKipasAngin,String PosisiKipasAngin,int JumlahAC,String KondisiAC,String PosisiAC,String SSID,String Bandwidth,int JumlahCCTV,String KondisiCCTV,String PosisiCCTV);
    void output(String KondisiLantai,String KondisiDinding, String KondisiAtap, String KondisiPintu, String KondisiJendela);
    void output(String SirkulasiUdara, int NilaiPencahayaan, int Kelembaban, int Suhu);
    void output(String Kebisingan, String Bau, String Kebocoran, String Kerusakan, String Keausan, String x);
    void output (String Kekokohan,String KunciPintuJendela,String Bahaya);
    
}
