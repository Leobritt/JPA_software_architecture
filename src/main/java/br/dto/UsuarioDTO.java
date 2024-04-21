package br.dto;

public record UsuarioDTO(
		/*
		 * o recordo é uma classe imutável
		 * é uma classe que não pode ser alterada
		 * é uma classe que não pode ser extendida, pois é final
		 * é uma classe que não pode ser instanciada, pois é abstract
		 * é uma classe que não pode ser alterada, pois é final
		 * vanategem de usar record é que ele já cria os métodos get e set
		 * e um toString
		 */
		String login,
		String email,
		String password,
		String nome) {
}
