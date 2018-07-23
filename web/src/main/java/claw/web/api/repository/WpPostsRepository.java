package claw.web.api.repository;

import claw.web.api.entity.WpPosts;
import org.springframework.data.repository.CrudRepository;

public interface WpPostsRepository extends CrudRepository<WpPosts, Long> {

}
