import java.util.Scanner;

import jogo.Jogador;
import jogo.ManusearJogo;


public class Start {
	public static void main(String[] args) {
		ManusearJogo novoJogo = new ManusearJogo();
		novoJogo.criarJogador("Fernando");
		novoJogo.criarJogador("João");
		novoJogo.criarJogador("Talita");
		novoJogo.criarJogador("Gomes");
		Jogador array[] = novoJogo.getJogadores();
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].getNome());
		}
		
		System.out.println();
		
		System.out.println("Digite o tipo da carta: \n1. Normal;\n2. Naipe+;\n3. Valor+;\n");
		Scanner sc = new Scanner(System.in);
		int tipo_carta = sc.nextInt();
		novoJogo.sortearCartas(tipo_carta);
		
		System.out.println();
	
		
		novoJogo.addPontos();
		
		System.out.println();
		System.out.println();
		
		novoJogo.anunciaVencedor();
		
		System.out.println();
		
		
		
		/*
		int turnos = 0;
		ManusearJogo novoJogo = new ManusearJogo();
		
		// pergunta nome
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do primeiro jogador: ");
		String nome_jogador1 = sc.next();
		System.out.println("Digite o nome do segundo jogador: ");
		String nome_jogador2 = sc.next();
		System.out.println();
		
		Jogador jogador1 = new Jogador(nome_jogador1);
		Jogador jogador2 = new Jogador(nome_jogador2);
		Jogador jogador3 = new Jogador("Jogador 3");

		while (turnos <= 3) {
			turnos++;
			
			// sorteia carta e acrescenta pontos ao vencedor
			novoJogo.cartaSorteda(jogador1);
			novoJogo.cartaSorteda(jogador2);
			novoJogo.cartaSorteda(jogador3);
			novoJogo.addPontos(jogador1, jogador2, jogador3);
			
			// finaliza o jogo
			if (turnos == 3) {
				System.out.println();
				Jogador jogador_vencedor = novoJogo.anunciaVencedor(jogador1, jogador2, jogador3);
				
				System.out.println("O jogo acabou!");
				System.out.println("O vencedor foi " + jogador_vencedor.getNome() + " com uma pontuação final de: " + jogador_vencedor.getPontos() + " pontos");
				break;
			}
			
			// checa se quer ir pro próximo round
			System.out.println();
			System.out.println("Deseja ir para o próximo round? (S/N)");
			String resposta = sc.next();
			System.out.println();
			
			if (resposta.equals("N")) {
				break;
			}
			
			
		}*/
	}
}
