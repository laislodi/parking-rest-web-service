package com.webservices.start.controller;

import com.webservices.start.persistence.model.Client;
import com.webservices.start.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/find-all")
    public List<Client> findAllVehicles() {
        return clientService.findAllClients();
    }

    @GetMapping(value = "/find")
    public Client findClient(@RequestParam Long idClient) {
        return clientService.findClient(idClient);
    }

    @GetMapping(value = "/find-by-document")
    public List<Client> findClientByDocument(@RequestParam String document) {
        return clientService.findClientByDocument(document);
    }

    @GetMapping(value = "/find-by-name")
    public List<Client> findClientByName(@RequestParam String name){
        return clientService.findClientByName(name);
    }

    @PutMapping("/edit")
    public void editClient(@RequestBody Client client) {
        clientService.editClient(client);
    }

    @PostMapping("/new")
    public long newClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }
}
