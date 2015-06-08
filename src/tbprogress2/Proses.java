/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tbprogress2;
 
/**
 *
 * @author Reinka Mega Adelia (178)
 */
public abstract class Proses {
    public void IdentitasKelas(){}
    abstract double persentaseKondisiRuang(int s);
    abstract double persentaseKondisiSarana(int s);
    abstract double persentaseKondisiSarana2(int s);
    abstract double persentaseKondisiLingkungan(int s);
    abstract double persentaseKondisiKebersihan(int s);
    abstract double persentaseKenyamanan(int s);
    abstract double persentaseKeamanan(int s);
//    void Persentase(double point, double total){
//        double persen;
//        persen = point/total;
//    }
    
    
}
