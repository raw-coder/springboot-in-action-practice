@SpringBootApplication 은 아래 3개의 annotation 을 포함함

- @Configuration : 스프링의 자바 기반 구성 클래스로 지정
- @ComponentScan : 웹 컨트롤러 클래스나 다른 컴포넌트 클래스를 자동으로 검색하여 스프링 애플리케이션 컨텍스트에 빈으로 등록
- @EnableAutoConfiguration : 스프링 부트 자동 구성

스프링 부트는 스타터 의존성 으로 의존성 문제를 해결

- 하나의 스타터는 필요한 라이브러리들의 의존성을 포함함
- 스타터에 대한 버전을 명시할 필요는 없음
- 스타터 의존성 버전은 스프링 부트 버전에 따라 결정됨 
- 스타터 의존성에 포함된 라이브러리를 제외할 수 있음
- 스타터 의존성에 포함된 라이브러리 다른 버전의 의존성을 추가할 수 있음 
