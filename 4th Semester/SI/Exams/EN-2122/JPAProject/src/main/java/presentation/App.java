package presentation;

import java.util.List;
import java.util.Scanner;
import businessLayer.BLService;
import jakarta.persistence.*;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaex");
		EntityManager em = emf.createEntityManager();
		try  {
			BLService blService = new BLService(em);
			while (true) {
				displayOptions();
				readOption(blService);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void displayOptions() {
		System.out.println("1 - totalPontosJogador(idJogador)");
		System.out.println("2 - totalJogosJogador(idJogador)");
		System.out.println("3 - pontosJogoPorJogador(refJogo)");
		System.out.println("4 - totalPartidasJogador(idJogador)");
		System.out.println("5 - associarCracha(idJogador, refJogo, nomeCracha)");
		System.out.println("6 - associarCrachaLocal(idJogador, refJogo, nomeCracha)");
		System.out.println("7 - iniciarConversa(idJogador, nomeConversa)");
		System.out.println("8 - juntarConversa(idJogador, idConversa)");
		System.out.println("9 - enviarMensagem(idJogador, idConversa, mensagem)");
		System.out.println("10 - jogadorTotalInfo()");
		System.out.println("11 - aumentarPontosCrachaOtimista(nomeCracha, refJogo)");
		System.out.println("12 - aumentarPontosCrachaPessimista(nomeCracha, refJogo)");
		System.out.println("13 - criarJogador(username, email, região)");
		System.out.println("14 - mudarEstadoJogador(idJogador, estadoJogador)");
		System.out.println("\tPressione CTRL+C para sair...");
		System.out.print("> ");
	}

	private static void readOption(BLService blService) {
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
			case "1" -> displayTotalPontosJogador(blService, scanner);
			case "2" -> displayTotalJogosJogador(blService, scanner);
			case "3" -> displayPontosJogoPorJogador(blService, scanner);
			case "4" -> displayTotalPartidasJogador(blService, scanner);
			case "5" -> displayAssociarCracha(blService, scanner);
			case "6" -> displayAssociarCrachaLocal(blService, scanner);
			case "7" -> displayIniciarConversa(blService, scanner);
			case "8" -> displayJuntarConversa(blService, scanner);
			case "9" -> displayEnviarMensagem(blService, scanner);
			case "10" -> displayJogadorTotalInfo(blService);
			case "11" -> displayAumentarPontosCrachaOtimista(blService, scanner);
			case "12" -> displayAumentarPontosCrachaPessimista(blService, scanner);
			case "13" -> displayCriarJogador(blService, scanner);
			case "14" -> displayMudarEstadoJogador(blService, scanner);
			default -> System.out.println("Invalid option");
		}
		System.out.println("\n\tPressione ENTER para continuar...\n");
		scanner.nextLine();
	}

	private static void displayTotalPontosJogador(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("1 - totalPontosJogador(idJogador)");
		System.out.print("idJogador: ");
		String idJogadorString = scanner.nextLine();
		try {
			Integer idJogador = Integer.parseInt(idJogadorString);
			System.out.println("totalPontosJogador(" + idJogador + ") -> " + blService.totalPontosJogador(idJogador));
		} catch (NumberFormatException e) {
			System.out.println("Invalid idJogador");
			displayTotalPontosJogador(blService, scanner);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayTotalJogosJogador(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("2 - totalJogosJogador(idJogador)");
		System.out.print("idJogador: ");
		String idJogadorString = scanner.nextLine();
		try {
			Integer idJogador = Integer.parseInt(idJogadorString);
			System.out.println("totalJogosJogador(" + idJogador + ") -> " + blService.totalJogosJogador(idJogador));
		} catch (NumberFormatException e) {
			System.out.println("Invalid idJogador");
			displayTotalJogosJogador(blService, scanner);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayPontosJogoPorJogador(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("3 - pontosJogoPorJogador(refJogo)");
		System.out.print("refJogo: ");
		String refJogo = scanner.nextLine();
		try {
			List<Object[]> pontosJogoPorJogadorResult = blService.pontosJogoPorJogador(refJogo);
			System.out.printf("%-10s | %-7s\n", "idJogador", "totalPontos");
			for (Object[] o : pontosJogoPorJogadorResult) {
				System.out.printf("%-10s | %-7s\n", o[0], o[1]);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayTotalPartidasJogador(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("4 - totalPartidasJogador(idJogador)");
		System.out.print("idJogador: ");
		String idJogadorString = scanner.nextLine();
		try {
			Integer idJogador = Integer.parseInt(idJogadorString);
			System.out.println("totalPartidasJogador(" + idJogador + ") -> " + blService.totalPartidasJogador(idJogador));
		} catch (NumberFormatException e) {
			System.out.println("Invalid idJogador");
			displayTotalPartidasJogador(blService, scanner);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayAssociarCracha(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("5 - associarCracha(idJogador, refJogo, nomeCracha)");
		System.out.print("idJogador: ");
		String idJogadorString = scanner.nextLine();
		try {
			Integer idJogador = Integer.parseInt(idJogadorString);
			System.out.print("refJogo: ");
			String refJogo = scanner.nextLine();
			System.out.print("idCracha: ");
			String idCracha = scanner.nextLine();
			blService.associarCracha(idJogador, refJogo, idCracha);
			System.out.println("associarCracha(" + idJogador + ", " + refJogo + ", " + idCracha + ") -> OK");
		} catch (NumberFormatException e) {
			System.out.println("Invalid idJogador");
			displayAssociarCracha(blService, scanner);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayAssociarCrachaLocal(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("6 - associarCrachaLocal(idJogador, refJogo, nomeCracha)");
		System.out.print("idJogador: ");
		String idJogadorString = scanner.nextLine();
		try {
			Integer idJogador = Integer.parseInt(idJogadorString);
			System.out.print("refJogo: ");
			String refJogo = scanner.nextLine();
			System.out.print("idCracha: ");
			String idCracha = scanner.nextLine();
			blService.associarCrachaLocal(idJogador, refJogo, idCracha);
			System.out.println("associarCrachaLocal(" + idJogador + ", " + refJogo + ", " + idCracha + ") -> OK");
		} catch (NumberFormatException e) {
			System.out.println("Invalid idJogador");
			displayAssociarCrachaLocal(blService, scanner);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayIniciarConversa(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("7 - iniciarConversa(idJogador, nomeConversa)");
		System.out.print("idJogador: ");
		String idJogadorString = scanner.nextLine();
		try {
			Integer idJogador = Integer.parseInt(idJogadorString);
			System.out.print("nomeConversa: ");
			String nomeConversa = scanner.nextLine();
			Integer idConversa = blService.iniciarConversa(idJogador, nomeConversa);
			System.out.println("iniciarConversa(" + idJogador + ", " + nomeConversa + ") -> " + idConversa);
		} catch (NumberFormatException e) {
			System.out.println("Invalid idJogador");
			displayIniciarConversa(blService, scanner);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayJuntarConversa(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("8 - juntarConversa(idJogador, idConversa)");
		System.out.print("idJogador: ");
		String idJogadorString = scanner.nextLine();
		try {
			Integer idJogador = Integer.parseInt(idJogadorString);
			System.out.print("idConversa: ");
			try {
				String idConversaString = scanner.nextLine();
				Integer idConversa = Integer.parseInt(idConversaString);
				blService.juntarConversa(idJogador, idConversa);
				System.out.println("juntarConversa(" + idJogador + ", " + idConversa + ") -> OK");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid idJogador");
			displayJuntarConversa(blService, scanner);
		}
	}

	private static void displayEnviarMensagem(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("9 - enviarMensagem(idJogador, idConversa, mensagem)");
		System.out.print("idJogador: ");
		String idJogadorString = scanner.nextLine();
		try {
			Integer idJogador = Integer.parseInt(idJogadorString);
			System.out.print("idConversa: ");
			try {
				String idConversaString = scanner.nextLine();
				Integer idConversa = Integer.parseInt(idConversaString);
				System.out.print("mensagem: ");
				String mensagem = scanner.nextLine();
				blService.enviarMensagem(idJogador, idConversa, mensagem);
				System.out.println("enviarMensagem(" + idJogador + ", " + idConversa + ", " + mensagem + ") -> OK");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid idJogador");
			displayEnviarMensagem(blService, scanner);
		}
	}

	private static void displayJogadorTotalInfo(BLService blService) {
		System.out.println();
		System.out.println("10 - jogadorTotalInfo()");

		try {
			List<Object[]> jogadorTotalInfo = blService.jogadorTotalInfo();
			System.out.printf("%-10s | %-7s | %-20s | %-9s | %-10s | %-12s | %-13s\n",
					"idJogador", "estado", "email", "username", "totalJogos", "totalPontos", "totalPartidas");

			for (Object[] o : jogadorTotalInfo) {
				System.out.printf("%-10s | %-7s | %-20s | %-9s | %-10s | %-12s | %-13s\n",
						o[0], o[1], o[2], o[3], o[4], o[5], o[6]);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayAumentarPontosCrachaOtimista(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("11 - aumentarPontosCrachaOtimista(nomeCracha, refJogo)");
		try {
			System.out.print("nomeCracha: ");
			String nomeCracha = scanner.nextLine();
			System.out.print("refJogo: ");
			String refJogo = scanner.nextLine();
			Integer novoLimitePontos = blService.aumentarPontosCrachaOtimista(nomeCracha, refJogo);
			System.out.println("aumentarPontosCrachaOtimista(" + nomeCracha + ", " + refJogo + ") -> "
					+ novoLimitePontos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayAumentarPontosCrachaPessimista(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("12 - aumentarPontosCrachaPessimista(nomeCracha, refJogo)");
		try {
			System.out.print("nomeCracha: ");
			String nomeCracha = scanner.nextLine();
			System.out.print("refJogo: ");
			String refJogo = scanner.nextLine();
			Integer novoLimitePontos = blService.aumentarPontosCrachaPessimista(nomeCracha, refJogo);
			System.out.println("aumentarPontosCrachaPessimista(" + nomeCracha + ", " + refJogo + ") -> "
					+ novoLimitePontos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayCriarJogador(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("13 - criarJogador(username, email, região)");
		try {
			System.out.print("username: ");
			String username = scanner.nextLine();
			System.out.print("email: ");
			String email = scanner.nextLine();
			System.out.print("região: ");
			String regiao = scanner.nextLine();
			Integer idJogador = blService.criarJogador(username, email, regiao);
			System.out.println("criarJogador(" + username + ", " + email + ", " + regiao + ") -> " + idJogador);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayMudarEstadoJogador(BLService blService, Scanner scanner) {
		System.out.println();
		System.out.println("14 - mudarEstadoJogador(idJogador, estadoJogador)");
		System.out.print("idJogador: ");
		String idJogadorString = scanner.nextLine();
		try {
			Integer idJogador = Integer.parseInt(idJogadorString);
			System.out.print("estadoJogador: ");
			String estadoJogador = scanner.nextLine();
			blService.mudarEstadoJogador(idJogador, estadoJogador);
			System.out.println("mudarEstadoJogador(" + idJogador + ", " + estadoJogador + ") -> OK");
		} catch (NumberFormatException e) {
			System.out.println("Invalid idJogador");
			displayMudarEstadoJogador(blService, scanner);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}