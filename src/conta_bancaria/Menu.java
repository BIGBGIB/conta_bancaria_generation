package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
import conta_bancaria.util.Sobre;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;
		
		/* Instanciar Objetos da Classe Conta */
		
		Conta c1 = new Conta(1, 770, 1, "Gabrielle", 1000.00f);
		c1.visualizar();
		Conta c2 = new Conta(2, 771, 2, "Ricardo", 1000.00f);
		c2.visualizar();
		Conta c3 = new Conta(3, 773, 3, "Boberto", 1000.00f);
		c3.visualizar();
		
		System.out.println("\nSacar R$ 1.000,00 da conta c2: " + (c2.sacar(1000.00f) ? 
				"Saque efetuado com sucesso!" : "Saldo insuficiente!"));
		c2.visualizar();
		System.out.println("\nDepositar R$ 2.000,00 na conta c2");
		c2.depositar(2000.00f);
		c2.visualizar();
		
		ContaCorrente cc1 = new ContaCorrente (4, 789, 1, "Raquel", 3000.00F, 2000.00f);
		cc1.visualizar();
		System.out.println("\nSacar R$ 3.500,00 da conta cc1: " + (cc1.sacar(3500.00f) ? 
				"Saque efetuado com sucesso!" : "Saldo insuficiente!"));
		cc1.visualizar();
		System.out.println("\nSacar R$ 5.500,00 da conta cc1: " + (cc1.sacar(5500.00f) ? 
				"Saque efetuado com sucesso!" : "Saldo insuficiente!"));
		cc1.visualizar();
		
		System.out.println("\nDepositar R$ 2.000,00 na conta cc1");
		cc1.depositar(2000.00f);
		cc1.visualizar();
		
		ContaPoupanca cp1 = new ContaPoupanca (5, 790, 2, "Claudete", 3000.00F, 7);
		cp1.visualizar();
		
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
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BRIGHT + "Todas as contas cadastradas: ");
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
}
