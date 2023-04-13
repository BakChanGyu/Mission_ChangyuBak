package com.ll.gramgram.base.appConfig;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

public class AppConfig {
    @Getter
    private static long likeablPersonFromMax;

    @Value("${custom.likeablePerson.from.max}")
    public void setLikeablPersonFromMax(long likeablPersonFromMax) {
        AppConfig.likeablPersonFromMax = likeablPersonFromMax;
    }
}
