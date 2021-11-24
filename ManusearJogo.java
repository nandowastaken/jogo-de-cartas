import java.util.Random;

public class ManusearJogo {
	private Jogador vencedor_rodada;
	private Jogador segundo_rodada;
	private Jogador terceiro_rodada;
	
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
	
	public void cartaSorteda(Jogador jogador) {
		// Sorteia carta
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
	
	private void CalculaPodio(Jogador jogador1, Jogador jogador2, Jogador jogador3) {
		Jogador maior_primeiros;
		
		// Calcula quem é maior entre jogador1 e jogador2
		if (jogador1.getCartaComNaipe() > jogador2.getCartaComNaipe()) {
			maior_primeiros = jogador1;
		} else {
			maior_primeiros = jogador2;
		}
		
		// calcula o vencedor da rodada
		if (maior_primeiros.getCartaComNaipe() > jogador3.getCartaComNaipe()) {
			vencedor_rodada = maior_primeiros;
		} else {
			vencedor_rodada = jogador3;
		}
		
		// calcula o segundo e o terceiro lugar
		if (vencedor_rodada == jogador1) {
			if (jogador2.getCartaComNaipe() > jogador3.getCartaComNaipe()) {
				segundo_rodada = jogador2;
				terceiro_rodada = jogador3;
			} else {
				segundo_rodada = jogador3;
				terceiro_rodada = jogador2;
			}
		} else if (vencedor_rodada == jogador2) {
			if (jogador1.getCartaComNaipe() > jogador3.getCartaComNaipe()) {
				segundo_rodada = jogador1;
				terceiro_rodada = jogador3;
			} else {
				segundo_rodada = jogador3;
				terceiro_rodada = jogador1;
			}
		} else if (vencedor_rodada == jogador3){
			if (jogador1.getCartaComNaipe() > jogador2.getCartaComNaipe()) {
				segundo_rodada = jogador1;
				terceiro_rodada = jogador2;
			} else {
				segundo_rodada = jogador2;
				terceiro_rodada = jogador1;
			}
		}
		
	}
	
	public void addPontos(Jogador jogador1, Jogador jogador2, Jogador jogador3) {
		CalculaPodio(jogador1, jogador2, jogador3);
		vencedor_rodada.addPonto(3);
		segundo_rodada.addPonto(2);
		terceiro_rodada.addPonto(1);
		System.out.println(vencedor_rodada.getNome() + " venceu a rodada.");
		
	}
	
	
	public Jogador anunciaVencedor(Jogador jogador1, Jogador jogador2, Jogador jogador3) {
		Jogador maior_pontuacao;
		if (jogador1.getPontos() > jogador2.getPontos()) {
			maior_pontuacao = jogador1;
		} else {
			maior_pontuacao = jogador2;
		}
		
		// calcula quem venceu a partida
		if (maior_pontuacao.getPontos() > jogador3.getPontos()) {
			return maior_pontuacao;
		} else {
			return jogador3;
		}
		
	}
	
	
}

