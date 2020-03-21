package com.example.scientificCentralService.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scientificCentralService.domain.Article;
import com.example.scientificCentralService.domain.Coauthor;
import com.example.scientificCentralService.dto.AdvancedQuerySendDTO;
import com.example.scientificCentralService.dto.BasicQueryResponseDTO;
import com.example.scientificCentralService.dto.ReviewerRequestDTO;
import com.example.scientificCentralService.dto.UserDTO;
import com.example.scientificCentralService.elastic.ArticleIndexUnit;
import com.example.scientificCentralService.elastic.ReviewerIndexUnit;
import com.example.scientificCentralService.service.ArticleService;
import com.example.scientificCentralService.service.CoauthorServices;
import com.example.scientificCentralService.service.ContentService;
import com.example.scientificCentralService.service.UserService;
import com.google.gson.Gson;


@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "http://localhost:4200")
public class SearchController {
	
	 @Autowired
	 private Client nodeClient;
	 
	 @Autowired
	 private ArticleService as;
	 
	 @Autowired
	 private ContentService cs;
	 
	 @Autowired
	 private CoauthorServices coauthorService;

	
	private HighlightBuilder highlightBuilder = new HighlightBuilder()
            .field("content", 50)
            .field("heading", 50)
            .field("author", 50)
            .field("coauthor", 50)
            .field("abs", 50)
            .field("keyterms", 50)
            .field("magazine", 50)
            .field("mainSC", 50);
	
	private HighlightBuilder highlightBuilderAdvanced = new HighlightBuilder()
            .field("content", 50)
            .field("heading", 50)
            .field("author", 50)
            .field("coauthor", 50)
            .field("abs", 50)
            .field("keyterms", 50)
            .field("magazine", 50)
            .field("mainSC", 50);
	
	 @PostMapping(value="/basic/{field}", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity basicQuery(@PathVariable String field, @RequestBody String query) throws ParseException {
	        System.out.println("Query: " + query);
	       
	        ArrayList<BasicQueryResponseDTO> retVal = new ArrayList<>();

	        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
	        highlightBuilder.highlightQuery(QueryBuilders.queryStringQuery(query));

	        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(query);
	        if (!field.equals("all")) {
	        	 queryStringQueryBuilder.field(field);
	        }
	        
	        QueryStringQueryBuilder app = new QueryStringQueryBuilder("true");
	        app.field("approved");
	      
	        queryStringQueryBuilder.analyzer("serbian");
	        boolQuery.must(queryStringQueryBuilder);
	        boolQuery.must(app);
	        SearchRequestBuilder request = nodeClient.prepareSearch("articleindexnova")
	                .setQuery(boolQuery)
	                .setSearchType(SearchType.DEFAULT)
	                .highlighter(highlightBuilder);
	        SearchResponse response = request.execute().actionGet();
	        System.out.println(response.toString());
	        retVal = getResponse(response);

	        return new ResponseEntity(retVal, HttpStatus.OK);

	    }
	 
	 @PostMapping(value="/advanced", consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity advancedQuery(@RequestBody List<AdvancedQuerySendDTO> listQuery) throws ParseException {
	        ArrayList<BasicQueryResponseDTO> retVal = new ArrayList<>();

	        for (AdvancedQuerySendDTO advanced : listQuery) {
	        	System.out.println(advanced.getField() + " " +advanced.getOperation() + " " + advanced.isPhrase() + " " + advanced.getQuery());
	        }
	        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
	        boolQuery.must(QueryBuilders.matchQuery("approved", "true"));
	        
	        for (AdvancedQuerySendDTO advanced : listQuery) {
	        	if (advanced.getQuery()!=null && !advanced.getQuery().isEmpty()) {	//da li je ista upisao u query
	        		if (advanced.getOperation().equals("AND")) {					//koji je operator
	        			if (advanced.isPhrase()) {		        					//da li je fraza
	        				
	        				if (advanced.getField().equals("all")) {
	        					boolQuery.must(QueryBuilders.multiMatchQuery(advanced.getQuery(), "heading", "keyterms", "abs",
	                                    "mainSC", "magazine", "content", "author", "coauthor").type("phrase").analyzer("serbian"));
	        				}else {
	        					boolQuery.must(QueryBuilders.matchPhraseQuery(advanced.getField(), advanced.getQuery().toLowerCase()).analyzer("serbian"));
	        				}
	        				
	        				
	        			}else {
	        				
	        				if (advanced.getField().equals("all")) {
	        					boolQuery.must(QueryBuilders.multiMatchQuery(advanced.getQuery(), "heading", "keyterms", "abs",
	                                    "mainSC", "magazine", "content", "author", "coauthor").analyzer("serbian"));
	        				}else {
	        					boolQuery.must(QueryBuilders.matchQuery(advanced.getField(), advanced.getQuery().toLowerCase()).analyzer("serbian"));
	        				}
	        				
	        			}
	        		}else if (advanced.getOperation().equals("OR")) {
	        			if (advanced.isPhrase()) {		
	        				
	        				if (advanced.getField().equals("all")) {
	        					boolQuery.should(QueryBuilders.multiMatchQuery(advanced.getQuery(),"heading", "keyterms", "abs",
	                                    "mainSC", "magazine", "content", "author", "coauthor").type("phrase").analyzer("serbian"));
	        				}else {
	        					boolQuery.should(QueryBuilders.matchPhraseQuery(advanced.getField(), advanced.getQuery().toLowerCase()).analyzer("serbian"));
	        				}
	        				
	        			}else {
	        				
	        				if (advanced.getField().equals("all")) {
	        					boolQuery.should(QueryBuilders.multiMatchQuery(advanced.getQuery(), "heading", "keyterms", "abs",
	                                    "mainSC", "magazine", "content", "author", "coauthor").analyzer("serbian"));
	        				}else {
	        					boolQuery.should(QueryBuilders.matchQuery(advanced.getField(), advanced.getQuery().toLowerCase()).analyzer("serbian"));
	        				}
	        			}
	        		}
	        	}
	        }
	        
	     
	        SearchRequestBuilder request = nodeClient.prepareSearch("articleindexnova")
	                .setQuery(boolQuery)
	                .setSearchType(SearchType.DEFAULT)
	                .highlighter(highlightBuilderAdvanced);
	        System.out.println(request);
	        
	        SearchResponse response = request.execute().actionGet();
	        System.out.println(response.toString());
	        retVal = getResponse(response);
	        System.out.println(retVal.size());

	        return new ResponseEntity(retVal, HttpStatus.OK);

	    }
	 
	 
	 @PostMapping(value="/searchReviewers/{idArticle}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<UserDTO>> reviewersQuery(@PathVariable String idArticle,@RequestBody ReviewerRequestDTO requestDTO) throws ParseException, IOException {
		 	Long id = Long.parseLong(idArticle);
		 	List<String> queryScientificFields = requestDTO.getFields();
		 	System.out.println("isMoreLikeThis " + requestDTO.isMoreLikeThis());
		 	System.out.println("isInDomain " + requestDTO.isInDomain());
		 	
	        for (String s : queryScientificFields) {
	        	System.out.println("Query: " + s);
	        }
	        
	        HashMap<Long, ReviewerIndexUnit> map = new HashMap<Long, ReviewerIndexUnit>();
	        ArrayList<ReviewerIndexUnit> reviewers = new ArrayList<>();
	        Article article = as.findOneById(id);

	        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
	        
	        
	        if(queryScientificFields.size()!=0) {
	            for (String field : queryScientificFields) {
	                MatchPhraseQueryBuilder mpqb = new MatchPhraseQueryBuilder("scientificFields", field);
	                mpqb.analyzer("serbian");
	                boolQuery.must(mpqb);
	            }
	        }
	        
	        //more like this
	        if(requestDTO.isMoreLikeThis()){
	            String[] likeThis = new String[1];
	            likeThis[0]=cs.getContent(article.getUrl(),"reviewer");
	            //System.out.println(likeThis[0]);
	            String[] fields = new String[1];
	            fields[0] = "contentOfReview";
	            MoreLikeThisQueryBuilder mltqb=new MoreLikeThisQueryBuilder(fields, likeThis,null );
	            mltqb.maxQueryTerms(10);
	            mltqb.minTermFreq(1);
	            mltqb.minimumShouldMatch("85%");
	            mltqb.minDocFreq(1);
	            mltqb.analyzer("serbian");
	            boolQuery.must(mltqb);
	            
	        }
	        
	        
	        if(requestDTO.isInDomain()){
	        	boolQuery.mustNot(QueryBuilders.geoDistanceQuery("location").
	        			point(article.getAuthor().getLatitude(), article.getAuthor().getLongitude()).distance(100, DistanceUnit.KILOMETERS));
	            
	            List<Coauthor> listCoauthors = coauthorService.findAllByArticle(article);
	            for (Coauthor co : listCoauthors) {
	            	boolQuery.mustNot(QueryBuilders.geoDistanceQuery("location").point(co.getLatitude(), co.getLongitude()).distance(100, DistanceUnit.KILOMETERS));
	            	/*GeoDistanceQueryBuilder gdqbCoauthor = new GeoDistanceQueryBuilder("location");
	            	gdqbCoauthor.distance(100, DistanceUnit.KILOMETERS);
		            System.out.println("CO LAT " +co.getLatitude() + " CO LONG " + co.getLongitude());
		            gdqbCoauthor.point(co.getLongitude(),co.getLatitude() );
		            boolQuery.mustNot(gdqbCoauthor);*/
	            }
	        }
	        
	        SearchRequestBuilder request = nodeClient.prepareSearch("reviewerindex")
	                .setQuery(boolQuery)
	                .setSearchType(SearchType.DEFAULT);
	        System.out.println("request" + request);
	        SearchResponse response = request.get();	        
	        //SearchResponse response = request.execute().actionGet();
	        
	        System.out.println(response.toString());
	        
	        //uzimam reviewere iz hits-a
	        for(SearchHit hit : response.getHits().getHits()) {
	            Gson gson = new Gson();
	            System.out.println("hit " + hit.toString());
	            ReviewerIndexUnit riu = gson.fromJson(hit.getSourceAsString(), ReviewerIndexUnit.class);
	            Long idDTO = gson.fromJson(hit.getSourceAsString(), ReviewerIndexUnit.class).getIdReviewer();
	            ReviewerIndexUnit rec = new ReviewerIndexUnit(riu.getName(), riu.getSurname(), riu.getCity(), riu.getState());
	            if (!map.containsKey(idDTO)) {
	            	map.put(idDTO, rec);
	            }
	        
	        }
	        
	        for (Entry<Long, ReviewerIndexUnit> me : map.entrySet()) {
	        	reviewers.add(me.getValue());
	        }

	        return new ResponseEntity(reviewers, HttpStatus.OK);

	    }
	 
	 private ArrayList<BasicQueryResponseDTO> getResponse(SearchResponse response){
	        ArrayList<BasicQueryResponseDTO> retVal = new ArrayList<>();
	        for(SearchHit hit : response.getHits().getHits()) {
	            Gson gson = new Gson();
	            BasicQueryResponseDTO basicQueryResponseDTO = new BasicQueryResponseDTO();

	            ArticleIndexUnit object = gson.fromJson(hit.getSourceAsString(), ArticleIndexUnit.class);
	            basicQueryResponseDTO.setArticle(object);

	            String allHighlights = "...";

	            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
	            for (Map.Entry<String, HighlightField> entry : highlightFields.entrySet()){
	               
	                String value = Arrays.toString(entry.getValue().fragments());
	                
	                //substring zbog uglastih zagrada fragmenata na pocetku i kraju
	                allHighlights+=value.substring(1, value.length()-1);
	                allHighlights+="...";
	            }

	            allHighlights = allHighlights.replace("<em>", "<b>");
	            allHighlights = allHighlights.replace("</em>", "</b>");
	            System.out.println(allHighlights);
	            basicQueryResponseDTO.setHighlights(allHighlights);
	            retVal.add(basicQueryResponseDTO);
	        }
	        return retVal;
	    }

}
