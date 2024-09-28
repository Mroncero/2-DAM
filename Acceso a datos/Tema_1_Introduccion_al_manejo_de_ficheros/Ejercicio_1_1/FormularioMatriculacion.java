package Tema_1_Introduccion_al_manejo_de_ficheros.Ejercicio_1_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

/* Ejercicio 1.1: Formulario (desarrollo interfaces) de Matrícula con Manejo de Archivos

nunciado: Diseña un programa o aplicación que simule un formulario de matriculación 
de alumnos similar al que se muestra a continuación. El formulario debe incluir los 
siguientes campos:

Nombre y Apellidos: Campo de texto para que el estudiante ingrese su nombre completo.
Email: Campo de texto para ingresar la dirección de correo electrónico.
Fecha de Nacimiento: Un campo para seleccionar la fecha de nacimiento.
Género: Dos opciones de selección (masculino y femenino) para que el estudiante elija su género.
Titulación de Acceso: Un menú desplegable con opciones como "FP Grado Medio", "FP Grado Superior", "Bachillerato", entre otras.
Observaciones: Un campo de texto donde el estudiante puede escribir cualquier comentario o información adicional que considere importante.
Botones de Guardar y Imprimir.


Funcionalidades Clave:
Guardar:
El usuario ingresa la información solicitada.
La información se almacena en variables globales (puedes modificar esto si prefieres una estructura de datos diferente).

Imprimir:
Los datos que se guardaron previamente en las variables se escriben en un fichero matricula.txt en un formato óptimo para su lectura.
 */
public class FormularioMatriculacion {

    // Variables funcionalidad
    private static String nom;
    private static String mail;
    private static String fechaNac;
    private static String gen;
    private static String titulacion;
    private static String obser;

    private static boolean datosGuardados = false;

    static String ruta = "G:\\Mi unidad\\2º-DAM\\MODULOS\\Acceso a datos\\Tema_1_Introduccion_al_manejo_de_ficheros\\Ejercicio_1_1\\datosFormulario.txt";

    public static void main(String[] args) {

        // Crear frame grid 5x1 ------------------------
        JFrame frame = new JFrame("Ejercicio 11: Formulario: matriculación alumno/a");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440, 550);
        frame.setLayout(new GridLayout(5, 1));

        // PANEL1 grid 3x2-------------------------
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 2));
        frame.add(panel1);

        // JLabel Nombre Apellidos
        JLabel name = new JLabel("Nombre y Apellidos:");
        name.setFont(new Font("Arial", Font.BOLD, 12));

        // TextField nombre
        JTextField nombreInput = new JTextField(10);

        // JLabel Email
        JLabel email = new JLabel("Email:");
        name.setFont(new Font("Arial", Font.BOLD, 12));

        // TextField correo
        JTextField correoInput = new JTextField(10);

        // JLabel fecha nacimiento
        JLabel year = new JLabel("Año nacimiento:");
        name.setFont(new Font("Arial", Font.BOLD, 12));

        // TextField año
        JTextField yearInput = new JTextField(10);

        panel1.add(name);
        panel1.add(nombreInput);
        panel1.add(email);
        panel1.add(correoInput);
        panel1.add(year);
        panel1.add(yearInput);

        // PANEL2 grid 1x3-------------------------
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 3));
        frame.add(panel2);

        // JLabel genero
        JLabel genero = new JLabel("Género:");
        genero.setFont(new Font("Arial", Font.BOLD, 12));

        // JCheckbox
        // Crear los checkboxes
        JCheckBox checkbox1 = new JCheckBox("Femenino");
        JCheckBox checkbox2 = new JCheckBox("Masculino");

        panel2.add(genero);
        panel2.add(checkbox1);
        panel2.add(checkbox2);

        ButtonGroup genGrupo = new ButtonGroup(); //agrupamos para solo poder elegir una opcion
        genGrupo.add(checkbox1);
        genGrupo.add(checkbox2);

        // panel3 grid 1x2-------------------------
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(1, 2));
        frame.add(panel3);

        // JLabel titulo
        JLabel titulo = new JLabel("Titulación de acceso:");
        titulo.setFont(new Font("Arial", Font.BOLD, 12));

        // ComboBox
        String[] opciones = { "FP grado medio", "Bachillerato" };
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        panel3.add(titulo);
        panel3.add(comboBox);

        // panel4 grid 2x1-------------------------
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(2, 1));
        frame.add(panel4);

        // JLabel observaciones
        JLabel observaciones = new JLabel("Observaciones:");
        titulo.setFont(new Font("Arial", Font.BOLD, 12));
        // TextArea
        JTextArea observacionesInput = new JTextArea();

        panel4.add(observaciones);
        panel4.add(observacionesInput);

        // panel5 grid 1x3 o flow-------------------------
        JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());
        frame.add(panel5);

        // JButton guardar
        JButton guardar = new JButton("Guardar");

        // JButton eliminar
        JButton imprimir = new JButton("Imprimir");

        panel5.add(guardar);
        panel5.add(imprimir);
        panel5.add(guardar, BorderLayout.WEST);
        panel5.add(imprimir, BorderLayout.EAST);

        // Hacer visible y centrar
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // Funcionalidad-------------------------------------

        //Boton guardar
        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Verificar que los campos no estén vacíos antes de guardar
                if (nombreInput.getText().isEmpty() || correoInput.getText().isEmpty() || yearInput.getText().isEmpty() || observacionesInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método si hay campos vacíos
                }

                // coger textos
                nom = nombreInput.getText();
                mail = correoInput.getText();
                fechaNac = yearInput.getText();
                obser = observacionesInput.getText();

                // checkBox
                if (checkbox1.isSelected()) {
                    gen = checkbox1.getText();
                } else if (checkbox2.isSelected()) {
                    gen = checkbox2.getText();
                }

                // ComboBox
                titulacion = (String) comboBox.getSelectedItem();

                // Marcar que los datos han sido guardados
                datosGuardados = true;
                System.out.println("Datos guardados.");

            }
        });

        //Boton Imprimir
        imprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Comprobar que se ha dado a guardar antes de imprimir
                if(!datosGuardados){
                    JOptionPane.showMessageDialog(frame, "Por favor, guarda los datos antes de imprimir.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    FileWriter fw = new FileWriter(ruta, true);
                    fw.write(name.getText() + " " + nom + "\n");
                    fw.write(email.getText() + " "  + mail + "\n");
                    fw.write(year.getText() + " " + fechaNac + "\n");
                    fw.write(genero.getText() + " " + gen + "\n");
                    fw.write(titulo.getText() + " " + titulacion + "\n");
                    fw.write(observaciones.getText() + " " + obser + "\n");

                    fw.close();
                    
                    System.out.println("Archivo escrito correctamente");
                    
                } catch (IOException i ) {
                }

            }
        });

    }
}

