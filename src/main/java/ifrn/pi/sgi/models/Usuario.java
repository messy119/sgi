package ifrn.pi.sgi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String rg;
	private String residencia;

	@ManyToOne
	private SGI sgi;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public SGI getSgi() {
		return sgi;
	}

	public void setSgi(SGI sgi) {
		this.sgi = sgi;
	}

	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", rg=" + rg + ", residencia=" + residencia + ", sgi=" + sgi
				+ "]";
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

}
