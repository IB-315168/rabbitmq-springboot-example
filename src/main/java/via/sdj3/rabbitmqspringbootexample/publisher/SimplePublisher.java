package via.sdj3.rabbitmqspringbootexample.publisher;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class SimplePublisher
{
  private RabbitTemplate rabbitTemplate;

  public SimplePublisher(RabbitTemplate template) {
    this.rabbitTemplate = template;
  }

  public void send(String msg)
  {
    String message = "[" + msg + "] received on - " + LocalDateTime.now();
    this.rabbitTemplate.convertAndSend("products.exchange", "product.routingKey", message);
    System.out.println("[SEND - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "] ----->" + message);
  }
}
