

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	private List<Pessoa> lst;
	private Scanner s;

	public App() {
		lst = new ArrayList<>();
		s = new Scanner(System.in);
	}

	public void cadastraPessoa() {
		System.out.println("Entre os dados da pessoa");
		System.out.println("Nome e sobrenome");
		System.out.print("->");
		String nome = s.nextLine();
		if (nome.isEmpty() || !nome.contains(" ")) {
			System.out.println("Nome invalido!!");
			System.out.println("Não cadastrado!!");
			return;
		}
		System.out.println("Masculino? (S/N)");
		String strSexo = s.nextLine();
		boolean sexo = true;
		if (strSexo.toLowerCase().equals("n")) {
			sexo = false;
		}
		Pessoa p = new Pessoa(nome, sexo);
		lst.add(p);
	}

	public void exibeRelatorios() {
		System.out.println("Relatorios:");
		System.out.println("<1> Todos");
		System.out.println("<2> Homens");
		System.out.println("<3> Mulheres");
		System.out.println("<4> Retorna");

		String op = s.nextLine();

		switch (op) {
		case "1":
			for (Pessoa p : lst) {
				System.out.println(p);
			}
			break;
		case "2":
			for (Pessoa p : lst) {
				if (p.getSexo() == 'M') {
					System.out.println(p);
				}
			}
			break;
		case "3":
			for (Pessoa p : lst) {
				if (p.getSexo() == 'F') {
					System.out.println(p);
				}
			}
			break;
		default:
			return;
		}
	}

	public static void main(String[] args) {
		App ap = new App();

		while (true) {
			System.out.println("");
			System.out.println("Opcoes:");
			System.out.println("<1> Cadastra Pessoa");
			System.out.println("<2> Relatorios");
			System.out.println("<3> Fim");

			String op = ap.s.nextLine();

			switch (op) {
			case "1":
				ap.cadastraPessoa();
				break;
			case "2":
				ap.exibeRelatorios();
				break;
			case "3":
				System.out.println("Fim");
				return;
			default:
				System.out.println("Opcao invalida! Tente novamente");
			}
		}
	}
}
