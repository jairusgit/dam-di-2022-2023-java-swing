package ejercicios;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio10Radio extends JFrame implements ActionListener {

    JLabel texto1, texto2, textoResultado;
    JTextField numero1, numero2;
    ButtonGroup grupoBotones;
    JRadioButton[] radioButtons = new JRadioButton[4];
    String[] operaciones = {"+","-","*","/"};
    int xInicial = 40;
    JButton botonReiniciar;

    public Ejercicio10Radio(){

        initLabels();
        initTextFields();
        initRadios();
        initBoton();
        initLayout();
    }

    private void initLabels(){

        texto1 = new JLabel("Número 1");
        texto1.setBounds(50,50,100,30);
        add(texto1);

        texto2 = new JLabel("Número 2");
        texto2.setBounds(150,50,100,30);
        add(texto2);

        textoResultado = new JLabel("Introduce los valores y selecciona una operación");
        textoResultado.setBounds(50,150,300,30);
        add(textoResultado);

    }

    private void initTextFields(){

        numero1 = new JTextField("");
        numero1.setBounds(50,80,55,30);
        add(numero1);

        numero2 = new JTextField("");
        numero2.setBounds(150,80,55,30);
        add(numero2);
    }

    private void initRadios(){

        grupoBotones = new ButtonGroup();
        for (int i = 0; i < radioButtons.length; i++){
            radioButtons[i] = new JRadioButton(operaciones[i]);
            radioButtons[i].setBounds(xInicial,120,50,30);
            radioButtons[i].setRolloverEnabled(false);
            initChangeListener(radioButtons[i],i);
            grupoBotones.add(radioButtons[i]);
            add(radioButtons[i]);
            xInicial += 50;
        }

    }

    private void initChangeListener(JRadioButton radio, int i){

        radio.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (radio.isSelected() && comprobarDatos()){
                    calculaResultado(operaciones[i]);
                }
            }
        });

    }

    private boolean comprobarDatos(){

        if (!"".equals(numero1.getText()) && !"".equals(numero2.getText())){
            try{
                double num1 = Double.parseDouble(numero1.getText());
                double num2 = Double.parseDouble(numero2.getText());
                return true;
            } catch(Exception e){
                return false;
            }
        }
        return false;
    }

    private void calculaResultado(String operacion){

        double num1 = Double.parseDouble(numero1.getText());
        double num2 = Double.parseDouble(numero2.getText());

        double resultado = switch (operacion) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };

        textoResultado.setText("Resultado: " + resultado);
        botonReiniciar.setVisible(true);
        if (resultado >= 0) getContentPane().setBackground(Color.green);
        else getContentPane().setBackground(Color.RED);
    }

    private void initBoton(){

        botonReiniciar = new JButton("Reiniciar");
        botonReiniciar.setBounds(50,200,100,30);
        botonReiniciar.addActionListener(this);
        botonReiniciar.setVisible(false);
        add(botonReiniciar);

    }

    private void initLayout(){

        //Layout absoluto
        setLayout(null);

        //Tamaño de la ventana
        setBounds(10,10,400,300);

        //Título
        setTitle("Ejercicio 10");

        //No redimensionable
        setResizable(false);

        //Cerrar proceso al cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Ejercicio10Radio();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonReiniciar){
            numero1.setText("");
            numero2.setText("");
            grupoBotones.clearSelection();
            textoResultado.setText("Introduce los valores y selecciona una operación");
            botonReiniciar.setVisible(false);
            getContentPane().setBackground(new Color(242,242,242));
        }
    }
}
