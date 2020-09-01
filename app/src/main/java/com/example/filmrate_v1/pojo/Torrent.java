package com.example.filmrate_v1.pojo;

public class Torrent {
    private String url;
    private String hash;
    private String quality;
    private String type;
    private int seeds;
    private int peers;
    private String size;
    private String date_uploaded;

    public Torrent(String url, String hash, String quality, String type, int seeds, int peers, String size, String date_uploaded) {
        this.url = url;
        this.hash = hash;
        this.quality = quality;
        this.type = type;
        this.seeds = seeds;
        this.peers = peers;
        this.size = size;
        this.date_uploaded = date_uploaded;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeeds() {
        return seeds;
    }

    public void setSeeds(int seeds) {
        this.seeds = seeds;
    }

    public int getPeers() {
        return peers;
    }

    public void setPeers(int peers) {
        this.peers = peers;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDate_uploaded() {
        return date_uploaded;
    }

    public void setDate_uploaded(String date_uploaded) {
        this.date_uploaded = date_uploaded;
    }
}
