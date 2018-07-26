package claw.web.dbclawler.repository;

import claw.web.dbclawler.entity.TextParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class TextParseService {
    @Autowired
    TextParseRepository textParseRepository;

    public Map<String, String> findAllByEntryId(int entryId){
        Map<String, String> mapText = new Hashtable<>();

        List<TextParse> list = textParseRepository.findAllByEntryId(entryId);
        list.forEach(x-> mapText.put(x.getType(), x.getCssSelector()));

        return mapText;
    }
}
