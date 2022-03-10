package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
	
	private String nome;
	
	private String descricao;
	
	private LocalDate dataInicial = LocalDate.now();
	
	private LocalDate dataFinal = dataInicial.plusDays(45);
	
	private Set<Dev> devsInscritos = new HashSet<Dev>();
	
	private Set<Conteudo> conteudos = new LinkedHashSet<Conteudo>();

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected String getDescricao() {
		return descricao;
	}

	protected void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	protected LocalDate getDataInicial() {
		return dataInicial;
	}

	protected void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	protected LocalDate getDataFinal() {
		return dataFinal;
	}

	protected void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	protected Set<Dev> getDevsInscritos() {
		return devsInscritos;
	}

	protected void setDevsInscritos(Set<Dev> devsInscritos) {
		this.devsInscritos = devsInscritos;
	}

	protected Set<Conteudo> getConteudos() {
		return conteudos;
	}

	protected void setConteudos(Set<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudos, dataFinal, dataInicial, descricao, devsInscritos, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bootcamp other = (Bootcamp) obj;
		return Objects.equals(conteudos, other.conteudos) && Objects.equals(dataFinal, other.dataFinal)
				&& Objects.equals(dataInicial, other.dataInicial) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(devsInscritos, other.devsInscritos) && Objects.equals(nome, other.nome);
	}

}
