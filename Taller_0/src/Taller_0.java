import java.util.Scanner;
import java.io.*;
public class Taller_0 {

	public static void main(String[] args) {
		String [] nombres = new String [999];
		String [] contraseñas = new String [999];

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
	public static void carga_H()throws NumberFormatException, IOException {
		String archivo= "Hechizos.txt";
        Scanner reader = new Scanner(archivo);
        while(reader.hasNextLine()){	
            String [] partes = archivo.split(", ");
            String nombre = partes[0];
            String nomHechizo = partes[1];
            int  poderAtaque = Integer.parseInt(partes[2]);
        }
        reader.close();
	}
	public static void carga_E()throws NumberFormatException, IOException {
		String archivo= "Enemigos.txt";
        Scanner reader = new Scanner(archivo);
        while(reader.hasNextLine()){	
            String [] partes = archivo.split(", ");
            String nombreE = partes[0];
            int  vidaE = Integer.parseInt(partes[2]);
            int  ataqueE = Integer.parseInt(partes[3]);
            String tipo = partes[4];
            int  velocidadE = Integer.parseInt(partes[5]);
        }
        reader.close();
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
		}
		else if(opcion.equals("2")){
		}
		else if(opcion.equals("3")){
		}
		else if(opcion.equals("4")){
		}
		else {
			System.out.println("Opcion Incorrecta");
			
		}
		
	}

}
