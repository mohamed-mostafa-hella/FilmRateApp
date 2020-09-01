package com.example.filmrate_v1.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class Film implements Parcelable{

    private int id;
    private String url;
    private String imdb_code;
    private String title;
    private String title_english;
    private String title_long;
    private String slug;
    private int year;
    private double rating;
    private int runtime;
    private List<String> genres;
    private String summary;
    private String description_full;
    private String synopsis;
    private String yt_trailer_code;
    private String language;
    private String mpa_rating;
    private String background_image;
    private String background_image_original;
    private String small_cover_image;
    private String medium_cover_image;
    private String large_cover_image;
    private String state;
    private List<Torrent> torrents;
    private String date_uploaded;

    public Film(int id, String url, String imdb_code, String title, String title_english, String title_long, String slug, int year, double rating, int runtime, List<String> genres, String summary, String description_full, String synopsis, String yt_trailer_code, String language, String mpa_rating, String background_image, String background_image_original, String small_cover_image, String medium_cover_image, String large_cover_image, String state, List<Torrent> torrents, String date_uploaded) {
        this.id = id;
        this.url = url;
        this.imdb_code = imdb_code;
        this.title = title;
        this.title_english = title_english;
        this.title_long = title_long;
        this.slug = slug;
        this.year = year;
        this.rating = rating;
        this.runtime = runtime;
        this.genres = genres;
        this.summary = summary;
        this.description_full = description_full;
        this.synopsis = synopsis;
        this.yt_trailer_code = yt_trailer_code;
        this.language = language;
        this.mpa_rating = mpa_rating;
        this.background_image = background_image;
        this.background_image_original = background_image_original;
        this.small_cover_image = small_cover_image;
        this.medium_cover_image = medium_cover_image;
        this.large_cover_image = large_cover_image;
        this.state = state;
        this.torrents = torrents;
        this.date_uploaded = date_uploaded;
    }

    protected Film(Parcel in) {
        id = in.readInt();
        url = in.readString();
        imdb_code = in.readString();
        title = in.readString();
        title_english = in.readString();
        title_long = in.readString();
        slug = in.readString();
        year = in.readInt();
        rating = in.readDouble();
        runtime = in.readInt();
        genres = in.createStringArrayList();
        summary = in.readString();
        description_full = in.readString();
        synopsis = in.readString();
        yt_trailer_code = in.readString();
        language = in.readString();
        mpa_rating = in.readString();
        background_image = in.readString();
        background_image_original = in.readString();
        small_cover_image = in.readString();
        medium_cover_image = in.readString();
        large_cover_image = in.readString();
        state = in.readString();
        date_uploaded = in.readString();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImdb_code() {
        return imdb_code;
    }

    public void setImdb_code(String imdb_code) {
        this.imdb_code = imdb_code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_english() {
        return title_english;
    }

    public void setTitle_english(String title_english) {
        this.title_english = title_english;
    }

    public String getTitle_long() {
        return title_long;
    }

    public void setTitle_long(String title_long) {
        this.title_long = title_long;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription_full() {
        return description_full;
    }

    public void setDescription_full(String description_full) {
        this.description_full = description_full;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getYt_trailer_code() {
        return yt_trailer_code;
    }

    public void setYt_trailer_code(String yt_trailer_code) {
        this.yt_trailer_code = yt_trailer_code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMpa_rating() {
        return mpa_rating;
    }

    public void setMpa_rating(String mpa_rating) {
        this.mpa_rating = mpa_rating;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }

    public String getBackground_image_original() {
        return background_image_original;
    }

    public void setBackground_image_original(String background_image_original) {
        this.background_image_original = background_image_original;
    }

    public String getSmall_cover_image() {
        return small_cover_image;
    }

    public void setSmall_cover_image(String small_cover_image) {
        this.small_cover_image = small_cover_image;
    }

    public String getMedium_cover_image() {
        return medium_cover_image;
    }

    public void setMedium_cover_image(String medium_cover_image) {
        this.medium_cover_image = medium_cover_image;
    }

    public String getLarge_cover_image() {
        return large_cover_image;
    }

    public void setLarge_cover_image(String large_cover_image) {
        this.large_cover_image = large_cover_image;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Torrent> getTorrents() {
        return torrents;
    }

    public void setTorrents(List<Torrent> torrents) {
        this.torrents = torrents;
    }

    public String getDate_uploaded() {
        return date_uploaded;
    }

    public void setDate_uploaded(String date_uploaded) {
        this.date_uploaded = date_uploaded;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(url);
        dest.writeString(imdb_code);
        dest.writeString(title);
        dest.writeString(title_english);
        dest.writeString(title_long);
        dest.writeString(slug);
        dest.writeInt(year);
        dest.writeDouble(rating);
        dest.writeInt(runtime);
        dest.writeStringList(genres);
        dest.writeString(summary);
        dest.writeString(description_full);
        dest.writeString(synopsis);
        dest.writeString(yt_trailer_code);
        dest.writeString(language);
        dest.writeString(mpa_rating);
        dest.writeString(background_image);
        dest.writeString(background_image_original);
        dest.writeString(small_cover_image);
        dest.writeString(medium_cover_image);
        dest.writeString(large_cover_image);
        dest.writeString(state);
        dest.writeString(date_uploaded);
    }
}
