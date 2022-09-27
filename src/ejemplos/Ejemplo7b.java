package ejemplos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo7b extends JFrame implements ActionListener{

    private JLabel labelTextField, labelTextArea, labelEmail;
    private JTextField textField;
    private JTextArea textArea, textAreaCuerpo;

    private JScrollPane scrollPane, scrollPaneResultado;
    private JButton botonGenerar, botonBorrar;

    public Ejemplo7b(){

        initLayout();
        initForm();
        initResultado();

        //Muestro el JFrame
        setVisible(true);
    }

    private void initLayout(){

        //Layout absoluto
        setLayout(null);

        //Tamaño de la ventana
        setBounds(10,10,800,600);

        //Título
        setTitle("ejemplos.Ejemplo 7a: JTextArea");

        //No redimensionable
        setResizable(false);

        //Cerrar proceso al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void initForm(){

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
        textArea.setBounds(50,140,300,500);
        textArea.setLineWrap(true); //Cambia de línea al llegar al final

        //JScrollPane
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50,140,300,200);
        add(scrollPane);

        //Botón
        botonGenerar = new JButton("Generar");
        botonGenerar.setBounds(50,370,300,30);
        botonGenerar.addActionListener(this);
        add(botonGenerar);

    }

    private void initResultado(){

        //Etiqueta
        labelEmail = new JLabel();
        labelEmail.setBounds(400,80,300,30);
        add(labelEmail);

        //JTextArea
        textAreaCuerpo = new JTextArea();
        textAreaCuerpo.setBounds(400,140,300,500);
        textAreaCuerpo.setBackground(this.getBackground());
        textAreaCuerpo.setEditable(false); //Impide que se pueda editar
        textAreaCuerpo.setLineWrap(true); //Cambia de línea al llegar al final

        //JScrollPane
        scrollPaneResultado = new JScrollPane(textAreaCuerpo);
        scrollPaneResultado.setBounds(400,140,300,200);
        add(scrollPaneResultado);

        //Botón
        botonBorrar = new JButton("Borrar");
        botonBorrar.setBounds(400,370,300,30);
        botonBorrar.addActionListener(this);
        add(botonBorrar);

        //Oculto por defecto
        visualizacionResultado(false);
    }

    private void visualizacionResultado(boolean mostrar){

        labelEmail.setVisible(mostrar);
        scrollPaneResultado.setVisible(mostrar);
        botonBorrar.setVisible(mostrar);
    }

    public static void main(String[] args) {
        new Ejemplo7b();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Generar
        if (e.getSource() == botonGenerar){
            labelEmail.setText(textField.getText());
            textAreaCuerpo.setText(textArea.getText());
            visualizacionResultado(true);
        }
        //Borrar
        else if (e.getSource() == botonBorrar){
            textField.setText("");
            textArea.setText("");
            labelEmail.setText("");
            textAreaCuerpo.setText("");
            visualizacionResultado(false);
        }
    }
}
