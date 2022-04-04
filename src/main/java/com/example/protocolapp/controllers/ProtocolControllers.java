package com.example.protocolapp.controllers;


import com.example.protocolapp.entity.Protocol;
import com.example.protocolapp.service.ProtocolService;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/protocol")
@AllArgsConstructor
public class ProtocolControllers {
    private final ProtocolService protocolService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createProtocol (@RequestBody Protocol protocol){
        protocolService.saveProtocol(protocol);
    }

    @GetMapping("/get/{id}")
    public Protocol getProtocol (@PathVariable("id") Long id){
        return protocolService.getProtocol(id);
    }

}
