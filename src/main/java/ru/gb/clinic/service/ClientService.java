package ru.gb.clinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.clinic.model.Client;
import ru.gb.clinic.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client saveClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }
}
