import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo1 extends JFrame implements ActionListener {

    JButton boton;
    public Ejemplo1(){

        //Asigno un layout absoluto
        setLayout(null);

        //Posición y tamaño de la ventana
        setBounds(0,0,450,350);

        //Título
        setTitle("Ejemplo 1: Botón");

        //No redimensionable
        setResizable(false);

        //Cerrar la aplicación al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Inicializo del botón
        boton = new JButton("Finalizar");

        //Posición y dimensiones del botón
        boton.setBounds(300,250,100,30);

        //Añado el botón al JFrame
        add(boton);

        //Añado el action listener al boton
        boton.addActionListener(this);

        //Muestro el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejemplo1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Si he pulsado el boton
        if (e.getSource() == boton){
            //Salgo de la aplicación
            System.exit(0);
        }
    }
}
