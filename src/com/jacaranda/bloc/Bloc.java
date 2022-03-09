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
	
	public void activa(int numero) throws BlocException {
		numero-=1;//se le resta 1 para poder indicar el indice del array
		if(numero>this.numNotas|| numero <0) { //comprobamos que los rangos son correctos
			throw new BlocException("La nota no existe");
		}else if (blocNotas[numero]instanceof NotaAlarma) {//comprobamos si el objeto esta instanciado a notaAlarma
			if(((NotaAlarma)blocNotas[numero]).isActivado()==true) {
				throw new BlocException("La nota ya esta activada");
			}
			((NotaAlarma)blocNotas[numero]).activar(); //activamos la alarma
		}else {
			throw new BlocException("La nota no tiene alarma");//Salta cuando la nota no esta instanciada a notaAlarma
		}
			
	}
	
	public void desactiva(int numero) throws BlocException{
		numero-=1;//se le resta 1 para poder indicar el indice del array
		if(numero>this.numNotas|| numero <0) {//comprobamos que los rangos son correctos
			throw new BlocException("La nota no existe");
		}else if(blocNotas[numero]instanceof NotaAlarma) {//comprobamos si el objeto esta instanciado a notaAlarma
			if(((NotaAlarma)blocNotas[numero]).isActivado()==false) {
				throw new BlocException("La nota ya esta desactivada");
			}
			((NotaAlarma)blocNotas[numero]).desactivar();//desactivamos la alarma
		}else {
			throw new BlocException("La nota no tiene alarma");//Salta cuando la nota no esta instanciada a notaAlarma
		}
	}
	
	
	
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
		Nota notasOrdenadas[]= new Nota[this.numNotas];
		Arrays.sort(notasOrdenadas);
		
		return notasOrdenadas.toString();
	}

}
