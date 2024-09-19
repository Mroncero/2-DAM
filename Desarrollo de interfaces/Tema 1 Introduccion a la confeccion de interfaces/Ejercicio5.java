import javax.swing.*;
import java.awt.*;


public class Ejercicio5 {

    static String usuarioOK = "pepe";
    static String contrasenaOk = "123";
    
    public static void main(String[] args) {

        //Crear ventana
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        //Jlabel
        JLabel usuario = new JLabel("Usuario: ");
        usuario.setBounds(100, 100, 100, 30);
        frame.add(usuario);

        //TextField
        JTextField textfield = new JTextField(20);
        textfield.setBounds(100, 150, 100, 30);
        frame.add(textfield);

        //Jlabel
        JLabel contrasena = new JLabel("Contraseña: ");
        contrasena.setBounds(100, 200, 100, 30);
        frame.add(contrasena);

        JPasswordField password = new JPasswordField();
        password.setBounds(100, 250, 100, 30);
        frame.add(password);

        //Butoon
        JButton button = new JButton();
        button.setBounds(50, 300, 100, 30); 
        frame.add(button); 

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String usuario = usuario.getText();
                String contrasena = usuario.getText();

                if(usuario.equals(usuarioOK) && contrasena.equals(contrasenaOK)){
                    labelResultado.setText("Resultado: correcto");
                }else{
                    labelResultado.setText("Resultado: incorrecto");
                }

            }
        });
        
        /*implementar dos mejoras 
        --numero intentos 
        --varios usuarios y contraseñas correctos
        */
    }
}
