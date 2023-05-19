package fp.Test;

import java.time.LocalDate;

import fp.bicis.BicicletasIMPL;
import fp.bicis.ContenedorBici;
import fp.bicis.FactoriaBicis;
import fp.bicis.TipoEstacion;
import fp.common.DiaSemana;

public class TestBicisStream {

	public static void main(String[] args) {
		ContenedorBici B= FactoriaBicis.leerbicis("data/bike_sharing_daily.csv");
		BicicletasIMPL b1= new BicicletasIMPL(1, LocalDate.of(2020, 2, 3), DiaSemana.MARTES, true, false, 0.70, 0.9384, TipoEstacion.INVIERNO);
		B.AgregaBici(b1);
		System.out.println(B.ExisteSalidaEnFecha(LocalDate.of(2020, 2, 3)));
		//Con Stream
		System.out.println(B.ExisteSalidaEnFechaStream(LocalDate.of(2020, 2, 3)));

		
		System.out.println(B.MediaTemperatura());
		//Con stream
		System.out.println(B.MediaTemperaturaStream());
		

		System.out.println(B.TemperaturaIdeal());
		//Con Stream
		System.out.println(B.TemperaturaIdealStream());
		
		//Minimo (si se va al enlace del dataset https://www.kaggle.com/datasets/contactprad/bike-share-daily-data
		//, se coloca en temp y sort Ascending, da como resultado el mismo mostrado por pantalla)
		System.out.println(B.TemperaturaMasBaja());
		
		//Si se quiere comprobar este metodo se puede temporalmente cambiar el BicicletasIMPL::getIdentificacion
		//por BicicletasIMPL::getTemperatura de la misma funcion
		System.out.println(B.TemperaturasDiasNoLaboralesOrdenadas());
		
		//El uno se repite al haberlo añadido antes por lo que en la llave 1 cuenta 2 
		System.out.println(B.CuentaLlavesStream());
		
		System.out.println(B.CreaSetsYSetsDeSeguridad());
		
		System.out.println(B.TemperaturasMinimasEnTiposDeDia());
		
		System.out.println(B.NTemperaturasMasAltasTiposDeDia(3));
		
		System.out.println(B.SensacionMasRepetida());
		
	}

}
