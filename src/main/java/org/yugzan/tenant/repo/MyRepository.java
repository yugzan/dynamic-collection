package org.yugzan.tenant.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author teddy
 *
 *         Jun 30, 2016
 */

@Repository
public interface MyRepository extends MongoRepository<MyDocument, String> {

}
