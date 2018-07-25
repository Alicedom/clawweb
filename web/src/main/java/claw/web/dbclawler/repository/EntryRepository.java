package claw.web.dbclawler.repository;

import claw.web.dbclawler.entity.Entry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends CrudRepository<Entry, Long>{

    @Query("select s from Entry s where s.entryId = ?1 and s.actived = true")
    List<Entry> findAllByEntryId(int entryId);
}
