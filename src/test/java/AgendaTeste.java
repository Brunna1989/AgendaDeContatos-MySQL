import br.com.brunnadornelles.model.Contato;
import br.com.brunnadornelles.service.Agenda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AgendaTeste {
    Agenda agenda = new Agenda();

    @Test
    public void registraTeste(){
        Contato contatoteste2 = new Contato(8L, "Lais", "2222", "lais@gmail.com");
        Assertions.assertTrue(agenda.registra(contatoteste2));
        agenda.removerContato(contatoteste2);
    }

    @Test
    public void registraNomeNullTeste(){
        Contato nomeNull = new Contato(11L, null, "5555", "null@gmail.com");
        Assertions.assertFalse(agenda.registra(nomeNull));
    }

    @Test
    public void registraNomeExistenteTeste(){
        Contato contatoteste3 = new Contato(9L, "Brunna", "123456", "brunna@gmail.com");
        Assertions.assertFalse(agenda.registra(contatoteste3));
    }

    @Test
    public void registraIdMenor0Teste(){
        Contato id = new Contato(-1L, "joao", "99999", "null@gmail.com");
        Assertions.assertFalse(agenda.registra(id));
    }

    @Test
    public void registraIdExistenteTeste(){
        Contato contatoteste1 = new Contato(6L, "Joao", "1111", "joao@gmail.com");
        Assertions.assertFalse(agenda.registra(contatoteste1));
    }

    @Test
    public void registraEmailNullTeste(){
        Contato emailNull = new Contato(12L, "joao", "99999", null);
        Assertions.assertFalse(agenda.registra(emailNull));
    }

    @Test
    public void registraEmailIncorretoTeste(){
        Contato contatoteste4 = new Contato(10L, "Pati", "4444", "patigmail.com");
        Assertions.assertFalse(agenda.registra(contatoteste4));
    }

    @Test
    public void registraTelefoneNullTeste(){
        Contato telefoneNull = new Contato(12L, "joao", null, "null@gmail.com");
        Assertions.assertFalse(agenda.registra(telefoneNull));
    }
    @Test
    public void removerContatoTeste(){
        Contato contatoteste2 = new Contato(8L, "Lais", "2222", "lais@gmail.com");
        agenda.registra(contatoteste2);
        Assertions.assertTrue(agenda.removerContato(contatoteste2));
    }

    @Test
    public void listaContatosTeste(){
        List contatos = agenda.listaContatos();
        Assertions.assertEquals(contatos.size(), agenda.listaContatos().size());
    }

    @Test
    public void buscarContatoNomeTeste(){
        Contato contatoteste5 = new Contato(7L, "Contato Teste", "2222", "teste@gmail.com");
        agenda.registra(contatoteste5);
        List contatos = agenda.buscarContatoNome(contatoteste5.getNome());
        Assertions.assertEquals(agenda.buscarContatoNome(contatoteste5.getNome()), contatos);
        agenda.removerContato(contatoteste5);
    }

    @Test
    public void buscarContatoIdTeste(){
        Contato contatoteste5 = new Contato(7L, "Contato Teste", "2222", "teste@gmail.com");
        agenda.registra(contatoteste5);
        List contatos = agenda.buscarContatoId(Math.toIntExact(contatoteste5.getId()));
        Assertions.assertEquals(agenda.buscarContatoId(Math.toIntExact(contatoteste5.getId())), contatos);
        agenda.removerContato(contatoteste5);
    }

    @Test
    public void listaOrdemAlfabeticaTeste(){
        List contato = agenda.listaOrdemAlfabetica();
        Assertions.assertEquals(agenda.listaOrdemAlfabetica().size(), contato.size());
    }
}