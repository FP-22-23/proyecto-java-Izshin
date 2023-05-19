package fp.Test;
import java.time.LocalDate;

import fp.bicis.Bicicletas;
import fp.bicis.BicicletasIMPL;
import fp.bicis.ContenedorBici;
import fp.bicis.FactoriaBicis;
import fp.bicis.TipoEstacion;
import fp.common.CondicionesLab;
import fp.common.DiaSemana;
import fp.common.SensacionTermica;
import vino.FactoriaVinos;
import vino.Vinos;

public class TestBici {

	public TestBici() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		CondicionesLab b= new CondicionesLab(false, false);
		BicicletasIMPL b1= new BicicletasIMPL(70, LocalDate.of(2020, 2, 3), DiaSemana.MARTES, true, false, 0.70, 0.9384, TipoEstacion.INVIERNO);
		b1.importa(b);

		//Bicicletas b3= new BicicletasIMPL(70, LocalDate.of(2027, 2, 3), DiaSemana.MARTES, true, false, 0.70, 0.9384, TipoEstacion.INVIERNO);
		//Bicicletas b4= new BicicletasIMPL(70, LocalDate.of(2020, 2, 3), DiaSemana.MARTES, true, false, 2.0, 0.9384, TipoEstacion.INVIERNO);
		//Ambas de estas dos lineas comentadas prueban el correcto funcionamiento de los checkers
		System.out.println(b1);
		System.out.println(b1.getCondicionesDiarias());
		Bicicletas b2= new BicicletasIMPL();
		System.out.println(b2);
		System.out.println(b1.compareTo(b2));
		System.out.println(b1.getSensacion());
		ContenedorBici B= FactoriaBicis.leerbicis("data/bike_sharing_daily.csv");
		B.AgregaBici(b1);
		System.out.println(B.getBici());
		B.QuitaBici(b1);
		//Buscar "CondicionesLab" para comprobar que los sistemas AgregaBici y QuitaBici funcionan
		System.out.println(B.getBici());
		System.out.println(B.getnBici());
		BicicletasIMPL b3= new BicicletasIMPL(67, LocalDate.of(2020, 2, 3), DiaSemana.MARTES, true, false, 0.70, 0.9384, TipoEstacion.INVIERNO);
		B.AgregaVariasBicis(b1, b3);
		System.out.println(B.getnBici());
		

		
		System.out.println(B.ExisteSalidaEnFecha(LocalDate.of(2020, 2, 3)));
		

		
		System.out.println(B.MediaTemperatura());
		
		

		System.out.println(B.TemperaturaIdeal());
		

		
		System.out.println(B.IdentificacionSalida());
		//Las identificaciones 67 y 70 cuenta 2 b1 /agregada en agregar varias bicis y la del csv
		System.out.println(B.CuentaLlaves());

	}
	
}
