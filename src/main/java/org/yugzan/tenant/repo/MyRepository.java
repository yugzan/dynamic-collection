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

//  @Query("{ '_id' : { $gt : ?0 } }")
//  public List<MyDocument> findSomeById(String id, Pageable pageable);

//  @Query("{ $and : [{ '_id' : { $gt : ?0 } }, { 'tags' : { $in : ?1 }}]}")
//  public List<MyDocument> findSomeByIdAndTags(String id, List<String> tags, Pageable pageable);

}
