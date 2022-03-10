import java.time.LocalDate;

import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		Curso curso1 = new Curso();
		
		curso1.setTitulo("Curso java");
		curso1.setDescricao("Descrição curso java");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		
		curso2.setTitulo("Curso js");
		curso2.setDescricao("Descrição curso js");
		curso2.setCargaHoraria(4);

		System.out.println(curso1);
		System.out.println(curso2);
		
		Mentoria mentoria1 = new Mentoria();
		
		mentoria1.setTitulo("Mentoria de java");
		mentoria1.setDescricao("Descrição mentoria java");
		mentoria1.setData(LocalDate.now());
		
		Mentoria mentoria2 = new Mentoria();
		
		mentoria2.setTitulo("Mentoria de js");
		mentoria2.setDescricao("Descrição mentoria js");
		mentoria2.setData(LocalDate.now());

		System.out.println(mentoria1);
		System.out.println(mentoria2);

	}

}
