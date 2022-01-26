package api.tistech.services.GameSearchService;

import org.springframework.stereotype.Service;

import api.tistech.dto.SearchWordsDTO;
import api.tistech.dto.ThirdIntGeneratorDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@NoArgsConstructor
@Getter
@Setter
public class SearchWordsServiceImpl implements INodesTreeService {
 
    public String execute(SearchWordsDTO nodes) {
        return "";
    }
}
