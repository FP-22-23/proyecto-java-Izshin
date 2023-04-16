package fp.common;

public record CondicionesLab(Boolean DiaLaboral, Boolean Vacaciones) {

	
	public String toString() {
		return "CondicionesLab [DiaLaboral=" + DiaLaboral + ", Vacaciones=" + Vacaciones + "]";
	}
	

}
