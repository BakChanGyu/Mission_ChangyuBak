package com.ll.gramgram.base.appConfig;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

public class AppConfig {
    @Getter
    private static long likeablePersonFromMax;


    @Value("${custom.likeablePerson.from.max}")
    public void setLikeablePersonFromMax(long likeablPersonFromMax) {
        AppConfig.likeablePersonFromMax = likeablPersonFromMax;
    }
}
