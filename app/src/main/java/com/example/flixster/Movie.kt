package com.example.flixster

import org.json.JSONArray

data class Movie (
    val movieId: Int,
    private val posterPath: String,
    val title: String,
    val overview: String,
){
    val posterimageurl ="https://image.tmdb.org/t/p/w342/$posterPath"

    companion object{
        fun fromJsonArray(moviejsonarray: JSONArray):List<Movie> {
            val movies = mutableListOf<Movie>()
            for(i in 0 until moviejsonarray.length()){
                val movieJson = moviejsonarray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }

    }

}