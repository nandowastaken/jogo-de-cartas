public class Jogador {
	private String nome;
	private int carta;
	private int carta_com_naipe;
	private int pontuacao;
	
	Jogador(String nome_dele) {
		nome = nome_dele;
	}
	
	public int getCarta() {
		return carta;
	}
	
	public void setCarta(int nome_da_carta) {
		carta = nome_da_carta;
	}
	
	public int getCartaComNaipe() {
		return carta_com_naipe;
	}
	
	public void setCartaComNaipe(int numero) {
		carta_com_naipe = numero; 
	}
	
	public void addPonto(int valor) {
		pontuacao += valor;
	}
	
	public int getPontos() {
		return pontuacao;
	}
	
	public String getNome() {
		return nome;
	}
	
}
