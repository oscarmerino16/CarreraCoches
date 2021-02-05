package Info;

import java.util.Scanner;

public class Carrerica {

	private String nombre;
    private int kilometros;
	private int dorsal;
    private Coche vCoches[];
	
    
    public Carrerica(String nombre, int kilometros) {
		
		this.nombre = nombre;
		this.kilometros = kilometros;
		this.vCoches = new Coche[10];
	}

    public void addCoche(){
    	
    	Scanner leer = new Scanner(System.in);
    	
    	for (int i = 0; i < vCoches.length; i++) {
			
    		String nombre="", eshumano="";
    		int  dorsal=0;
    		boolean humano = false;
    		
    		if (vCoches[i]==null) {
				System.out.println("Dime el nombre del corredor");
				nombre = leer.next();
				do {
				System.out.println("Dime el dorsal del corredor");
				dorsal = leer.nextInt();
				}while (!comprobarDorsal(dorsal));
				

				System.out.println("Es jugador(SI) o maquina(NO)");
				eshumano = leer.next();
				
				if (eshumano.equalsIgnoreCase("SI")) {
					humano = true;
				}else {
					humano = false;
				}
				
				
				int pos = buscarHueco();
				if (pos == -1) {
					System.out.println("La carrera esta llena");
				}else {
					vCoches[pos] = new Coche(nombre, dorsal, this.kilometros, true);
				}
				break;
			}
    		
		}
    	
    	
    }
    
   

	private int buscarHueco() {
		for (int i = 0; i < vCoches.length; i++) {
			if (vCoches[i]==null) {
				return i;
			}
		}
		return -1;
	}

	//Devuelvo false si no se encuenta
	private boolean comprobarDorsal(int dorsal) {
		
		for (Coche co : vCoches) {
			
			if (co !=null && dorsal == co.getDorsal()) {
				return false;
			}
		}
		
		return true;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getKilometros() {
		return kilometros;
	}


	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}


	public Coche[] getvCoches() {
		return vCoches;
	}




	@Override
	public String toString() {
		return "Carrerica [nombre=" + nombre + ", kilometros=" + kilometros + "]";
	}

	public boolean comprobarCarreraTerminada() {

        for (Coche coche : vCoches) {
            if (coche != null && coche.getEstadoCoche().equalsIgnoreCase("Marcha")) {
                return false;
            }
        }
        return true;
    }

	public void empezarCarrera() {

        for (Coche coche : vCoches) {
            if(coche != null) {
            coche.setEstadoCoche("Marcha");
            }
        }
    
    
	}
	public void ganador() {
        for (Coche coche : vCoches) {
            if (coche != null && coche.getEstadoCoche().equalsIgnoreCase("Terminado")) {
                System.out.println("El ganador es: " + coche );
                
                break;
            }
        }
    }
	
	
	
	
}
