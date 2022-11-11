package via.sdj3.rabbitmqspringbootexample.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import via.sdj3.rabbitmqspringbootexample.model.Product;
import via.sdj3.rabbitmqspringbootexample.publisher.ProductPublisher;

@RestController
public class PublisherRestController
{
  private ProductPublisher rabbitMQService;

  public PublisherRestController(ProductPublisher rabbitMQService)
  {
    this.rabbitMQService = rabbitMQService;
  }

  @PostMapping("/products")
  public ResponseEntity<String> publishProductDetails(@RequestBody Product product) {
      if(rabbitMQService.send(product)) {
        System.out.println(product.getDescription() + "sent to broker" + HttpStatus.OK);
      }
      else {
        return ResponseEntity.status(500).body("error.");
      }
      return ResponseEntity.ok(product.getDescription());
  }
}


