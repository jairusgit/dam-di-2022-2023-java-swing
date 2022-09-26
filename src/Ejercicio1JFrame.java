import javax.swing.JFrame;

/**
 *
 * @author jairogarciarincon
 */
public class Ejercicio1JFrame extends JFrame{
    
    public Ejercicio1JFrame(){
        
        //Layout absoluto
        setLayout(null);
        
        //Opciones del JFrame
        setBounds(10,10,1024,800);
        setResizable(false);
        
        //Muestro el JFrame
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new Ejercicio1JFrame();
    }
    
}
