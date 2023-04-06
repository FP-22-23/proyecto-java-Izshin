package fp.Test;
import java.time.LocalDate;

import fp.bicis.Bicicletas;
import fp.bicis.BicicletasIMPL;
import fp.bicis.TipoEstacion;
import fp.common.DiaSemana;
import fp.common.SensacionTermica;

public class TestBici {

	public TestBici() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Bicicletas b1= new BicicletasIMPL(70, LocalDate.of(2020, 2, 3), DiaSemana.MARTES, true, false, 0.70, 0.9384, TipoEstacion.INVIERNO);
		//Bicicletas b3= new BicicletasIMPL(70, LocalDate.of(2027, 2, 3), DiaSemana.MARTES, true, false, 0.70, 0.9384, TipoEstacion.INVIERNO);
		//Bicicletas b4= new BicicletasIMPL(70, LocalDate.of(2020, 2, 3), DiaSemana.MARTES, true, false, 2.0, 0.9384, TipoEstacion.INVIERNO);
		//Ambas de estas dos lineas comentadas prueban el correcto funcionamiento de los checkers
		System.out.println(b1);
		System.out.println(b1.getCondicionesDiarias());
		Bicicletas b2= new BicicletasIMPL();
		System.out.println(b2);
		System.out.println(b1.compareTo(b2));
		System.out.println(b1.getSensacion());
	
	}
	
}
