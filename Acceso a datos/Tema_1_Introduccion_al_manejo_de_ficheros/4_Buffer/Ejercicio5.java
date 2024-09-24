/* 
 * Ejercicio 5: Copiar un archivo usando buffers
 * 
 * Crea un programa en Java que permita a los usuarios copiar el contenido de un archivo de texto llamado "archivo_origen.txt" en otro archivo de texto llamado "archivo_destino.txt" utilizando buffers para mejorar la eficiencia en la lectura y escritura de archivos. El programa debe seguir estos pasos:

1. Abre el archivo de origen ("archivo_origen.txt") en modo lectura.

2. Abre el archivo de destino ("archivo_destino.txt") en modo escritura. Si el archivo de destino ya existe, el programa debe sobrescribir su contenido.

3. Utiliza un buffer de lectura y un buffer de escritura para copiar el contenido del archivo de origen al archivo de destino en bloques de datos. Puedes definir el tamaño del buffer (por ejemplo, 1024 bytes o más pequeño hasta que veáis el tamaño de cada bloque copiado).

4. Mientras haya datos disponibles en el archivo de origen, lee un bloque de datos en el buffer de lectura y escribe ese bloque en el archivo de destino utilizando el buffer de escritura. Al final de cada bloque, escribir un comentario tipo "Fin copia bloque 1"

5. Una vez copiados los datos, introducir una cadena de caracteres al final del documento destino, por ejemplo, "Última modificación: 25-09-2023 15:04:01"
 Cierra ambos archivos después de completar la copia.

6. Asegúrate de manejar adecuadamente las excepciones en caso de que los archivos no existan o ocurra algún otro error relacionado con la lectura o escritura de archivos.
 */

 import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
 import java.io.FileWriter;
 import java.io.RandomAccessFile;

 
public class Ejercicio5 {
    public static void main(String[] args) {

        
        String origen = "G:\\Mi unidad\\2º-DAM\\MODULOS\\Acceso a datos\\Tema_1_Introduccion_al_manejo_de_ficheros\\4_Buffer\\fileOrigen.txt";
        String destino = "G:\\Mi unidad\\2º-DAM\\MODULOS\\Acceso a datos\\Tema_1_Introduccion_al_manejo_de_ficheros\\4_Buffer\\fileDestino.txt";
        int bufferSize = 1024;
        try {
            // Abrir archivo origen
            RandomAccessFile fileOrigen = new RandomAccessFile(origen, "r");
            
            // Abrir archivo destino
            RandomAccessFile fileDestino = new RandomAccessFile(origen, "w");

            //Utiliza un buffer de lectura y un buffer de escritura para copiar el contenido del archivo de origen al archivo de destino en bloques de datos. Puedes definir el tamaño del buffer.
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(origen));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destino));

            //Crear un array para almacenar cada bloque de 1024 bytes 
            byte[] buffer = new byte[bufferSize];
            int datosLeidos;
            int contador = 1;
            
            //leer 
            while((datosLeidos = bis.read(buffer)) != -1){
                bos.write(buffer, 0, datosLeidos); // Escribir solo los bytes leídos

                // Imprimir información sobre el bloque copiado
                System.out.println("Leyendo contenido del bloque: " + contador);
                System.out.println(new String(buffer, 0, datosLeidos));
                System.out.println("Fin del bloque: " + contador);
                contador++;

            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        

        
    }
    
}
