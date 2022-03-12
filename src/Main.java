import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
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

		Bootcamp bootcamp = new Bootcamp();
		
		bootcamp.setNome("Bootcamp Java Developper");
		bootcamp.setDescricao("Descrição bootcamp java developper");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria1);
		bootcamp.getConteudos().add(mentoria2);
		
		Dev devCamila = new Dev();
		
		devCamila.setNome("Camila");
		
		System.out.println(devCamila.getConteudosInscritos());
		
		Dev devJoao = new Dev();
		
		devJoao.setNome("João");
		
		System.out.println(devJoao.getConteudosInscritos());
		
		devCamila.inscreverBootcamp(bootcamp);
		devJoao.inscreverBootcamp(bootcamp);
		
		System.out.println(devCamila.getConteudosInscritos());
		System.out.println(devJoao.getConteudosInscritos());
		
		System.out.println(devCamila.getConteudosConcluidos());
		System.out.println(devJoao.getConteudosConcluidos());
		
		/*
		 * devCamila.progredir(); devJoao.progredir();
		 */
		
		devCamila.progredir(100d);
		devJoao.progredir(90d);
		
		System.out.println(devCamila.getConteudosInscritos());
		System.out.println(devJoao.getConteudosInscritos());
		
		System.out.println(devCamila.getConteudosConcluidos());
		System.out.println(devJoao.getConteudosConcluidos());
		
		/*
		 * System.out.println(devCamila.calcularTotalXp());
		 * System.out.println(devJoao.calcularTotalXp());
		 * 
		 * devCamila.progredir();
		 * 
		 * System.out.println(devCamila.calcularTotalXp());
		 * System.out.println(devJoao.calcularTotalXp());
		 * 
		 * devJoao.progredir(); devJoao.progredir();
		 * 
		 * System.out.println(devCamila.calcularTotalXp());
		 * System.out.println(devJoao.calcularTotalXp());
		 */
		
		System.out.println(devCamila.getTotalXp());
		System.out.println(devJoao.getTotalXp());
		
		devCamila.progredir(90d);
		
		System.out.println(devCamila.getTotalXp());
		System.out.println(devJoao.getTotalXp());
		
		devJoao.progredir(80d);
		devJoao.progredir(70d);
		
		System.out.println(devCamila.getTotalXp());
		System.out.println(devJoao.getTotalXp());
		
		bootcamp.calcularRanking().forEach(System.out::println);
		
		devCamila.progredir(90d);
		devCamila.progredir(80d);
		
		bootcamp.calcularRanking().forEach(System.out::println);
	}

}
