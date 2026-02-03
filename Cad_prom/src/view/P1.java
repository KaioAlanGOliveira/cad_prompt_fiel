package view;

import java.util.List;
import java.util.Scanner;

import connection.Dao;
import dizimista.Pagamento;
import javaBean.Fiel;

public class P1 {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		Dao dao = new Dao();
		int opcao = -1;

		dao.getConnection();

		System.out.println("\n--- SISTEMA DE DIZIMISTAS 2026 ---");
		System.out.println("1 - DODOS DO FIEL");
		System.out.println("2 - DADOS DO PARAGAMENTO");
		if (leitor.hasNextInt()) {
			opcao = leitor.nextInt();
			leitor.nextLine();
		} else {
			System.out.println("Erro: Digite apenas números.");
			leitor.nextLine();

		}

		switch (opcao) {
		case 1: {
			trataPagamento(leitor, dao, opcao);
			leitor.close();
			break;
		}
		case 2: {
			trataDizimista(leitor, dao, opcao);
			leitor.close();
		}
			break;
		}
	}

	private static void trataDizimista(Scanner leitor, Dao dao, int opcao) {
		do {
			System.out.println("\n--- SISTEMA DE DIZIMISTAS 2026 ---");
			System.out.println("1 - Mostar");
			System.out.println("2 - Remover");
			System.out.println("3 - Adicionar");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");

			if (leitor.hasNextInt()) {
				opcao = leitor.nextInt();
				leitor.nextLine();
			} else {
				System.out.println("Erro: Digite apenas números.");
				leitor.nextLine();
				continue;
			}

			switch (opcao) {
			case 1:
				exibirListaDizimistas(dao);
				break;
			case 2:
				executarRemocaoDizimistas(leitor, dao);
				break;
			case 3:
				executarAdicaoDizimistas(leitor, dao);
				break;
			case 0:
				System.out.println("Encerrando sistema...");
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 0);
	}

	private static void trataPagamento(Scanner leitor, Dao dao, int opcao) {
		do {
			System.out.println("\n--- SISTEMA DE DIZIMISTAS 2026 ---");
			System.out.println("1 - Mostar");
			System.out.println("2 - Remover");
			System.out.println("3 - Adicionar");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");

			if (leitor.hasNextInt()) {
				opcao = leitor.nextInt();
				leitor.nextLine();
			} else {
				System.out.println("Erro: Digite apenas números.");
				leitor.nextLine();
				continue;
			}

			switch (opcao) {
			case 1:
				exibirLista(dao);
				break;
			case 2:
				executarRemocao(leitor, dao);
				break;
			case 3:
				executarAdicao(leitor, dao);
				break;
			case 0:
				System.out.println("Encerrando sistema...");
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 0);
	}

//	Dizimistas

	private static void executarRemocaoDizimistas(Scanner scan, Dao dao) {
		System.out.print("\nDigite o CPF completo para remover: ");
		if (scan.hasNextDouble()) {
			double cpf = scan.nextDouble();
			scan.nextLine(); // Limpa buffer
			dao.removerFiel(cpf);
		} else {
			System.out.println("CPF inválido.");
			scan.nextLine();
		}
	}

	private static void executarAdicaoDizimistas(Scanner scan, Dao dao) {
		Pagamento novo = new Pagamento();
		System.out.println("\n--- CADASTRO ---");

		System.out.print("CPF: ");
		novo.setCpf(scan.nextInt());
		scan.nextLine();

		System.out.print("Data (AAAA-MM-DD): ");
		String data = scan.next(); 
		novo.setDataPagamento(java.sql.Date.valueOf(data));

		System.out.print("Pago?: ");
		novo.setPago(scan.nextBoolean());

		

		dao.adicionaDizimistas(novo);
	}

	private static void exibirListaDizimistas(Dao dao) {
		
		System.out.println("\n--- LISTAGEM DADOS DO PAGAMENTO---");
		List<Pagamento> lista = dao.listarDizimistas();
		
		if (lista.isEmpty()) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			for (Pagamento j : lista) {
				System.out.printf("id: %d | CPF: %d | Data: %s | Pago: %b%n", j.getId(), j.getCpf(), j.getDataPagamento(), j.getPago());

			}
		}
	}
		
// Fiel
	private static void exibirLista(Dao dao) {
		System.out.println("\n--- LISTAGEM  DADOS DO FIEL ");
		List<Fiel> lista = dao.listarFiel();
		
		if (lista.isEmpty()) {
			System.out.print("Nenhum registro encontrado.");
		} else {
			for (Fiel j : lista) {
				System.out.printf("CPF: %.0f | Nome: %s | Idade: %s | Tel: %s%n", j.getCpf(), j.getNome(), j.getIdade(),
						j.getTelefone());
				
			}
		}
		
		
	}

	private static void executarRemocao(Scanner scan, Dao dao) {
		System.out.print("\nDigite o CPF completo para remover: ");
		if (scan.hasNextDouble()) {
			double cpf = scan.nextDouble();
			scan.nextLine(); // Limpa buffer
			dao.removerFiel(cpf);
		} else {
			System.out.println("CPF inválido.");
			scan.nextLine();
		}
	}

	private static void executarAdicao(Scanner scan, Dao dao) {
		Fiel novo = new Fiel();
		System.out.println("\n--- CADASTRO ---");

		System.out.print("CPF: ");
		novo.setCpf(scan.nextDouble());
		scan.nextLine();

		System.out.print("Nome: ");
		novo.setNome(scan.nextLine());

		System.out.print("Idade: ");
		novo.setIdade(scan.nextLine());

		System.out.print("Telefone: ");
		novo.setTelefone(scan.nextLine());

		dao.adicionarFiel(novo);
	}
}
