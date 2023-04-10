## Title: [1Week] 박찬규

### 미션 요구사항 분석 & 체크리스트

---
필수미션:  
- [x] 호감대상 삭제기능 구현
    - [x] 삭제 버튼이 있어야 한다.
    - [x] [id="fromInstaMemberId"] 를 파라미터로 넘겨줘야 한다.
    - [x] 삭제에 성공하면 삭제 완료 메시지를 띄운다.
  
선택미션:  
- [x] 구글 로그인 구현
  - [x] application.yml 파일의 민감한 정보 마스킹 

### 1주차 미션 요약

---

**[접근 방법]**

- 다른 사람 코드를 이어서 작성한다는 생각으로 미리 작성된 기능의 코딩 스타일을 참고하며 개발했다.

1. 호감대상 삭제 기능의 경우 호감 목록에서 삭제 버튼을 눌렀을 때, likeablePerson 인스턴스의 id 값을 파라미터로 넘기는 것을 확인했다. 
2. `LikealbePersonController`에 `/likeablePerson/delete/{id}` 경로로 들어온 요청을 처리하는 `delete()` 메서드를 생성하고 
@PreAuthorize("isAuthenticated()") 어노테이션을 붙여 인증된 사용자만 접근 가능하게 했다.
3. `LikeablePersonServie` 에 `deleteByLikeablePersonId()` 메서드를 생성하여 컨트롤러의 `delete()` 메서드로부터 LikeablePerson 인스턴스의
id를 키 값으로 받아 해당 인스턴스를 DB에서 삭제하는 기능을 구현했다.
4. 주소창에 `/likeablePerson/delete/{id}`를 입력하는 등 비정상적인 접근이 이루어진 경우에도 성공적으로 삭제되었다는 메시지를 전달하는데,
id가 존재하지 않는 경우 해당 likeablePerson이 없음을 알리는 메세지를 추가했다.
5. 본인이 아닌 다른 회원이 삭제를 시도할 겨우 접근 제한을 알리는 메시지를 추가했다.
6. 구글 로그인을 사용하기 위해 구글 클라우드에서 Google+ API를 발급받아 `application.yml` 파일에 client-id와 client-secret, scope를 설정해줬다.
7. client-id와 client-secret은 유출되면 악용될 수 있는 민감한 개인 정보이므로 `applicaiton.properties` 설정 파일을 만들어
   해당 id와 비밀번호를 변수로 저장 후 .gitignore에 등록했다.


**[특이사항]**

- 버튼을 통해 제대로 된 경로로 접근하지 않고 주소창에 /likeablePerson/detele/{id}를 치면
존재하지 않는 아이디인데도 삭제되었다는 메시지가 떴다.
- 구글 로그인 api 설정 시 scope: 설정을 안 해주니 로그인 후 제대로 된 인가가 이루어지지 않았다.
- 카카오나 구글 로그인 시 한번 인증을 거치고 나면 로그아웃 후나 서버 재시작 후, 
  링크만 클릭해도 아이디 비밀번호 입력 없이 로그인이 되는데,
  카카오/구글 서버에 저장돼있는 토큰 때문으로 추측된다.

**[Refactoring]**
- [x] 삭제 요청시 RsData를 따로 반환해주는 service 메서드
- [x] LikeablePersonController에서 중복되는 메서드 제거
- [x] 메서드명 가독성 좋게 수정
- [x] 컨트롤러에서는 메시지 전달 처리만 하도록 변경
- [x] delete() 메소드를 @DeleteMapping("/likeablePerson/{id}로 변경)
- [x] 삭제 요청을 delete 요청으로 보내도록 변경
- [x] tests 코드 변경