package via.sdj3.rabbitmqspringbootexample.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig
{
  @Bean public Exchange productExchange()
  {
    return new DirectExchange("products.exchange");
  }

  @Bean public Queue productQueue()
  {
    return new Queue("product.queue");
  }

  @Bean public Queue messageQueue()
  {
    return new Queue("distribution.notification");
  }

  @Bean public Binding productBinding()
  {
    return BindingBuilder.bind(productQueue()).to(productExchange())
        .with("product.routingKey").noargs();
  }

  @Bean public Binding messageBinding()
  {
    return BindingBuilder.bind(messageQueue()).to(productExchange())
        .with("distribution.notification.routingKey").noargs();
  }

  @Bean public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }

}