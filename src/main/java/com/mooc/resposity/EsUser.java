package com.mooc.resposity;

import com.mooc.pojo.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsUser extends ElasticsearchRepository<User,Long> {

    User findByUserNameOrAddress (String name,String address);

    User findByAddress(String mobile);
}
