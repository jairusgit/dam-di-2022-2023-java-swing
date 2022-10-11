package ejemplos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class Ejemplo10b extends JFrame implements ChangeListener {

    JCheckBox checkBox1, checkBox2, checkBox3;
    JLabel label;

    public Ejemplo10b(){

        //Añado los checkbox y sus listeners
        checkBox1 = new JCheckBox("Español");
        checkBox1.setBounds(10,10,150,30);
        checkBox1.addChangeListener(this);
        checkBox1.setRolloverEnabled(false); //Evita el stateChanged al pasar por encima
        add(checkBox1);

        checkBox2 = new JCheckBox("Inglés");
        checkBox2.setBounds(10,50,150,30);
        checkBox2.addChangeListener(this);
        checkBox2.setRolloverEnabled(false); //Evita el stateChanged al pasar por encima
        add(checkBox2);

        checkBox3 = new JCheckBox("Alemán");
        checkBox3.setBounds(10,90,150,30);
        checkBox3.addChangeListener(this);
        checkBox3.setRolloverEnabled(false); //Evita el stateChanged al pasar por encima
        add(checkBox3);

        label = new JLabel("Idiomas: ninguno.");
        label.setBounds(10,130,250,30);
        add(label);

        //Configurar y mostrar JFrame
        initPantalla();
    }

    private void initPantalla() {

        setLayout(null); //Layout absoluto
        setTitle("Ejemplo 10"); //Título del JFrame
        setSize(300, 200); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    public static void main(String[] args) {
        new Ejemplo10b();
    }


    @Override
    public void stateChanged(ChangeEvent e) {

        ArrayList<String> idiomas = new ArrayList<String>();

        //Si selecciono uno de los checkbox, lo añado al arraylist
        if (checkBox1.isSelected()) idiomas.add("Español"); else idiomas.remove("Español");
        if (checkBox2.isSelected()) idiomas.add("Inglés"); else idiomas.remove("Inglés");
        if (checkBox3.isSelected()) idiomas.add("Alemán"); else idiomas.remove("Alemán");

        //Seteo el texto en función del tamaño del arraylist
        switch (idiomas.size()) {
            case 0  -> label.setText("Idiomas: ninguno.");
            case 1  -> label.setText("Idioma: " + idiomas.get(0) + ".");
            default -> label.setText(setTexto(idiomas) + ".");
        }
    }

    private String setTexto(ArrayList<String> idiomas){

        String texto = "Idiomas: ";
        texto += (idiomas.size() == 2) ? idiomas.get(0) + " y " + idiomas.get(1) :
                idiomas.get(0) + ", " + idiomas.get(1)  + " y " + idiomas.get(2);
        return texto;
    }
}
