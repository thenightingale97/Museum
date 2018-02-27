package com.museum.service;

import com.museum.entity.Author;
import com.museum.model.view.AuthorView;

public interface AuthorService extends Service<Author, Integer> {
    void save(AuthorView authorView);
}
