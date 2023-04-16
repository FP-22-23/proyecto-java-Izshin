package fp.bicis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.DiaSemana;
import fp.common.SensacionTermica;

public class ContenedorBici {
	private Set<BicicletasIMPL> Bicis;


	public void Bicis() {
		Bicis= new HashSet<BicicletasIMPL>();
	}	
	
	public ContenedorBici(Stream<BicicletasIMPL> bici) {
		this.Bicis=bici.collect(Collectors.toSet());}
	
	public Set<BicicletasIMPL> getBici(){
		return Bicis;
	}
	public int getnBici(){
		return Bicis.size();
	}
	public Set<BicicletasIMPL> AgregaBici(BicicletasIMPL bici) {
		Bicis.add(bici);
		return Bicis;
	
	}
	public Set<BicicletasIMPL> AgregaVariasBicis(BicicletasIMPL bici, BicicletasIMPL bici2) {
		Set<BicicletasIMPL> b = new HashSet<BicicletasIMPL>();
		b.add(bici2);
		b.add(bici);
		Bicis.addAll(b);
		return Bicis;
	
	}
	public Set<BicicletasIMPL> QuitaBici(BicicletasIMPL bici) {
		if(Bicis.contains(bici)) {
		Bicis.remove(bici);}
		else {throw new IllegalArgumentException("No exsite esa carre salida");}
		return Bicis;
		
	}
	public boolean ExisteSalidaEnFecha(LocalDate fecha){
		for(BicicletasIMPL p:Bicis) {
			if(p.getFecha().equals(fecha)) {
				return true;
			}
			
		};
			return false;
	}
	
	public Double MediaTemperatura(){
		Double contador=0.00;
		for(BicicletasIMPL p:Bicis) {
			contador=contador+p.getTemperatura();
		}
			return contador/Bicis.size();
	}
	public Set<BicicletasIMPL> TemperaturaIdeal(){
		HashSet<BicicletasIMPL> res = new HashSet<BicicletasIMPL>();

		for(BicicletasIMPL p:Bicis) {
			if(p.getSensacion()==SensacionTermica.IDEAL) {
				res.add(p);
			}
			
		};
		return res;
	}
	public Map<Integer, LinkedList> IdentificacionSalida(){
		Map<Integer, LinkedList>  res = new HashMap<Integer, LinkedList>();
		for(BicicletasIMPL p:Bicis) {
		LinkedList<Object> pes= new LinkedList<>();
			pes.add(p.getDiaSem());
			pes.add(p.getEstacion());
			pes.add(p.getTemperatura());
			pes.add(p.getVelViento());
			res.put(p.getIdentificacion(), pes);


				
			}
		
			return res;
			
}
	
	public Map<Integer, Integer> CuentaLlaves(){
		Map<Integer, Integer>  res = new HashMap<Integer, Integer>();
		
		for(BicicletasIMPL p:Bicis) {
			if(res.containsKey(p.getIdentificacion())) {
			res.put(p.getIdentificacion(),res.get(p.getIdentificacion())+1);
		}
			else {
				res.put(p.getIdentificacion(), 1);}
			}
		return res;
	}
	
	public int hashCode() {
		return Objects.hash(Bicis);
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContenedorBici other = (ContenedorBici) obj;
		return Objects.equals(Bicis, other.Bicis);
	}

	public String toString() {
		return "ContenedorBici [Bicicletas=" + getBici() + "]";
	}
}
