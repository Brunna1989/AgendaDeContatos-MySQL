package br.com.brunnadornelles.service;

import br.com.brunnadornelles.database.AgendaBanco;
import br.com.brunnadornelles.model.Contato;

import java.util.List;

public class Agenda {
    private AgendaBanco agendaBanco = new AgendaBanco();
    public boolean registra(Contato contato){
        if(!this.buscarContatoId(Math.toIntExact(contato.getId())).isEmpty()){
            return false;
        }
        if(!this.buscarContatoNome(contato.getNome()).isEmpty()){
            return false;
        }
        if (contato.getNome() == null || contato.getNome().isBlank()){
            return false;
        }
        if(!contato.getNome().matches("[a-zA-Z]+")){
            return false;
        }
        if(contato.getEmail() == null || contato.getEmail().isBlank()){
            return false;
        }
        if(!contato.getEmail().matches("^(.+)@(.+)$")){
            return false;
        }
        if(contato.getId() == null){
            return false;
        }
        if(contato.getId() < 0){
            return false;
        }
        if(contato.getTelefone() == null || contato.getTelefone().isBlank()){
            return false;
        }

        agendaBanco.addContato(contato);
        return true;
    }

    public boolean removerContato(Contato contato){
        if(contato == null){
            return false;
        }
        agendaBanco.deletarContato(contato);
        return true;
    }

    public List<Contato> listaContatos() {
        return agendaBanco.listarContatos();
    }

    public List<Contato> buscarContatoNome(String nome){
        return agendaBanco.buscarContatoNome(nome);
    }

    public List<Contato> buscarContatoId(int id) {
        try {
            return agendaBanco.buscarContatoId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Contato> listaOrdemAlfabetica(){
        return agendaBanco.listarContatosPeloNome();
    }
}