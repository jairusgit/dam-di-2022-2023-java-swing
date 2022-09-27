package ejercicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author jairogarciarincon
 */
public class Ejercicio3JDialog extends JDialog implements ActionListener{

    private JButton boton;
    private JLabel label;
    
    public Ejercicio3JDialog(Ejercicio3JFrame parent, boolean modal){
        
        //Recojo el parent
        super(parent, modal);
        
        //Opciones del JDialog
        setLayout(null);
        setBounds(510, 10, 500, 500);
        
        //Etiqueta
        label = new JLabel(parent.texto);
        label.setBounds(150, 50, 200, 100);
        add(label);
        
        //Botón
        boton = new JButton("Volver");
        boton.setBounds(150, 150, 200, 100);
        boton.addActionListener(this);
        add(boton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton){
            setVisible(false);
        }
    }
    
}
