package ejercicios;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author jairogarciarincon
 */
public class Ejercicio2JLabel extends JFrame {
    
    private JLabel label,label2,label3;

    public Ejercicio2JLabel() {
       
       //Layout absoluto
        setLayout(null);
        
        //Opciones del JFrame
        setBounds(10,10,800,600);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        
        //Etiqueta 1
        label = new JLabel("Jairo");
        label.setOpaque(true);
        label.setBounds(300,50,200,100);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.DARK_GRAY);
        label.setBorder(new LineBorder(Color.RED));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("MONOSPACED",PLAIN,16));
        add(label);
        
        //Etiqueta 2
        label2 = new JLabel("Marcos");
        label2.setOpaque(true);
        label2.setBounds(300,200,200,100);
        label2.setForeground(Color.WHITE);
        label2.setBackground(Color.DARK_GRAY);
        label2.setBorder(new LineBorder(Color.RED));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(new Font("MONOSPACED",PLAIN,16));
        add(label2);
        
        //Etiqueta 3
        label3 = new JLabel("Mario");
        label3.setOpaque(true);
        label3.setBounds(300,350,200,100);
        label3.setForeground(Color.WHITE);
        label3.setBackground(Color.DARK_GRAY);
        label3.setBorder(new LineBorder(Color.RED));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(new Font("MONOSPACED",PLAIN,16));
        add(label3);
        
        //Muestro el JFrame
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Ejercicio2JLabel();
    }   
   
    
}
