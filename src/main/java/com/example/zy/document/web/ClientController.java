package com.example.zy.document.web;

import com.example.zy.document.document.Client;
import com.example.zy.document.dto.ClientDTO;
import com.example.zy.document.repository.ClientRepository;
import com.example.zy.document.utils.ZyCode;
import com.example.zy.document.utils.ZyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RequestMapping("/api/client")
public class ClientController {

    Logger logger = Logger.getLogger(ClientController.class.getName());
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("/save")
    public ZyResponse<Client> saveDocument(@RequestBody ClientDTO clientDTO) {
        try {
//            tokenGenerator.
            return new ZyResponse<>(ZyCode.SUCCESS, clientRepository.save(Client.from(clientDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/all")
    public ZyResponse<List<Client>> readAllDocuments() {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, clientRepository.findAll());
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PutMapping("/update")
    public ZyResponse<Client> updateDocument(@RequestBody ClientDTO clientDTO) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, clientRepository.save(Client.from(clientDTO)));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ZyResponse<String> deleteDocument(@PathVariable String id) {
        try {
            clientRepository.deleteById(id);
            return new ZyResponse<>(ZyCode.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ZyResponse<Optional<Client>> readDocument(@PathVariable String id) {
        try {
            return new ZyResponse<>(ZyCode.SUCCESS, clientRepository.findById(id));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }

    @PostMapping("/filter")
    public ZyResponse<List<Client>> filterDocuments(@RequestBody ClientDTO clientDTO) {
        try {
            if (clientDTO.getNickname() == null) {
                clientDTO.setNickname("");
            }
            if (clientDTO.getDescription() == null) {
                clientDTO.setDescription("");
            }
            if (clientDTO.getDescriptionShort() == null) {
                clientDTO.setDescriptionShort("");
            }
            if (clientDTO.getStatusId() == null) {
                clientDTO.setStatusId("");
            }
            return new ZyResponse<>(ZyCode.SUCCESS, clientRepository.findByFills(clientDTO.getNickname(), clientDTO.getDescription(), clientDTO.getDescriptionShort(), clientDTO.getStatusId()));
        } catch (Exception e) {
            logger.info(e.getMessage());
            return new ZyResponse<>(ZyCode.ERROR);
        }
    }
}
