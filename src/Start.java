import java.util.Scanner;

import jogo.Jogador;
import jogo.ManusearJogo;


public class Start {
	public static void main(String[] args) {
		ManusearJogo novoJogo = new ManusearJogo();
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int rounds = 3;
		String nome_jogador;
		
		// Cria os jogadores
		System.out.println("Digite o nome do primeiro jogador: ");
		nome_jogador = sc.next();
		novoJogo.criarJogador(nome_jogador);
		
		System.out.println("Digite o nome do segundo jogador: ");
		nome_jogador = sc.next();
		novoJogo.criarJogador(nome_jogador);
		
		System.out.println("Digite o nome do terceiro jogador: ");
		nome_jogador = sc.next();
		novoJogo.criarJogador(nome_jogador);
		
		System.out.println("Digite o nome do quarto jogador: ");
		nome_jogador = sc.next();
		novoJogo.criarJogador(nome_jogador);
		
		Jogador array[] = novoJogo.getJogadores();
		
		System.out.println();
		System.out.println("Digite quantos rounds você quer: (3 - 5)");
		rounds = sc2.nextInt();
		
		if (rounds > 5 || rounds < 3) {
			System.out.println("Era para ser entre 3 e 5. Você vai jogar um jogo de 3 rounds");
			rounds = 3;
		}
		
		System.out.println("Digite o tipo da carta: \n1. Normal;\n2. Naipe+;\n3. Valor+;\n");
		
		int tipo_carta = sc2.nextInt();
		
		
		while (rounds > 0) {
			
			novoJogo.sortearCartas(tipo_carta);
			System.out.println();
			novoJogo.addPontos();
			System.out.println();
			System.out.println();
			
			if (rounds - 1 == 0) {
				break;
			}
			
			System.out.println("Deseja continuar? S/N");
			String resposta = sc.next();
			if (resposta.equals("N")) {
				break;
			}
			
			rounds--;
			
		}
		
		novoJogo.anunciaVencedor();
		
		System.out.println();
		
		
		
	}
}
