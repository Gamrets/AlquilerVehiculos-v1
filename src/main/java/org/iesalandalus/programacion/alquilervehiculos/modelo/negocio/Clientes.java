package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class Clientes {

	private List<Cliente> coleccionClientes;

	public Clientes() {

		coleccionClientes = new ArrayList<>();
	}

	public ArrayList<Cliente> get() {

		ArrayList<Cliente> clientesCopia = new ArrayList<>(coleccionClientes);
		return clientesCopia;
	}

	public int getCantidad() {

		return coleccionClientes.size();
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {

			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}

		if (!coleccionClientes.contains(cliente)) {
			coleccionClientes.add(cliente);
		} else {

			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");

		}
	}

	public Cliente buscar(Cliente cliente) {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}

		int indice = coleccionClientes.indexOf(cliente);

		if (indice == -1) {
			return null;
		} else {
			return coleccionClientes.get(coleccionClientes.indexOf(cliente));
		}
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {

			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}

		if (!coleccionClientes.contains(cliente)) {

			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		} else {
			coleccionClientes.remove(cliente);
		}

	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		if (nombre != null && !nombre.trim().isEmpty()) {
			cliente.setNombre(nombre);
		}
		if (telefono != null && !telefono.trim().isEmpty()) {
			cliente.setTelefono(telefono);
		}

		if (!coleccionClientes.contains(cliente)) {

			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}

	}
}
