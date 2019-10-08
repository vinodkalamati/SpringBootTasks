package com.stackroute.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {
    @Id
    @ApiModelProperty(notes = "Id of the movie primary key")
    @GeneratedValue
    int id;
    @ApiModelProperty(notes = "Title of the movie")
    String movieTitle;
    @ApiModelProperty(notes = "overview of the movie")
    String overview;
    @ApiModelProperty(notes = "Movie language")
    String language;


}
