package fp.bicis;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.CondicionesLab;
import fp.common.DiaSemana;
import fp.common.SensacionTermica;
import fp.utiles.Checkers;

public class BicicletasIMPL implements Comparable<Bicicletas>, Bicicletas {


	private Integer Identificacion;
	private LocalDate Fecha;
	private DiaSemana DiaSem;
	private Boolean Laboral;
	private Boolean Vacaciones;
	private Double Temperatura;
	private Double VelViento;
	private TipoEstacion Estacion;
	private SensacionTermica Sensacion;
	private List<Double> CondicionesDiarias;
	private List <CondicionesLab> CondLab;
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
		CondLab=new LinkedList<CondicionesLab>();
		

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
		this.CondLab= new LinkedList<CondicionesLab>();
		
		

	}
	
	



	private List<CondicionesLab> getCondiconesLab() {
		return CondLab;
	}
	public List<CondicionesLab> importa(CondicionesLab Laboral){
		CondLab.add(Laboral);
		return CondLab;

		
	};
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
	+getLaboral()+ ","+getEstacion()+ ","+getVacaciones()+ ","+getTemperatura()+","+getVelViento()+","+getSensacion()+ ","+getCondiconesLab()+"]";
}
	


	public int compareTo(Bicicletas c) {
		int res=getIdentificacion().compareTo(c.getIdentificacion());
		return res;
	}
	
	
}
	