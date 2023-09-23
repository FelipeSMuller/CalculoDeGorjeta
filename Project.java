package CalculadoraDeGorjetas;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Project {

	public static void main(String[] args) {

		double reverse, reverse2, valorFinal;

		String valorFormatado, valorFormatado2;

		String escolha = null;

		String[] refeicoes = { "Macarrão", "Carne", "Feijoada", "Arroz", "Sopa", "Pizza", "Pão", "Bolo" };

		for (int i = 0; i < refeicoes.length; i++) {

			refeicoes[i] = refeicoes[i].toUpperCase();
		}

		Double valorCompra = null;

		Double valorGorjeta = null;

		while (true) {

			try {

				escolha = JOptionPane.showInputDialog(null, "Escolha sua refeição ");

				escolha = escolha.toUpperCase();

				valorCompra = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da sua compra"));

				valorGorjeta = Double.parseDouble(
						JOptionPane.showInputDialog(null, "Digite em porcentagem a quantidade da sua gorjeta"));

				if (valorCompra <= 0 || valorGorjeta <= 0 || escolha == null || valorGorjeta > 100) {

					JOptionPane.showMessageDialog(null,
							"Você inseriu valores inválidos ou não inseriu nenhuma informação ");
					break;
				}

			} catch (NumberFormatException | NullPointerException e) {

				JOptionPane.showMessageDialog(null,
						" Você não preencheu com dados válidos, ou saiu do programa de maneira incorreta");

				break;

			}

			for (int i = 0; i < refeicoes.length; i++) {

				if (refeicoes[i].contains(escolha)) {

					JOptionPane.showMessageDialog(null,
							" A refeição que você escolheu existe em nosso cardápio, aguarde um momento enquanto estamos preparando...");

					DecimalFormat df = new DecimalFormat("R$ ##,##");

					DecimalFormat Df = new DecimalFormat("##,##%");

					valorFormatado = df.format(valorCompra);

					valorFormatado2 = Df.format(valorGorjeta);

					JOptionPane.showMessageDialog(null, "Prato Escolhido = " + escolha + " \nValor Da Compra = "
							+ valorFormatado + " \nPorcentagem De Gorjeta = " + valorFormatado2);

					valorFormatado = valorFormatado.replace("R$ ", "").replace(",", "");

					reverse = Double.parseDouble(valorFormatado);

					valorFormatado2 = valorFormatado2.replace("%", "").replace("", "");

					reverse2 = Double.parseDouble(valorFormatado2) / 100.0;

					valorFinal = (reverse * reverse2) + reverse;

					JOptionPane.showMessageDialog(null, "Preço Inicial = " + " R$" + valorFormatado
							+ " \nPreço Final com Acréscimo = " + " R$" + valorFinal);

				}

			}

		}

	}

}
