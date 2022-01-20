package jogo;
import java.util.Arrays;
import java.util.Random;

import cartas.CartaNaipe;
import cartas.CartaNormal;

public class ManusearJogo {
	private Jogador jogadores[] = new Jogador[4];
	private int arrayPos = 0;
	
	public void criarJogador(String nome) {
		jogadores[arrayPos] = new Jogador(nome);
		arrayPos++;
	}
	
	public Jogador[] getJogadores() {
		return jogadores;
	}
	
	
	private String formatarNumero(int numero_da_carta) {
		switch (numero_da_carta) {
			case 1:
				return "Ás";
			case 2:
				return "Paus";
			case 3:
				return "Ouros";
			case 4:
				return "Copas";
			case 5:
				return "Espadas";
			case 11:
				return "Valete";
			case 12:
				return "Dama";
			default:
				return "Rei";
		}
		
	}
	
	/*
	
	public void sortearCartas() {
		// Sorteia carta
		for (int i = 0; i < this.jogadores.length; i++) {
			Jogador jogador = jogadores[i];
			Random gerador = new Random();
			int carta_selecionada = gerador.nextInt(13) + 1;
			int naipe = gerador.nextInt(4) + 2;
			String naipe_formatado = formatarNumero(naipe);
			jogador.setCarta(carta_selecionada);
			jogador.setCartaComNaipe(carta_selecionada * naipe);
			
			// Checa se a carta precisa ser formatada ou não
			if (carta_selecionada == 1 || carta_selecionada >= 11) {
				String carta_formatada = formatarNumero(carta_selecionada);
				System.out.println(jogador.getNome() + ": " + carta_formatada + " de " + naipe_formatado);
			
			} else {
				System.out.println(jogador.getNome() + ": " + jogador.getCarta() + " de " + naipe_formatado);
			}
			
			System.out.println("Pontuação final da carta: " + carta_selecionada + " * " + naipe + " = " + carta_selecionada*naipe);
			System.out.println();
		}
		
	}*/
	
	public void sortearCartas(int tipo) {
		switch (tipo) {
			case 1:
				CartaNormal cartas_normais_rodada = new CartaNormal();
				cartas_normais_rodada.sortearCartas(this.jogadores);
				break;
			case 2:
				CartaNaipe cartas_naipe_rodada = new CartaNaipe();
				cartas_naipe_rodada.sortearCartas(this.jogadores);
				break;
			case 3: 
				System.out.println();
				break;
			
		}
	}
	
	// Informa a posição do jogador no podio
	private void CalculaPodio() {
		for (int i = 0; i < this.jogadores.length; i++) {
			for (int j = 0; j < this.jogadores.length; j++) {
				if (this.jogadores[i].getCartaComNaipe() > this.jogadores[j].getCartaComNaipe()) {
					this.jogadores[i].addPosPodio();
				}
			}
		}
	}
	
	public void addPontos() {
		CalculaPodio();
		
		// Organiza em ordem crescente as maiores pontuações
		int posicoes[][] = new int[2][this.jogadores.length];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < this.jogadores.length; j++) {
				posicoes[i][j] = this.jogadores[j].getPosPodio();
			}
		}
		
		Arrays.sort(posicoes[1]);
		
		int lugar = 0;
		Jogador vencedor_rodada = null;
		
		// armazena os vencedores
		Jogador[] vencedores_rodada = new Jogador[4];
		int index_vencedor = 0;
		
		for (int i = posicoes[0].length - 1; i >= 0; i--) {
			int jogador = posicoes[1][i];
			
			// acrescenta pontos aos jogadores
			for (int j = 0; j < posicoes[0].length; j++) {
				if (jogador == posicoes[0][j]) {
					this.jogadores[j].addPonto(3 - lugar);
					
					
					if (lugar == 0) {
						vencedores_rodada[index_vencedor] = this.jogadores[j];
						index_vencedor++;
					}
					
					if (i != 0) {
						if (lugar != 3 && jogador != posicoes[1][i - 1]) {
							lugar++;
						}
					} 
					
					if (vencedor_rodada == null) {
						vencedor_rodada = this.jogadores[j];
						
					}
					
					// para não haver repetição de acréscimo
					posicoes[0][j] = -1;
					break;
				}
			}
			
			
		}
		
		System.out.print("Vencedores da rodada: ");
		
		// formata o texto que anuncia os vencedores
		for (int i = 0; i < vencedores_rodada.length; i++) {
			if (vencedores_rodada[i] == null) {
				break;
			} else if (i < index_vencedor - 1 && index_vencedor - 1 == i + 1) {
				System.out.print(vencedores_rodada[i].getNome() + " e ");
			} else if (i < index_vencedor - 1 && index_vencedor > 1) {
				System.out.print(vencedores_rodada[i].getNome() + ", ");
			} else {
				System.out.print(vencedores_rodada[i].getNome() + " ");
			}
			
		}
		
	}
	
	
	public void anunciaVencedor() {
		
		Jogador[] podio = new Jogador[this.jogadores.length];
		int primeiro_vencedor = podio.length - 1;
		int num_ganhadores = 1;
		
		for (int i = 0; i < this.jogadores.length; i++) {
			// determina a posição do jogador no podio
			for (int j = 0; j < this.jogadores.length; j++) {
				if (this.jogadores[i].getPontos() > this.jogadores[j].getPontos()) {
					this.jogadores[i].addPosFinal();
				}
			}
			
			// acrescenta os jogadores nesse podio
			if (podio[this.jogadores[i].getPosFinal()] == null) {
				podio[this.jogadores[i].getPosFinal()] = this.jogadores[i];
			} else {
				podio[this.jogadores[i].getPosFinal() + 1] = this.jogadores[i];
			}
		}
		
		Jogador[] vencedores = new Jogador[podio.length];
		vencedores[primeiro_vencedor] = podio[primeiro_vencedor];
		
		for (int i = podio.length - 2; i > 0; i--) {
			if (podio[i].getPontos() == podio[primeiro_vencedor].getPontos()) {
				vencedores[i] = podio[i];
				num_ganhadores++;
			}
		}
		
		System.out.print("Vencedores do jogo: ");
		
		int falta_anunciar = num_ganhadores;
		
		// formata o texto que anuncia os vencedores
		for (int i = 0; i < vencedores.length; i++) {
			if (vencedores[i] != null) {
				if (falta_anunciar == 2 && num_ganhadores > 1) {
					System.out.print(vencedores[i].getNome() + " e ");
				} else if (falta_anunciar > 2) {
					System.out.print(vencedores[i].getNome() + ", ");
				} else {
					System.out.print(vencedores[i].getNome());
				}
				
				falta_anunciar--;
			}
		}
	}
}

