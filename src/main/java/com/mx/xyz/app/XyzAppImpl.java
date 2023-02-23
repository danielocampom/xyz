package com.mx.xyz.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.xyz.entity.IncidenciaEntity;
import com.mx.xyz.entity.MovimientoEntity;
import com.mx.xyz.enums.EstadoEnum;
import com.mx.xyz.handle.exception.BadRequestException;
import com.mx.xyz.handle.exception.NoContentException;
import com.mx.xyz.repository.EquipoRepository;
import com.mx.xyz.repository.IncidenciaRepository;
import com.mx.xyz.repository.MovimientoRepository;
import com.mx.xyz.repository.OperadorRepository;
import com.mx.xyz.vo.BuscaIncidenciaRequestVO;
import com.mx.xyz.vo.DashboardResponseVO;
import com.mx.xyz.vo.IncidenciaRequestVO;
import com.mx.xyz.vo.IncidenciaResponseVO;

@Service
public class XyzAppImpl implements XyzApp {

	@Autowired
	private IncidenciaRepository incidenciaRepository;

	@Autowired
	private OperadorRepository operadorRepository;

	@Autowired
	private EquipoRepository equipoRepository;

	@Autowired
	private MovimientoRepository movimientoRepository;

	@Override
	public IncidenciaResponseVO agregaIncidencia(IncidenciaRequestVO incidencia) {
		IncidenciaEntity in = new IncidenciaEntity();
		in.setEquipoIncidencia(equipoRepository.findById(incidencia.getIdEquipo())
				.orElseThrow(() -> new BadRequestException("El equipo no es valido")));
		in.setEstadoIncidencia(EstadoEnum.ABIERTO);
		in.setFechaIncidencia(new Date());
		in.setOperadorIncidencia(operadorRepository.findById(incidencia.getIdOperador())
				.orElseThrow(() -> new BadRequestException("El operador no es valido")));
		MovimientoEntity mov = new MovimientoEntity();
		mov.setDate(new Date());
		mov.setTipo("INSERCCION");
		incidenciaRepository.save(in);
		movimientoRepository.save(mov);
		return getIncidencia(in);
	}

	private IncidenciaResponseVO getIncidencia(IncidenciaEntity incidencia) {
		IncidenciaResponseVO in = new IncidenciaResponseVO();
		in.setEquipo(incidencia.getEquipoIncidencia().getNombreEquipo());
		in.setEstado(incidencia.getEstadoIncidencia().name());
		in.setFecha(incidencia.getFechaIncidencia());
		in.setId(incidencia.getIdInicidencia());
		in.setIdEquipo(incidencia.getEquipoIncidencia().getIdEquipo());
		in.setIdOperador(incidencia.getOperadorIncidencia().getIdOperador());
		in.setOperador(incidencia.getOperadorIncidencia().getNombreOperador());
		return in;
	}

	@Override
	public IncidenciaResponseVO resuelveIncidencia(Long idIncidencia) {
		IncidenciaEntity in = incidenciaRepository.findById(idIncidencia)
				.orElseThrow(() -> new BadRequestException("Incidencia no valida"));
		in.setEstadoIncidencia(EstadoEnum.RESUELTO);
		incidenciaRepository.save(in);
		return getIncidencia(in);
	}

	@Override
	public Object consultaIncidencia(BuscaIncidenciaRequestVO busca) {
		MovimientoEntity mov = new MovimientoEntity();
		mov.setDate(new Date());
		mov.setTipo("CONSULTA");
		movimientoRepository.save(mov);
		if (busca.getIdIncidencia() != null) {
			return getIncidencia(incidenciaRepository.findById(busca.getIdIncidencia())
					.orElseThrow(() -> new NoContentException(null)));
		} else if (busca.getFecha() != null) {
			Pattern pattern = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
			Matcher matcher = pattern.matcher(busca.getFecha());
			if (!matcher.matches())
				throw new BadRequestException("La fecha no tiene el formato correcto");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date fecha = formatter.parse(busca.getFecha());
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fecha);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				calendar.set(Calendar.MILLISECOND, 0);
				Date fechaInicio = calendar.getTime();
				calendar.set(Calendar.HOUR_OF_DAY, 23);
				calendar.set(Calendar.MINUTE, 59);
				calendar.set(Calendar.SECOND, 59);
				calendar.set(Calendar.MILLISECOND, 999);
				Date fechaFin = calendar.getTime();
				List<IncidenciaResponseVO> res = new ArrayList<>();
				incidenciaRepository.findByFechaIncidenciaBetween(fechaInicio, fechaFin)
						.forEach(i -> res.add(getIncidencia(i)));
				if (res.isEmpty())
					throw new NoContentException(null);
				return res;
			} catch (ParseException e) {
				throw new BadRequestException("La fecha no tiene el formato correcto");
			}
		} else if (busca.getIdOperador() != null) {
			List<IncidenciaResponseVO> res = new ArrayList<>();
			incidenciaRepository
					.findByOperadorIncidencia(operadorRepository.findById(busca.getIdOperador())
							.orElseThrow(() -> new BadRequestException("El operador no es valido")))
					.forEach(i -> res.add(getIncidencia(i)));
			if (res.isEmpty())
				throw new NoContentException(null);
			return res;
		}
		throw new BadRequestException("Requiere indicar un idIncidencia, fecha o idOperador para realizar la consulta");
	}

	@Override
	public DashboardResponseVO consultaDash() {
		DashboardResponseVO dash = new DashboardResponseVO();
		dash.setAbiertos(incidenciaRepository.findByEstadoIncidencia(EstadoEnum.ABIERTO).size());
		dash.setInsertados(movimientoRepository.findByTipo("INSERCCION").size());
		dash.setResueltos(incidenciaRepository.findByEstadoIncidencia(EstadoEnum.RESUELTO).size());
		dash.setServicioConsultado(movimientoRepository.findByTipo("CONSULTA").size());
		return dash;
	}

}
