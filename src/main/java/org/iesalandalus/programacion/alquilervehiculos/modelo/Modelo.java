package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {

	private Alquileres alquileres;
	private Clientes clientes;
	private Turismos turismos;

	public Modelo() {
	}

	public void comenzar() {
		alquileres = new Alquileres();
		clientes = new Clientes();
		turismos = new Turismos();
	}

	public void terminar() {
		System.out.println("El modelo finalizado");
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {

		// Insertamos en clientes copia cliente recibido
		clientes.insertar(new Cliente(cliente));
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}

		if (clientes.buscar(alquiler.getCliente()) == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}

		if (turismos.buscar(alquiler.getTurismo()) == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}

		alquileres.insertar(new Alquiler(alquiler));
	}

	public void insertar(Vehiculo turismo) throws OperationNotSupportedException {

		// Insertamos en turismos copia turismo recibido
		turismos.insertar(new Vehiculo(turismo));
	}

	public Cliente buscar(Cliente cliente) {
		return clientes.buscar(cliente);
	}

	public Alquiler buscar(Alquiler alquiler) {
		return alquileres.buscar(alquiler);

	}

	public Vehiculo buscar(Vehiculo turismo) {
		return turismos.buscar(turismo);

	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {

		clientes.modificar(cliente, nombre, telefono);

	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {

		if (alquileres.buscar(alquiler) == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}
		alquileres.devolver(alquiler, fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		for (Alquiler alquilerCliente : alquileres.get(cliente)) {
			alquileres.borrar(alquilerCliente);
		}
		clientes.borrar(cliente);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {

		alquileres.borrar(alquiler);

	}

	public void borrar(Vehiculo turismo) throws OperationNotSupportedException {

		for (Alquiler alquilerTurismo : alquileres.get(turismo)) {
			alquileres.borrar(alquilerTurismo);
		}

		turismos.borrar(turismo);
	}

	public List<Cliente> getClientes() {

		List<Cliente> listaClientes = new ArrayList<>();
		Iterator<Cliente> iterator = clientes.get().iterator();
		while(iterator.hasNext()) {
		    Cliente cliente = iterator.next();
		    if (cliente != null) {
		        listaClientes.add(new Cliente(cliente));
		    }
		}
		return listaClientes;
	}
	

	public List<Alquiler> getAlquileres() {

		List<Alquiler> listaAlquileres = new ArrayList<>();
		Iterator<Alquiler> iterador = alquileres.get().iterator();
		while (iterador.hasNext()) {
		    Alquiler alquiler = iterador.next();
		    if (alquiler != null) {
		        listaAlquileres.add(new Alquiler(alquiler));
		    }
		}
		return listaAlquileres;
	}

	public List<Vehiculo> getTurismos() {

		List<Vehiculo> listaTurismos = new ArrayList<>();
		Iterator<Vehiculo> iterador = turismos.get().iterator();
		while (iterador.hasNext()) {
		    Vehiculo turismo = iterador.next();
		    if (turismo != null) {
		        listaTurismos.add(new Vehiculo(turismo));
		    }
		}
		return listaTurismos;

	}

	public List<Alquiler> getAlquileres(Cliente cliente) {

		List<Alquiler> listaAlquileres = new ArrayList<>();
		Iterator<Alquiler> iterador = alquileres.get(cliente).iterator();
		while (iterador.hasNext()) {
		    Alquiler alquiler = iterador.next();
		    if (alquiler != null) {
		        listaAlquileres.add(new Alquiler(alquiler));
		    }
		}
		return listaAlquileres;

	}

	public List<Alquiler> getAlquileres(Vehiculo turismo) {

		List<Alquiler> listaAlquileres = new ArrayList<>();
		Iterator<Alquiler> iterador = alquileres.get(turismo).iterator();
		while (iterador.hasNext()) {
		    Alquiler alquiler = iterador.next();
		    if (alquiler != null) {
		        listaAlquileres.add(new Alquiler(alquiler));
		    }
		}
		return listaAlquileres;
	}

}
