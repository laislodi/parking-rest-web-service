package com.webservices.start.service;

import com.webservices.start.persistence.model.Client;
import com.webservices.start.persistence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findClient(Long idClient) {
        return clientRepository.findById(idClient);
    }

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public void editClient (Client client) {
        clientRepository.save(client);
    }

    public long createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findClientByDocument(String document) {
        return clientRepository.findByDocument(document);
    }

    public List<Client> findClientByName(String name) {
        return clientRepository.findByName(name);
    }
}
