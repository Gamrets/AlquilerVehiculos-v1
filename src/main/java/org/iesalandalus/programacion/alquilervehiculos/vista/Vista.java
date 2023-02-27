package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

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
					listarVehiculos();
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
					terminar();
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
		Vehiculo turismo = Consola.leerTurismo();

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
		Vehiculo turismo = Consola.leerTurismoMatricula();
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
		Vehiculo turismo = Consola.leerTurismoMatricula();
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
			// Obrengo lista de clientes del controlador
			List<Cliente> clientes = controlador.getClientes();

			// Utilisando colection sort ordeno la lista / con comparator defino criterio de
			// comparacion
			Collections.sort(clientes, new Comparator<Cliente>() {

				public int compare(Cliente c1, Cliente c2) {
					// Primero se compara por el nobre
					int resultado = c1.getNombre().compareTo(c2.getNombre());
					// Despues por dni
					if (resultado == 0) {
						resultado = c1.getDni().compareTo(c2.getDni());
					}
					return resultado;
				}
			});
			for (Cliente cliente : clientes) {
				System.out.println(cliente);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarVehiculos() {
		Consola.mostrarCabecera("Listar todos los vehiculos");
		try {
	        List<Vehiculo> vehiculos = controlador.getTurismos();
	        Collections.sort(vehiculos, new Comparator<Vehiculo>() {
	        
	            public int compare(Vehiculo t1, Vehiculo t2) {
	                int resultado = t1.getMarca().compareTo(t2.getMarca());
	                if (resultado == 0) {
	                    resultado = t1.getModelo().compareTo(t2.getModelo());
	                    if (resultado == 0) {
	                        resultado = t1.getMatricula().compareTo(t2.getMatricula());
	                    }
	                }
	                return resultado;
	            }
	        });
	        for (Vehiculo vehiculo : vehiculos) {
	            System.out.println(vehiculo);
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
	

	private void listarAlquileres() {
		Consola.mostrarCabecera("Listar alquileres");
		try {
			List<Alquiler> alquileres = controlador.getAlquileres();
			Collections.sort(alquileres, new Comparator<Alquiler>() {
				public int compare(Alquiler a1, Alquiler a2) {
					int resultado = a1.getFechaAlquiler().compareTo(a2.getFechaAlquiler());
					if (resultado == 0) {
						resultado = a1.getCliente().getNombre().compareTo(a2.getCliente().getNombre());
						if (resultado == 0) {
							resultado = a1.getCliente().getDni().compareTo(a2.getCliente().getDni());
						}
					}
					return resultado;
				}
			});
			for (Alquiler alquiler : alquileres) {
				System.out.println(alquiler);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void listarAlquileresCliente() {
		Consola.mostrarCabecera("Listar alquileres de un cliente");
		Cliente cliente = Consola.leerClienteDni();
		try {
			List<Alquiler> alquileres = controlador.getAlquileres(cliente);
			Collections.sort(alquileres, new Comparator<Alquiler>() {
				public int compare(Alquiler a1, Alquiler a2) {
					int resultado = a1.getFechaAlquiler().compareTo(a2.getFechaAlquiler());
					if (resultado == 0) {
						resultado = a1.getCliente().getNombre().compareTo(a2.getCliente().getNombre());
						if (resultado == 0) {
							resultado = a1.getCliente().getDni().compareTo(a2.getCliente().getDni());
						}
					}
					return resultado;
				}
			});
			
			for (Alquiler alquiler : alquileres) {
				System.out.println(alquiler);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Listar alquileres de un turismo");
		Vehiculo turismo = Consola.leerTurismoMatricula();
		try {
			List<Alquiler> alquileres = controlador.getAlquileres(turismo);
			Collections.sort(alquileres, new Comparator<Alquiler>() {
				public int compare(Alquiler a1, Alquiler a2) {
					int resultado = a1.getFechaAlquiler().compareTo(a2.getFechaAlquiler());
					if (resultado == 0) {
						resultado = a1.getCliente().getNombre().compareTo(a2.getCliente().getNombre());
						if (resultado == 0) {
							resultado = a1.getCliente().getDni().compareTo(a2.getCliente().getDni());
						}
					}
					return resultado;
				}
			});

			for (Alquiler alquiler : alquileres) {
				System.out.println(alquiler);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
