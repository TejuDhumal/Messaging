package com.example.messagingclustering.publisher.controller;


import com.example.messagingclustering.consumer.component.MessageConsumer;
import com.example.messagingclustering.exception.ConnectionRefusedException;
import com.example.messagingclustering.model.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublishController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private MessageConsumer messageConsumer;

    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody SystemMessage systemMessage) {
        try {
            jmsTemplate.convertAndSend("message-queue", systemMessage);
//            System.out.println(systemMessage);
            return new ResponseEntity<>("sent", HttpStatus.OK);

        } catch (Exception e) {
            throw new ConnectionRefusedException("Connection refused");
        }
    }


    //  @JmsListener(destination = "message-queue")
    @GetMapping("/getMsg")
    public String getMessage(){
       return messageConsumer.getMessage();
    }

//    public SystemMessage getMessage(SystemMessage systemMessage) throws JMSException {
//        SystemMessage message = (SystemMessage) jmsTemplate.receiveSelectedAndConvert("message-queue", String.valueOf((SystemMessage.class)));
//        if (message == null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(message);
//    }
//        return messageConsumer.messageListener(systemMessage);
//    }



}