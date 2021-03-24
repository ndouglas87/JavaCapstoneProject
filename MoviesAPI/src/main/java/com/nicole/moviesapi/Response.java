/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicole.moviesapi;

import java.util.List;

/**
 *
 * @author newtonacho
 */
public class Response{
    public int page;
    public List<Result> results;
    public int total_pages;
    public int total_results;
}