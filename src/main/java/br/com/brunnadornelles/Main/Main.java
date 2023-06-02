package br.com.brunnadornelles.Main;

import br.com.brunnadornelles.model.Contato;
import br.com.brunnadornelles.service.Agenda;

public class Main {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        Contato contato1 = new Contato(1L,"Gilberto", "51985142565", "amanda@gmail.com");
        agenda.registra(contato1);
        Contato contato2 = new Contato(2L,"Patricia", "51994524756", "patricia@gmail.com");
        agenda.registra(contato2);
        Contato contato3 = new Contato(3L,"Brunna", "51990150771", "bruna@gmmail.com");
        agenda.registra(contato3);
        Contato contato4 = new Contato(4L,"Alberto", "51984254525", "lucas@gmail.com");
        agenda.registra(contato4);
        Contato contato5 = new Contato(5L,"Joana", "51985412533", "debora@gmail.com");
        agenda.registra(contato5);
        Contato contato6 = new Contato(6L,"Karolina", "51985257424", "maria@gmail.com");
        agenda.registra(contato6);

        System.out.println("\n---------------------------------------------");
        System.out.println("------------- Lista de Contatos -------------\n");
        System.out.println(agenda.listaContatos());

        System.out.println("\n---------------------------------------------\n");
        agenda.removerContato(contato3);

        System.out.println("\n---------------------------------------------");
        System.out.println("- Lista de Contatos após deletar um contato -\n");
        System.out.println(agenda.listaContatos());

        System.out.println("\n---------------------------------------------");
        System.out.println("-------- Buscando contato pelo nome ---------\n");
        System.out.println(agenda.buscarContatoNome(contato4.getNome()));

        System.out.println("\n---------------------------------------------");
        System.out.println("--------- Buscando contato pelo ID ----------\n");
        System.out.println(agenda.buscarContatoId(Math.toIntExact(contato1.getId())));

        System.out.println("\n---------------------------------------------");
        System.out.println("-------- Lista em Ordem Alfabética ----------\n");
        System.out.println(agenda.listaOrdemAlfabetica());
    }
}


