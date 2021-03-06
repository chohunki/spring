


-로그인이란?
 접근 허가 증명을 얻기 위해 사용자 인증으로 개인이 컴퓨터 시스템에 접근하는 작업
 
 -쿠키(Cookie)와 세션(Session)을 사용하는 이유
 
 HTTP 프로토콜에는 비연결성(Connectionless)과 비상태성(Stateless)라는 특징이 있습니다. 모든 사용자의 요청마다 연결과 해제의 과정을 거치면서 연결 상태를 유지하지 않고 연결 해제 후에도 상태 정보를 저장하지 않기 때문에 서버의 자원을 크게 절약할 수 있습니다. 하지만 이로 인해 사용자를 식별할 수 없어서 같은 사용자가 요청을 여러번 하더라도 매번 새로운 사용자로 인식하는 단점이 있습니다.
하지만 우리가 사용하고 있는 웹사이트를 생각해보면 로그인을 한 번 하고나면 그 사이트에서는 다시 로그인할 필요 없이 여러 페이지의 기능들을 이용할 수 있고 심지어 브라우저를 종료했다가 나중에 다시 접속했을 때도 그 로그인 상태를 유지할 수도 있습니다. 이런 HTTP의 비상태, 비연결의 특성들을 보완한 기술이 쿠키와 세션입니다.

쿠키는 서버를 대신해서 이러한 정보들을 웹 브라우저에 저장(정확히 하면 웹 브라우저를 이용하고 있는 컴퓨터에 저장)하고 사용자가 요청을 할 때 그 정보를 함께 보내서 서버가 사용자를 식별할 수 있게 해줍니다. 이로써 로그인 기능도 이용할 수 있고 사용자에 맞게 사용자마다 다른 정보를 제공할 수 있게 되는데 이 웹브라우저에 저장되는 데이터를 쿠키라고 합니다.

쿠키는 주로 아래의 세 가지 목적을 위해 사용됩니다.

1. 세션 관리(Session Management)
로그인, 사용자 닉네임, 접속 시간, 장바구니 등의 서버가 알아야할 정보들을 저장합니다.

2. 개인화(Personalization)
사용자마다 다르게 그 사람에 적절한 페이지를 보여줄 수 있습니다.

3. 트래킹(Tracking)
사용자의 행동과 패턴을 분석하고 기록합니다.

세션은 쿠키를 이용합니다. 어떤 웹 브라우저가 서버에 요청을 하면 서버는 세션 아이디를 할당해서 응답할 때 함께 전달합니다. 웹 브라우저는 이 세션 아이디를 쿠키에 저장해두고 매 요청마다 세션 아이디를 함께 전달합니다. 서버는 세션 아이디를 바탕으로 사용자를 식별하고 사용자의 데이터를 서버에 저장하여 관리합니다.

-쿠키(Cookie)
Set-Cookie, Cookie Header
쿠키는 서버가 사용자의 웹 브라우저에 저장하는 데이터라고 했습니다. 쿠키의 데이터 형태는 Key 와 Value로 구성되고 String으로만 이루어져 있습니다. 4KB 이상 저장할 수는 없습니다.
HTTP의 일종으로 사용자가 어떠한 웹 사이트를 방문할 경우, 그 사이트가 사용하고 있는 서버에서 사용자의 컴퓨터에 저장하는 작은 기록 정보 파일이다.
브라우저마다 저장되는 쿠키는 다릅니다. (크롬으로 남긴 쿠키는 인터넷 익스플로어에서 사용할 수 없습니다.) 서버에서는 브라우저가 다르면 다른 사용자로 인식합니다.
HTTP에서 클라이언트의 상태 정보를 클라이언트의 PC에 저장하였다가 필요시 정보를 참조하거나 재사용할 수 있다.


-쿠키 특징

이름, 값, 만료일(저장 기간 설정), 경로 정보로 구성되어 있다.
클라이언트에 총 300개의 쿠키를 저장할 수 있다.
하나의 도메인 당 20개의 쿠키를 가질 수 있다
하나의 쿠키는 4KB(=4096byte)까지 저장 가능하다.

-쿠키의 동작 순서

클라이언트가 페이지를 요청한다. (사용자가 웹사이트 접근)
웹 서버는 쿠키를 생성한다.
생성한 쿠키에 정보를 담아 HTTP 화면을 돌려줄 때,
같이 클라이언트에게 돌려준다.
넘겨 받은 쿠키는 클라이언트가 가지고 있다가(로컬 PC에 저장)
다시 서버에 요청할 때 요청과 함께 쿠키를 전송한다.
동일 사이트 재방문시 클라이언트의 PC에 해당 쿠키가 있는 경우,
요청 페이지와 함께 쿠키를 전송한다.

-사용 예시

방문했던 사이트에 다시 방문 하였을 때 아이디와 비밀번호 자동 입력
팝업창을 통해 "오늘 이 창을 다시 보지 않기" 체크


-세션(Session)

일정 시간동안 같은 사용자(브라우저)로부터 들어오는
일련의 요구를 하나의 상태로 보고, 그 상태를 일정하게 유지시키는 기술이다.

여기서 일정 시간은 방문자가 웹 브라우저를 통해
웹 서버에 접속한 시점으로부터 웹 브라우저를 종료하여 연결을 끝내는 시점을 말한다.

즉, 방문자가 웹 서버에 접속해 있는 상태를 하나의 단위로 보고 그것을 세션이라고 한다.


-세션 특징
웹 서버에 웹 컨테이너의 상태를 유지하기 위한 정보를 저장한다.
웹 서버의 저장되는 쿠키(=세션 쿠키)
브라우저를 닫거나, 서버에서 세션을 삭제했을때만 삭제가 되므로,
쿠키보다 비교적 보안이 좋다.
저장 데이터에 제한이 없다.(서버 용량이 허용하는 한...)
각 클라이언트 고유 Session ID를 부여한다.
Session ID로 클라이언트를 구분하여 각 클라이언트 요구에 맞는 서비스 제공

-세션의 동작 순서
클라이언트가 페이지를 요청한다. (사용자가 웹사이트 접근)
서버는 접근한 클라이언트의 Request-Header 필드인 Cookie를 확인하여,
클라이언트가 해당 session-id를 보냈는지 확인한다.
session-id가 존재하지 않는다면,
서버는 session-id를 생성해 클라이언트에게 돌려준다.
서버에서 클라이언트로 돌려준 session-id를 쿠키를 사용해 서버에 저장한다.
쿠키 이름 : JSESSIONID
클라이언트는 재접속 시,
이 쿠키(JSESSIONID)를 이용하여 session-id 값을 서버에 전달

-사용 예시
화면이 이동해도 로그인이 풀리지 않고 로그아웃하기 전까지 유지


출처: https://hahahoho5915.tistory.com/32 [넌 잘하고 있어]




![image](https://user-images.githubusercontent.com/80931911/111965892-9be7f980-8b39-11eb-827c-f274b6d23aa5.png)

1. 사용자가 로그인을 한다.
2. 서버에서는 계정정보를 읽어 사용자를 확인한 후, 사용자의 고유한 ID값을 부여하여 세션 저장소에 저장한 후, 이와 연결되는 세션ID를 발행합니다.
3. 사용자는 서버에서 해당 세션ID를 받아 쿠키에 저장을 한 후, 인증이 필요한 요청마다 쿠키를 헤더에 실어 보냅니다.
4. 서버에서는 쿠키를 받아 세션 저장소에서 대조를 한 후 대응되는 정보를 가져옵니다.
5. 인증이 완료되고 서버는 사용자에 맞는 데이터를 보내줍니다.


![image](https://user-images.githubusercontent.com/80931911/111969114-3e55ac00-8b3d-11eb-81e4-ce3d535d70fc.png)

![image](https://user-images.githubusercontent.com/80931911/111969536-b328e600-8b3d-11eb-8b5e-3a852c8b06f5.png)
