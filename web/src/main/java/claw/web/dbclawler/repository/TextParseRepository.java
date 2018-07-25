package claw.web.dbclawler.repository;

import claw.web.dbclawler.entity.TextParse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TextParseRepository extends CrudRepository<TextParse, Long>{

    @Query(value = "select s from TextParse s where s.entryId = ?1")
    List<TextParse> findAllByEntryId(int entryId);
}
