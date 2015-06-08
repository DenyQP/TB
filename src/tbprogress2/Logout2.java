/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tbprogress2;

/**
 *
 * @author eko
 */


    import javax.swing.JFrame;
import javax.swing.JTextField;



public class Logout2 {
public static void main(String aa[])
{
    JFrame frame =new JFrame();
    JTextField field=new JTextField("hahaha \nakhirnya \nbisa");
    frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
    frame.add(field);
        frame.pack();
        frame.setVisible(true);


 frame.addComponentListener(new java.awt.event.ComponentAdapter() {
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
            //dispose
  }
  if (selectedOption == javax.swing.JOptionPane.NO_OPTION) {
            //stay
  }
  //System.out.println("hii!! i am hidden!!");

  }
}