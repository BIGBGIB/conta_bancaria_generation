package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
import conta_bancaria.util.Sobre;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {

		int opcao;

		criarContasTeste();
		
		while (true) {

			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_PURPLE_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                      GBank                          ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

		
			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch(InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número inteiro entre 0 e 8");
				leia.nextLine();
			}
			
			if (opcao == 0) {
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "GBank - Aqui você tem valor!");
				Sobre.sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Criar Conta");
				cadastrarConta();
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Todas as contas cadastradas: ");
				listarContas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Digite o número da conta que deseja buscar: ");
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Digite o número da conta que deseja atualizar: ");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Digite o número da conta que deseja deletar: ");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Digite o número da conta que deseja sacar: ");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Digite o número da conta que deseja depositar: ");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Transferência bancária");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BRIGHT + "Opção inválida!");
				keyPress();
				break;
			}

		}
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}
	
	public static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
	}
 

	public static void listarContas() {
		contaController.listarTodas();
	}

	public static void cadastrarConta() {

		System.out.print("Digite o número da agência: ");
		int agencia = leia.nextInt();
		System.out.print("Digite o nome do titular da conta: ");
		String titular = leia.next();
		System.out.print("Digite o tipo da conta (1 - Conta Corrente | 2 - Conta Poupança): ");
		int tipo = leia.nextInt();
		System.out.print("Digite o saldo da conta: ");
		float saldo = leia.nextFloat();

		switch (tipo) {
		case 1 -> {
			System.out.print("Digite o limite da conta: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.print("Digite o dia do aniversário do titular da conta: ");
			int dia = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, dia));
		} 
		default -> System.out.println(Cores.TEXT_RED_BRIGHT + "Opção inválida!" + Cores.TEXT_RESET);
			


		}
	}

}
