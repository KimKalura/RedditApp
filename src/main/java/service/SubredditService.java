package service;

import DTO.SubredditRequestDTO;
import DTO.SubredditResponseDTO;
import mapper.SubredditMapper;
import model.Subreddit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SubredditRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubredditService {
    private SubredditRepository subredditRepository;

    private SubredditMapper subredditMapper;

    @Autowired
    public SubredditService(SubredditRepository subredditRepository, SubredditMapper subredditMapper) {
        this.subredditRepository = subredditRepository;
        this.subredditMapper = subredditMapper;
    }


    public Subreddit addSubreddit(SubredditRequestDTO subredditRequestDTO) {
        return subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditRequestDTO));
    }

    public List<SubredditResponseDTO> getAllSubreddits() {
        return subredditRepository.findAll().stream()
                .map(subreddit -> subredditMapper.mapSubredditToDto(subreddit))
                .collect(Collectors.toList());
    }

}
