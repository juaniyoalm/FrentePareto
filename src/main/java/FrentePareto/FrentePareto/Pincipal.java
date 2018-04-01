package FrentePareto.FrentePareto;

import java.util.Map.Entry;
import java.util.TreeMap;

public class Pincipal {
	
	private static TreeMap<Integer, Integer> fPareto = new TreeMap<Integer, Integer>();
	

	public static void main(String[] args) {
		
		EntradaSalida io = new EntradaSalida();
		TreeMap<Integer, String[]> data = io.readFile();
		
		getFrentePareto(data);
		
		System.out.println(fPareto.toString());
	}

	private static void getFrentePareto(TreeMap<Integer, String[]> data) {
		
		for(Entry<Integer, String[]> entry : data.entrySet()) {
			String[] value = entry.getValue();
			int clave = Integer.valueOf(value[1]);
			int valor = Integer.valueOf(value[0]);
			  
			if (!fPareto.containsKey(clave)) {
				fPareto.put(clave, valor);
			} else {
				if (fPareto.get(clave) < Integer.valueOf(valor)) {
					fPareto.put(clave, valor);
				}
			}
		}
	}
}
