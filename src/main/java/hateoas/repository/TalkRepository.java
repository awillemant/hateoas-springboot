package hateoas.repository;

import hateoas.entity.Talk;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "talks", path="talks")
public interface TalkRepository extends PagingAndSortingRepository<Talk,Long> {

    public List<Talk> findBySpeakerName(@Param("name")String speakerName);

}
