package conta_bancaria;

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

			opcao = leia.nextInt();
			if (opcao == 0) {
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "GBank - Aqui você tem valor!");
				Sobre.sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Criar Conta");
				criarContasTeste();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Todas as contas cadastradas: ");
				listarContas();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Digite o número da conta que deseja buscar: ");
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Digite o número da conta que deseja atualizar: ");
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Digite o número da conta que deseja deletar: ");
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Digite o número da conta que deseja sacar: ");
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Digite o número da conta que deseja depositar: ");
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Transferência bancária");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BRIGHT + "Opção inválida!");
				break;
			}

	}
}

	public static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
}
	
	public static void listarContas() {
		contaController.listarTodas();
	}

	
}
