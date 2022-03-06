package com.jacaranda.notas;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota {
	private static int codigoSiguiente=1;
	private int codigo;
	protected String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	//Constructor
	public Nota(String texto) {
		super();
		setTexto(texto);
		this.codigo= codigoSiguiente++;
		//pendiente fcreacion y fmodifi
		this.fechaCreacion = LocalDateTime.now();
		this.fechaUltimaModificacion= this.fechaCreacion;
		
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		this.fechaUltimaModificacion=LocalDateTime.now();
	}

	public int getCodigo() {
		return codigo;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
	
	//Si la fecha de creacion es igual a la de modificación el resultad
	//es false
	public boolean isModificado() {
		boolean modificado = true;
		if(fechaCreacion.equals(fechaUltimaModificacion)) {
			modificado = false;
		}
		return modificado;
	}
	/*
	 * Si la cadena es 0 emty es true
	 */
	public boolean isEmpty() {
		boolean empty = false;
		if(this.texto.length()==0) {
			empty= true;
		}
		return empty;
	}
	
	public boolean isCreadoAnterior(String nota) {
		boolean resultado=false;//por defecto la nota esta creada anterior mente
		if(isEmpty()==true) {
			resultado=true;
		}
		return resultado;
	}
	
	public boolean isModificadoAnterior(String nota) {
		boolean resultado=false;//por defecto la nota esta creada anterior mente
		if(isEmpty()==true&&isModificado()==false) {
			resultado=true;
		}
		return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(texto, other.texto);
	}

	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", texto=" + texto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaUltimaModificacion=" + fechaUltimaModificacion + "]";
	}
	/*
	 * Pendiente
	public int compareTo(String nota) {
		
	}
	*/
}
