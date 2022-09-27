package ejemplos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo2b extends JFrame implements ActionListener {

    JButton[] botones = new JButton[3];
    int posicionX = 10;

    public Ejemplo2b(){

        //Asigno un layout absoluto
        setLayout(null);

        //Posición y tamaño de la ventana
        setBounds(0,0,350,200);

        //Título
        setTitle("ejemplos.Ejemplo 2: Botones");

        //No redimensionable
        setResizable(false);

        //Cerrar la aplicación al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Recorro el array de botones
        for (int i = 0; i < botones.length; i++){
            botones[i] = new JButton(String.valueOf(i+1));
            botones[i].setBounds(posicionX,100,90,30);
            add(botones[i]);
            botones[i].addActionListener(this);
            posicionX += 100;
        }

        //Muestro el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejemplo2b();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton boton : botones) {
            if (e.getSource() == boton) {
                setTitle(boton.getText());
            }
        }
    }
}
