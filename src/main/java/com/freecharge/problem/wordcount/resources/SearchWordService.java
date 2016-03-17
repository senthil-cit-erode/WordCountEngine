package com.freecharge.problem.wordcount.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.freecharge.problem.wordcount.controller.WordSearch;
import com.freecharge.problem.wordcount.models.WordCount;

@Path("/WordSearchService")
public class SearchWordService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public WordCount countWords(@QueryParam("query") String word){
		return WordSearch.getInstance().getCount(word);
	}
	
}
