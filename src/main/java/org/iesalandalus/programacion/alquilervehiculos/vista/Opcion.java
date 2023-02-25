package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {

	SALIR("Salir"), INSERTAR_CLIENTE("Insertar cliente"), INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"), BUSCAR_CLIENTE("Buscar cliente"), BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"), MODIFICAR_CLIENTE("Modificar cliente"), DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"), BORRAR_TURISMO("Borrar turismo"), BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"), LISTAR_TURISMOS("Listar turismos"), LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTES("Listar alquileres de clientes"),
	LISTAR_ALQUILERES_TURISMO("Listar alquileres de turismos");

	private String cadenaAmostrar;

	Opcion(String cadenaAmostrar) {
		this.cadenaAmostrar = cadenaAmostrar;
	}

	public static Opcion getOpcionSegunOrdinal(int ordinal) {

		if (esOrdinalValido(ordinal)) {

			return values()[ordinal];

		} else {

			throw new IllegalArgumentException("ERROR: Ordinal de la opcion no valido.");
		}

	}

	public static boolean esOrdinalValido(int ordinal) {

		return (ordinal >= 0 && ordinal <= values().length - 1);
	}
}
