package fp.bicis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

import fp.common.DiaSemana;
import fp.common.SensacionTermica;
import fp.utiles.Checkers;




public class FactoriaBicis {	
	public static ContenedorBici leerbicis(String RutaFichero) {
	ContenedorBici res=null;
	try { 
		Stream<BicicletasIMPL>  sv= Files.lines(Paths.get(RutaFichero)).skip(1)
				.map(FactoriaBicis::parsearBicis);
		res=new ContenedorBici(sv);
	}catch(IOException e) {
		System.out.println("No se ha encontrade el fichero" + RutaFichero);
	}
	return res;
}
public static BicicletasIMPL parsearBicis(String lineaCSV) {
	String[] campos= lineaCSV.split(",");
	Checkers.check("Error en elementos bici", campos.length==16);
	Integer Identificacion= Integer.valueOf(campos[0].trim());
	LocalDate Fecha= LocalDate.parse(campos[1].trim());
	Integer Dia= Integer.valueOf(campos[6].trim());
	Integer Lab= Integer.valueOf(campos[7].trim());
	Integer Vac= Integer.valueOf(campos[5].trim());
	Double Temperatura=Double.valueOf(campos[9].trim());
	Double VelViento=Double.valueOf(campos[12].trim());
	Integer Est=Integer.valueOf(campos[2].trim());
	
	return new BicicletasIMPL(Identificacion, Fecha, parseaSemana(Dia),parseaLaboral(Lab),
			parseaVacaciones(Vac), Temperatura, VelViento, parseaEstacion(Est));
	

}

	

	
	
public static DiaSemana parseaSemana(Integer Dia) {
	switch(Dia) {
	case 0:
		return DiaSemana.DOMINGO;
	case 1:
		return DiaSemana.LUNES;
	case 2: 
		return DiaSemana.MARTES;
	case 3:
		return DiaSemana.MIERCOLES;
	case 4:
		return DiaSemana.JUEVES;
	case 5:
		return DiaSemana.VIERNES;

	default:
		return DiaSemana.SABADO;
	
				
	}
}
public static Boolean parseaLaboral(Integer Lab) {
	Boolean Laboral;
	if(Lab==1) {
		Laboral=true;
		
	}
	else
		Laboral=false;
	return Laboral;
}public static Boolean parseaVacaciones(Integer Vac) {
	Boolean Vacaciones;
	if(Vac==1) {
		Vacaciones=true;
		
	}
	else
		Vacaciones=false;
	return Vacaciones;}
public static TipoEstacion parseaEstacion(Integer Est) {
	switch(Est) {
	case 1:
		return TipoEstacion.INVIERNO;
	case 2: 
		return TipoEstacion.PRIMAVERA;
	case 3:
		return TipoEstacion.VERANO;

   default:
		return TipoEstacion.OTOÑO;
}
}
public static SensacionTermica parseaSensacion(Double temperatura) {
	if (0.000<temperatura && temperatura <0.250) {
		return SensacionTermica.FRIO;}
	else if (0.250<=temperatura && temperatura<=0.55) {
		return SensacionTermica.IDEAL;}
	else {return SensacionTermica.CALOR;
		
		
	
}
}
}


