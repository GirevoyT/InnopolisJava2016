package ru.innopolis.server.models.lection;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.innopolis.common.models.lection.Lection;
import ru.innopolis.common.models.lection.LectionService;
import ru.innopolis.common.models.lection.exeptions.LectionServiceDataExeption;

import java.util.List;

/**
 * Created by Girevoy.T on 15.11.2016.
 */
@Slf4j
public class LectionServiceImplDecorator implements LectionService {
	@Autowired
	@Getter
	@Setter
	private LectionService lectionServiceComponent;


	@Override
	public List<Lection> getLectionsList() throws LectionServiceDataExeption {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();

		log.info("Пользователь {} выполнил действие: Запрос списка лекций",userDetails.getUsername());

		return lectionServiceComponent.getLectionsList();
	}
}
