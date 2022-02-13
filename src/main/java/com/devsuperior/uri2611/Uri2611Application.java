package com.devsuperior.uri2611;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MovieMinProjection> list1 = repository.search1("Action");
		System.out.println("\n*** RESULTADO SQL RAIZ:");
		list1.stream().map(x -> new MovieMinDTO(x)).forEach(System.out::println);

		System.out.println("\n\n");

		List<MovieMinDTO> list2 = repository.search2("Action");
		System.out.println("\n*** RESULTADO JPQL:");
		list2.stream().forEach(System.out::println);
	}

}
