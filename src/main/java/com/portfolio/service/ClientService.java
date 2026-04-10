package com.portfolio.service;

import com.portfolio.model.Client;
import com.portfolio.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClinets() {
        return clientRepository.findAll();
    }

}
