package Info;

import java.util.Random;
import java.util.Scanner;

public class Principal {

	
		public static void main(String[] args) {
			
			Scanner leer = new Scanner(System.in);
			
			Carrerica c = null;
			int opc1=0, opc=0;
			Coche car;
			
			do {
	            opc1=Menu.pintaMenu();
	            switch (opc1) {
	            case 1:
	                //Menu.pintaMenuCarrera();
	            	c.empezarCarrera();
	                do {


	                    for (int i = 0; i < c.getvCoches().length; i++) {
	                        if (c.getvCoches()[i]!=null) {
	                            car=c.getvCoches()[i];

	                            if (car.isHumano()) {
	                                //Juega humano
	                                opc=Menu.pintaMenuCarrera();
	                                System.out.println(car.toString());
	                                switch (opc) {
	                                
	                                case 1:
	                                    car.acelerar();
	                                    System.out.println();
	                                    break;
	                                case 2:
	                                    car.frenar();
	                                    System.out.println();
	                                    break;
	                                case 3:
	                                    car.rearrancar();
	                                    System.out.println();
	                                    break;
	                                }
	                            }else {
	                                //Juega Maquina aleatorio
	                            	Random r = new Random();
									switch (r.nextInt(2)) {
									case 0: {
										car.acelerar();
										break;
									}
									case 1: {
										car.frenar();
										break;
									}
									}
	                            }


	                        }

	                    }
	           } while (!c.comprobarCarreraTerminada());

	                break;
	            case 2:
	                c.addCoche();
	                break;
	            case 3:
	                String nombreCarrera;
	                int kilometros;

	                System.out.println("dime el nombre de la carrera");
	                nombreCarrera= leer.next();

	                System.out.println("Dime la distancia de la carrera");
	                kilometros=leer.nextInt();

	                c = new Carrerica(nombreCarrera, kilometros);
	                break;
	            case 4:
	                System.out.println("salir");
	                opc1=4;
	                break;

	            default:
	                break;
	            }
	        } while (opc1!=4);
	
	}

}
