package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
		}
		this.controlador = controlador;
	}

	public void comenzar() {

		Opcion opcion = null;

		do {

			Consola.mostrarMenu();
			
			try {
				opcion = Consola.elegirOpcion();
				ejecutar(opcion);
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}

		} while (opcion != Opcion.SALIR);

		terminar();
	}

	private void ejecutar(Opcion opcion) {

			switch (opcion) {
				case INSERTAR_CLIENTE:
					insertarCliente();
					break;
				case INSERTAR_TURISMO:
					insertarTurismo();
					break;

				case INSERTAR_ALQUILER:
					insertarAlquiler();
					break;

				case BUSCAR_CLIENTE:
					buscarCliente();
					break;

				case BUSCAR_TURISMO:
					buscarTurismo();
					break;

				case BUSCAR_ALQUILER:
					buscarAlquiler();
					break;

				case MODIFICAR_CLIENTE:
					modificarCliente();
					break;

				case DEVOLVER_ALQUILER:
					devolverAlquiler();
					break;

				case BORRAR_CLIENTE:
					borrarCliente();
					break;

				case BORRAR_TURISMO:
					borrarTurismo();
					break;

				case BORRAR_ALQUILER:
					borrarAlquiler();
					break;
				case LISTAR_CLIENTES:
					listarClientes();
					break;
				case LISTAR_TURISMOS:
					listarTurismos();
					break;
				case LISTAR_ALQUILERES:
					listarAlquileres();
					break;
				case LISTAR_ALQUILERES_CLIENTES:
					listarAlquileresCliente();
					break;
				case LISTAR_ALQUILERES_TURISMO:
					listarAlquileresTurismo();
					break;

				default:
					opcion = Opcion.SALIR;
			}	

	}

	public void terminar() {
		System.out.println("Hasta luego,nos vemos pronto.");
	}

	private void insertarCliente() {

		Consola.mostrarCabecera("Insertar cliente");
		Cliente cliente = Consola.leerCliente();

		try {
			controlador.insertar(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void insertarTurismo() {
		Consola.mostrarCabecera("Insertar turismo");
		Turismo turismo = Consola.leerTurismo();

		try {
			controlador.insertar(turismo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void insertarAlquiler() {
		Consola.mostrarCabecera("Insertar alquiler");
		Alquiler alquiler = Consola.leerAlquiler();

		try {
			controlador.insertar(alquiler);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente");
		Cliente cliente = Consola.leerClienteDni();
		try {
			cliente = controlador.buscar(cliente);
			System.out.println(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void buscarTurismo() {
		Consola.mostrarCabecera("Buscar turismo");
		Turismo turismo = Consola.leerTurismoMatricula();
		try {
			turismo = controlador.buscar(turismo);
			System.out.println(turismo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void buscarAlquiler() {
		Consola.mostrarCabecera("Buscar alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		try {
			alquiler = controlador.buscar(alquiler);
			System.out.println(alquiler);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void modificarCliente() {
		Consola.mostrarCabecera("Modificar cliente");
		Cliente cliente = Consola.leerClienteDni();
		String nombre = Consola.leerNombre();
		String telefono = Consola.leerTelefono();
		try {
			controlador.modificar(cliente, nombre, telefono);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void devolverAlquiler() {
		Consola.mostrarCabecera("Devolver alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		LocalDate fechaDevolucion = Consola.leerFechaDevolucion();
		try {
			controlador.devolver(alquiler, fechaDevolucion);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		Cliente cliente = Consola.leerClienteDni();
		try {
			controlador.borrar(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void borrarTurismo() {
		Consola.mostrarCabecera("Borrar turismo");
		Turismo turismo = Consola.leerTurismoMatricula();
		try {
			controlador.borrar(turismo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void borrarAlquiler() {
		Consola.mostrarCabecera("Borrar alquiler");
		Alquiler alquiler = Consola.leerAlquiler();
		try {
			controlador.borrar(alquiler);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void listarClientes() {
		Consola.mostrarCabecera("Listar clientes");
		try {
			System.out.println(controlador.getClientes());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarTurismos() {
		Consola.mostrarCabecera("Listar todos los turismos");
		try {
			System.out.println(controlador.getTurismos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarAlquileres() {
		Consola.mostrarCabecera("Listar alquileres");
		try {
			System.out.println(controlador.getAlquileres());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void listarAlquileresCliente() {
		Consola.mostrarCabecera("Listar alquileres de un cliente");
		Cliente cliente = Consola.leerClienteDni();
		try {
			System.out.println(controlador.getAlquileres(cliente));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Listar alquileres de un turismo");
		Turismo turismo = Consola.leerTurismoMatricula();
		try {
			System.out.println(controlador.getAlquileres(turismo));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
