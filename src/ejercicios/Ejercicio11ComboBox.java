package ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio11ComboBox extends JFrame implements ActionListener {

    private JLabel labelR, labelG, labelB;
    private JComboBox comboR, comboG, comboB;

    private JButton rgb2hex;

    public Ejercicio11ComboBox(){

        initLabels();
        initComboBox();
        initButtons();
        initLayout();

    }

    void initLabels(){

        labelR = new JLabel("R:");
        labelR.setBounds(50,40,30,30);
        add(labelR);

        labelG = new JLabel("G:");
        labelG.setBounds(50,70,30,30);
        add(labelG);

        labelB = new JLabel("B:");
        labelB.setBounds(50,100,30,30);
        add(labelB);

    }

    void initComboBox(){

        comboR = new JComboBox();
        comboR.setBounds(80,50,50,20);
        add(comboR);

        comboG = new JComboBox();
        comboG.setBounds(80,80,50,20);
        add(comboG);

        comboB = new JComboBox();
        comboB.setBounds(80,110,50,20);
        add(comboB);

        //Relleno los combobox
        for (int i = 0; i < 256; i++){
            comboR.addItem(String.valueOf(i));
            comboG.addItem(String.valueOf(i));
            comboB.addItem(String.valueOf(i));
        }

    }

    void initButtons(){

        rgb2hex = new JButton("RGB a HEX");
        rgb2hex.setBounds(50,140,100,30);
        rgb2hex.addActionListener(this);
        add(rgb2hex);

    }

    private void initLayout(){

        //Layout absoluto
        setLayout(null);

        //Tamaño de la ventana
        setBounds(10,10,400,300);

        //Título
        setTitle("Ejercicio 11");

        //No redimensionable
        setResizable(false);

        //Cerrar proceso al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Ejercicio11ComboBox();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Si pulsa el botón de rgb a hex
        if (e.getSource() == rgb2hex){
            //Recojo los valores de R, G y B
            String stringR = String.valueOf(comboR.getSelectedItem());
            String stringG = String.valueOf(comboG.getSelectedItem());
            String stringB = String.valueOf(comboB.getSelectedItem());
            //Los convierto a enteros
            int r = Integer.parseInt(stringR);
            int g = Integer.parseInt(stringG);
            int b = Integer.parseInt(stringB);
            //Cambio el fondo del JFrame
            Color color = new Color(r,g,b);
            getContentPane().setBackground(color);
        }

    }

    //TODO Mostrar el color resultante en labels RGB y Hex
    //TODO Obtener el color a partir de Hex y mostrarlo convertido en RGB
}
