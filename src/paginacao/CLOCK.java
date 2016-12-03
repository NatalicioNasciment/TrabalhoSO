package paginacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLOCK {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferLeitura = new BufferedReader(new InputStreamReader(System.in));
		int quadros, ponteiro = 0, acerto = 0, falha = 0, ref_len;
		int buffer[][];
		int referencia[];
		int mem_layout[][];
		int used_layout[][];

		System.out.println("Informe o numero de quadro de paginas:  ");
		quadros = Integer.parseInt(bufferLeitura.readLine());

		System.out.println("Insira o tamanho da sequencia ");
		ref_len = Integer.parseInt(bufferLeitura.readLine());

		referencia = new int[ref_len];
		mem_layout = new int[ref_len][quadros];
		used_layout = new int[ref_len][quadros];
		buffer = new int[quadros][2];
		for (int j = 0; j < quadros; j++) {
			buffer[j][0] = -1;
			buffer[j][1] = 0;
		}
		System.out.println("Informe os valores ");
		for (int i = 0; i < ref_len; i++) {
			referencia[i] = Integer.parseInt(bufferLeitura.readLine());
		}
		System.out.println();
		for (int i = 0; i < ref_len; i++) {
			int search = -1;
			for (int j = 0; j < quadros; j++) {
				if (buffer[j][0] == referencia[i]) {
					search = j;
					acerto++;
					buffer[j][1] = 1;
					break;
				}
			}
			if (search == -1) {

				while (buffer[ponteiro][1] == 1) {
					buffer[ponteiro][1] = 0;
					ponteiro++;
					if (ponteiro == quadros)
						ponteiro = 0;
				}
				buffer[ponteiro][0] = referencia[i];
				buffer[ponteiro][1] = 1;
				falha++;
				ponteiro++;
				if (ponteiro == quadros)
					ponteiro = 0;
			}
			for (int j = 0; j < quadros; j++) {
				mem_layout[i][j] = buffer[j][0];
				used_layout[i][j] = buffer[j][1];
			}
		}

		for (int i = 0; i < quadros; i++) {
			for (int j = 0; j < ref_len; j++)
				System.out.printf("%3d %d ", mem_layout[j][i], used_layout[j][i]);
			System.out.println();
		}

		System.out.println("O numero de acertos: " + acerto);
		System.out.println("Taxa de acerto: " + (float) ((float) acerto / ref_len));
		System.out.println("O numero de falhas " + falha);
	}

}