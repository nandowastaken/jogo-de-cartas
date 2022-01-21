package jogo;
import java.util.Arrays;
import java.util.Random;

import cartas.Carta;
import cartas.CartaNaipe;
import cartas.CartaNormal;
import cartas.CartaValor;

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
	
	public void sortearCartas(int tipo_carta) {
		// Sorteia carta
		for (int i = 0; i < this.jogadores.length; i++) {
			// sorteia a carta
			Jogador jogador = jogadores[i];
			Carta carta = null;
			Random gerador = new Random();
			int num_carta = gerador.nextInt(13) + 1;
			int num_naipe = gerador.nextInt(4) + 2;
			
			// criarCarta
			switch (tipo_carta) {
				case 1:
					carta = new CartaNormal();
					carta.setNumCarta(num_carta);
					carta.setNumNaipe(num_naipe);
					carta.formatarCarta();
					carta.setValorTotal();
					jogador.setCarta(carta);
					break;
				case 2:
					carta = new CartaNaipe();
					carta.setNumCarta(num_carta); 
					carta.setNumNaipe(num_naipe);
					carta.formatarCarta();
					carta.setValorTotal();
					jogador.setCarta(carta);
					break;
				case 3: 
					carta = new CartaValor();
					carta.setNumCarta(num_carta); 
					carta.setNumNaipe(num_naipe);
					carta.formatarCarta();
					carta.setValorTotal();
					jogador.setCarta(carta);
					break;
			}
			
			System.out.println(jogador.getNome() + ": " + carta.getCartaFormatada());
			
			System.out.println("Pontuação final da carta: " + carta.getNumCarta() + " * " + carta.getValorNaipe() + " = " + carta.getValorTotal());
			System.out.println();
		}
		
	}
	
	// Informa a posição do jogador no podio
	private void CalculaPodio() {
		for (int i = 0; i < this.jogadores.length; i++) {
			Carta carta_i = jogadores[i].getCarta();
			for (int j = 0; j < this.jogadores.length; j++) {
				Carta carta_j = jogadores[j].getCarta();
				if (carta_i.getValorTotal() > carta_j.getValorTotal()) {
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
		
		// Reseta a pontuação
		for (int i = 0; i < this.jogadores.length; i++) {
			this.jogadores[i].setPosPodio(0);
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

