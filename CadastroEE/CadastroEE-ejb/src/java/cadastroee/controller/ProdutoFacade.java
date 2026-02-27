package cadastroee.controller;

import cadastroee.model.Produto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProdutoFacade implements ProdutoFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public void create(Produto entity) {
        getEntityManager().persist(entity);
    }

    public void edit(Produto entity) {
        getEntityManager().merge(entity);
    }

    public void remove(Produto entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public Produto find(Object id) {
        return getEntityManager().find(Produto.class, id);
    }

    public List<Produto> findAll() {
        return getEntityManager().createNamedQuery("Produto.findAll", Produto.class).getResultList();
    }
}