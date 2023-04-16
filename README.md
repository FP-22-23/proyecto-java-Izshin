# proyecto-java-Izshin

proyecto-java-Izshin created by GitHub Classroom
Proyecto 2023 FP Grupo 4 

Nombre: Iván Fernández Limárquez
DNI: 77015962W


Estructura de las carpetas del proyecto

/src: Directorio con el código fuente.
fp.Bicis: Paquete que contiene los tipos del proyecto.
fp.common: con los enum DiaSemana y Estacion
fp.Test: Paquete que contiene las clases de test del proyecto.
fp.utiles: Paquete que contiene las clases de utilidad.
/data: Contiene el dataset del proyecto.
bike_sharing_daily.csv: Archivo csv que contiene datos de diferentes partidas de ajedrez.


#Estructura del dataset:
  https://www.kaggle.com/datasets/contactprad/bike-share-daily-data
  Este dataset se compone de varias columnas, aunque las usadas son:
  instant: Integer Identificador del dato
  dteday: LocalDate Fecha
  holiday: Boolean Vacaciones (0 no son vacaciones, 1 si son)
  weekday: Integer Dia de la semana (0 domingo 1 Lunes... 6 sabado)
  workingday: Boolean Laboral (0 no es laboral, 1 si es)
  temp: Double temperatura
  windspeed: Double velocidad del viento
  


#Propiedades:
  private Integer Identificacion;
	private LocalDate Fecha; La fecha en la que se ha realizado el recorrido
	private DiaSemana DiaSem; Propiedad que dice el dia de la semana
 	private Boolean Laboral; Propiedad que dice si el dia es laboral o no
	private Boolean Vacaciones; Propiedad que dice si el dia es en vacaciones o no
	private Double Temperatura; La temperatura del dia
	private Double VelViento; La velocidad del viento del dia
	private List<Double> CondicionesDiarias; Lista con la temperatura y velocidad del viento
	
	
	
	
#Tipos auxiliares:
  private TipoEstacion Estacion; ENUM de la estacion en la que se ha realizado el recorrido
	private SensacionTermica Sensacion; ENUM propiedad derivada que, en base a la temperatura, dice la sensacion termica
	private List <CondicionesLab> CondLab; RECORD que devuelve las condiciones laborales del dia, si es laboral y/o vacaciones


#Archivos:

  Bicicletas: Interfaz, contiene todas las funciones principales del proyecto
  BicicletasIMPL: Clase, Implementa todas las funciones y agrega las funciones basicas como el hascode, toString, o compare to.
  FactoriaBicicletas: Clase que se ocupa de leer el csv y parsear los diversos aspectos del mismo, muchos de los parsea incluidos en esta 
  factoria se encargan de transmutar los Integer del csv en los tipos de BicicletasIMPL, por ejemplo parseaDiaSem se encarga en asignar
  cada numero a un dia de la semana.
  

#Constructores:
C1: Tiene un parámetro por cada propiedad básica del tipo.
C2: Crea un objeto de tipo Partida a partir de los siguientes parámetros: Integer Identificacion, LocalDate Fecha, DiaSemana DiaSem, 
Boolean Laboral, Boolean Vacaciones,Double Temperatura, Double VelViento, TipoEstacion Estacion
			
			
			
#Restricciones:
  La temperatura tiene que estar entre 0 y 1
  El año de la fecha no puede ser mayor que el actual
  
  
  
#Funciones:
	Integer getIdentificacion(); Retorna el numero identificativo del recorrido
	 LocalDate getFecha(); Retorna la fecha
	 DiaSemana getDiaSem(); Retorna el dia de la semana
	 Boolean getLaboral(); Retorna si es la boral o no
	 Boolean getVacaciones(); Retorna si son vacaciones o no
	 Double getTemperatura(); Retorna la temperatura
	 Double getVelViento(); Retorna la velocidad del viento
	 TipoEstacion getEstacion(); Retorna la estacion
	 SensacionTermica getSensacion();  Retorna la sensacion termica
	 List<Double> getCondicionesDiarias();  Retorna las condiciones diarias
	 void setIdentificacion(Integer identificacion) ; Cambia la Identificacion de un objeto tipo Bicicletas
	 void setFecha(LocalDate fecha) ; Cambia la fecha de un objeto tipo Bicicletas
	 void setDiaSem(DiaSemana diaSem); Cambia el dia de la semana de un objeto tipo Bicicletas
	 void setLaboral(Boolean laboral) ;Cambia si es dia laboral o no de un objeto tipo Bicicletas
	 void setVacaciones(Boolean vacaciones); Cambia si es vacaciones o no de un objeto tipo Bicicletas
	 void setTemperatura(Double temperatura); Cambia la temperatura de un objeto tipo Bicicletas
	 void setVelViento(Double velViento);Cambia la velocidad del viento de un objeto tipo Bicicletas
	 void setEstacion(TipoEstacion estacion); Cambia la estacion de un objeto tipo Bicicletas
	 int compareTo(Bicicletas b2); Compara dos objetos de tipo Bicicletas
	 public void Bicis: Crea el set de bicis vacio
	 public ContenedorBici: agrega todos las instancias del lector en el set
	 public Set<BicicletasIMPL> TemperaturaIdeal flitra todas las salidas y devuelve solo aquellas con la temperatura clasificada como "ideal"
	 public Map<Integer, LinkedList> IdentificacionSalida() Toma la identificacion de cada salida como clave y le asigna el dia, la estacion, temperatura 
	 y velocidad del viento como valores
	 public Map<Integer, Integer> CuentaLlaves: Toma la identificacion como clave y cuenta cuantas veces se repite en el Set bicicletas.
