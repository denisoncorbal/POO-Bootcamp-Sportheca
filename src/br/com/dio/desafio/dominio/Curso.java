package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{
	
	private int cargaHoraria;	
	
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}	
	
	@Override
	public String toString() {
		return "Curso [titulo=" + getTitulo() + ", descricao=" + getDescricao() + ", cargaHoraria=" + cargaHoraria + "]";
	}
	
	@Override
	@Deprecated
	protected double calcularXp() {
		return XP_PADRAO * cargaHoraria;
	}
	
	@Override
	protected double calcularXp(Double nota) {
		
		return XP_PADRAO * cargaHoraria * nota / 100;
	}
	
	
	
}
