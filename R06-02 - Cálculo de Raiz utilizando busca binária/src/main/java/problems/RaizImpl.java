package problems;

/**
 * Classe com metodos para calcular raiz n-esima de um numero com aproximacao
 * e para encontrar os limites que dividem um array em 3 partes de mesmo tamanho
 * 
 * @author adalbertocajueiro
 *
 */
public class RaizImpl implements Raiz {

	public double raiz(int numero, int raiz, double erro) {
		return raiz(numero, raiz, erro, 0, numero);
	}

	private double raiz(int numero, int raiz, double erro, int left, int right) {
		int middle = (left+right)/2;
		double estimativa = recursivePow(middle, raiz);
		double diferença = abs(estimativa-numero);
		if (diferença < erro) {
			return middle;
		}
		else if (estimativa > numero) {
			return raiz(numero, raiz, erro, left, middle);
		}
		else {
			return raiz(numero, raiz, erro, middle, right);
		}
	}

	private double recursivePow(int base, int raiz) {
		double resultado = 0;
		if (raiz == 0) {
			return 1.0;
		} else {
			resultado = base * recursivePow(base, raiz - 1);
		}
		return resultado;
	}

	private double abs(double num) {
		double resultado = num;
		if (num < 0) {
			resultado = (-1) * num;
		}
		return resultado;
	}
public static void main(String[] args) {
	RaizImpl teste = new RaizImpl();
	System.out.println(teste.raiz(16, 4, 0.1)); 
}
}