package ejemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo9 extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menuOpciones, menuTamano, menuColor;
    JMenuItem tamano1, tamano2, color1, color2, salir;

    public Ejemplo9(){

        //Barra de menú
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //Crear menú de opciones
        menuOpciones = new JMenu("Opciones");
        menuBar.add(menuOpciones);

        //Creo menús de tamaño y color
        menuTamano = new JMenu("Tamaño");
        menuOpciones.add(menuTamano);
        menuColor = new JMenu("Colores");
        menuOpciones.add(menuColor);

        //Añado items de menú
        tamano1 = new JMenuItem("640x480");
        menuTamano.add(tamano1);
        tamano1.addActionListener(this);
        tamano2 = new JMenuItem("1024x768");
        menuTamano.add(tamano2);
        tamano2.addActionListener(this);
        color1 = new JMenuItem("Rojo");
        menuColor.add(color1);
        color1.addActionListener(this);
        color2 = new JMenuItem("Verde");
        menuColor.add(color2);
        color2.addActionListener(this);

        //Acción de salir
        salir = new JMenuItem("Salir");
        menuBar.add(salir);
        salir.addActionListener(this);

        //Configurar y mostrar JFrame
        initPantalla();
    }

    private void initPantalla() {

        setLayout(null); //Layout absoluto
        setTitle("Ejemplo 9"); //Título del JFrame
        setSize(300, 200); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    public static void main(String[] args) {
        new Ejemplo9();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //En función del ítem de menú, ejecuto acción
        if (e.getSource() == tamano1){
            setSize(640,480);
        }
        else if (e.getSource() == tamano2){
            setSize(1024,768);
        }
        else if (e.getSource() == color1){
            getContentPane().setBackground(Color.red);
        }
        else if (e.getSource() == color2){
            getContentPane().setBackground(Color.green);
        }
        else if (e.getSource() == salir){
            System.exit(0);
        }
    }
}
