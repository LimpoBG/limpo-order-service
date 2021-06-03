package limpo.orderservice.controller;

import limpo.orderservice.model.Client;
import limpo.orderservice.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ClientController.BASE_URL)
public class ClientController{

    public static final String BASE_URL = "/clients";

    public final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<?> getAllClients(){
        List<Client> result = clientService.getAllClients();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable("id") Long id){
        Client result = clientService.getClientById(id);
        if(result == null){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addNewClient(@RequestBody Client client){
        Client result = clientService.addNewClient(client);
        if(client == null){
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        }

        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id){
         Long result = clientService.deleteClient(id);
         if(result == null){
             return new ResponseEntity(null, HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity(result ,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Client client){
        Client result = clientService.updateClient(id,client);
        if(result == null){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result, HttpStatus.CREATED);
    }
}