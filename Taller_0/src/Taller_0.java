import java.util.Scanner;
import java.io.*;
public class Taller_0 {

	public static void main(String[] args) {
		//Listas archivo "Jugadores.txt"
		String [] nombres = new String [999];
		String [] contraseñas = new String [999];
		int [] vida = new int [999];
		int [] ataque = new int [999];
		int [] defensa = new int [999];
		int [] velocidad = new int [999];
		int [] hechizos = new int [999];
		int [] xp = new int [999];
		
		//Listas archivo "Hechizos.txt"
		String [] nomHechizo = new String[999];
		int [] poderAtaque = new int [999];
		
		//Listas archivo "HechizosJugadores.txt"
		String [] nomJugador = new String[999];
		String [] nomHechizoJ = new String[999];
		
		//Listas archivo "Enemigos.txt"
		String [] nombreE = new String[999];
		int [] vidaE = new int [999];
		int [] ataqueE = new int [999];
		String [] tipoE = new String[999];
		int [] velocidadE = new int [999];
	}
	public static int carga_J() throws NumberFormatException, IOException{
		String archivo= "Jugadores.txt";
        Scanner reader = new Scanner(archivo);
        int cant = 0;
        while(reader.hasNextLine()){	
            String [] partes = archivo.split(", ");
            String nombre = partes[0];
            String contraseña = partes[1];
            int  vida = Integer.parseInt(partes[2]);
            int  ataque = Integer.parseInt(partes[3]);
            int  defensa = Integer.parseInt(partes[4]);
            int  velocidad = Integer.parseInt(partes[5]);
            int  hechizos = Integer.parseInt(partes[6]);
            int  xp = Integer.parseInt(partes[7]);
            cant++;
        }
        reader.close();
        return cant;
	}
	public static int carga_H()throws NumberFormatException, IOException {
		String archivo= "Hechizos.txt";
        Scanner reader = new Scanner(archivo);
        int cant = 0;
        while(reader.hasNextLine()){	
            String [] partes = archivo.split(", ");
            String nomHechizo = partes[0];
            int  poderAtaque = Integer.parseInt(partes[1]);
            cant++;
        }
        reader.close();
        return cant;
	}
	public static int carga_HechizosJugadores()throws NumberFormatException, IOException {
		String archivo= "HechizosJugadores.txt";
        Scanner reader = new Scanner(archivo);
        int cant = 0;
        while(reader.hasNextLine()){	
            String [] partes = archivo.split(", ");
            String nomJugador = partes[0];
            String nomHechizo = partes[1];
            cant++;
        }
        reader.close();
        return cant;
	}
	
	public static int carga_E()throws NumberFormatException, IOException {
		String archivo= "Enemigos.txt";
        Scanner reader = new Scanner(archivo);
        int cant = 0;
        while(reader.hasNextLine()){	
            String [] partes = archivo.split(", ");
            String nombreE = partes[0];
            int  vidaE = Integer.parseInt(partes[2]);
            int  ataqueE = Integer.parseInt(partes[3]);
            String tipo = partes[4];
            int  velocidadE = Integer.parseInt(partes[5]);
            cant++;
        }
        reader.close();
        return cant;
	}
	public static void inicioSesion(String contraseñas[], String nombres[],int cantidadUsuarios) {
		Scanner scan = new Scanner(System.in);
		boolean llave = true;
		while(llave) {
			System.out.println("INICIAR SESION");
			System.out.println("Escriba su nombre de usuario: ");
			System.out.println("Para finalizar el programa introduzca 0");
			String nombreUsuario = scan.nextLine();
			int indexUsuario = index(nombres, nombreUsuario, cantidadUsuarios);
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
					agregar_Jugador();
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
	private static void agregar_Jugador() {
		// TODO Auto-generated method stub	
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
			//eliminarJugador();
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
	private static void eliminarJugador(int cantidadUsuarios, String[] nombres, int contraseñas[], int vida[], int ataque[], int defensa[], int velocidad[], int hechizos[], int xp[], String []nomJugador, String []nomHechizoJ){
		Scanner scan = new Scanner(System.in);
		System.out.println("Eliminar Jugador");
		System.out.println("-------------------");
		System.out.println("Escriba el Nombre del jugador a eliminar: ");
		String eliminado = scan.nextLine();
		int indexUsuario = index(nombres, eliminado, cantidadUsuarios);
		for (int i = 0; i < nombres.length; i++) {
			if (eliminado.equals(nombres[i]) && indexUsuario == i) {
				System.out.println("Se ha encontrado al jugador");
				System.out.println("Eliminando...");
				nombres = null;
	            contraseñas = null;
	            vida = null;
	            ataque = null;
	            defensa = null;
	            velocidad = null;
	            hechizos = null;
	            xp = null;
	            nomJugador = null;
	            nomHechizoJ = null;
			}
			else {
				System.out.println("No se ha encontrado al jugador");
			}
		}
	}
	private static void verEstadisticas() {
		// TODO Auto-generated method stub	
	}
	private static void agregarHechizo() {
		// TODO Auto-generated method stub	
	}
	private static void agregarEnemigo() {
		// TODO Auto-generated method stub	
	}
	
}
