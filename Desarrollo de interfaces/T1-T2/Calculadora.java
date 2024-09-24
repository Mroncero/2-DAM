import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora {

    static int num1;
    static int num2;
    static int posicion = 0;

    public static void main(String[] args) {

        // Frame
        JFrame frame = new JFrame(" ");
        frame.setSize(500, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel grid 1x1 ------------------------------
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));

        // textfield
        JTextField resultado = new JTextField();
        resultado.setPreferredSize(new Dimension(700, 80));
        panel.add(resultado);
        frame.add(panel, BorderLayout.NORTH);

        // Panel2 grid 4x4 ------------------------------
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 4));
        frame.add(panel2);

        // JButton
        JButton boton1 = new JButton("7");
        JButton boton2 = new JButton("8");
        JButton boton3 = new JButton("9");
        JButton boton4 = new JButton("+");
        JButton boton5 = new JButton("4");
        JButton boton6 = new JButton("5");
        JButton boton7 = new JButton("6");
        JButton boton8 = new JButton("-");
        JButton boton9 = new JButton("1");
        JButton boton10 = new JButton("2");
        JButton boton11 = new JButton("3");
        JButton boton12 = new JButton("*");
        JButton boton13 = new JButton("0");
        JButton boton14 = new JButton("c");
        JButton boton15 = new JButton("=");
        JButton boton16 = new JButton("/");

        panel2.add(boton1);
        panel2.add(boton2);
        panel2.add(boton3);
        panel2.add(boton4);
        panel2.add(boton5);
        panel2.add(boton6);
        panel2.add(boton7);
        panel2.add(boton8);
        panel2.add(boton9);
        panel2.add(boton10);
        panel2.add(boton11);
        panel2.add(boton12);
        panel2.add(boton13);
        panel2.add(boton14);
        panel2.add(boton15);
        panel2.add(boton16);

        // cambiar color botones
        Color azul = new Color(150, 39, 90);
        boton1.setBackground(azul);

        // Hacer visible y centrar
        frame.setVisible(true);
        // frame.setLocationRelativeTo(null);

        /*
         * Funcionalidad calculadora--------------------
         * Al pulsar el botón de un número,
         * se guarde en una variable y se muestre
         * en el panel de resultados
         */

        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //es el primer numero
                if (posicion == 0) {
                    num1 = 7;
                    resultado.setText("" + num1);
                    posicion++;
                }else{
                    num2 = 7;
                    posicion = 0;
                }

            }
        });

    }

}
