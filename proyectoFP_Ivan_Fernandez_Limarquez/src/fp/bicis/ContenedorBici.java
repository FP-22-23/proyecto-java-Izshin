package fp.bicis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
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
	public boolean ExisteSalidaEnFechaStream(LocalDate fecha) {
		return Bicis.stream().anyMatch(s->fecha.equals(s.getFecha()));
	}
	
	public Double MediaTemperatura(){
		Double contador=0.00;
		for(BicicletasIMPL p:Bicis) {
			contador=contador+p.getTemperatura();
		}
			return contador/Bicis.size();
	}
	public Double MediaTemperaturaStream() {
		return Bicis.stream().mapToDouble(BicicletasIMPL::getTemperatura).average().getAsDouble();
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
	
	public Set<BicicletasIMPL> TemperaturaIdealStream(){
		return Bicis.stream().filter(s->SensacionTermica.IDEAL==s.getSensacion())
				.map(s->s).distinct().collect(Collectors.toSet());
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
	public Map<Object, Long> CuentaLlavesStream(){
		return Bicis.stream().collect(Collectors.groupingBy(s->s.getIdentificacion(), Collectors.counting()));
	}
	
	public Double TemperaturaMasBaja() {
		return Bicis.stream().filter(s->SensacionTermica.FRIO==s.getSensacion()).
				mapToDouble(BicicletasIMPL::getTemperatura).min().getAsDouble();
	}
	
	
	public List<Integer> TemperaturasDiasNoLaboralesOrdenadas(){
	Comparator<BicicletasIMPL> c= Comparator.comparing(BicicletasIMPL::getTemperatura);
	return Bicis.stream().filter(s->false==s.getLaboral()).sorted(c.reversed()).map(BicicletasIMPL::getIdentificacion).collect(Collectors.toList());
	}
	
	public Object CreaSetsYSetsDeSeguridad(){
		return Bicis.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
	}

	
	public Map<Object, Optional<BicicletasIMPL>> TemperaturasMinimasEnTiposDeDia(){
		Comparator<BicicletasIMPL> c= Comparator.comparing(BicicletasIMPL::getTemperatura);
		return Bicis.stream().collect(Collectors.groupingBy(s->s.getSensacion(), Collectors.minBy(c)));
	}
	
	public List<BicicletasIMPL> Naux(List<BicicletasIMPL> l , Integer n){return l.stream()
		.sorted(Comparator.comparing(i->i.getTemperatura())).limit(n).collect(Collectors.toList());}

	public SortedMap<SensacionTermica, List<BicicletasIMPL>> NTemperaturasMasAltasTiposDeDia(Integer n){
		
		return Bicis.stream().collect(Collectors
				.groupingBy(s->s.getSensacion(), TreeMap::new ,Collectors.collectingAndThen(Collectors.toList(), l->Naux(l,n))));
	}
	public Map<SensacionTermica, Long> AcumuladorSensacion(){
		return Bicis.stream().collect(Collectors.groupingBy(BicicletasIMPL::getSensacion, Collectors.counting()));
	}
	public SensacionTermica SensacionMasRepetida() {
		Map<SensacionTermica,Long> res=AcumuladorSensacion();
	return res.entrySet().stream().max(Comparator.comparing(i->i.getValue())).get(
			).getKey();}
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
