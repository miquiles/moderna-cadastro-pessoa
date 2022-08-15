import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("moderna");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        //listar todos
        String sql = "from Pessoa";
        TypedQuery typedQuery = entityManager.createQuery(sql, Pessoa.class);
        List<Pessoa> listaDePessoas = typedQuery.getResultList();

        int i = 1;
        for (Pessoa pessoaPercorrida : listaDePessoas){
            System.out.println(pessoaPercorrida);
            System.out.println(i++);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();



    }
}
