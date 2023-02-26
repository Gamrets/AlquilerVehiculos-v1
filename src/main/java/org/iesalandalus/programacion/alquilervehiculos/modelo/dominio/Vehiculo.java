package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public abstract class Vehiculo {

	private static final String ER_MARCA = "([A-ZÑ][a-zñ]+([ -]?[A-ZÑ][A-ZÑa-zñ]+)?)|[A-Z]+";
	
	
	//Lo importante en matricula española letras validas son B,C,D,G,H,J,K,L,M,N,P,R,S,T,V,W,X,Y,Z
	private static final String ER_MATRICULA = "\\d{4}\\s{0,1}([B-D]|[F-H]|[J-N]|[P-T]|[V-Z]){3}";

	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;

	public Vehiculo(String marca, String modelo, int cilindrada, String matricula) {

		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}

	public Vehiculo(Vehiculo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		setMarca(turismo.getMarca());
		setModelo(turismo.getModelo());
		setCilindrada(turismo.getCilindrada());
		setMatricula(turismo.getMatricula());

	}
	
	
	public abstract int getFactorPrecio();

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMarca(String marca) {

		if (marca == null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
			
		if (!marca.matches(ER_MARCA)) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		
		this.marca = marca;
	}

	private void setModelo(String modelo) {

		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}

		if (modelo.trim().isEmpty()) {

			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}

		this.modelo = modelo;
	}

	private void setCilindrada(int cilindrada) {

		if ((cilindrada <= 0) || (cilindrada > 5000)) {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		this.cilindrada = cilindrada;
	}

	private void setMatricula(String matricula) {

		if (matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		
		if (!matricula.replaceAll(" ", "").matches(ER_MATRICULA)) {
			
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
	if (this == obj) {
	return true;
	}
	if (obj instanceof Vehiculo) {
	Vehiculo other = (Vehiculo) obj;
	return Objects.equals(matricula, other.matricula);
	}
	return false;
	}

	@Override
	public String toString() {
		return (String.format("%s %s (%sCV) - %s", marca, modelo, cilindrada, matricula, "disponible"));
	}
	

	public static Vehiculo getTurismoConMatricula(String matriculaValida) {
		
		if (matriculaValida == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}

		Vehiculo turismo = new Vehiculo("Seat","León",20,matriculaValida);
		
		return turismo;
	}
}
