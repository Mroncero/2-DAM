
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ejercicio5 {
    
    static String pass = "123456";
    static String user = "Antonio";
    public static void main(String[] args) {
        
        //Crear objeto JFrame
        JFrame frame = new JFrame("Inicio de Sesion");
        
        //LLamar a ametodos de JFrame para tamaño, cierre y layout
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); //Sin layout para el JFrame

        //Creamos JTextField
         //Crear JTextField
        JTextField Usuario = new JTextField(20);
        Usuario.setBounds(150,60,150,30); //Tamaño y posicion
        frame.add(Usuario);//Añadimos al panel
         //Crear JTextField
         JTextField Contraseña = new JTextField(20);
         Contraseña.setBounds(150,120,150,30); //Tamaño y posicion
         frame.add(Contraseña);//Añadimos al panel

         //Crear boton
        JButton boton = new JButton("Inicio de Sesion");
        boton.setBounds(150,200,170,20); //Tamaño y posicion del boton
        frame.add(boton);//Añadimos al panel

        //Añadir ActionListener al boton


        boton.addActionListener(new ActionListener() {
            
            @Override

                public void actionPerformed(ActionEvent e){
                     
                    //Cambiar texto
                    String user2  = Usuario.getText();
                    String pass2 = Contraseña.getText();

                    if ((user2.equals(user))&&(pass2.equals(pass))) {
                        boton.setText("Correcto");
                        
                    }else{

                        boton.setText("Incorrecto");
                    }
                    
                }
        });

     

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}

/*implementar dos mejoras 
--numero intentos 
--varios usuarios y contraseñas correctos
*/

//PREGUNTA no trabajamos por coordenadas porque cada pantall tiene un tamaño distinto nosotros necesitamos layout para que las cosas se coloquen correctamente
