package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	protected static final String PATRON_FECHA = "dd/LL/yyyy";
	protected static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {

	}

	public static void mostrarCabecera(String mensaje) {
		System.out.printf("%n%s%n", mensaje);
		String formatoStr = "%0" + mensaje.length() + "d%n";
		System.out.println(String.format(formatoStr, 0).replace("0", "-"));
	}

	public static void mostrarMenu() {
		mostrarCabecera("Gestión de reservas de vehiculos");
		System.out.println("");
		for (Accion opcion : Accion.values()) {
			System.out.println(opcion);
		}
	}

	private static String leerCadena(String mensaje) {
		System.out.println(mensaje);
		String cadena = Entrada.cadena();
		return cadena;
	}

	private static Integer leerEntero(String mensaje) {
		System.out.println(mensaje);
		Integer entero = Entrada.entero();
		return entero;
	}

	private static LocalDate leerFecha(String mensaje) {
		System.out.println(mensaje);
		LocalDate fecha = LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
		return fecha;
	}

	public static Accion elegirOpcion() throws OperationNotSupportedException {

		try {
			Accion opcion = null;

			while (opcion == null) {
				int ordinal = leerEntero("Introduce numero de opcion que quieres ejecutar: ");
				opcion = Accion.getOpcionSegunOrdinal(ordinal);
			}
			return opcion;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}

	public static String leerNombre() {
		String nombre = leerCadena("Introduce el nombre: ");
		return nombre;
	}

	public static String leerTelefono() {
		String telefono = leerCadena("Introduce el telefono: ");
		return telefono;
	}

	public static Cliente leerCliente() {

		Cliente cliente = null;
		String nombre = leerNombre();
		String dni = leerCadena("Introduce DNI del cliente: ");
		String telefono = leerTelefono();

		try {
			cliente = new Cliente(nombre, dni, telefono);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cliente;
	}

	public static Cliente leerClienteDni() {
		// Cliente cliente;
		String dni = leerCadena("Introduce DNI del cliente: ");
		return Cliente.getClienteConDni(dni);
	}

	public static Vehiculo leerTurismo() {

		Vehiculo turismo = null;
		String marca = leerCadena("Introduce marca: ");
		String modelo = leerCadena("Introduce modelo: ");
		int cilindrada = leerEntero("Introduce numero cilindrada: ");
		String matricula = leerCadena("Introduce matricula(1111AAA): ");

		try {
			turismo = new Vehiculo(marca, modelo, cilindrada, matricula);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		return turismo;
	}

	public static Vehiculo leerTurismoMatricula() {

		String matricula = leerCadena("Introduce matricula(1111AAA): ");
		return Vehiculo.getTurismoConMatricula(matricula);
	}

	public static Alquiler leerAlquiler() {

		Cliente cliente = leerClienteDni();
		Vehiculo turismo = leerTurismoMatricula();
		Alquiler alquiler = null;
		LocalDate fechaDate = leerFecha("Introduce fecha de alquiler(dd/mm/aaaa):");

		try {
			alquiler = new Alquiler(cliente, turismo, fechaDate);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return alquiler;
	}

	public static LocalDate leerFechaDevolucion() {
		LocalDate fechaDevolucion = leerFecha("Introduce fecha de devolucion(dd/mm/aaaa): ");
		return fechaDevolucion;
	}

}
