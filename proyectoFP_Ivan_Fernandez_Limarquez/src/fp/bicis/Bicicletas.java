package fp.bicis;

import java.time.LocalDate;
import java.util.List;

import fp.common.Condiciones;
import fp.common.DiaSemana;
import fp.common.SensacionTermica;

public interface Bicicletas {
	 Integer getIdentificacion();
	 LocalDate getFecha();
	 DiaSemana getDiaSem();
	 Boolean getLaboral();
	 Boolean getVacaciones();
	 Double getTemperatura();
	 Double getVelViento();
	 TipoEstacion getEstacion();
	 SensacionTermica getSensacion();
	 List<Double> getCondicionesDiarias();
	 void setIdentificacion(Integer identificacion) ;
	 void setFecha(LocalDate fecha) ;
	 void setDiaSem(DiaSemana diaSem); 
	 void setLaboral(Boolean laboral) ;
	 void setVacaciones(Boolean vacaciones); 
	 void setTemperatura(Double temperatura); 
	 void setVelViento(Double velViento);
	 void setEstacion(TipoEstacion estacion); 
	 int compareTo(Bicicletas b2);
	List<CondicionesLab> importa(CondicionesLab b);
	
}
