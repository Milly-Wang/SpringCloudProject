package cn.milly.movie.client;

import cn.milly.movie.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements UserController {
    @Override
    public User findById(Integer id) {
        System.out.println("执行熔断器");
        return null;
    }
}
