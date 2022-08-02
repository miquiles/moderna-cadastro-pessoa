import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("moderna-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Eduardo");
        pessoa.setCpf("999999999");
        entityManager.persist(pessoa);


    }
}
