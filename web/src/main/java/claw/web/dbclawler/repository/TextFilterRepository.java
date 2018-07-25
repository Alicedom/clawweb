package claw.web.dbclawler.repository;

import claw.web.dbclawler.entity.TextFilter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TextFilterRepository extends CrudRepository<TextFilter, Long>{

    @Query(value = "select s from TextFilter s where s.entryId = ?1 ")
    List<TextFilter> findAllByEntryId(int entryId);
}
