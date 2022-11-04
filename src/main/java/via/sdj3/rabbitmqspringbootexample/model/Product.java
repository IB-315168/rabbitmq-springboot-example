package via.sdj3.rabbitmqspringbootexample.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Product.class)
public class Product implements Serializable
{
  private Long id;
  private String description;
  private int numOfParts;
  private double weight;
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  private Date date;

  public Product()
  {
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public int getNumOfParts()
  {
    return numOfParts;
  }

  public void setNumOfParts(int numOfParts)
  {
    this.numOfParts = numOfParts;
  }

  public double getWeight()
  {
    return weight;
  }

  public void setWeight(double weight)
  {
    this.weight = weight;
  }

  public Date getDate()
  {
    return date;
  }

  public void setDate(Date date)
  {
    this.date = date;
  }

  @Override public String toString()
  {
    return "Product{" + "id=" + id + ", description='" + description + '\''
        + ", numOfParts=" + numOfParts + ", weight=" + weight + ", date=" + date
        + '}';
  }
}
