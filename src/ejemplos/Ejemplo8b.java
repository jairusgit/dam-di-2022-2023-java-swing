package ejemplos;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static java.awt.Font.PLAIN;

public class Ejemplo8b extends JFrame {

    //Display para mostrar los números
    JLabel display;
    //Cantidad de botones de calculadora
    int numBotones = 17;
    //Array de botones para números y operaciones
    JButton botones[] = new JButton[numBotones];
    //Array de strings para las etiquetas de los botones
    String textoBotones[] = {"Resultado","7","8","9","/","4","5","6","*","1","2","3","-","C","0",".","+"};
    //Array de posiciones en X de cada botón
    int xBotones[] = {15, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210, 15, 80, 145, 210};
    //Array de posiciones en Y de cada botón
    int yBotones[] = {90, 155, 155, 155, 155, 220, 220, 220, 220, 285, 285, 285, 285, 350, 350, 350, 350};
    //Array de índices del array de botones que corresponden a números (en el órden en el que se pintarán)
    int numerosBotones[] = {14, 9, 10, 11, 5, 6, 7, 1, 2, 3};
    //Array de índices del array de botones que corresponden a operaciones (en el órden en el que se pintarán)
    int[]  operacionesBotones = {16, 12, 8, 4};
    //Alto y ancho de cada botón
    int anchoBoton = 50;
    int altoBoton = 50;
    //Para indicar que he terminado de escribir dígitos un número y que voy a añadir el siguiente
    boolean nuevoNumero = true;
    //Para indicar si ya he utilizado el punto decimal en ese número (solo puede haber uno)
    boolean puntoDecimal = false;
    //Para almacenas los resultados parciales y totales de las operaciones realizadas
    double operando1 = 0;
    double operando2 = 0;
    double resultado = 0;
    //Para almacenar el string de la operación realizada (+, -, *, /)
    String operacion = "";

    public Ejemplo8b(){

        initDisplay(); //Display de la calculadora
        initBotones(); //Botones de la calculadora
        initPantalla(); //Opciones del JFrame
        eventosNumeros(); //Eventos asociados a los botones de números de la calculadora
        eventoDecimal(); //Eventos asociados al botón decimal "." de la calculadora
        eventosOperaciones(); //Eventos asociados a los botones de operaciones (+,-,*,/) de la calculadora
        eventoResultado();  //Eventos asociados al botón resultado de la calculadora
        eventoLimpiar();  //Eventos asociados al botón de limpiar "C" de la calculadora

    }

    private void initDisplay(){

        display = new JLabel("0"); //Inicio JLabel
        display.setBounds(15, 15, 245, 60); //Posición y dimensiones
        display.setOpaque(true); //Para poder darle un color de fondo
        display.setBackground(Color.BLACK); //Color de fondo
        display.setForeground(Color.GREEN); //Color de fuente
        display.setBorder(new LineBorder(Color.DARK_GRAY)); //Borde
        display.setFont(new Font("MONOSPACED", PLAIN, 24)); //Fuente
        display.setHorizontalAlignment(SwingConstants.RIGHT); //Alineamiento horizontal derecha
        display.setFocusable(true); //Permito que tenga el foco para poder escribir con el teclado
        add(display); //Añado el JLabel al JFrame
        display.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //Obtengo el string que corresponde a la tecla pulsada
                String ch = String.valueOf(e.getKeyChar());
                //Compruebo si es alguno del array de botones (salvo el de resultado)
                for (int i = 1; i < textoBotones.length; i++){
                    //Si se corresponde con lo que he pulsado
                    if (textoBotones[i].equals(ch)){
                        botones[i].doClick(); //Hago clic en ese botón
                    }
                }
                //Si pulsa el = o el retorno de carro
                if ("=".equals(ch) || e.getKeyCode() == 10){
                    botones[0].doClick(); //Hago clic en el botón de resultado
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void initBotones(){

        for (int i = 0; i < numBotones; i++){
            botones[i] = new JButton(textoBotones[i]); //Inicializo JButton
            int size = (i == 0) ? 24 : 16; //EL botón de Resultado tendrá un tamaño de fuente mayor que todos los demás
            int ancho = (i == 0) ? 245 : anchoBoton; //EL botón de Resultado será más ancho que todos los demás
            botones[i].setBounds(xBotones[i],yBotones[i],ancho,altoBoton); //Posición y dimensiones
            botones[i].setFont(new Font("MONOSPACED",PLAIN,size)); //Fuente
            botones[i].setOpaque(true); //Para poder darle un color de fondo
            botones[i].setFocusPainted(false); //Para que no salga una recuadro azul cuando tenga el foco
            botones[i].setBackground(Color.DARK_GRAY); //Color de fondo
            botones[i].setForeground(Color.WHITE); //Color de fuente
            botones[i].setBorder(new LineBorder(Color.DARK_GRAY)); //Borde
            add(botones[i]); //Añado el JButton al JFrame
        }

    }

    private void initPantalla() {

        setLayout(null); //Layout absoluto
        setTitle("Calculadora"); //Título del JFrame
        setSize(290, 455); //Dimensiones del JFrame
        setResizable(false); //No redimensionable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        getContentPane().setBackground(Color.BLACK); //Color de fondo
        setVisible(true); //Mostrar JFrame
    }

    private void eventosNumeros() {

        for (int i = 0; i < 10; i++){
            int numBoton = numerosBotones[i];
            botones[numBoton].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Si es un nuevo número y no es 0, sustituyo el valor del display
                    if (nuevoNumero){
                        if (!textoBotones[numBoton].equals("0")){
                            display.setText(textoBotones[numBoton]);
                            nuevoNumero = false; //Ya no es un nuevo número
                        }
                    }
                    //Si no, lo añado a los dígitos que ya hubiera
                    else{
                        display.setText(display.getText() + textoBotones[numBoton]);
                    }
                    display.requestFocus(); //Le devuelve el foco al display (por si escribe con el teclado)

                }
            });
            botones[numBoton].addMouseListener(mouseListeners(botones[numBoton]));
        }

    }

    private void eventoDecimal(){

        botones[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si todavía no he añadido el punto decimal al número actual
                if (!puntoDecimal){
                    display.setText(display.getText() + textoBotones[15]);
                    puntoDecimal = true; //Ya no puedo añadir el punto decimal en este número
                    nuevoNumero = false; //Por si empiezo el número con punto decimal (por ejemplo, .537)
                }
                display.requestFocus(); //Le devuelve el foco al display (por si escribe con el teclado)
            }
        });
        botones[15].addMouseListener(mouseListeners(botones[15]));

    }

    private void eventosOperaciones() {

        for (int numBoton : operacionesBotones) { //Es la versión optimizada de for (int i = 0; i < operacionesBotones.length; i++){
            botones[numBoton].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Si no tenía ninguna operación pendiente de realizar
                    if (operacion.equals("")) {
                        //Asocio la operación del botón a la variable
                        operacion = textoBotones[numBoton];
                        //Asigno a operando2 el valor del display (como double)
                        operando2 = Double.parseDouble(display.getText());
                        //Reseteo para poder introducir otro número y otro decimal
                        nuevoNumero = true;
                        puntoDecimal = false;
                        //Si tenía alguna pendiente, calculo el resultado de la anterior y luego me guardo la actual
                    } else {
                        operando2 = resultado(); //Se almacena en operando2 para poder encadenar operaciones posteriores
                        operacion = textoBotones[numBoton];
                    }
                    display.requestFocus(); //Le devuelve el foco al display (por si escribe con el teclado)
                }
            });
            botones[numBoton].addMouseListener(mouseListeners(botones[numBoton]));
        }

    }

    private void eventoResultado() {

        botones[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Al pulsar el botón de resultado, directamente lo calculo y reseteo la calculadora,
                //sin necesidad de almacenar el resultado para futuras operaciones
                resultado();
                display.requestFocus(); //Le devuelve el foco al display (por si escribe con el teclado)
            }
        });
        botones[0].addMouseListener(mouseListeners(botones[0]));
    }

    private MouseListener mouseListeners(JButton boton){

        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //Cambio de color de fondo al pulsar
                boton.setBackground(new Color(0, 255, 234));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //Vuelvo al color de fondo de mouse entered al soltar
                boton.setBackground(new Color(255, 221, 0));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //Cambio de color de fondo al entrar
                boton.setBackground(new Color(255, 221, 0));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //Vuelvo al color de fondo original al salir
                boton.setBackground(Color.DARK_GRAY);
            }
        };
    }

    private void eventoLimpiar() {

        botones[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Al pulsar el botón de limpiar, se resetean el display y las variables de la calculadora,
                display.setText("0");
                limpiar();
                display.requestFocus(); //Le devuelve el foco al display (por si escribe con el teclado)
            }
        });

    }

    // Calcula el resultado en función de la operación seleccionada y lo devuelve formateado en el display
    private double resultado(){

        //recojo el valor del display
        operando1 = Double.parseDouble(display.getText());

        //Selecciono y realizo operación
        switch (operacion){

            case "+" :  resultado = operando2 + operando1;
                break;
            case "-" :  resultado = operando2 - operando1;
                break;
            case "*" :  resultado = operando2 * operando1;
                break;
            case "/" :  resultado = operando2 / operando1;
                break;

        }

        //Formateo y muestro en el display
        Locale localeActual = Locale.GERMAN;
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(localeActual);
        simbolos.setDecimalSeparator('.');
        DecimalFormat formatoResultado = new DecimalFormat("#.######", simbolos);
        display.setText(String.valueOf(formatoResultado.format(resultado)));

        //Limpio variables para poder continuar
        limpiar();

        //Devuelvo el valor del resultado
        return resultado;

    }

    //Resetea los valores de la calculadora para poder continuar haciendo operaciones
    private void limpiar(){

        operando1 = operando2 = 0;
        operacion = "";
        nuevoNumero = true;
        puntoDecimal = false;
    }

    public static void main(String[] args) {
        new Ejemplo8b();
    }
}
