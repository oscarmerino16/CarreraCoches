package Info;

public class Coche {

	private String nombrePiloto;
	private int dorsal;
	private int distanciaCarrera;
	private String estadoCoche;
	private final int POTENCIA=50;
	private int velocidad;
	private int kmRecorridos;


	public Coche(String nombrePiloto, int dorsal) {
		super();
		this.nombrePiloto = nombrePiloto;
		this.dorsal = dorsal;
		this.estadoCoche="PARADO";
		this.velocidad=0;
		this.kmRecorridos=0;
		distanciaCarrera = 300; //De momento
	}


	public String getNombrePiloto() {
		return nombrePiloto;
	}
	public void setNombrePiloto(String nombrePiloto) {
		this.nombrePiloto = nombrePiloto;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public String getEstadoCoche() {
		return estadoCoche;
	}
	public void setEstadoCoche(String estadoCoche) {
		this.estadoCoche = estadoCoche;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public int getKmRecorridos() {
		return kmRecorridos;
	}
	public void setKmRecorridos(int kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	public int getDistanciaCarrera() {
		return distanciaCarrera;
	}
	public int getPotencia() {
		return POTENCIA;
	}
	
	public void arrancar() {
		
		
		switch (this.estadoCoche) {
		case "PARADO":
			this.setEstadoCoche("MARCHA");
			System.out.println("Has arrancado el coche");
			break;
		case "MARCHA":
			System.out.println("Tu coche ya esta en marcha, has perdido el turno");
			break;
			
		case "ACCIDENTADO":
			System.out.println("Tu coche esta accidentado, debes rearrancarlo en el turno siguiente");
			break;
			
		case "TERMINADO":
			System.out.println("Ya has terminado la carrera");
			break;
		
		}
		
	}

	public void acelerar() {
		
		switch (this.getEstadoCoche()) {
		
		case "PARADO":
			System.out.println("Para acelerar, primero debes arrancar el coche en el turno siguiente");
			break;
		
		case "MARCHA":
			double random = Math.random()*this.POTENCIA+1;
			int acel = (int)Math.floor(random);
			velocidad+=acel;
			if (velocidad>200) {
				estadoCoche = "ACCIDENTADO";
				velocidad=0;
			}else {
				kmRecorridos+=acel;
			}
			break;
			
		case "ACCIDENTADO":
			System.out.println("Para poder acelerar, debes rearrancar el coche en el turno siguiente");
			break;
			
		case "TERMINADO":
			System.out.println("Ya has terminado la carrera");
			break;
		}
		
	}
	
	public void frenar() {
		
		switch (this.getEstadoCoche()) {
		
		case "PARADO":
			System.out.println("Para acelerar, primero debes arrancar el coche en el turno siguiente");
			break;
		
		case "MARCHA":
			double random = Math.random()*this.POTENCIA+1;
			int acel = (int)Math.floor(random);
			velocidad-=acel;
			if (velocidad>200) {
				estadoCoche = "ACCIDENTADO";
				velocidad=0;
			}else {
				kmRecorridos+=acel;
			}
			break;
			
		case "ACCIDENTADO":
			System.out.println("Para poder acelerar, debes rearrancar el coche en el turno siguiente");
			break;
			
		case "TERMINADO":
			System.out.println("Ya has terminado la carrera");
			break;
		}
		
	}
	

	public void rearrancar() {
		
		if (this.estadoCoche.equalsIgnoreCase("ACCIDENTADO") && this.estadoCoche!="TERMINADO" ) {
			this.estadoCoche="MARCHA";
		}
		
		
	}
	
}
	

