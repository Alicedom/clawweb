package claw.web.dbclawler.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyParseService {
    @Autowired
    private BodyParseRepository bodyParseRepository;

    public List<String> getListBody(int entryId){
        return  bodyParseRepository.findAllByEntryIdAndRankGreaterThanEqual0OrderByRank(entryId);
    }

    public String getBodyRemove(int entryId){
        List<String>  list =  bodyParseRepository.findAllByEntryIdAndRankLessThan0OrderByRank(entryId);
        return getString(list);
    }

    private String getString(List<String> list){
        StringBuilder stringBuilder = new StringBuilder();

        list.forEach(x-> stringBuilder.append(x).append(","));

        return stringBuilder.toString();
    }

}
