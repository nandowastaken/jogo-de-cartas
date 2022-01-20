package cartas;

import java.util.Random;

import jogo.Jogador;

public class CartaValor extends Carta {
	
	private boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0 && i != num) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void setValorTotal() {
		
		if (isPrime(getNumCarta())) {
			setValorNaipe(getNumNaipe() * 3);
		} else {
			setValorNaipe(getNumNaipe());
		}
		
		this.valor_total = getNumCarta() * getValorNaipe();
	}
	

}
