package FrentePareto.FrentePareto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeMap;

public class EntradaSalida {

	public EntradaSalida() {

	}

	public TreeMap<Integer, String[]> readFile() {
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		TreeMap<Integer, String[]> salida = new TreeMap<Integer, String[]>();
		String[] separador;
		int count = 0;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("src/main/java/FrentePareto/FrentePareto/archivo.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
				separador = linea.split(" ");
				salida.put(count, separador);
				count++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return salida;

	}
}
