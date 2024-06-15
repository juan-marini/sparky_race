import java.util.Scanner;
import java.text.DecimalFormat;

public class RoboRace {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		String direcao; // direcao contendo a direcao escolhida pelo usuario
		String direcao_correta = "";
		short progresso = 1; // progresso do usuario ao decorrer do labirinto
		short distancia; // quantidade de movimentos escolhida pelo usuario
		short distancia_necessaria = 0; // quantia de movimentos para atravessar um corredor do labirinto
		short distancia_total = 32;
		short consumo_energetico = 5;
		int potencia = 240;

		System.out.println("Bem vindo(a) ao SparkyRace, tente completar o percurso usando nosso robo!");

		System.out.println("□ " + "□ " + "□ " + "□ " + "□ " + "□ ");
		System.out.println("□ " + "  " + "  " + "  " + "  " + "□ ");
		System.out.println("□ " + "  " + "  " + "  " + "  " + "□ ");
		System.out.println("□ " + "  " + "  " + "  " + "  " + "  ");
		System.out.println("□ " + "□ " + "□ " + "□ " + "□ " + "□ ");
		System.out.println("  " + "  " + "  " + "  " + "  " + "□ ");
		System.out.println("  " + "  " + "  " + "  " + "  " + "□ ");
		System.out.println("↓ " + "  " + "  " + "  " + "  " + "□ ");
		System.out.println("□" + "  " + "  " + "  " + "  " + " □");
		System.out.println("□" + "  " + "  " + "  " + "  " + " □");
		System.out.println("□ " + "□ " + "□ " + "□ " + "□ " + "□ ");

		System.out.println("\nSparky possui " + potencia + "w de bateria e cada passo que ele da consome "
				+ consumo_energetico + "w.");

		System.out.println("Os comandos de direção são: CIMA, BAIXO, DIREITA, ESQUERDA (maiúsculo ou minúsculo)."
				+ "Note que a visão do mapa é panorâmica, e não do ponto de vista do robô.");

		System.out.println("Só é possível avancar um número de passos maior que 0");

		do {

			switch (progresso) {
			case 1:
				distancia_necessaria = 3;
				direcao_correta = "baixo";
				break;
			case 2:
				distancia_necessaria = 5;
				direcao_correta = "direita";
				break;
			case 3:
				distancia_necessaria = 6;
				direcao_correta = "cima";
				break;
			case 4:
				distancia_necessaria = 5;
				direcao_correta = "esquerda";
				break;
			case 5:
				distancia_necessaria = 4;
				direcao_correta = "cima";
				break;
			case 6:
				distancia_necessaria = 5;
				direcao_correta = "direita";
				break;
			case 7:
				distancia_necessaria = 2;
				direcao_correta = "baixo";
				break;
			}

		
			do {
				System.out.println("Qual a direção?");
				direcao = entrada.next();
				System.err.println(!direcao.equalsIgnoreCase(direcao_correta)? "Direção Incorreta, tente novamente" : "");
			} while (!direcao.equalsIgnoreCase(direcao_correta));
			do {
				System.out.println("Qual a distância?");
				distancia = entrada.nextShort();
				if (distancia <= 0)
					System.err.println("Número de passos inválido, tente novamente.");
				else {

					if (distancia >= distancia_necessaria) {
						System.out.println("Caminho certo, continue assim!");
						potencia -= distancia_necessaria * consumo_energetico;
						distancia_necessaria = 0;
						progresso++;
					} else {
						potencia -= distancia * consumo_energetico;
						distancia_necessaria -= distancia;
						System.out.println("Passos insuficiente! Faltam " + distancia_necessaria + " passos");
					}
					double bateria = (double) potencia * 100 / 240;
					System.out.println("Bateria Atual:" + (bateria < 0 ? 0 : df.format(bateria)) + "%");
				}
			} while (distancia_necessaria >= 1 && potencia > 0);

		} while (potencia > 0 && progresso <= 7);

		System.out.println(progresso == 8 ? "Parabéns você completou o Sparky Race!!" : "A bateria acabou, recarregue o robo");

		entrada.close();

	}
}
