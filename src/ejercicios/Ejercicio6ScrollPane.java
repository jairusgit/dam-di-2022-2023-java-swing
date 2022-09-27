package ejercicios;

import javax.swing.*;

public class Ejercicio6ScrollPane extends JFrame {

    JTextArea textArea;
    JScrollPane scrollPane;
    public Ejercicio6ScrollPane(){

        //Layout
        initLayout();

        //JTextArea
        textArea = new JTextArea(getTexto());
        textArea.setBounds(50,50,700,2000);
        textArea.setLineWrap(true);
        textArea.setEditable(false);

        //JScrollPane
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50,50,700,450);
        add(scrollPane);

        setVisible(true);
    }

    private String getTexto(){

        String texto = "";
        for (int i = 1; i <= 10; i++){
            for (int j = 1; j <= 10; j++){
                texto += i + "x" + j + " = " + (i*j) + "\n";
            }
            texto += "\n";
        }
        return texto;
    }

    private void initLayout(){

        //Layout absoluto
        setLayout(null);

        //Tamaño de la ventana
        setBounds(10,10,800,600);

        //Título
        setTitle("Ejercicio 6");

        //No redimensionable
        setResizable(false);

        //Cerrar proceso al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Ejercicio6ScrollPane();
    }

}
