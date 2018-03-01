package com.museum.model.filter;

import com.museum.model.request.ShowpieceFilterRequest;

public class ShowpieceFilter {

    private final Integer authorId;

    private final Integer hallId;


    public ShowpieceFilter(Integer authorId, Integer hallId) {
        this.authorId = authorId;
        this.hallId = hallId;
    }

    public static ShowpieceFilter of(ShowpieceFilterRequest request) {
        return new ShowpieceFilter(
                Integer.parseInt(request.getAuthorId()), Integer.parseInt(request.getHallId()));
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public Integer getHallId() {
        return hallId;
    }
}
