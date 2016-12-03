package paginacao;

import java.util.LinkedList;

class LRU extends AlgoritmoDeSubstituicao {

	public LRU(int numeroDeQuadros) {
		super(numeroDeQuadros);
		// TODO Auto-generated constructor stub
		this.quadros = new LinkedList();

	}

	@Override
	public void inserir(String pageNumber) {
		// TODO Auto-generated method stub
		int tmp = quadros.indexOf(pageNumber);
		if (tmp == -1) {

			if (quadros.size() < numeroDeQuadros) {
				quadros.add(pageNumber);
			} else {

				quadros.remove(0);
				quadros.add(pageNumber);
			}
			numeroDeFalhas++;

		} else {
			quadros.remove(tmp);
			quadros.add(pageNumber);
		}
	}

}
