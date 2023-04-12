## Title: [2Week] 박찬규

### 미션 요구사항 분석 & 체크리스트

---
필수미션:  
- [x] 중복 호감표시 방지
- [x] 11명 이상의 호감상대 등록 불가
- [x] 호감표시 사유 수정
  
선택미션:  
- [x] 네이버 로그인 구현

### 2주차 미션 요약

---

**[접근 방법]**

1. 필수 미션부터 시작, 중복 호감표현 방지를 위해 기존의 호감상대 리스트를 가져와서 username으로 비교했다.
2. 호감상대 리스트 길이가 10이상일땐 rq.historyback() 해줬다.
3. 중복이면서 attractiveCodeType이 같지 않으면 해당 호감상대 정보를 업데이트 했다.
4. 선택 미션에서 응답으로 받은 데이터의 RegistrationId가 "NAVER" 인 경우 oauthId를 response의 id 값으로 재정의해줬다.

**[특이사항]**

- 네이버 로그인시 application.yml 파일에 user-name-attribute 옵션을 response로 설정해주고 response 속성값을 가져왔는데 바로 id 값을 가져오는 방법이 있는지 궁금하다.

**[Refactoring]**
- [ ] LikeablePersonController에 update() 메서드 생성하여 add() 에서 redirect 처리
- [ ] LikeablePersonService에 vaild() 메서드 생성하여 검증로직 처리