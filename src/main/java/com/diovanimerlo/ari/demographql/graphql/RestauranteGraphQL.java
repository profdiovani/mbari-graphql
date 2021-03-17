package com.diovanimerlo.ari.demographql.graphql;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.diovanimerlo.ari.demographql.domain.Restaurante;
import com.diovanimerlo.ari.demographql.repository.RestauranteRepository;

@Component
public class RestauranteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver{
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	
	public Optional<Restaurante> recuperarRestaurantePorCnpj(String cnpj) {
		return restauranteRepository.findByCnpj(cnpj);
	}
	
	public List<Restaurante> recuperarListaRestaurantes()
	{
		
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
		listaRestaurantes = (ArrayList<Restaurante>) restauranteRepository.findAll();
			
		return listaRestaurantes;
	}
	
	public Restaurante cadastrarRestaurante(Restaurante restaurante) {
		Restaurante restauranteCriado = restauranteRepository.save(restaurante);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(restauranteCriado.getId()).toUri();
		return restauranteCriado;

	}
}
