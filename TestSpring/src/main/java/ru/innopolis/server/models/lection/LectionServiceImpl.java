package ru.innopolis.server.models.lection;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.common.models.lection.Lection;
import ru.innopolis.common.models.lection.LectionService;
import ru.innopolis.common.models.lection.exeptions.LectionServiceDataExeption;
import ru.innopolis.server.dao.lection.DAOLection;
import ru.innopolis.server.dao.exeptions.DAOExeption;

import java.util.List;


/**
 * Created by Girevoy.T on 01.11.2016.
 */
public class LectionServiceImpl implements LectionService{
	@Autowired
	private DAOLection daoLection;

	public void setDaoLection(DAOLection daoLection) {
		this.daoLection = daoLection;
	}

	@Override
	public List<Lection> getLectionsList() throws LectionServiceDataExeption {
		try {
			return daoLection.getLectionsList();
		} catch (DAOExeption e) {
			throw new LectionServiceDataExeption(e);
		}
	}


}
