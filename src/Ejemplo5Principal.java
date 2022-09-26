import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo5Principal extends JFrame implements ActionListener {

    JButton boton;
    JLabel label;

    public Ejemplo5Principal(){

        //Asigno un layout absoluto
        setLayout(null);

        //Posición y tamaño de la ventana
        setBounds(10,10,410,210);

        //Título
        setTitle("Ejemplo 5: Diálogos modales");

        //No redimensionable
        setResizable(false);

        //Cerrar la aplicación al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Etiqueta
        label = new JLabel("Esta es la ventana principal");
        label.setBounds(115,60,200,30);
        add(label);

        //Botón
        boton = new JButton("Haz clic aquí");
        boton.setBounds(105,110,200,40);
        add(boton);
        boton.addActionListener(this);

        //Muestro el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejemplo5Principal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton){
            Ejemplo5Secundaria secundaria = new Ejemplo5Secundaria(this,false);
            secundaria.setVisible(true);
        }
    }
}
