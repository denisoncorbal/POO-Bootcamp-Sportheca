package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	private String nome;
	
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<Conteudo>();
	
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<Conteudo>();	
	
	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	protected void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	protected Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	protected void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscritos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dev other = (Dev) obj;
		return Objects.equals(conteudosConcluidos, other.conteudosConcluidos)
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && Objects.equals(nome, other.nome);
	}

	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
	}
	
	public void progredir() {
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		
		if(conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());
			this.conteudosInscritos.remove(conteudo.get());
		}
		else {
			System.err.println("Você não está matriculado em nenhum conteúdo!");
		}
		
	}
	
	public Double calcularTotalXp() {
		return this.conteudosConcluidos.stream()
				.mapToDouble(Conteudo :: calcularXp)
				.sum();
	}
}
