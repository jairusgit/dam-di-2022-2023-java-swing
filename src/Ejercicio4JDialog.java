import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author jairogarciarincon
 */
public class Ejercicio4JDialog extends JDialog implements ActionListener{

    private JButton boton;
    private JLabel label1, label2, label3;

    public Ejercicio4JDialog(Ejercicio4JFrame parent, boolean modal){
        
        //Recojo el parent
        super(parent, modal);
        
        //Opciones del JDialog
        setLayout(null);
        setBounds(510, 10, 500, 500);

        //Cálculos
        int valorMaquina = getRandom();
        //String resultado = (parent.valorUsuario + valorMaquina) % 2 == 0 ? "Has ganado" : "Has perdido";

        //Etiquetas
        label1 = new JLabel("Has elegido: " + parent.valorUsuario);
        label1.setBounds(150, 50, 200, 100);
        add(label1);

        label2 = new JLabel("La máquina ha elegido: " + valorMaquina);
        label2.setBounds(150, 75, 200, 100);
        add(label2);

        label3 = new JLabel(calculaResultado(parent,valorMaquina));
        label3.setBounds(150, 100, 200, 100);
        add(label3);

        //Botón
        boton = new JButton("Volver");
        boton.setBounds(150, 250, 200, 100);
        boton.addActionListener(this);
        add(boton);
    }

    private int getRandom(){

        Random random = new Random();
        return random.nextInt(4) + 1;

    }

    private String calculaResultado(Ejercicio4JFrame parent, int valorMaquina){


        boolean resultadoPar = (parent.valorUsuario + valorMaquina) % 2 == 0;
//        String resultado;
//        if ((resultadoPar && parent.pares) || (!resultadoPar && !parent.pares)){
//            resultado = "Has ganado";
//        }
//        else {
//            resultado = "Has perdido";
//        }
//        return resultado;

        return ((resultadoPar && parent.pares) || (!resultadoPar && !parent.pares)) ?
                "Has ganado" : "Has perdido";
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton){
            setVisible(false);
        }
    }
    
}
