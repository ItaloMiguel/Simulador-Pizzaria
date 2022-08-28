package pizzaria;

public class NovoClienteDeciderAleatorio implements NovoClienteDecider {

	private static final double PROBABILIDADE_DE_GERAR_NOVO_CLIENTE = 0.4; 
	
	@Override
	public boolean deveGerarNovoCliente(int tempoSimulacao) {

		double randomAte1 = Math.random();
		return randomAte1 < PROBABILIDADE_DE_GERAR_NOVO_CLIENTE;
	}

}
