package claw.web.dbclawler.repository;

import claw.web.dbclawler.entity.BodyParse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BodyParseRepository extends CrudRepository<BodyParse,Long>{

    @Query(value = "select s from BodyParse s where s.entryId = ?1 order by s.rank")
    List<BodyParse> findAllByEntryIdOrderByRank(int entryId);

    @Query(value = "select s.cssSelector from BodyParse s where s.entryId = ?1 and rank >= 0 order by s.rank")
    List<String> findAllByEntryIdAndRankGreaterThanEqual0OrderByRank(int entryId);

    @Query(value = "select s.cssSelector from BodyParse s where s.entryId = ?1 and rank < 0 order by s.rank")
    List<String> findAllByEntryIdAndRankLessThan0OrderByRank(int entryId);
}
//