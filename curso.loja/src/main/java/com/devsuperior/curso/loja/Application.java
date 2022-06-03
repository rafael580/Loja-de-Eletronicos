package com.devsuperior.curso.loja;

import com.devsuperior.curso.loja.entities.*;
import com.devsuperior.curso.loja.entities.enums.EstadoPagamento;
import com.devsuperior.curso.loja.entities.enums.TipoCliente;
import com.devsuperior.curso.loja.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repository;
	@Autowired
	private ProdutoRepository Prorepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPeditoRepository itemPeditoRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Categoria cat = new Categoria("informatica");
		Categoria cat1 = new Categoria("escriotio");

		Produto p1 = new Produto("computador",3500.0);
		Produto p2 = new Produto("impressora",800.0);
		Produto p3 = new Produto("mouse",80.0);

		Estado estado2 = new Estado("MINAS GERAIS");
		Estado estado1 = new Estado("SAO PAULO");

		Cidade cidade1 = new Cidade("Uberlandia",estado2);
		Cidade cidade2 = new Cidade("Campinas",estado1);
		Cidade cidade3 = new Cidade("Sao Paulo",estado1);

		Cliente cliente1 = new Cliente("Maria Silva","maria@gmail.com","262789712377", TipoCliente.PESSOAFISICA);
		cliente1.getTelefones().addAll(Arrays.asList("96905737", "873412334"));

		Endereco endereco = new Endereco("Rua flores","300","Apto 203","Jardim","28220834",cliente1,cidade3);
		Endereco endereco1 = new Endereco("AVENIDA MATOS","105","Sala 800","Centro","28220834",cliente1,cidade2);


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido( sdf.parse("30/09/2017 10:32"), cliente1, endereco);
		Pedido ped2 = new Pedido( sdf.parse("10/10/2017 19:35"), cliente1, endereco1);
		cliente1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		Pagamento pagto1 = new PagamentoComCartao( EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);


		cliente1.getEnderecos().addAll(Arrays.asList(endereco,endereco1));

		estado1.getCidades().addAll(Arrays.asList(cidade2,cidade3));
		estado2.getCidades().add(cidade1);

		cat.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat));
		p2.getCategorias().addAll(Arrays.asList(cat,cat1));

		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));

		repository.saveAll(Arrays.asList(cat,cat1));
		Prorepository.saveAll(Arrays.asList(p1,p2,p3));

		clienteRepository.save(cliente1);
		enderecoRepository.saveAll(Arrays.asList(endereco,endereco1));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p2,100.00,1,800.00);

		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		p2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPeditoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}
}