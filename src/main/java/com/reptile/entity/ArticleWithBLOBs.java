package com.reptile.entity;

public class ArticleWithBLOBs extends Article {
    private byte[] contentCrawl;

    private byte[] detailsTxt;

    private byte[] detailsDiv;

    public byte[] getContentCrawl() {
        return contentCrawl;
    }

    public void setContentCrawl(byte[] contentCrawl) {
        this.contentCrawl = contentCrawl;
    }

    public byte[] getDetailsTxt() {
        return detailsTxt;
    }

    public void setDetailsTxt(byte[] detailsTxt) {
        this.detailsTxt = detailsTxt;
    }

    public byte[] getDetailsDiv() {
        return detailsDiv;
    }

    public void setDetailsDiv(byte[] detailsDiv) {
        this.detailsDiv = detailsDiv;
    }
}