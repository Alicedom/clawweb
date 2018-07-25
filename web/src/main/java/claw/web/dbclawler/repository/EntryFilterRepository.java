package claw.web.dbclawler.repository;

import claw.web.dbclawler.entity.EntryFilter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntryFilterRepository extends CrudRepository<EntryFilter, Long>{

    @Query("select s.text from EntryFilter s where s.entryId = :entryId " +
            "and s.selected = false ")
    List<String> findAllByEntryIdAndSelectedIsFalse(@Param("entryId") int entryId);

    @Query("select s.text from EntryFilter s where s.entryId = :entryId " +
            "and s.selected = true")
    List<String> findAllByEntryIdAndSelectedIsTrue(@Param("entryId") int entryId);

}
