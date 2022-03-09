package com.jacaranda.notas;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota> {
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
		this.fechaUltimaModificacion= this.fechaCreacion; // lo igualamos ya que si ponemos .now nos da una diferencia de segundos
		
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
	
	//Si la fecha de creacion es igual a la de modificaci�n el resultad
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
	
	public boolean isCreadoAnterior(Nota other) {
		boolean resultado=false;
		if(other.fechaCreacion.isBefore(this.fechaCreacion)) {//comparamos si un objeto nota es anterior a la creacion que otro objeto nota
			resultado= true;
		}
		return resultado;
	}
	
	public boolean isModificadoAnterior(Nota other) {
		boolean resultado=false;
		if(other.fechaUltimaModificacion.isBefore(this.fechaUltimaModificacion)) {//comparamos si un objeto nota es anterior a la modificacion de otro objeto nota
			
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

	@Override
	public int compareTo(Nota o) {
		int resultado= this.codigo-o.codigo; //ordenamos por codigo 
		
			
		return resultado;
	}
}
