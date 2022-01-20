package cartas;

import java.util.Random;

import jogo.Jogador;

public class CartaNormal extends Carta {
	
	@Override
	public void setValorTotal() {
		setValorNaipe(getNumNaipe());
		this.valor_total = getNumCarta() * getValorNaipe();
	}
	
}
