package paginacao;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		System.out.println("Informe aqui");
		Scanner scanner = new Scanner(System.in);
		String referencia = scanner.nextLine();
		String[] stringReferencia = referencia.split(";");

		// FIFO
		AlgoritmoDeSubstituicao fifo = new FIFO(3);

		for (int i = 0; i < (stringReferencia.length - 1); i++) {
			fifo.inserir(stringReferencia[i]);

		}
		System.out.println("Page Faults: " + fifo.getPageFaultCount());

		// LRU
		AlgoritmoDeSubstituicao lru = new LRU(3);

		for (int i = 0; i < (stringReferencia.length - 1); i++) {
			lru.inserir(stringReferencia[i]);

		}
		System.out.println("Page Faults: " + lru.getPageFaultCount());
	}

}