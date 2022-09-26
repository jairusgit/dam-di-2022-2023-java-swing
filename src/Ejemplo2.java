import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo2 extends JFrame implements ActionListener {

    JButton boton1, boton2, boton3;

    public Ejemplo2(){

        //Asigno un layout absoluto
        setLayout(null);

        //Posición y tamaño de la ventana
        setBounds(0,0,350,200);

        //Título
        setTitle("Ejemplo 2: Botones");

        //No redimensionable
        setResizable(false);

        //Cerrar la aplicación al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Creación de botones
        boton1 = new JButton("1");
        boton2 = new JButton("2");
        boton3 = new JButton("3");

        //Posición y tamaño de botones
        boton1.setBounds(10,100,90,30);
        boton2.setBounds(110,100,90,30);
        boton3.setBounds(210,100,90,30);

        //Añado los botones al JFrame
        add(boton1);
        add(boton2);
        add(boton3);

        //Añado el action listener a los botones
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);

        //Muestro el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejemplo2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            setTitle("Botón 1");
        }
        else if (e.getSource() == boton2){
            setTitle("Botón 2");
        }
        else if (e.getSource() == boton3){
            setTitle("Botón 3");
        }
    }
}
