package com.jiaotd.getaway;

import com.jiaotd.getaway.filter.UserResolveFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：TODO
 *
 * @author jiaotengda
 * Date:     2020/3/22
 */
@Configuration
@Slf4j
public class Config {
    @Bean
    public UserResolveFilter userCenterResolveUserFilter() {
        log.info("init UserResolveFilter");
        return new UserResolveFilter();
    }
}
