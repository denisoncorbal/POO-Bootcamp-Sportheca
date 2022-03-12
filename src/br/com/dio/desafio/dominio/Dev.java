package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
	private String nome;
	
	private Set<Conteudo> conteudosInscritos = new LinkedHashSet<Conteudo>();
	
	private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<Conteudo>();	
	
	private Double totalXp = 0d;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Conteudo> getConteudosInscritos() {
		return conteudosInscritos;
	}

	public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
		this.conteudosInscritos = conteudosInscritos;
	}

	public Set<Conteudo> getConteudosConcluidos() {
		return conteudosConcluidos;
	}

	public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
		this.conteudosConcluidos = conteudosConcluidos;
	}
	
	public void setTotalXp(Double xp) {
		this.totalXp = xp;
	}
	
	public Double getTotalXp() {
		return this.totalXp;
	}	

	@Override
	public String toString() {
		return "Dev [nome=" + nome + ", conteudosInscritos=" + conteudosInscritos + ", conteudosConcluidos="
				+ conteudosConcluidos + ", totalXp=" + totalXp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudosConcluidos, conteudosInscritos, nome, totalXp);
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
				&& Objects.equals(conteudosInscritos, other.conteudosInscritos) && Objects.equals(nome, other.nome)
				&& Objects.equals(totalXp, other.totalXp);
	}

	public void inscreverBootcamp(Bootcamp bootcamp) {
		this.conteudosInscritos.addAll(bootcamp.getConteudos());
		bootcamp.getDevsInscritos().add(this);
	}
	
	@Deprecated
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
	
	public void progredir(Double nota) {
		Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
		
		if(conteudo.isPresent()) {
			this.conteudosConcluidos.add(conteudo.get());			
			this.conteudosInscritos.remove(conteudo.get());
			this.setTotalXp(this.totalXp + conteudo.get().calcularXp(nota));
		}
		else {
			System.err.println("Você não está matriculado em nenhum conteúdo!");
		}
		
	}
	
	@Deprecated
	public Double calcularTotalXp() {
		return this.conteudosConcluidos.stream()
				.mapToDouble(Conteudo :: calcularXp)
				.sum();
	}
}
