import dao.PessoaDao;
import model.Pessoa;

public class Principal{
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa();

        p1.setNome("teste");
        p1.setCpf("9030");

        PessoaDao pessoaDao = new PessoaDao();
        pessoaDao.salvar(p1);
    }
}
