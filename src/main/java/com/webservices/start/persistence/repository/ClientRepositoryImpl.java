package com.webservices.start.persistence.repository;

import com.webservices.start.persistence.model.Client;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Client c");

        return query.getResultList();
    }

    @Override
    public Client findById(Long idClient) {
        Query query = entityManager.createQuery("FROM Client WHERE idClient = :idClient");
        query.setParameter("idClient", idClient);

        return (Client) query.getSingleResult();
    }

    @Transactional // javax.persistence.TransactionRequiredException: Executing an update/delete query
    @Override
    public long save(Client client) {
        return entityManager.merge(client).getIdClient();
    }

    @Override
    public List<Client> findByDocument(String document) {
        Query query = entityManager.createQuery("SELECT c FROM Client c WHERE cpf = :cpf ");
        query.setParameter("cpf", document);
        List list = query.getResultList();

        return list;
    }

    @Override
    public List<Client> findByName(String name) {
        Query query = entityManager.createQuery("SELECT c FROM Client c WHERE name LIKE :name ");
        String argument = "%" + name + "%";
        query.setParameter("name", argument);
        List list = query.getResultList();

        return list;
    }
}
