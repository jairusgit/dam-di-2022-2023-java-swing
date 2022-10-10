package ejemplos;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Ejemplo10 extends JFrame implements ChangeListener {

    JCheckBox checkBox1, checkBox2, checkBox3;
    JLabel label;

    public Ejemplo10(){

        //Añado los checkbox y sus listeners
        checkBox1 = new JCheckBox("Español");
        checkBox1.setBounds(10,10,150,30);
        checkBox1.addChangeListener(this);
        add(checkBox1);

        checkBox2 = new JCheckBox("Inglés");
        checkBox2.setBounds(10,50,150,30);
        checkBox2.addChangeListener(this);
        add(checkBox2);

        checkBox3 = new JCheckBox("Alemán");
        checkBox3.setBounds(10,90,150,30);
        checkBox3.addChangeListener(this);
        add(checkBox3);

        label = new JLabel("Idiomas: ninguno");
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
        new Ejemplo10();
    }


    @Override
    public void stateChanged(ChangeEvent e) {

        String texto = "Idiomas: ";

        //Si selecciono uno de los checkbox, lo añado al string
        if (checkBox1.isSelected()){
            texto += "Español, ";
        }
        if (checkBox2.isSelected()){
            texto += "Inglés, ";
        }
        if (checkBox3.isSelected()){
            texto += "Alemán, ";
        }

        //Quito la última ', ' y escribo el texto
        texto = texto.substring(0, texto.length() - 2);
        label.setText(texto);

        //TODO 1: AL pasar un checkbox no tiene que cambiar el texto
        //TODO 2: Si hay más de un idioma, el último debería ser " y Alemán"
        //TODO 3: El texto tiene que acabar con un .
        //TODO 4: SI solo hay un idioma, no debe poner Idiomas

    }
}
