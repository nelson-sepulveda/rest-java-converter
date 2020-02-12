package com.javarevolutions.ws.rest.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.javarevolutions.ws.rest.vo.DateConverter;
import com.javarevolutions.ws.rest.vo.VOUsuario;


@Path("/java")
public class ServiceLoginJR 
{
	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON}) 
	@Produces({MediaType.APPLICATION_JSON})
	public VOUsuario validaUsuario(VOUsuario user) {
		if(user.getUsuario().equals("java") && user.getPassword().equals("1234")) {
			user.setUserValido(true);
		}
		user.setPassword("daw5dada05d4aw5d4awd4awda");
		return user;
	}
	
	@POST
	@Path("/converter")
	@Consumes({MediaType.APPLICATION_JSON}) 
	@Produces({MediaType.APPLICATION_JSON})
	public Response converterDateUTC(DateConverter fecha) throws ParseException {
		
		DateFormat formatoOrigen = new SimpleDateFormat("HH:mm:ss");
		DateFormat formatoDestino = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fechados = formatoOrigen.parse(fecha.getHora());
		formatoDestino.setTimeZone(TimeZone.getTimeZone("UTC"));
		String fechaFormato = formatoDestino.format(fechados);
		fecha.setDato2("UTC");
		fecha.setHora(fechaFormato);
		
		return Response.ok(fecha).build();
	}
	
}
