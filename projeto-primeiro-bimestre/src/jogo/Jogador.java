package jogo;

import cartas.Carta;

public class Jogador {
	private String nome;
	private int posPodio;
	private int posFinal;
	//private int carta;
	//private int carta_com_naipe;
	private int pontuacao;
	
	private Carta carta;
	
	Jogador(String nome_dele) {
		this.nome = nome_dele;
	}
	
	/*
	public int getCarta() {
		return carta;
	}
	
	
	public void setCarta(int nome_da_carta) {
		this.carta = nome_da_carta;
	}
	
	public int getCartaComNaipe() {
		return this.carta_com_naipe;
	} 
	
	public void setCartaComNaipe(int numero) {
		this.carta_com_naipe = numero; 
	} */
	
	public void setCarta(Carta carta) {
		this.carta = carta;
	}
	
	public Carta getCarta() {
		return this.carta;
	}
	
	public void addPonto(int valor) {
		this.pontuacao += valor;
	}
	
	public int getPontos() {
		return this.pontuacao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setPosPodio(int valor) {
		this.posPodio = valor;
	}
	
	// Acrescenta uma posição no podio
	public void addPosPodio() {
		this.posPodio++;
	}
	
	public int getPosPodio() {
		return this.posPodio;
	}
	
	public void addPosFinal() {
		this.posFinal++;
	}
	
	public int getPosFinal() {
		return this.posFinal;
	}
	
	
	
}
