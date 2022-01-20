package cartas;
import jogo.Jogador;

public abstract class Carta {
	private int num_carta;
	private int num_naipe;
	private int valor_naipe;
	private String carta_formatada;
	
	protected int valor_total;
	
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
	
	public void formatarCarta() {
		if (this.num_carta == 1 || this.num_carta >= 11) {
			this.carta_formatada = formatarNumero(this.num_carta);
		} else {
			this.carta_formatada = String.valueOf(this.num_carta);
		}
		
		this.carta_formatada += " de " + formatarNumero(this.num_naipe);
	}
	
	public String getCartaFormatada() {
		return this.carta_formatada;
	}
	
	public void setNumCarta(int num_carta) {
		this.num_carta = num_carta;
	}
	
	public int getNumCarta() {
		return this.num_carta;
	}
	
	public void setNumNaipe(int num_naipe) {
		this.num_naipe = num_naipe;
	}
	
	public int getNumNaipe() {
		return this.num_naipe;
	}
	
	public void setValorNaipe(int valor) {
		this.valor_naipe = valor;
	}
	
	public int getValorNaipe() {
		return this.valor_naipe;
	}
	
	public abstract void setValorTotal();
	
	public int getValorTotal() {
		return this.valor_total;
	}
	
	
}
