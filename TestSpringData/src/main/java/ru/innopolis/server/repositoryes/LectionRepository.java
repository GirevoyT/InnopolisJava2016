package ru.innopolis.server.repositoryes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.server.entity.LectionsEntity;

/**
 * Created by Girevoy.T on 09.11.2016.
 */
@Repository
public interface LectionRepository extends CrudRepository<LectionsEntity,Integer>{
}
