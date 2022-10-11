package ejemplos;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ejemplo12 extends JFrame implements ItemListener {

    JComboBox comboBox;
    JLabel label;

    public Ejemplo12(){

        //Inicializo combobox y le añado ítems
        comboBox = new JComboBox();
        comboBox.setBounds(10,10,80,20);
        add(comboBox);

        comboBox.addItem("ninguno");
        comboBox.addItem("rojo");
        comboBox.addItem("verde");
        comboBox.addItem("azul");
        comboBox.addItemListener(this);

        //Inicializo label
        label = new JLabel("Color seleccionado: ninguno");
        label.setBounds(10,80,200,30);
        add(label);

        initPantalla();
    }

    private void initPantalla() {

        setLayout(null); //Layout absoluto
        setTitle("Ejemplo 12"); //Título del JFrame
        setSize(300, 200); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    public static void main(String[] args) {
        new Ejemplo12();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        String texto = "Color seleccionado: ";

        //Añado a texto el valor seleccionado en el combo
        if (e.getSource() == comboBox){
            texto += (String) comboBox.getSelectedItem();
            label.setText(texto);
        }

    }

    //TODO 1: Cambiar el color del fondo al seleccionado
    //TODO 2: Añadir 15 colores más (usar arrays)
    //TODO 3: Extraer los colores de un fichero
    //TODO 4: Extraer los colores de una API desde la ruta proporcionada en Teams
}
