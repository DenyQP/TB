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


public class contoh extends JFrame implements ActionListener{
    JLabel a[] = new JLabel[4];
    JTextField b[] = new JTextField[4];
    JButton c[] = new JButton[6];
    public contoh(){
           super("IDENTITAS RUANG KELAS");

        
     
        
        a[0] = new JLabel("Nama Ruang");
        a[0].setBounds(15, 30, 160, 20);
        a[1] = new JLabel("Lokasi Ruang");
        a[1].setBounds(15, 60, 160, 20);
        a[2] = new JLabel("Fakultas");
        a[2].setBounds(15, 90, 160, 20);
        a[3] = new JLabel("Program Studi");
        a[3].setBounds(15, 120, 160, 20);
        b[0] = new JTextField();
        b[0].setBounds(150, 30, 250, 20);
        b[1] = new JTextField();
        b[1].setBounds(150, 60, 250, 20);
        b[2] = new JTextField();
        b[2].setBounds(150, 90, 250, 20);
        b[3] = new JTextField();
        b[3].setBounds(150, 120, 250, 20);
        c[0] = new JButton("ADD");
        c[0].setBounds(15, 160, 60, 20);
        c[0].addActionListener(this);
        c[1] = new JButton("SAVE");
        c[1].setBounds(80, 160, 70, 20);
        c[1].addActionListener(this);
        c[2] = new JButton("EDIT");
        c[2].setBounds(155, 160, 60, 20);
        c[3] = new JButton("DELETE");
        c[3].setBounds(220, 160, 80, 20);
        c[4] = new JButton("OK");
        c[4].setBounds(305, 160, 55, 20);
        c[5] = new JButton("NEXT");
        c[5].setBounds(365, 160, 70, 20);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createTitledBorder("Panel Manager"));
        panel.add(a[0]);
        panel.add(b[0]);
        panel.add(a[1]);
        panel.add(b[1]);
        panel.add(a[2]);
        panel.add(b[2]);
        panel.add(a[3]);
        panel.add(b[3]);
        panel.add(c[0]);
        panel.add(c[1]);
        panel.add(c[2]);
        panel.add(c[3]);
        panel.add(c[4]);
        panel.add(c[5]);
        
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //pack();
        setSize(450, 300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
                b[0].setEditable(false);
        b[1].setEditable(false);
        b[2].setEditable(false);
        b[3].setEditable(false);
        c[0].setVisible(true);
        c[1].setVisible(false);
        c[2].setVisible(false);
        c[3].setVisible(false);
        c[4].setVisible(false);
        c[5].setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == c[0]){
        b[0].setEditable(true);
        b[1].setEditable(true);
        b[2].setEditable(true);
        b[3].setEditable(true);
        c[0].setVisible(false);
        c[1].setVisible(true);
        c[2].setVisible(false);
        c[3].setVisible(false);
       }
       else if(e.getSource() == c[1]){
//        da.Save(NM, LK, JR, FK);
//        tampilDataKeTabel();
        c[0].setVisible(true);
        c[1].setVisible(false);
        c[5].setVisible(true);
        
        }
    
    }
    
}
