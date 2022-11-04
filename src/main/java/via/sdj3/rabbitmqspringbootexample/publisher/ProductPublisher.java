package via.sdj3.rabbitmqspringbootexample.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import via.sdj3.rabbitmqspringbootexample.model.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ProductPublisher
{
  private RabbitTemplate template;
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductPublisher.class);
  private String EXCHANGE = "products.exchange";
  private String KEY = "product.routingKey";

  public ProductPublisher(RabbitTemplate template)
  {
    this.template = template;
  }

  public boolean send(Product p) {
    try {
      LOGGER.info("[SEND] ["+ LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+"] " + p.toString());
      template.convertAndSend(EXCHANGE, KEY, p);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}
