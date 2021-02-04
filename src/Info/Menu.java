package Info;

import java.util.Scanner;

public class Menu {

	public static int pintaMenu() {

		int opc1 = 0;
        Scanner leer = new Scanner(System.in);

        do {
            System.out.println("Pulsa 1 para Jugar");
            System.out.println("Pulsa 2 para añadir un jugador");
            System.out.println("Pulsa 3 para añadir el nombre de la carrera");
            System.out.println("Pulsa 4 para salir");
            opc1 = leer.nextInt();
        } while (opc1 < 1 || opc1 > 4);
        return opc1;
    }



    public static int pintaMenuCarrera() {
        int opc = 0;
        Scanner leer = new Scanner(System.in);

        do {
            System.out.println("Pulsa 1 para acelerar");
            System.out.println("Pulsa 2 para frenar");
            System.out.println("Pulsa 3 para rearrancar");
            opc = leer.nextInt();
        } while (opc < 1 || opc > 4);
        return opc;
    }

			
	}
	
	
