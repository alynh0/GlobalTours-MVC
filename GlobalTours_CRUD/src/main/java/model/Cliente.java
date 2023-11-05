package model;

import java.time.LocalDate;

public class Cliente {

	private int id_cliente;
	private String nome_cliente;
	private String telefone_cliente;
	private String email_cliente;
	private LocalDate dataNascimento;
	private String senha_cliente;

	public Cliente(int id_cliente, String nome_cliente, String telefone_cliente, String email_cliente,
			String senha_cliente, LocalDate dataNascimento) {
		this.id_cliente = id_cliente;
		this.nome_cliente = nome_cliente;
		this.telefone_cliente = telefone_cliente;
		this.email_cliente = email_cliente;
		this.senha_cliente = senha_cliente;
		this.dataNascimento = dataNascimento;
	}

	public Cliente() {
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getTelefone_cliente() {
		return telefone_cliente;
	}

	public void setTelefone_cliente(String telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getSenha_cliente() {
		return senha_cliente;
	}

	public void setSenha_cliente(String senha_cliente) {
		this.senha_cliente = senha_cliente;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", nome_cliente=" + nome_cliente + ", telefone_cliente="
				+ telefone_cliente + ", email_cliente=" + email_cliente + ", dataNascimento=" + dataNascimento
				+ ", senha_cliente=" + senha_cliente + "]";
	}

}
