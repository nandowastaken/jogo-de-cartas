package cartas;

import java.util.Random;

import jogo.Jogador;

public class CartaNaipe extends Carta {
	@Override
	public void setValorTotal() {
		setValorNaipe(1);
		this.valor_total = getNumCarta() * getValorNaipe();
		
	}
	


}
