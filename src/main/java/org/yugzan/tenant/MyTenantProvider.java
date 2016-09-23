package org.yugzan.tenant;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yongzan
 * @date 2016/9/23
 */
@Component("myTenantProvider")
public class MyTenantProvider {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Optional<String> targetCollectionName = Optional.empty();

    public void setTenantName(String name) {
        targetCollectionName = Optional.ofNullable(name);
    }

    public String getTenantName() {

        /**
         * using user name or id bind an collection.
         * */
        // if (SecurityContextHolder.getContext().getAuthentication() != null)
        // targetCollectionName =
        // Optional.ofNullable(
        // SecurityContextHolder.getContext().getAuthentication().getName());

        if (!targetCollectionName.isPresent()) {
            targetCollectionName = Optional.of("Basic_Collection");
        }
        logger.info("get getTenantname: {}", targetCollectionName);
        return targetCollectionName.get();
    }
}
