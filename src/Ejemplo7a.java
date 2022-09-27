import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo7a extends JFrame {

    private JLabel labelTextField, labelTextArea;
    private JTextField textField;
    private JTextArea textArea;

    public Ejemplo7a(){

        //Layout absoluto
        setLayout(null);

        //Tamaño de la ventana
        setBounds(10,10,800,600);

        //Título
        setTitle("Ejemplo 7a: JTextArea");

        //No redimensionable
        setResizable(false);

        //Cerrar proceso al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Etiqueta
        labelTextField = new JLabel("Email:");
        labelTextField.setBounds(50,50,300,30);
        add(labelTextField);

        //JTextField
        textField = new JTextField();
        textField.setBounds(50,80,300,30);
        add(textField);

        //Etiqueta
        labelTextArea = new JLabel("Cuerpo del mensaje:");
        labelTextArea.setBounds(50,110,300,30);
        add(labelTextArea);

        //JTextArea
        textArea = new JTextArea();
        textArea.setBounds(50,140,300,200);
        textArea.setLineWrap(true); //Cambia de línea al llegar al final
        add(textArea);

        //Muestro el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ejemplo7a();
    }
}
