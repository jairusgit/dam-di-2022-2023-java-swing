package ejemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ejemplo12a extends JFrame implements ItemListener {

    JComboBox comboBox;
    JLabel label;
    int numColores = 6;
    String[] nombres = {"Por defecto","Blanco","Gris","Rojo","Naranja","Verde","Azulito"};
    Color[] colores = {null,Color.white,Color.gray,Color.red,Color.orange,Color.green,new Color(75, 185, 200, 178)};

    public Ejemplo12a(){

        //Color por defecto
        colores[0] = getContentPane().getBackground();

        //Inicializo combobox y le añado ítems
        comboBox = new JComboBox();
        comboBox.setBounds(10,10,150,20);
        add(comboBox);

        for (String nombre: nombres){
            comboBox.addItem(nombre);
        }
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
        new Ejemplo12a();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        String texto = "Color seleccionado: ";

        if (e.getSource() == comboBox){
            int i = comboBox.getSelectedIndex(); //Obtengo el índice
            getContentPane().setBackground(colores[i]); //Asigno el color
            texto += (String) comboBox.getSelectedItem();
            label.setText(texto);  //Añado a texto el valor seleccionado en el combo

        }

    }

    //TODO 1: Cambiar el color del fondo al seleccionado
    //TODO 2: Añadir 15 colores más (usar arrays)
    //TODO 3: Extraer los colores de un fichero
}
