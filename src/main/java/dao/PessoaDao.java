package dao;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PessoaDao {

    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;

    public PessoaDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("moderna");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public void salvar(Pessoa pessoa){
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Pessoa pesquisarPorId(Long id){
        var pessoaEncontrada = entityManager.find(Pessoa.class, id);
        entityManager.close();
        return pessoaEncontrada;

    }

    public void deletar(Long id){
        var pessoaEncontrada = entityManager.find(Pessoa.class, id);
        entityManager.remove(pessoaEncontrada);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void atualizar(Pessoa pessoa){
        entityManager.merge(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    public void listarTodos(){

        var sql = "from Pessoa";
        TypedQuery typedQuery = entityManager.createQuery(sql, Pessoa.class);
        List<Pessoa> listaPessoas = typedQuery.getResultList();

        for (Pessoa pessoaPercorrida : listaPessoas){
            System.out.println(pessoaPercorrida);
        }

        entityManager.close();
    }


}
