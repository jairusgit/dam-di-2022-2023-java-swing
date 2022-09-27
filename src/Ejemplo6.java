import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo6 extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField textField;
    private JButton boton;

    public Ejemplo6(){

        //Layout absoluto
        setLayout(null);

        //Tamaño de la ventana
        setBounds(10,10,400,300);

        //Título
        setTitle("Ejemplo 6: JTextField");

        //No redimensionable
        setResizable(false);

        //Cerrar proceso al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Etiqueta
        label = new JLabel("Introduce tu nombre:");
        label.setBounds(50,50,200,30);
        add(label);

        //JTextField
        textField = new JTextField();
        textField.setBounds(50,100,200,30);
        add(textField);

        //Botón
        boton = new JButton("Cambiar título");
        boton.setBounds(50,150,200,30);
        boton.addActionListener(this);
        add(boton);

        //Muestro el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejemplo6();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton){
            String titulo = textField.getText();
            setTitle("Has escrito " + titulo);
        }
    }
}
