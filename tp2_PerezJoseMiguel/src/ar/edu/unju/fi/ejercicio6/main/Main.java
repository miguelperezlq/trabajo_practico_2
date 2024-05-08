package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {
	public static void main(String[] args) {
		//EJEMPLO
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		//definición de expresión lambda que define el convertidor de FelinoDomestico a //FelinoSalvaje.
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());
		//se realiza la conversión
		FelinoSalvaje felino1 = converter.convert(gato);
		//mostramos los datos del objeto felino salvaje felino1
		converter.mostrarObjeto(felino1);
		
        //EJERCICIO06
        FelinoSalvaje felinoSalvaje = new FelinoSalvaje("Tanner", (byte) 20, 186f);
        // Verificar que el objeto no sea nulo utilizando el método estático isNotNull()
        if (Converter.isNotNull(felinoSalvaje)) {
            //convertiendo FelinoSalvaje a FelinoDomestico
            Converter<FelinoSalvaje, FelinoDomestico> converter1 = x ->
                new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
            
            // Realizar la conversión
            FelinoDomestico felinoDomestico = converter1.convert(felinoSalvaje);
            
            // Mostrar los datos del objeto FelinoDomestico utilizando el método mostrarObjeto()
            converter1.mostrarObjeto(felinoDomestico);
        } else {
            System.out.println("El objeto felinoSalvaje es nulo.");
        }
        
        

    }
}
