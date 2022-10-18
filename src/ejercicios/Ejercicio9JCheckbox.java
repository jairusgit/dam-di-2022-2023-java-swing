package ejercicios;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio9JCheckbox extends JFrame implements ActionListener, ChangeListener {

    JLabel label1, label2;
    JCheckBox checkbox;
    JButton button;

    public Ejercicio9JCheckbox(){

        initLabels();
        initCheckBox();
        initBoton();
        initLayout();

    }

    public static void main(String[] args) {
        new Ejercicio9JCheckbox();
    }

    private void initLabels(){

        label1 = new JLabel("¿Acepta las condiciones del servicio?");
        label1.setBounds(80,50,300,30);
        add(label1);

        label2 = new JLabel("Has aceptado las condiciones del servicio");
        label2.setBounds(50,170,300,30);
        label2.setVisible(false);
        add(label2);

    }

    private void initCheckBox(){

        checkbox = new JCheckBox("");
        checkbox.setBounds(50,50, 20, 30);
        checkbox.addChangeListener(this);
        add(checkbox);

    }

    private void initBoton(){

        button = new JButton("Aceptar");
        button.setBounds(50,100,100,30);
        button.addActionListener(this);
        button.setEnabled(false);
        add(button);

    }

    private void initLayout(){

        //Layout absoluto
        setLayout(null);

        //Tamaño de la ventana
        setBounds(10,10,400,400);

        //Título
        setTitle("Ejercicio 9");

        //No redimensionable
        setResizable(false);

        //Cerrar proceso al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            label2.setVisible(true);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        button.setEnabled(checkbox.isSelected());
    }
}
