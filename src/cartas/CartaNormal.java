package cartas;

import java.util.Random;

import jogo.Jogador;

public class CartaNormal extends Carta {

	@Override
	public void sortearCartas(Jogador[] jogadores) {
		
		for (int i = 0; i < jogadores.length; i++) {
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
	}
	
}
