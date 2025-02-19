package com.example.demo.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageData<T> {
    private int total;
    private T list;
}
