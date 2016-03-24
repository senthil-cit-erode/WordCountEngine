package com.freecharge.problem.wordcount.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.freecharge.problem.wordcount.config.FolderConfig;
import com.freecharge.problem.wordcount.controller.SourceFileRepo;
import com.freecharge.problem.wordcount.controller.WordSearch;
import com.freecharge.problem.wordcount.models.SourceFile;
import com.freecharge.problem.wordcount.models.WordCount;

@Path("/WordCountEngine")
public class SearchWordService {

	static {
		WordSearch.getInstance();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public WordCount countWords(@QueryParam("query") String word) {
		return WordSearch.getInstance().getCount(word);
	}

	@GET
	@Path("/sourceFiles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SourceFile> getSources() {
		return SourceFileRepo.getInstance().getSourceFileList();
	}
}
