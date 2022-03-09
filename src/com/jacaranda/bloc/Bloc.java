package com.jacaranda.bloc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

import com.jacaranda.notas.Nota;
import com.jacaranda.notas.NotaAlarma;

public class Bloc {
	private static final int NUMERO_NOTAS_MAXIMA=100;
	private int numNotas;
	private String nombre;
	private Nota blocNotas[] ;
	//Constructor
	public Bloc(String nombre) {
		super();
		this.nombre = nombre;
		this.numNotas=0;
		this.blocNotas= new Nota[NUMERO_NOTAS_MAXIMA];
		
	}
	public String getBlocNotas(int indice) {
		
		return blocNotas[indice].toString();
	}
	//actualizar un texto de una nota existente
	public void updateNota(int numero, String texto) throws BlocException {
		if(numero>=this.numNotas) {
			throw new BlocException("Nota no existente");
		}else {
			blocNotas[numero].setTexto(texto);
		}
		
	}
	/*
	 * Por hacer
	public void activa(int numero) {
		if(numero>this.numNotas) {
			throw new BlocException("Nota no existente");
		}else {
			blocNotas[numero]
		}
	}
	public void desactiva(int numero){
	if(numero>this.numNotas) {
			throw new BlocException("Nota no existente");
		}else {
			blocNotas[numero]
		}
	}
	
	*/
	
	public static int getNumeroNotasMaxima() {
		return NUMERO_NOTAS_MAXIMA;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloc other = (Bloc) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
	public String ordena() {
		Arrays.sort(blocNotas);
		String notas="";
		for(int i=0 ;i<this.numNotas;i++) {
			notas+=blocNotas[i]+", ";
		}
		return notas;
	}

}
