package com.museum.model.filter;

import com.museum.model.filter.util.FilterUtil;
import com.museum.model.request.ShowpieceFilterRequest;

public class ShowpieceFilter {

    private final Integer authorId;

    private final Integer hallId;

    private final Integer guardianId;


    public ShowpieceFilter(Integer authorId, Integer hallId, Integer guardianId) {
        this.authorId = authorId;
        this.hallId = hallId;
        this.guardianId = guardianId;
    }

    public static ShowpieceFilter of(ShowpieceFilterRequest request) {
        return new ShowpieceFilter(
                FilterUtil.parseInteger(request.getAuthorId()),
                FilterUtil.parseInteger(request.getHallId()),
                FilterUtil.parseInteger(request.getGuardianId()));
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public Integer getHallId() {
        return hallId;
    }

    public Integer getGuardianId() {
        return guardianId;
    }
}
