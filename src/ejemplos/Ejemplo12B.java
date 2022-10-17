package ejemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejemplo12B extends JFrame implements ItemListener {

    JComboBox comboBox;
    JLabel label;
    ArrayList<String> nombres, colores = new ArrayList<String>();

    String rutaNombres = "src/files/nombres.txt";
    String rutaColores = "src/files/colores.txt";

    public Ejemplo12B() throws IOException {

        //Leo de los ficheros
        nombres = leerFichero(rutaNombres);
        colores = leerFichero(rutaColores);

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

    private ArrayList<String> leerFichero(String ruta) throws IOException {

        ArrayList<String> array = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(ruta));
        String linea;
        while ((linea = bufferedReader.readLine()) != null){
            array.add(linea);
        }
        return array;
    }

    private void initPantalla() {

        setLayout(null); //Layout absoluto
        setTitle("Ejemplo 12"); //Título del JFrame
        setSize(300, 200); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    public static void main(String[] args) throws IOException {
        new Ejemplo12B();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        String texto = "Color seleccionado: ";

        if (e.getSource() == comboBox){
            //Índice del array de nombres a partir del seleccionado en el combobox
            int i = nombres.indexOf((String) comboBox.getSelectedItem());
            //Construyo el color del hexadecimal
            Color color = new Color(hex(colores.get(i)));
            getContentPane().setBackground(color); //Asigno el color
            texto += (String) comboBox.getSelectedItem();
            label.setText(texto);  //Añado a texto el valor seleccionado en el combo

        }

    }

    private int hex(String color_hex){
        return Integer.parseInt(color_hex,  16 );
    }

    //TODO 1: Cambiar el color del fondo al seleccionado
    //TODO 2: Añadir 15 colores más (usar arrays)
    //TODO 3: Extraer los colores de un fichero
}
