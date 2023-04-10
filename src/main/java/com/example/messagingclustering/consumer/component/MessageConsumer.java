package com.example.messagingclustering.consumer.component;


import com.example.messagingclustering.model.SystemMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    List<String> mapList = new ArrayList<>();


    //    @JmsListener(destination = "message-queue")
    @JmsListener(destination = "message-queue")
    public void messageListener(SystemMessage systemMessage) {
        LOGGER.info("message Received.{}", systemMessage);
//        Map<String, String> map1 = new HashMap<>();
        mapList.add(systemMessage.getMessage());
//        System.out.println(map1);
    }


    public String getMessage() {
        if(mapList.isEmpty()){
            return null;
        }
        int i;
        for (i = 0; i < mapList.size()-1; i++)
            System.out.println(mapList.get(i));
             return mapList.get(i).toString();
    }

//    public SystemMessage messageListener(final SystemMessage systemMessage) throws JMSException {
//        String messageData = null;
//        LOGGER.info("Message has been received----->" +systemMessage);
//        String rcvrName = null;
//        if(systemMessage instanceof TextMessage) {
//            TextMessage textMessage = (TextMessage)systemMessage;
//            messageData = textMessage.getText();
////            Map map = new Gson().fromJson(messageData, Map.class);
////            rcvrName  = (String) map.get("Name");
////            log.info("Receiver Name----->" +rcvrName);
//        }
//        return systemMessage;
//    }


}
