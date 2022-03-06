package com.jacaranda.notas;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Activable {
	
	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO=5;
	private int minutosRepetir;
	private boolean activado;
	
	/*
	 * Cosntructor que hereda texto de nota y pone por defecto 
	 * los minutos de repeticion
	 */
	public NotaAlarma(String texto, LocalDateTime fechaAlarma,boolean activado) {
		super(texto);
		setFechaAlarma(fechaAlarma);
		this.activado= activado;
		this.minutosRepetir= MINUTOS_REPETIR_POR_DEFECTO;
	}

	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int minutosRepetir) {
		super(texto);
		setFechaAlarma(fechaAlarma);
		this.minutosRepetir = minutosRepetir;
		this.activado = true;
	}

	private void setFechaAlarma(LocalDateTime fechaAlarma) {
		
		//Preguntar donde colocar la exception
		
				this.fechaAlarma = fechaAlarma;
	}

	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}
	
	@Override
	public  void activar() {
		this.activado=true;
	}
	
	@Override
	public void desactivar() {
		this.activado=false;
	}
	
	public boolean isActivado() {
		return this.activado;
		}

	@Override
	public String toString() {
		return "NotaAlarma [texto "+texto+" fechaAlarma=" + fechaAlarma + ", minutosRepetir=" + minutosRepetir + ", activado="
				+ activado + "]";
	}
	
	
	
	
	
	
}
