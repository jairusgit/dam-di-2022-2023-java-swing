package ejercicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jairogarciarincon
 */
public class Ejercicio3JFrame extends JFrame implements ActionListener{
    
    private JButton carne, pescado;
    public String texto;
    
    public Ejercicio3JFrame(){
        
        //Opciones del JFrame
        setLayout(null);
        setBounds(10, 10, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Botón carne
        carne = new JButton("Carne");
        carne.setBounds(150, 160, 200, 75);
        carne.addActionListener(this);
        add(carne);
        
        //Botón pescado
        pescado = new JButton("Pescado");
        pescado.setBounds(150, 240, 200, 75);
        pescado.addActionListener(this);
        add(pescado);
        
        //Muestro el JFrame
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == carne) {
            texto = "Carne";
            //Abro JDialog
            Ejercicio3JDialog ventana = new Ejercicio3JDialog(this, true);
            ventana.setVisible(true);
        }
        else if (e.getSource() == pescado){
            texto = "Pescado";
            //Abro JDialog
            Ejercicio3JDialog ventana2 = new Ejercicio3JDialog(this, true);
            ventana2.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Ejercicio3JFrame();
    }
}
