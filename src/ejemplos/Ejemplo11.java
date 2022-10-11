package ejemplos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ejemplo11 extends JFrame implements ChangeListener {

    JRadioButton radio1, radio2, radio3;
    ButtonGroup grupoBotones;
    public Ejemplo11(){

        //Inicializo grupo de botones
        grupoBotones = new ButtonGroup();

        //Inicializo radios
        radio1 = new JRadioButton("640x480");
        radio1.setBounds(10,20,100,30);
        radio1.addChangeListener(this);
        add(radio1);
        grupoBotones.add(radio1);

        radio2 = new JRadioButton("800x600");
        radio2.setBounds(10,70,100,30);
        radio2.addChangeListener(this);
        add(radio2);
        grupoBotones.add(radio2);

        radio3 = new JRadioButton("1024x768");
        radio3.setBounds(10,120,100,30);
        radio3.addChangeListener(this);
        add(radio3);
        grupoBotones.add(radio3);

        initPantalla();
    }

    private void initPantalla() {

        setLayout(null); //Layout absoluto
        setTitle("Ejemplo 11"); //Título del JFrame
        setSize(350, 230); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    public static void main(String[] args) {
        new Ejemplo11();
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        if (radio1.isSelected()) setSize(640,480);
        if (radio2.isSelected()) setSize(800,600);
        if (radio3.isSelected()) setSize(1024,768);
    }
}
