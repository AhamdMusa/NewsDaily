
package com.brainybrains.newsdaily.fromAPI;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;
    private boolean bigexpandiIt=false;
    private boolean miniexpandiIt=true;

    public boolean isBigexpandiIt() {
        return bigexpandiIt;
    }

    public void setBigexpandiIt(boolean bigexpandiIt) {
        this.bigexpandiIt = bigexpandiIt;
    }

    public boolean isMiniexpandiIt() {
        return miniexpandiIt;
    }

    public void setMiniexpandiIt(boolean miniexpandiIt) {
        this.miniexpandiIt = miniexpandiIt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
