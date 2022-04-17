import java.util.Scanner;
import java.io.*;

public class Taller_0 {
		//Listas archivo "Jugadores.txt"
		static String [] nombres = new String [999];
		static String [] contraseñas = new String [999];
		static int [] vida = new int [999];
		static int [] ataque = new int [999];
		static int [] defensa = new int [999];
		static int [] velocidad = new int [999];
		static int [] hechizos = new int [999];
		static int [] xp = new int [999];
		static int cantUsuarios = 0;
		
		//Listas archivo "Hechizos.txt"
		static String [] nomHechizo = new String[999];
		static int [] poderAtaque = new int [999];
		static int cantHechizos = 0;
		
		//Listas archivo "HechizosJugadores.txt"
		static String [] nomJugador = new String[999];
		static String [] nomHechizoJ = new String[999];
		static int cantHechizosJugadores = 0;
		
		//Listas archivo "Enemigos.txt"
		static String [] nombreE = new String[999];
		static int [] vidaE = new int [999];
		static int [] ataqueE = new int [999];
		static String [] tipoE = new String[999];
		static int [] velocidadE = new int [999];
		static int cantEnemigos = 0;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		carga_J();
		carga_H();
		carga_HJ();
		inicio_Sesion();
		
	}
	
	public static int carga_J() throws NumberFormatException, IOException{
		String archivo= "Jugadores.txt";
        Scanner reader = new Scanner(archivo);
        int cantUsuarios = 0;
        while(reader.hasNextLine()){	
            String [] partes = archivo.split(", ");
            nombres[cantUsuarios] = partes[0];
            contraseñas[cantUsuarios] = partes[1];
            vida[cantUsuarios]= Integer.parseInt(partes[2]);
            ataque[cantUsuarios] = Integer.parseInt(partes[3]);
            defensa[cantUsuarios] = Integer.parseInt(partes[4]);
            velocidad[cantUsuarios] = Integer.parseInt(partes[5]);
        	hechizos[cantUsuarios] = Integer.parseInt(partes[6]);
            xp[cantUsuarios] = Integer.parseInt(partes[7]);
            cantUsuarios++;
        }
        reader.close();
        return cantUsuarios;
	}
	public static int carga_H()throws NumberFormatException, IOException {
		String archivo= "Hechizos.txt";
        Scanner reader = new Scanner(archivo);
        int cantHechizos = 0;
        while(reader.hasNextLine()){	
            String [] partes = archivo.split(", ");
            nomHechizo[cantHechizos] = partes[0];
            poderAtaque[cantHechizos] = Integer.parseInt(partes[1]);
            cantHechizos++;
        }
        reader.close();
        return cantHechizos;
	}
	public static int carga_HJ()throws NumberFormatException, IOException {
		String archivo= "HechizosJugadores.txt";
        Scanner reader = new Scanner(archivo);
        int cantHechizosJugadores = 0;
        while(reader.hasNextLine()){	
            String [] partes = archivo.split(", ");
            nomJugador[cantHechizosJugadores] = partes[0];
            nomHechizo[cantHechizosJugadores] = partes[1];
            cantHechizosJugadores++;
        }
        reader.close();
        return cantHechizosJugadores;
	}
	
	public static int carga_E()throws NumberFormatException, IOException {
		String archivo= "Enemigos.txt";
        Scanner reader = new Scanner(archivo);
        int cantEnemigos = 0;
        while(reader.hasNextLine()){	
            String [] partes = archivo.split(", ");
            nombreE[cantEnemigos] = partes[0];
            vidaE[cantEnemigos] = Integer.parseInt(partes[2]);
            ataqueE[cantEnemigos] = Integer.parseInt(partes[3]);
            tipoE[cantEnemigos] = partes[4];
            velocidadE[cantEnemigos] = Integer.parseInt(partes[5]);
            cantEnemigos++;
        }
        reader.close();
        return cantEnemigos;
	}
	public static void inicio_Sesion() {
		Scanner scan = new Scanner(System.in);
		boolean llave = true;
		while(llave) {
			System.out.println("INICIAR SESION");
			System.out.println("Escriba su nombre de usuario: ");
			System.out.println("Para finalizar el programa introduzca 0");
			String nombreUsuario = scan.nextLine();
			int indexUsuario = index(nombres, nombreUsuario, cantUsuarios);
			if((nombreUsuario).equals(null) || (nombreUsuario).equals("0")){
				llave=false;
				System.out.println("Se a finalizado la operacion");
			}
			else if (nombreUsuario.equals("ADMIN")) {
				System.out.println("Escriba su contraseña");
				String pass = scan.nextLine();
				if((pass).equals("Patata19")) {
					menu_admin();
				}
			}
			else if (!nombreUsuario.equals("")) {
				if (indexUsuario == -1) {
		            System.out.println("El jugador ingresado no existe");
		        }
				else {
						System.out.println("Escriba su contraseña");
						String pass1 = scan.nextLine();
						for (int i = 0; i < contraseñas.length; i++) {
							if (pass1.equals(contraseñas[i]) && indexUsuario == i) {
								System.out.println("Acceso Correcto");
								menu_cliente();
							}
							else {
								System.out.println("Contraseña Incorrecta");
							}
						}
					}
			}
			else {
				System.out.println("Usuario no encontrado");
				System.out.println("¿Desea agregar un nuevo jugador?(1)SI - (2)NO: ");
				String opcion = scan.nextLine();
				if (opcion.equals("1")) {
					nuevo_usuario();
				}
				else if(!opcion.equals("1") && !opcion.equals("2")) {
					System.out.println("opcion invalida");
				}
				else {
					System.out.println("Saliendo...");
				}
				System.out.println("Volviendo al principio de la operacion");
			}
		}
	}
	public static void nuevo_usuario(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Porfavor indique su nombre:");
		String name = sc.nextLine();
		System.out.println("Porfavor indique su contraseña:");
		String contraseña = sc.nextLine();
		nombres[cantUsuarios] = name;
        contraseñas[cantUsuarios] = contraseña;
        vida[cantUsuarios]= 10;
        ataque[cantUsuarios] = 10;
        defensa[cantUsuarios] = 10;
        velocidad[cantUsuarios] = 10;
    	hechizos[cantUsuarios] = 0;
        xp[cantUsuarios] = 0;
        cantUsuarios++;
	}
	private static void menu_cliente() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1) Pelear contra un enemigo");
		System.out.println("2) Aprender un hechizo");
		System.out.println("3) Ver estadísticas de un Jugador");
		System.out.println("4) Ver estadísticas de hechizos");
		System.out.println("5) Ver ranking jugadores más experiencia");
		System.out.println("Ingrese el numero del menú al que quiera ingresar: ");
		String opcion = scan.nextLine();
		if (opcion.equals("1")){
			
		}
		else if(opcion.equals("2")){
		}
		else if(opcion.equals("3")){
		}
		else if(opcion.equals("4")){
		}
		else if(opcion.equals("5")) {
		}
		else {
			System.out.println("Opcion Incorrecta");
		}
	}
	public static int index(String[] list, String argument, int cant) {
        for (int i = 0; i < cant; i++) {
            if (list[i].equals(argument)) {
                return i;
            }
        }
        return -1;
	}
	private static void menu_admin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1) Eliminar Jugador");
		System.out.println("2) Agregar Enemigos");
		System.out.println("3) Agregar Hechizos");
		System.out.println("4) Ver Estadisticas");
		System.out.println("Ingrese el numero del menú al que quiera ingresar: ");
		String opcion = scan.nextLine();
		if (opcion.equals("1")){
			eliminarJugador();
		}
		else if(opcion.equals("2")){
			agregarEnemigo();
		}
		else if(opcion.equals("3")){
			agregarHechizo();
		}
		else if(opcion.equals("4")){
			verEstadisticas();
		}
		else {
			System.out.println("Opcion Incorrecta");
		}
	}
	private static void eliminarJugador(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Eliminar Jugador");
		System.out.println("------------------------------------------");
		System.out.println("Escriba el Nombre del jugador a eliminar: ");
		String eliminado = scan.nextLine();
		int indexUsuario = index(nombres, eliminado, cantUsuarios);
		for (int i = 0; i < nombres.length; i++) {
			if (eliminado.equals(nombres[i]) && indexUsuario == i) {
				System.out.println("Se ha encontrado al jugador");
				eliminarDatoString(nombres,cantUsuarios,nombres[i]);
				eliminarDatoString(contraseñas,cantUsuarios,contraseñas[i]);
	            eliminarDatoEntero(vida,cantUsuarios,vida[i]);
	            eliminarDatoEntero(ataque,cantUsuarios,ataque[i]);
	            eliminarDatoEntero(defensa,cantUsuarios,defensa[i]);
	            eliminarDatoEntero(velocidad,cantUsuarios,velocidad[i]);
	            eliminarDatoEntero(hechizos,cantUsuarios,hechizos[i]);
	            eliminarDatoEntero(xp,cantUsuarios,xp[i]);
	            eliminarDatoString(nomJugador,cantUsuarios,nomJugador[i]);
	            eliminarDatoString(nomHechizoJ,cantUsuarios,nomHechizoJ[i]);
				System.out.println("Eliminado...");
				break;
			}
			else {
				System.out.println("No se ha encontrado al jugador");
			}
		}
	}
	private static void agregarEnemigo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Agregar un Enemigo");
		System.out.println("------------------------------------------");
		System.out.println("Escriba el Nombre del enemigo: ");
		String nombEnemigoAgregado = scan.nextLine();
		int indexEnemigo = index(nombreE, nombEnemigoAgregado, cantEnemigos);
		for (int i = 0; i < nombreE.length; i++) {
				agregarDatoString(nombreE,cantEnemigos,nombEnemigoAgregado);
				System.out.println("Escriba la cantidad de vida del enemigo: ");
				int vidaEnemigoAgregado = scan.nextInt();
				agregarDato(vidaE,cantEnemigos,vidaEnemigoAgregado);
				System.out.println("Escriba el daño de ataque del enemigo: ");
				int ataqueoEnemigoAgregado = scan.nextInt();
				agregarDato(ataqueE,cantEnemigos,ataqueoEnemigoAgregado);
				System.out.println("Escriba el tipo del enemigo: ");
				String tipoEnemigoAgregado = scan.nextLine();
				agregarDatoString(tipoE,cantEnemigos,tipoEnemigoAgregado);
				System.out.println("Escriba la velocidad del enemigo: ");
				int velocidadEnemigoAgregado = scan.nextInt();
				agregarDato(velocidadE,cantEnemigos,velocidadEnemigoAgregado);
				break;
		}
	}
	private static void agregarHechizo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Agregar un Hechizo");
		System.out.println("------------------------------------------");
		System.out.println("Escriba el Nombre del Hechizo: ");
		String nombHechizoAgregado = scan.nextLine();
		int indexHechizo = index(nomHechizo, nombHechizoAgregado, cantHechizos);
		for (int i = 0; i < nomHechizo.length; i++) {
				agregarDatoString(nomHechizo,cantHechizos,nombHechizoAgregado);
				System.out.println("Escriba la cantidad de a del hechizo: ");
				int ataqueHechizoAgregado = scan.nextInt();
				agregarDato(poderAtaque,cantHechizos,ataqueHechizoAgregado);
				break;
		}
	}
	private static void verEstadisticas() {

		//print
	}
	
	public static int eliminarDatoEntero(int a[],int n, int x) {
		int i = 0;
		while(i<n && x!=a[i]) {
			i++;
		}
		if(i<n) {
			for(int k=i; k < n-1; k++) {
				a[k] = a[k+1];
			}
			n--;
		}
		return n;
	}
	public static int eliminarDatoString(String a[],int n, String x) {
		int i = 0;
		while(i<n && x!=a[i]) {
			i++;
		}
		if(i<n) {
			for(int k=i; k < n-1; k++) {
				a[k] = a[k+1];
			}
			n--;
		}
		return n;
	}
	public static boolean agregarDato(int a[],int n, int x) {
		int i = 0;
		if (i < n) {
			a[n] = x;
			n++;
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean agregarDatoString(String a[],int n, String x) {
		int i = 0;
		if (i < n) {
			a[n] = x;
			n++;
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
