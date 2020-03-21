package com.example.scientificCentralService.dto;




import com.example.scientificCentralService.elastic.ArticleIndexUnit;

public class BasicQueryResponseDTO {

    ArticleIndexUnit article;
    String highlights;
    
    public BasicQueryResponseDTO(ArticleIndexUnit article, String highlights) {
        this.article = article;
        this.highlights = highlights;
    }

    public BasicQueryResponseDTO() {
    }

	public ArticleIndexUnit getArticle() {
		return article;
	}

	public void setArticle(ArticleIndexUnit article) {
		this.article = article;
	}

	public String getHighlights() {
		return highlights;
	}

	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}

   
}
