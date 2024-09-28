import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.IOException;

public class Ejercicio7AccesoADatosConINterfaz {
    /* Se me ha ocurrido crear una interfaz gráfica para el Ejercicio7 de acceso a datos de
     * Buffer del tema 1
     */

    public static void main(String[] args) {

        String resultadoMensaje = "";

        // Crear frame
        JFrame frame = new JFrame("Programa Copiar archivos");
        frame.setSize(360, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        // Panel 1 ------------------------------
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 1));
        frame.add(p1);

        // JLABEL
        JLabel label1 = new JLabel("Ruta Origen");
        label1.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel label2 = new JLabel("Ruta destino");
        label2.setFont(new Font("Arial", Font.BOLD, 12));

        // JTextField
        JTextField rutaOrigen = new JTextField(10);
        JTextField rutaDestino = new JTextField(10);

        p1.add(label1);
        p1.add(rutaOrigen);
        p1.add(label2);
        p1.add(rutaDestino);

        // Panel 2 ------------------------------
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        frame.add(p2);

        JLabel mensajeText = new JLabel(resultadoMensaje);
        mensajeText.setFont(new Font("Arial", Font.ITALIC, 12));
        p2.add(mensajeText);

        // Panel 3 ------------------------------
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        frame.add(p3);

        JButton botonCopiar = new JButton("copiar");
        Color azul = new Color(79, 117, 162);
        botonCopiar.setBackground(azul);

        p3.add(botonCopiar, BorderLayout.WEST);

        /* FUNCIONALIDAD */

        botonCopiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String archivoOrigen = rutaOrigen.getText();
                String archivoDestino = rutaDestino.getText();

                if (archivoOrigen.isEmpty() || archivoDestino.isEmpty()) {
                    mensajeText.setText("Por favor, ingrese ambas rutas.");
                    return;
                }

                try {

                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivoOrigen));
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(archivoDestino));

                    // Leer todo el contenido
                    int byteLeido;
                    System.out.println(bis.available()); // información cuantos bytes se pueden leer sin bloquear

                    while ((byteLeido = bis.read()) != -1) {
                        bos.write(byteLeido);
                    }
                    bos.flush(); // asegurar que se escriban todos los datos

                    System.out.println("copia realizada con exito");
                    mensajeText.setText("copia realizada con exito");

                    // Limpiar los campos de texto
                    rutaOrigen.setText("");
                    rutaDestino.setText("");

                } catch (IOException io) {

                }

            }
        });

        // Mostrar ventana y centrar
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}