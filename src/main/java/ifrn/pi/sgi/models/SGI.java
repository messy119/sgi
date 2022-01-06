package ifrn.pi.sgi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SGI {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Nome;
	private String Editora;
	private String Genero;
	private String Ano;
	private String Autor;
	private String Sinopse;

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEditora() {
		return Editora;
	}

	public void setEditora(String editora) {
		Editora = editora;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getAno() {
		return Ano;
	}

	public void setAno(String ano) {
		Ano = ano;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getSinopse() {
		return Sinopse;
	}

	public void setSinopse(String sinopse) {
		Sinopse = sinopse;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "SGI [Id=" + Id + ", Nome=" + Nome + ", Editora=" + Editora + ", Genero=" + Genero + ", Ano=" + Ano
				+ ", Autor=" + Autor + ", Sinopse=" + Sinopse + "]";
	}

}
