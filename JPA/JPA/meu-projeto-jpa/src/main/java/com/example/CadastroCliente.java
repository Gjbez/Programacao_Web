package main.java.com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastroCliente {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Clientes-PU");
        EntityManager em = emf.createEntityManager();

        //LEITURA
        Cliente c1 = em.find(Cliente.class, 1);
        System.out.println("Cliente 1: " + c1.getNome());

        //INSERÇÃO
        Cliente novo = new Cliente();
        novo.setNome("Loja Nova");
        em.getTransaction().begin();
        em.persist(novo);
        em.getTransaction().commit();
        System.out.println("Inserido cliente com id = " + novo.getId());

        //ATUALIZAÇÃO
        Cliente c2 = em.find(Cliente.class, 1);
        em.getTransaction().begin();
        c2.setNome("Autopeças XX");
        em.getTransaction().commit();

        //REMOÇÃOa
        Cliente c3 = em.find(Cliente.class, novo.getId());
        em.getTransaction().begin();
        em.remove(c3);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}