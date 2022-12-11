package com.koli.bvceservices.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieModel {

    @SerializedName("Search")
    public ArrayList<Search> search;
    @SerializedName("totalResults")
    public String totalResults;
    @SerializedName("Response")
    public String response;

    public ArrayList<Search> getSearch() {
        return search;
    }

    public void setSearch(ArrayList<Search> search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public class Search{
        @SerializedName("Title")
        public String title;
        @SerializedName("Year")
        public String year;
        @SerializedName("imdbID")
        public String imdbID;
        @SerializedName("Type")
        public String type;
        @SerializedName("Poster")
        public String poster;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }
    }
}
