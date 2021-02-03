package Info;

public class Coche {

	private String nombrePiloto;
	private int dorsal;
	private int distanciaCarrera;
	private String estadoCoche;
	private final int POTENCIA=50;
	private int velocidad;
	private int kmRecorridos;
	private boolean humano;


	public Coche(String nombrePiloto, int dorsal, int distancia, boolean humano) {
		super();
		this.nombrePiloto = nombrePiloto;
		this.dorsal = dorsal;
		this.estadoCoche="PARADO";
		this.velocidad=0;
		this.kmRecorridos=0;
		distanciaCarrera = distancia; //De momento
		this.humano = humano;
	}

	public boolean isHumano() {
		return humano;
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
		
		switch (this.getEstadoCoche().toUpperCase()) {
		
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
			if (this.kmRecorridos >= this.distanciaCarrera) {
				this.estadoCoche = "TERMINADO";
			}
			
			break;
			
		case "ACCIDENTADO":
			System.out.println("Te has estampao animal, tienes que rearrancar");
			break;
			
		case "TERMINADO":
			System.out.println("Ya has terminado la carrera");
			break;
		}
		
	}
	
	public void frenar() {
		
		switch (this.getEstadoCoche()) {
		
		case "PARADO":
			System.out.println("Te has estampao animal");
			break;
		
		case "MARCHA":
			double random = Math.random()*this.POTENCIA+1;
			int acel = (int)Math.floor(random);
			int velocidad = this.getVelocidad();
			int kms = this.getKmRecorridos();
			velocidad-=acel;
			if (velocidad < 0) {
				this.setVelocidad(0);
				this.setEstadoCoche("Estas parado.");
				System.out.println("Tu velocidad es de " + this.getVelocidad());
			}else {
				this.setVelocidad(velocidad);
				this.setKmRecorridos(kms+velocidad);
				System.out.println("Vas a " + this.getVelocidad() + " km/h");
			}
			if (this.kmRecorridos >= this.distanciaCarrera) {
				this.estadoCoche = "TERMINADO";
			}
			break;
			
		case "ACCIDENTADO":
			System.out.println("Te has estampao animal");
			break;
			
		case "TERMINADO":
			System.out.println("Ya has terminado la carrera");
			break;
		}
		
	}
	

	public void rearrancar() {
		
		if (this.estadoCoche.equalsIgnoreCase("ACCIDENTADO") && this.estadoCoche!="TERMINADO" ) {
			this.estadoCoche="MARCHA";
			System.out.println("Has rearrancado");
		}
		
		
	}


	@Override
	public String toString() {
		return "Coche [nombrePiloto=" + nombrePiloto + ", dorsal=" + dorsal +", velocidad=" + velocidad
				+ ", kmRecorridos=" + kmRecorridos + "]";
	}
	
	
	
}
	

