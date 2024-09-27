package com.example.Heredar;

import com.example.Heredar.entidades.Profesor;
import com.example.Heredar.enumeraciones.Titulos;
import com.example.Heredar.repositorios.AlumnoRepository;
import com.example.Heredar.repositorios.PersonaRepository;
import com.example.Heredar.repositorios.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class HeredarApplication {
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	ProfesorRepository profesorRepository;
	@Autowired
	AlumnoRepository alumnoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HeredarApplication.class, args);
		System.out.println("Funcionando Single Table");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepository,AlumnoRepository alumnoRepository, ProfesorRepository profesorRepository){
		return args -> {
			System.out.println("FUNCIONANDO");
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fechaString= "2024-09-23";
			Date fecha = formatoFecha.parse(fechaString);

			Profesor profesor = Profesor.Builder()
					.nombre("Alfredo")
					.apellido("Sanchez")
					.edad(40)
					.cantHijos(2)
					.sueldo(3.14)
					.titulo(Titulos.INGENIERO)
					.fechaIngreso(fecha)
					.build();

			profesorRepository.save(profesor);


		};

	}

}
