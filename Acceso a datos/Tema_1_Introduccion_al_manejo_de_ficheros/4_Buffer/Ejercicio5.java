/* 
 * Ejercicio 5: Copiar un archivo usando buffers
 * 
 * Crea un programa en Java que permita a los usuarios copiar el contenido de un archivo de texto llamado "archivo_origen.txt" en otro archivo de texto llamado "archivo_destino.txt" utilizando buffers para mejorar la eficiencia en la lectura y escritura de archivos. El programa debe seguir estos pasos:

Abre el archivo de origen ("archivo_origen.txt") en modo lectura.

Abre el archivo de destino ("archivo_destino.txt") en modo escritura. Si el archivo de destino ya existe, el programa debe sobrescribir su contenido.

Utiliza un buffer de lectura y un buffer de escritura para copiar el contenido del archivo de origen al archivo de destino en bloques de datos. Puedes definir el tamaño del buffer (por ejemplo, 1024 bytes o más pequeño hasta que veáis el tamaño de cada bloque copiado).

Mientras haya datos disponibles en el archivo de origen, lee un bloque de datos en el buffer de lectura y escribe ese bloque en el archivo de destino utilizando el buffer de escritura. Al final de cada bloque, escribir un comentario tipo "Fin copia bloque 1"

Una vez copiados los datos, introducir una cadena de caracteres al final del documento destino, por ejemplo, "Última modificación: 25-09-2023 15:04:01"
 Cierra ambos archivos después de completar la copia.

Asegúrate de manejar adecuadamente las excepciones en caso de que los archivos no existan o ocurra algún otro error relacionado con la lectura o escritura de archivos.
 */

public class Ejercicio5 {
    
}
