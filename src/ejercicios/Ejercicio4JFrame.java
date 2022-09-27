package ejercicios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jairogarciarincon
 */
public class Ejercicio4JFrame extends JFrame implements ActionListener{

    JButton botonPares, botonNones;
    private JButton[] botones = new JButton[5];
    private int xInicial = 50;
    private JLabel texto1, texto2;
    public int valorUsuario;
    public boolean pares = true;

    public Ejercicio4JFrame(){
        
        //Opciones del JFrame
        setLayout(null);
        setBounds(10, 10, 600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Etiquetas
        texto1 = new JLabel("Bienvenido a pares o nones");
        texto1.setBounds(xInicial, 80, 400, 20);
        add(texto1);
        texto2 = new JLabel("Elige pares o nones y pulsa un botón del 1 al 5");
        texto2.setBounds(xInicial, 100, 400, 20);
        add(texto2);

        //Botones de pares y nones
        botonPares = new JButton("Pares");
        botonPares.setBounds(150, 160, 80, 75);
        botonPares.addActionListener(this);
        add(botonPares);
        botonNones = new JButton("Nones");
        botonNones.setBounds(310, 160, 80, 75);
        add(botonNones);
        botonNones.addActionListener(this);

        //Botones del 1 al 5
        for (int i = 0; i < botones.length; i++){
            botones[i] = new JButton(String.valueOf(i+1));
            botones[i].setBounds(xInicial, 260, 80, 75);
            initAccion(this, botones[i],i+1);
            add(botones[i]);
            botones[i].setVisible(false);
            xInicial += 100;
        }

        //Muestro el JFrame
        setVisible(true);
    }

    private void initAccion(Ejercicio4JFrame parent, JButton boton, int valor){
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton){
                    valorUsuario = valor;
                    visibilidadBotones(false);
                    Ejercicio4JDialog secundaria = new Ejercicio4JDialog(parent, true);
                    secundaria.setVisible(true);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        new Ejercicio4JFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonPares){
            pares = true;
        }
        if (e.getSource() == botonNones){
            pares = false;
        }
        visibilidadBotones(true);
    }

    private void visibilidadBotones(boolean mostrar){
        for (JButton botone : botones) {
            botone.setVisible(mostrar);
        }
    }
}
