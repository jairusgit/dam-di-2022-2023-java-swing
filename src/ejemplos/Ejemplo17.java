package ejemplos;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo17 extends JFrame{

    CardLayout tarjetas;
    JPanel panelTarjetas;

    public Ejemplo17(){

        //Centro el JFrame en la pantalla
        setLocationRelativeTo(null);

        //Inicializo un border layout para el JFrame
        setLayout(new BorderLayout());

        //Creo un panel para el botón superior con fondo rojo
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(Color.RED);

        //Añado un botón para intercambiar tarjetas y le añado el action listener
        JButton cambiarTarjeta = new JButton("Cambiar tarjeta");
        cambiarTarjeta.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent event){
                tarjetas.next(panelTarjetas);
            }
        });

        //Añado el botón al panel de pestañas
        panelSuperior.add(cambiarTarjeta);

        //Añado el panel de pestañas a la parte superior del JFrame
        add(panelSuperior,BorderLayout.NORTH);

        //Inicializo el layout y el panel para las tarjetas
        tarjetas = new CardLayout();
        panelTarjetas = new JPanel();
        panelTarjetas.setLayout(tarjetas);

        //Inicializo 2 tarjetas, cada una es un JPanel con un color de fondo
        JPanel primeraTarjeta = new JPanel();
        JPanel segundaTarjeta = new JPanel();
        primeraTarjeta.setBackground(Color.GREEN);
        segundaTarjeta.setBackground(Color.BLUE);

        //Añado botones a las dos tarjetas
        nuevoBoton(primeraTarjeta, "Manzanas");
        nuevoBoton(primeraTarjeta, "Naranjas");
        nuevoBoton(primeraTarjeta, "Plátanos");
        nuevoBoton(segundaTarjeta, "Lechugas");
        nuevoBoton(segundaTarjeta, "Tomates");
        nuevoBoton(segundaTarjeta, "Cebollas");

        //Añado las dos tarjetas al panel de tarjetas
        panelTarjetas.add(primeraTarjeta, "Frutas");
        panelTarjetas.add(segundaTarjeta, "Verduras");

        //Muestro la primera
        tarjetas.show(panelTarjetas, "Frutas");

        //Añado el panel de tarjetas a la parte central del border layout
        add(panelTarjetas,BorderLayout.CENTER);

        //Configurar y mostrar JFrame
        initPantalla();
    }

    private void initPantalla() {

        setTitle("Ejemplo 17"); //Título del JFrame
        setSize(400,300); //Dimensiones del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    //Nuevo botón
    private void nuevoBoton(JPanel panel, String titulo){

        JButton boton = new JButton(titulo);
        panel.add(boton);

    }

    public static void main(String[] args) {
        new Ejemplo17();
    }

}
