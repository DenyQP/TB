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
    void output(String koder);
    
}
