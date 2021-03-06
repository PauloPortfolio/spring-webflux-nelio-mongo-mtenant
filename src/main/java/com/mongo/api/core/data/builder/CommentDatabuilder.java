package com.mongo.api.core.data.builder;

import com.github.javafaker.Faker;
import com.mongo.api.core.dto.UserAuthorDto;
import com.mongo.api.modules.comment.Comment;
import com.mongo.api.modules.user.User;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Builder
@Getter
public class CommentDatabuilder {

    private final Comment commentDataBuilder;

    private static final ModelMapper converter = new ModelMapper();

    private final static Faker faker = new Faker(new Locale("en-BR"));

    @Default
    private static String id;

    @Default
    private static Date date;

    @Default
    private static String text;

    @Default
    private static User author;


    @SneakyThrows
    public static CommentDatabuilder commentNullIdAuthorParam(User user) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Comment comment = new Comment();
        comment.setCommentId(null);
        comment.setDate(sdf.parse("11/11/2011"));
        comment.setText(faker.lorem()
                             .sentence());
        comment.setAuthor(converter.map(user,UserAuthorDto.class));

        return CommentDatabuilder.builder()
                                 .commentDataBuilder(comment)
                                 .build();
    }


    public Comment create() {
        return this.commentDataBuilder;
    }
}
