package fp.bicis;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fp.common.DiaSemana;
import fp.common.SensacionTermica;
import fp.utiles.Checkers;

public class BicicletasIMPL implements Comparable<Bicicletas>, Bicicletas {

//NOTA: Las variables en comentarios se implementaran mas adelante en la segunda entrega,
	//pues en el csv los Dias de la semana, laborales y estacion vienen dados por numeros.
	private Integer Identificacion;
	private LocalDate Fecha;
	//private Integer Dia;
	private DiaSemana DiaSem;
	//private Integer Lab;
	private Boolean Laboral;
	private Boolean Vacaciones;
	private Double Temperatura;
	private Double VelViento;
	//private Integer Est;
	private TipoEstacion Estacion;
	private SensacionTermica Sensacion;
	private List<Double> CondicionesDiarias;
	public BicicletasIMPL() {
		Identificacion= 8676;
		Fecha= LocalDate.of(2022, 12, 25);
		DiaSem= DiaSem.LUNES;
		Laboral= true;
		Vacaciones= true;
		Temperatura= 0.1;
		VelViento= 0.23829;
		Estacion= Estacion.INVIERNO;
		Sensacion= getSensacion();
		CondicionesDiarias= new LinkedList<>();
		CondicionesDiarias.add(Temperatura);
		CondicionesDiarias.add(VelViento);
	}
	
	public BicicletasIMPL(Integer Identificacion, LocalDate Fecha, DiaSemana DiaSem, 
			Boolean Laboral, Boolean Vacaciones,Double Temperatura, Double VelViento, TipoEstacion Estacion) {
		this.Identificacion=Identificacion;
		this.Fecha=Fecha;
		Checkers.check("Fecha por encima de este año",(this.Fecha.getYear()<LocalDate.now().getYear()));
		this.DiaSem=DiaSem;
		this.Laboral=Laboral;
		this.Vacaciones=Vacaciones;
		this.Temperatura=Temperatura;
		Checkers.check("Temperatura demasiado fria", (Temperatura>0));
		Checkers.check("Temperatura demasiado caliente",(Temperatura<1));
		this.VelViento=VelViento;
		this.Estacion=Estacion;
		this.Sensacion= getSensacion();
		this.CondicionesDiarias= new LinkedList<>();
		this.CondicionesDiarias.add(Temperatura);
		this.CondicionesDiarias.add(VelViento);
		

	}
	public List<Double> getCondicionesDiarias() {
		
		return CondicionesDiarias;
		
	}
	public Boolean getVacaciones() {
		return Vacaciones;
	}
	public Double getTemperatura() {
		return Temperatura;
	}
	public Double getVelViento() {
		return VelViento;
	}
	public Integer getIdentificacion() {
		return Identificacion;
	}
	public DiaSemana getDiaSem() {
		return DiaSem;
	}
	public Boolean getLaboral() {
		return Laboral;
	}
	public TipoEstacion getEstacion() {
		return Estacion;
	}
	public SensacionTermica getSensacion() {
		if (0.000<Temperatura && Temperatura <0.250) {
			return Sensacion.FRIO;}
		else if (0.250<=Temperatura && Temperatura<=0.55) {
			return Sensacion.IDEAL;}
		else {return Sensacion.CALOR;
			
			
		}
		
	}
	
	public LocalDate getFecha() {
		return Fecha;
	}
	
	
//	public DiaSemana getDiaSem() {
//		switch(Dia) {
//		case 0:
//			return DiaSem.DOMINGO;
//		case 1:
//			return DiaSem.LUNES;
//		case 2: 
//			return DiaSem.MARTES;
//		case 3:
//			return DiaSem.MIERCOLES;
//		case 4:
//			return DiaSem.JUEVES;
//		case 5:
//			return DiaSem.VIERNES;
//
//		default:
//			return DiaSem.SABADO;
//		
//					
//		}
//	}
//	public Boolean getLaboral() {
//		if(Lab==1) {
//			Laboral=true;
//			
//		}
//		else
//			Laboral=false;
//		return Laboral;
//	}
//	public Boolean getVacaciones() {
//		return Vacaciones;
//	}
//	public Float getTemperatura() {
//		return Temperatura;
//	}
//	public Float getVelViento() {
//		return VelViento;
//	}
//	public TipoEstacion getEstacion() {
//		switch(Est) {
//		case 1:
//			return Estacion.INVIERNO;
//		case 2: 
//			return Estacion.PRIMAVERA;
//		case 3:
//			return Estacion.VERANO;
//	
//	   default:
//			return Estacion.OTOÑO;
//	}
//	}

	



	
		public void setIdentificacion(Integer identificacion) {
			this.Identificacion = identificacion;
		}
		public void setFecha(LocalDate fecha) {
			Checkers.check("Fecha por encima de este año",(this.Fecha.getYear()<LocalDate.now().getYear()));
			this.Fecha = fecha;
		}
		public void setDiaSem(DiaSemana diaSem) {
			this.DiaSem = diaSem;
		}
		public void setLaboral(Boolean laboral) {
			this.Laboral = laboral;
		}
		public void setVacaciones(Boolean vacaciones) {
			this.Vacaciones = vacaciones;
		}
		public void setTemperatura(Double temperatura) {
			Checkers.check("Temperatura demasiado fria", (Temperatura>0));
			Checkers.check("Temperatura demasiado caliente",(Temperatura<1));
			this.Temperatura = temperatura;
		}
		public void setVelViento(Double velViento) {
			this.VelViento = velViento;
		}
		public void setEstacion(TipoEstacion estacion) {
			this.Estacion = estacion;
		}
		
	
		public int hashCode() {
			return Objects.hash(DiaSem, Estacion, Fecha, Identificacion, Laboral, Sensacion, Temperatura, Vacaciones,
					VelViento);
		}
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BicicletasIMPL other = (BicicletasIMPL) obj;
			return DiaSem == other.DiaSem && Estacion == other.Estacion && Objects.equals(Fecha, other.Fecha)
					&& Objects.equals(Identificacion, other.Identificacion) && Objects.equals(Laboral, other.Laboral)
					&& Sensacion == other.Sensacion && Objects.equals(Temperatura, other.Temperatura)
					&& Objects.equals(Vacaciones, other.Vacaciones) && Objects.equals(VelViento, other.VelViento);
		}
	
	public String toString() {
	return "Bicis" + "["+getIdentificacion() +","+ getFecha()+","+getLaboral()+ ","+getDiaSem() + ","
	+getLaboral()+ ","+getEstacion()+ ","+getVacaciones()+ ","+getTemperatura()+","+getVelViento()+","+getSensacion()+"]";
}
	
	public int compareTo(Bicicletas c) {
		int res=getIdentificacion().compareTo(c.getIdentificacion());
		return res;
	}
	
	
}
	