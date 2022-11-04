package via.sdj3.rabbitmqspringbootexample.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import via.sdj3.rabbitmqspringbootexample.publisher.SimplePublisher;

@RestController
public class RabbitMQRestController
{
  private SimplePublisher publisher;

  public RabbitMQRestController(SimplePublisher publisher)
  {
    this.publisher = publisher;
  }

  @RequestMapping("/message")
  public String sendMessage(@RequestParam String messageBody) {
    System.out.println("<-- " + messageBody);
    publisher.send(messageBody);
    return "Message sent.";
  }
}
