package cartas;
import jogo.Jogador;

public abstract class Carta {
	protected String formatarNumero(int numero_da_carta) {
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
	
	protected abstract void sortearCartas(Jogador[] jogadores);
}
