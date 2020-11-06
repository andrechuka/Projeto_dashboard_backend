package br.com.andre.dashboard.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.andre.dashboard.model.Evento;
import br.com.andre.dashboardDTO.VolumeAlarmes;

public interface EventoDAO extends CrudRepository<Evento, Integer>{
	
	public ArrayList<Evento>findAllByDataBetween(LocalDate inicio, LocalDate fim);

	//public ArrayList<VolumeAlarmes>getAllVolumes();
	
	
	@Query("SELECT new br.com.andre.dashboardDTO.VolumeAlarmes(evt.alarme.nome, count(evt.alarme.id))"
			+ " FROM Evento evt "
			+ " WHERE evt.data >= :dataInicio AND evt.data <= :dataFim"
			+ " GROUP BY evt.alarme.id")
	
	public ArrayList<VolumeAlarmes>getAllByDatas(@Param ("dataInicio") LocalDate dataInicio, 
												@Param ("dataFim")LocalDate dataFim);


}
