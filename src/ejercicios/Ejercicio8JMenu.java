package ejercicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Ejercicio8JMenu extends JFrame{
    JMenuBar menuBar;
    JMenuItem menuItem1, menuItem2;
    JLabel labelNum1, labelNum2;
    JTextField textoAncho, textoAlto;
    
    
    Ejercicio8JMenu(){
        
        initLabel();
        initTextField();
        initMenu();
        initVentana();
    }
    
    public void initVentana(){

        setLayout(null);
        setBounds(0, 0, 300, 350);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void initMenu(){
        
        //Creo la barra del menu y añado los items
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        menuItem1 = new JMenuItem("Redimensionar ventana");
        menuBar.add(menuItem1);
        
        menuItem2 = new JMenuItem("Salir");
        menuBar.add(menuItem2);
        
        //Eventos de los items del menu
        menuItem1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                int ancho;
                int alto;
                if (!textoAncho.getText().equals("") && !textoAlto.getText().equals("")) {
                    ancho = Integer.parseInt(textoAncho.getText());
                    alto = Integer.parseInt(textoAlto.getText());
                    
                    if ((ancho >= 100 && ancho <= 1000) && (alto >= 100 && alto <= 1000)) {
                        setBounds(0, 0, ancho, alto);
                    }
                }
            }
            
        });
        
        menuItem2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //Cierro la ventana padre
                System.exit(0);
            }
            
        });
        
    }
    
    
    public void initLabel(){
        //Tamaño de los labels
        int anchoLabel = 200;
        int altoLabel = 50;
        
        //Inicializo labels
        labelNum1 = new JLabel("Ancho de la ventana en pixeles");
        labelNum2 = new JLabel("Alto de la ventana en pixeles");
        
        //Posicion de los labels
        labelNum1.setBounds(30, 50, anchoLabel, altoLabel);
        labelNum2.setBounds(30, 140, anchoLabel, altoLabel);
        
        //Añado los labels
        add(labelNum1);
        add(labelNum2);
    }
    
    public void initTextField(){
        //Tamaño de los text fields
        int anchoLabel = 200;
        int altoLabel = 50;
        
        //Inicializo los text fields
        textoAncho = new JTextField("");
        textoAlto = new JTextField("");
        
        //Posicion de los text fields
        textoAncho.setBounds(30, 105, anchoLabel, altoLabel);
        textoAlto.setBounds(30, 200, anchoLabel, altoLabel);
        
        //Añado los fields
        add(textoAncho);
        add(textoAlto);
    }
        
    
    public static void main(String[] args) {
        new Ejercicio8JMenu();
    }
}
