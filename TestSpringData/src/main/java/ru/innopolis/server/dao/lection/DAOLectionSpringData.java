package ru.innopolis.server.dao.lection;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.common.models.lection.Lection;
import ru.innopolis.mapper.MapperFactoryInstance;
import ru.innopolis.server.dao.exeptions.DAOExeption;
import ru.innopolis.server.entity.LectionsEntity;
import ru.innopolis.server.repositoryes.LectionRepository;

import java.util.List;

/**
 * Created by Girevoy.T on 09.11.2016.
 */
@Slf4j
public class DAOLectionSpringData implements DAOLection {
	@Autowired
	LectionRepository lectionRepository;

	static {
		MapperFactoryInstance.getMapperFactoryInstance().classMap(Lection.class, LectionsEntity.class)
			.byDefault()
			.register();
	}
	private static MapperFacade mapper = MapperFactoryInstance.getMapperFactoryInstance().getMapperFacade();

	@Override
	public List<Lection> getLectionsList() throws DAOExeption {
		return mapper.mapAsList(lectionRepository.findAll(),Lection.class);
	}

	@Override
	public void addNewLection(Lection lection) throws DAOExeption {
		lectionRepository.save(mapper.map(lection,LectionsEntity.class));
	}

	@Override
	public void deleteLection(Lection lection) throws DAOExeption {
		lectionRepository.delete(lection.getId());
	}
}
