package com.mongo.api.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentAllDto {
    private String commentId;
    private String authorId;
    private String postId;
    private String text;
}
