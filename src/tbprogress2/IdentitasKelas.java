/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tbprogress2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Reinka
 */
public class IdentitasKelas extends JFrame implements ActionListener{
    JLabel lbl[] = new JLabel[4];
    JTextField txt[] = new JTextField[4];
    JButton btn[] = new JButton[6];
    public IdentitasKelas(){
           super("IDENTITAS RUANG KELAS");
        lbl[0] = new JLabel("Nama Ruang");
        lbl[0].setBounds(15, 30, 160, 20);
        lbl[1] = new JLabel("Lokasi Ruang");
        lbl[1].setBounds(15, 60, 160, 20);
        lbl[2] = new JLabel("Fakultas");
        lbl[2].setBounds(15, 90, 160, 20);
        lbl[3] = new JLabel("Program Studi");
        lbl[3].setBounds(15, 120, 160, 20);
        txt[0] = new JTextField();
        txt[0].setBounds(150, 30, 250, 20);
        txt[1] = new JTextField();
        txt[1].setBounds(150, 60, 250, 20);
        txt[2] = new JTextField();
        txt[2].setBounds(150, 90, 250, 20);
        txt[3] = new JTextField();
        txt[3].setBounds(150, 120, 250, 20);
        btn[0] = new JButton("ADD");
        btn[0].setBounds(15, 160, 60, 20);
        btn[0].addActionListener(this);
        btn[1] = new JButton("SAVE");
        btn[1].setBounds(80, 160, 70, 20);
        btn[1].addActionListener(this);
        btn[2] = new JButton("EDIT");
        btn[2].setBounds(155, 160, 60, 20);
        btn[3] = new JButton("DELETE");
        btn[3].setBounds(220, 160, 80, 20);
        btn[4] = new JButton("OK");
        btn[4].setBounds(305, 160, 55, 20);
        btn[5] = new JButton("NEXT");
        btn[5].setBounds(365, 160, 70, 20);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createTitledBorder("Panel Manager"));
        panel.add(lbl[0]);
        panel.add(txt[0]);
        panel.add(lbl[1]);
        panel.add(txt[1]);
        panel.add(lbl[2]);
        panel.add(txt[2]);
        panel.add(lbl[3]);
        panel.add(txt[3]);
        panel.add(btn[0]);
        panel.add(btn[1]);
        panel.add(btn[2]);
        panel.add(btn[3]);
        panel.add(btn[4]);
        panel.add(btn[5]);
        
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //pack();
        setSize(450, 300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        txt[0].setEditable(false);
        txt[1].setEditable(false);
        txt[2].setEditable(false);
        txt[3].setEditable(false);
        btn[0].setVisible(true);
        btn[1].setVisible(false);
        btn[2].setVisible(false);
        btn[3].setVisible(false);
        btn[4].setVisible(false);
        btn[5].setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == btn[0]){
        txt[0].setEditable(true);
        txt[1].setEditable(true);
        txt[2].setEditable(true);
        txt[3].setEditable(true);
        btn[0].setVisible(false);
        btn[1].setVisible(true);
        btn[2].setVisible(false);
        btn[3].setVisible(false);
       }
       else if(e.getSource() == btn[1]){
//        da.Save(NM, LK, JR, FK);
//        tampilDataKeTabel();
        btn[0].setVisible(true);
        btn[1].setVisible(false);
        btn[5].setVisible(true);
        
        }
    
    }
    
}

