package com.example.jao.batch.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.jao.batch.demo.model.Empleado;
@Component
public class JobListener extends JobExecutionListenerSupport{
	private static final Logger LOG= LoggerFactory.getLogger(JobListener.class);
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public JobListener(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus()==BatchStatus.STARTED){
			LOG.info("JobListener:::JOB ARRANCADO");
		}
		if(jobExecution.getStatus()==BatchStatus.COMPLETED){
			LOG.info("JobListener:::JOB FINALIZADO");
			jdbcTemplate.query("SELECT id, nombre, apellidos, telefono, dni, sexo, profesion FROM empleado", 
					(rs, row) -> new Empleado(row, rs.getString(2), rs.getString(3), rs.getString(4) ,rs.getString(5) ,rs.getString(6), rs.getString(7)))
					.forEach(persona -> LOG.info("Registro < " + persona + " >"));
			
			
			/*
			 * List<Empleado> empleados = jdbcTemplate.query(
			 * "SELECT id, nombre, apellidos, telefono, dni, sexo, profesion FROM empleado",
			 * new RowMapper<Empleado>() {
			 * 
			 * @Override public Empleado mapRow(ResultSet rs, int rowNum) throws
			 * SQLException { return new Empleado( rs.getInt("id"), rs.getString("nombre"),
			 * rs.getString("apellidos"), rs.getString("telefono"), rs.getString("dni"),
			 * rs.getString("sexo"), rs.getString("profesion") ); } } );
			 * 
			 * empleados.forEach(empleado -> LOG.info("JobListener:::Empleado registrado: "
			 * + empleado));
			 */
			//jdbcTemplate.query("SELECT id, nombre, apellidos, telefono, dni, sexo, profesion", (rs , row) => new Empleado(rs.getString(0), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)))
		}
		
	}
}
