package com.beyond.library.result;

import java.util.List;

public interface Paged<T> {

    int getTotal();

    int getPage();

    int getPageSize();

    int getPageCount();

    List<T> getData();

}
