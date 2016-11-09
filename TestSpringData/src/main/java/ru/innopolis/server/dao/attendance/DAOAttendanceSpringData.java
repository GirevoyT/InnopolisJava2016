package ru.innopolis.server.dao.attendance;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.common.models.attendance.Attendance;
import ru.innopolis.mapper.MapperFactoryInstance;
import ru.innopolis.server.dao.exeptions.DAOExeption;
import ru.innopolis.server.entity.AttendanceEntity;
import ru.innopolis.server.repositoryes.AttendanceRepository;

import java.util.List;

/**
 * Created by Girevoy.T on 09.11.2016.
 */
@Slf4j
@Repository
public class DAOAttendanceSpringData implements DAOAttendance {
	@Autowired
	AttendanceRepository attendanceRepository;

	static {
		MapperFactoryInstance.getMapperFactoryInstance().classMap(Attendance.class, AttendanceEntity.class)
			.field("lectionId","key.lectionId")
			.field("studentId","key.studentId")
			.register();
		MapperFactoryInstance.getMapperFactoryInstance().classMap(AttendanceEntity.EmbKey.class, Attendance.class)
			.byDefault()
			.register();
	}
	private static MapperFacade mapper = MapperFactoryInstance.getMapperFactoryInstance().getMapperFacade();

	@Override
	public List<Attendance> getAttendacesList() throws DAOExeption {
		return mapper.mapAsList(attendanceRepository.findAll(),Attendance.class);
	}

	@Override
	public void addNewAttendance(Attendance attendance) throws DAOExeption {
		attendanceRepository.save(mapper.map(attendance,AttendanceEntity.class));
	}

	@Override
	public void deleteAttendance(Attendance attendance) throws DAOExeption {
		attendanceRepository.delete(mapper.map(attendance,AttendanceEntity.class).getKey());
	}
}
