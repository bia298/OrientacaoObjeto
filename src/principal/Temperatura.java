package principal;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Temperatura {
	static Double[][] averageTemp = new Double[9][12];
	static Double[][] minTemperature = new Double[9][12];
	static Double[][] maxTemperature = new Double[9][12];
	static Double[][][] dados = new Double[10][12][31];

	public static void main(String[] args) {

		// Temperatura para o mês de janeiro/2020 em Brasília obtidas do site do INMET
		Temperatura.dados[9][0][0] = 21.2;
		Temperatura.dados[9][0][1] = 21.9;
		Temperatura.dados[9][0][2] = 21.4;
		Temperatura.dados[9][0][3] = 19.1;
		Temperatura.dados[9][0][4] = 20.9;
		Temperatura.dados[9][0][5] = 22.2;
		Temperatura.dados[9][0][6] = 22.4;
		Temperatura.dados[9][0][7] = 21.2;
		Temperatura.dados[9][0][8] = 22.9;
		Temperatura.dados[9][0][9] = 22.9;
		Temperatura.dados[9][0][10] = 24.5;
		Temperatura.dados[9][0][11] = 24.1;
		Temperatura.dados[9][0][12] = 24.5;
		Temperatura.dados[9][0][13] = 25.5;
		Temperatura.dados[9][0][14] = 25.0;
		Temperatura.dados[9][0][15] = 25.5;
		Temperatura.dados[9][0][16] = 23.9;
		Temperatura.dados[9][0][17] = 21.7;
		Temperatura.dados[9][0][18] = 23.8;
		Temperatura.dados[9][0][19] = 23.3;
		Temperatura.dados[9][0][20] = 21.9;
		Temperatura.dados[9][0][21] = 20.4;
		Temperatura.dados[9][0][22] = 20.5;
		Temperatura.dados[9][0][23] = 20.1;
		Temperatura.dados[9][0][24] = 20.0;
		Temperatura.dados[9][0][25] = 20.2;
		Temperatura.dados[9][0][26] = 20.9;
		Temperatura.dados[9][0][27] = 20.8;
		Temperatura.dados[9][0][28] = 22.3;
		Temperatura.dados[9][0][29] = 22.9;
		Temperatura.dados[9][0][30] = 24.1;

		mainMenu();

	}

	public static int mainMenu() {

		int option;
		int[] data = new int[31];
		Scanner ler = new Scanner(System.in);

		do {
			System.out.print("Informe o número correspondente a opção desejada \n");
			System.out.print("Digite 1 para entrar dados de temperatura \n");
			System.out.print("Digite 2 para obter temperatura média \n");
			System.out.print("Digite 3 para obter temperatura mínima \n");
			System.out.print("Digite 4 para obter temperatura máxima \n");
			System.out.print("Digite 5 para obter relatório meteorológico \n");

			option = ler.nextInt();

			switch (option) {
			case 1:

				data[0] = 0;
				data[1] = 0;
				data = readDate();
				inTemperature(data);
				break;
			case 2:
				data[0] = 0;
				data[1] = 0;
				data = readDate();
				avgTemperature(data);
				break;
			case 3:
				data[0] = 0;
				data[1] = 0;
				data = readDate();
				minTemperature(data);
				break;
			case 4:
				data[0] = 0;
				data[1] = 0;
				data = readDate();
				maxTemperature(data);
				break;
			case 5:
				data[0] = 0;
				data[1] = 0;

				data = readDate();
				metReport(data);
				break;
			default:
				System.out.println("Ops!Opção escolhida não é válida!\n");
				break;
			}
		} while (option != 6);
		return 0;
	}

	public static final Scanner ler = new Scanner(System.in);

// Leitura da data desejada pelo usuário
	static // Entrada dos meses

	int[] readDate() {
		int month;
		int year;
		int[] data = new int[2];
		Scanner ler = new Scanner(System.in);
		System.out.print("Informe o mês desejado (entre 1 e 12): \n");
		month = ler.nextInt();
		while (month != 1 && month != 2 && month != 3 && month != 4 && month != 5 && month != 6 && month != 7
				&& month != 8 && month != 9 && month != 10 && month != 11 && month != 12) {
			System.out.print("Desculpe! Mês informado é invalido, digite um valor entre 1 e 12:\n");
			month = ler.nextInt();
		}
		System.out.print("Informe o ano desejado (entre 2011-2020): \n");
		year = ler.nextInt();
		while (year != 2011 && year != 2012 && year != 2013 && year != 2014 && year != 2015 && year != 2016
				&& year != 2017 && year != 2018 && year != 2019 && year != 2020) {
			System.out.print("Desculpe!Ano informado é invalido, digite um valor entre 2011 e 2020:\n");
			year = ler.nextInt();
		}

		data[0] = month - 1;
		data[1] = year - 2011;

		return data;
	}

// Entrada das Temperaturas

	public static Double[][][] inTemperature(int[] data) {

		Double[][][] dados = new Double[9][12][31];
		int i = 0;
		int year;
		int month;
		double[] temperature = new double[31];

		month = data[0];
		year = data[1];
		int ano = year + 2011;

		if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {
			for (i = 1; i <= 31; i++) {
				System.out.print("Informe a temperatura média do dia " + i + "\n:");
				temperature[i] = ler.nextInt();
			}
		}
		if (month == 3 || month == 5 || month == 8 || month == 10) {
			for (i = 1; i <= 30; i++) {
				System.out.print("Informe a temperatura média do dia " + i + "\n:");
				temperature[i] = ler.nextInt();
			}
		} else if (month == 1) {
			if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
				for (i = 1; i <= 29; i++) {
					System.out.print("Informe a temperatura média do dia " + i + "\n:");
					temperature[i] = ler.nextInt();
				}
			} else {
				for (i = 1; i <= 29; i++) {
					System.out.print("Informe a temperatura média do dia " + i + "\n:");
					temperature[i] = ler.nextInt();
				}
			}
		}

		for (int a = 1; a <= i; a++) {
			Temperatura.dados[a][month][year] = temperature[a];

		}

		return dados;

	}

// Cálculo da temperatura média

	static double avgTemperature(int[] data) {

		int year;
		int month;
		int numDay = 0;
		int i = 0;
		double sum = 0;
		double[][] avgTemp = new double[12][31];
		Double[][][] dados = new Double[9][12][31];
		dados = Temperatura.dados;
		Double[] temperature = new Double[31];

		month = data[0];
		year = data[1];
		int ano = year + 2011;

		if (dados[year][month][0] != null) {
			if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {
				for (i = 0; i <= 30; i++) {
					temperature[i] = dados[year][month][i];
					sum = sum + temperature[i];
					numDay = 31;

				}
			}

			if (month == 3 || month == 5 || month == 8 || month == 10) {
				for (i = 0; i <= 29; i++) {
					temperature[i] = dados[year][month][i];
					sum = sum + temperature[i];
					numDay = 30;
					;
				}

			} else if (month == 1) {
				if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
					for (i = 0; i <= 28; i++) {
						temperature[i] = dados[year][month][i];
						sum = sum + temperature[i];
						numDay = 29;
					}
				} else {
					for (i = 0; i <= 27; i++) {
						temperature[i] = dados[year][month][i];
						sum = sum + temperature[i];
						numDay = 28;
					}
				}
			}
			avgTemp[month][year] = sum / numDay;
			double media = sum / numDay;
			System.out.print("A temperatura média foi de ");
			System.out.printf("%.2f", media);
			System.out.print("°C");
			// Temperatura.averageTemp[month][year] = avgTemp[month][year];
		} else {
			System.out.print(
					"Não existem dados disponíveis para esse mês/ano. Para proceder digite 1 no menu principal. \n");

		}

		return 0;
	}

//Cálculo da temperatura mínima de um determinado período

	static double minTemperature(int[] date) {

		Double[] temperature = new Double[31];
		double minimumTemperature;
		int i;
		int month;
		int year;
		Double[][][] dados = new Double[9][12][31];
		dados = Temperatura.dados;
		// a é um contador do número de vezes que um valor apareceu no array do mês
		int a = 1;

		month = date[0];
		year = date[1];
		int ano = year + 2011;
		ArrayList<Integer> datas = new ArrayList<Integer>();

		// Arrumar a inicialização aqui

		if (dados[year][month][0] != null) {
			temperature[0] = dados[year][month][0];
			minimumTemperature = temperature[0];

			if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {

				for (i = 1; i <= 30; i++) {
					temperature[i] = dados[year][month][i];
					if (minimumTemperature > temperature[i]) {
						minimumTemperature = temperature[i];
						datas.clear();
						a = i + 1;
						datas.add(a);

					} else if (minimumTemperature == temperature[i]) {
						a = i + 1;
						datas.add(a);
					}
				}
			}

			if (month == 3 || month == 5 || month == 8 || month == 10) {
				for (i = 1; i <= 29; i++) {
					temperature[i] = dados[year][month][i];
					if (minimumTemperature > temperature[i]) {
						minimumTemperature = temperature[i];
						datas.clear();
						a = i + 1;
						datas.add(a);

					} else if (minimumTemperature == temperature[i]) {
						a = i + 1;
						datas.add(a);
					}
				}
			} else if (month == 1) {
				if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
					for (i = 1; i <= 28; i++) {
						temperature[i] = dados[year][month][i];
						if (minimumTemperature > temperature[i]) {
							minimumTemperature = temperature[i];
							datas.clear();
							a = i + 1;
							datas.add(a);

						} else if (minimumTemperature == temperature[i]) {
							a = i + 1;
							datas.add(a);
						}
					}
				} else {
					for (i = 1; i <= 27; i++) {
						temperature[i] = dados[year][month][i];
						if (minimumTemperature > temperature[i]) {
							minimumTemperature = temperature[i];
							datas.clear();
							a = i + 1;
							datas.add(a);

						} else if (minimumTemperature == temperature[i]) {
							a = i + 1;
							datas.add(a);
						}
					}
				}
			}

			System.out.print("A temperatura mínima foi de " + minimumTemperature + "°C no(s) dia(s) ");
			for (int cont = 0; cont < datas.size(); cont++) {
				System.out.print(datas.get(cont) + " ");
			}
		} else {
			System.out.print(
					"Não existem dados disponíveis para esse mês/ano. Para proceder digite 1 no menu principal. \n");
		}

		return 0;
	}

//Cálculo da temperatura máxima de um determinado período

	static double maxTemperature(int[] date) {

		Double[] temperature = new Double[31];
		double maximumTemperature;
		int i;
		int month;
		int year;
		Double[][][] dados = new Double[9][12][31];
		dados = Temperatura.dados;
		int a = 1;

		month = date[0];
		year = date[1];
		int ano = year + 2011;
		ArrayList<Integer> datas = new ArrayList<Integer>();
		if (dados[year][month][0] != null) {
			// Arrumar a inicialização aqui
			temperature[0] = dados[year][month][0];
			maximumTemperature = temperature[0];

			if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {
				for (i = 1; i <= 30; i++) {
					temperature[i] = dados[year][month][i];
					if (temperature[i] > maximumTemperature) {
						maximumTemperature = temperature[i];
						datas.clear();
						a = i + 1;
						datas.add(a);

					} else if (maximumTemperature == temperature[i]) {
						a = i + 1;
						datas.add(a);
					}
				}
			}

			if (month == 3 || month == 5 || month == 8 || month == 10) {
				for (i = 1; i <= 29; i++) {
					temperature[i] = dados[year][month][i];
					if (temperature[i] > maximumTemperature) {
						maximumTemperature = temperature[i];
						datas.clear();
						a = i + 1;
						datas.add(a);

					} else if (maximumTemperature == temperature[i]) {
						a = i + 1;
						datas.add(a);
					}
				}
			} else if (month == 1) {
				if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
					for (i = 1; i <= 28; i++) {
						temperature[i] = dados[year][month][i];
						if (temperature[i] > maximumTemperature) {
							maximumTemperature = temperature[i];
							datas.clear();
							a = i + 1;
							datas.add(a);

						} else if (maximumTemperature == temperature[i]) {
							a = i + 1;
							datas.add(a);
						}
					}
				} else {
					for (i = 1; i <= 27; i++) {
						temperature[i] = dados[year][month][i];
						if (temperature[i] > maximumTemperature) {
							maximumTemperature = temperature[i];
							datas.clear();
							a = i + 1;
							datas.add(a);

						} else if (maximumTemperature == temperature[i]) {
							a = i + 1;
							datas.add(a);
						}
					}
				}
			}

			System.out.print("A temperatura mínima foi de " + maximumTemperature + "°C no(s) dia(s) ");
			for (int cont = 0; cont < datas.size(); cont++) {
				System.out.print(datas.get(cont) + " ");
			}
		}
		else {System.out.print("Não existem dados disponíveis para esse mês/ano. Para proceder digite 1 no menu principal. \n");}
		return 0;
	}

//Relatório Metereológico

	static double metReport(int[] date) {

		int month;
		int year;
		int ano;
		int cont;
		month = date[0];
		year = date[1];
		int mes = month + 1;
		ano = year + 2011;
		int dia;
		Double[][][] dados = new Double[9][12][31];
		dados = Temperatura.dados;
		if (dados[year][month][0] != null) {
			
		System.out.print("Relatório de Temperaturas de " + mes + "/" + ano + "\n");

		avgTemperature(date);
		System.out.print(" \n");
		minTemperature(date);
		System.out.print(" \n");
		maxTemperature(date);
		System.out.print(" \n");

		// Data Válida
		if (month == 0 || month == 2 || month == 4 || month == 6 || month == 7 || month == 9 || month == 11) {
			for (cont = 0; cont <= 30; cont++) {
				dia = cont + 1;
				System.out.print("Dia " + dia + ": " + Temperatura.dados[year][month][cont] + "°C \n");
			}
		}

		else if (month == 3 || month == 5 || month == 8 || month == 10) {
			for (cont = 0; cont <= 29; cont++) {
				dia = cont + 1;
				System.out.print("Dia " + dia + ": " + Temperatura.dados[year][month][cont] + "°C \n");
			}
		} else if (month == 1) {
			if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
				for (cont = 0; cont <= 28; cont++) {
					dia = cont + 1;
					System.out.print("Dia " + dia + ": " + Temperatura.dados[year][month][cont] + "°C \n");
				}

			} else {
				for (cont = 0; cont <= 29; cont++) {
					dia = cont + 1;
					System.out.print("Dia " + dia + ": " + Temperatura.dados[year][month][cont] + "°C \n");
				}

			}

		}}
		else {System.out.print("Não existem dados disponíveis para esse mês/ano. Para proceder digite 1 no menu principal. \n");}

		return 0;
	}
}