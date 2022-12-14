package pizzaria.listener;

import pizzaria.eventos.*;

public class PizzariaListenerConsolePrinter implements PizzariaListener {

	@Override
	public void ocorreuEvento(EventoPizzaria evento) {

		switch (evento.getTipoEvento()) {

		case CLIENTE_CHEGOU:
			String nomeCliente = ((EventoChegouCliente) evento).getCliente().getNome();
			System.out.println("Cliente " + nomeCliente + " chegou na pizzaria.");
			break;

		case GARCON_PEGOU_PEDIDO:
			EventoGarconPegouPedido ev = (EventoGarconPegouPedido) evento;
			System.out.println("Garçon " + ev.getGarcom().getNome() + " pegou o pedido " + ev.getPedido().getSabores()
					+ " do cliente " + ev.getCliente().getNome() + ".");
			break;
			
		case PIZZAIOLO_PEGO_PEDIDO:
			EventoPizzaioloPegouPedido ep = (EventoPizzaioloPegouPedido) evento;
			System.out.println("Pizzaiolo " + ep.getPizzaiolo().getNome() + " pegou o pedido " + ep.getPedido().getSabores() +
					" do garcom " + ep.getGarcom().getNome() + ".");
			break;
			
		case PIZZA_ESTA_PRONTA:
			EventoPizzaPronta pp = (EventoPizzaPronta) evento;
			System.out.println("Pizzaiolo " + pp.getPizzaiolo().getNome() + " fez  o pedido " + pp.getPedido() + ".");
			break;
			
		case CLIENTE_RECEBE_PIZZA:
			EventoClienteRecebeuPedido crp = (EventoClienteRecebeuPedido) evento;
			System.out.println("Garcom " + crp.getGarcom().getNome() + " levou o pedido "+ crp.getPedido().getSabores()+ " para " + crp.getCliente().getNome() + ".");
			break;
			
		case PIZZAIOLO_TERMINO_PEDIDO:
			EventoPizzaioloTerminoPizza ptp = (EventoPizzaioloTerminoPizza) evento;
			System.out.println("Pizzaiolo " + ptp.getPizzaiolo().getNome() + " termino o pedido " + ptp.getPedido().getSabores() + ".");
			break;
		
		case CLIENTE_FOI_EMBORA:
			EventoClienteFoiEmbora cfe = (EventoClienteFoiEmbora) evento;
			System.out.println("Cliente" + cfe.getCliente().getNome() + " foi embora.");
			break;
			
		default:
			throw new IllegalStateException(
					"Não conheço o tipo evento " + evento.getTipoEvento() + ". Favor atualizar a classe "
							+ this.getClass().getName() + " para lidar com esse tipo de evento.");
		}

	}

}
