package sg.edu.nus.iss.app.ssfpractice.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.app.ssfpractice.models.Order;

@Repository
public class PizzaRepo {
  @Autowired
  private RedisTemplate<String, Object> template;

  public void add(String id, Order order){
    template.opsForValue().set(id, order);
  }

  public Optional<Object> getOrder(String id){
    return Optional.ofNullable(template.opsForValue().get(id));

  }
}
