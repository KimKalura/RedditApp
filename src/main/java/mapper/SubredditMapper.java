package mapper;


import DTO.SubredditRequestDTO;
import DTO.SubredditResponseDTO;
import model.Subreddit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") //pt a folosi metodele de mapare
public abstract class SubredditMapper {

    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")//atributul... din ...
    public abstract Subreddit mapDtoToSubreddit (SubredditRequestDTO subredditRequestDTO);

    @Mapping(target = "numberOfPosts", expression = "java(subreddit.getPostList().size())")//target-ul e mereu ce iese, ce vreau sa construiesc; la expression->ce met vreau sa apelez care sa imi care sa imi calculeze noOfPosts
    public abstract SubredditResponseDTO mapSubredditToDto (Subreddit subreddit);
}
