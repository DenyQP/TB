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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Reinka
 */
public class Login extends JFrame implements ActionListener{

    JComboBox nama;
    JPasswordField pas;
    JButton login;
    public Login() {
        super("LOGIN");
        String name[] = new String[4];
        name[0] = "Pilih Nama";
        name[1] = "Eko";
        name[2] = "Deny";
        name[3] = "Reinka";

        JLabel txt = new JLabel("Nama");
        txt.setBounds(10, 30, 180, 20);
        JLabel text = new JLabel("Password");
        text.setBounds(10, 60, 180, 20);
        nama = new JComboBox(name);
        nama.setBounds(120, 30, 150, 20);
        pas = new JPasswordField();
        pas.setBounds(120, 60, 150, 20);
        login = new JButton("LOGIN");
        login.setBounds(160, 90, 80, 20);
        login.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createTitledBorder("Panel Manager"));
        panel.add(txt);
        panel.add(text);
        panel.add(nama);
        panel.add(pas);
        panel.add(login);
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //pack();
        setSize(350, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
           
            
            if (nama.getSelectedItem().equals("Eko") && pas.getText().equals("167")) {
                JOptionPane.showMessageDialog(null, "Welcome " + nama.getSelectedItem());
            } else if (nama.getSelectedItem().equals("Deny") && pas.getText().equals("175")) {
                JOptionPane.showMessageDialog(null, "Welcome " + nama.getSelectedItem());
            } else if (nama.getSelectedItem().equals("Reinka") && pas.getText().equals("178")) {
                JOptionPane.showMessageDialog(null, "Welcome " + nama.getSelectedItem());
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed!!!");
            }
        }
    }
}
    
