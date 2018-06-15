package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public void gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());
		
		if(this.autor.getId() != null) {
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		} else {
			new DAO<Autor>(Autor.class).adiciona(this.autor);
		}
		
		this.autor = new Autor();
		
//		return "livro?faces-redirect=true";
	}
	
	public List<Autor> getListaAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	
	public void carregar(Autor autor) {
		this.autor = autor;
	}
	
	public void remover(Autor autor) {
		new DAO<Autor>(Autor.class).remove(autor);
	}
	
}
