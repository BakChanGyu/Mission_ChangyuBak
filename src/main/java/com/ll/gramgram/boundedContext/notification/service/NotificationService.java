package com.ll.gramgram.boundedContext.notification.service;

import com.ll.gramgram.base.rsData.RsData;
import com.ll.gramgram.boundedContext.instaMember.entity.InstaMember;
import com.ll.gramgram.boundedContext.likeablePerson.entity.LikeablePerson;
import com.ll.gramgram.boundedContext.notification.entity.Notification;
import com.ll.gramgram.boundedContext.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public List<Notification> findByToInstaMember(InstaMember toInstaMember) {
        List<Notification> notifications = notificationRepository.findByToInstaMember(toInstaMember);

        notifications.stream()
                .forEach(notification -> notification.setReadDate(LocalDateTime.now()));
        Collections.reverse(notifications);
        return notifications;
    }

    public RsData save(LikeablePerson likeablePerson, String typeCode, int oldAttractiveTypeCode) {
        Notification notification = new Notification()
                .builder()
                .fromInstaMember(likeablePerson.getFromInstaMember()) // 호감을 표시하는 사람의 인스타 멤버
                .toInstaMember(likeablePerson.getToInstaMember()) // 호감을 받는 사람의 인스타 멤버
                .typeCode(typeCode)
                .newGender(likeablePerson.getFromInstaMember().getGender())
                .oldAttractiveTypeCode(oldAttractiveTypeCode)
                .newAttractiveTypeCode(likeablePerson.getAttractiveTypeCode()) // 1=외모, 2=능력, 3=성격
                .build();

        notificationRepository.save(notification);

        return RsData.of("S-1", "알림을 생성했습니다.");
    }
}
