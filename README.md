# Spring   

## Spring structure   
<img src="https://user-images.githubusercontent.com/88373857/147024829-25f6a20f-6e47-4b80-812a-37ac4895ba6d.jpg" width="500" height="500">

프로젝를 최초로 생성하면 필요한 코드와 라이브러리를 다운로드 한다   
사용자 폴더 내 **'.m2/repository'** 폴더 안에는 프로젝트 생성 시 다운로드된 파일들이 추가된다.   

## Spring의 주요 특징
* **POJO 기반의 구성**      
  - JAVA 코드를 이용해서 객체를 구성하는 방식을 그대로 스프링에서 사용할 수 있다
  - 코드를 개발할 때 개발자가 특정한 라이브러리나 컨테이너의 기술에 종속적이지 않다는 것을 의미   
  - 생산성, 코드에 대한 테스트 작업 유연   
  
* **의존성 주입(DI)을 통한 객체 간의 관계 구성**    
  - **의존성** : 하나의 객체가 다른 객체 없이 제대로 된 역할을 할 수 없다는 것을 의미   
  - **주입** : 어떤 객체가 필요한 객체를 외부에서 밀어 넣는 것을 의미   
  - **외부에서 객체를 주입하는 이유** : 주입을 받는 입장에서는 어떤 객체인지 신경 쓸 필요가 없기 때문이다   
  - **ApplicationContext**가 필요한 객체들을 생성하고, 필요한 객체들을 주입하는 역할   
<img src="https://user-images.githubusercontent.com/88373857/147059695-80f66cf2-066b-4a79-ae21-77f0608082eb.jpg" width="500" height="300">
 
* **AOP 지원**   
  - 반드시 처리가 필요한 부분(횡단 관심사)을 모듈로 분리하여 제작하는 것   
  
* **편리한 MVC 구조**   

* **WAS의 종속적이지 않은 개발 환경**   

## Annotation   
**@Component** : 해당 클래스가 스프링에서 관리해야 할 대상임을 명시   
**@Data** : setter, getter, 생성자, toString()등을 자동으로 생성, 결합한 형태로 한 번에 자주 사용되는 모든 메서드들을 생성(세부적인 설정이 필요 없는 경우라면 @Data를 이용)   
**@Configuration** : 1개 이상의 @Bean을 제공하는 class의 경우 반드시 명시해야 함
**@ComponentScan** : 해당 패캐지에 있는 클래스들을 조사하면서 @Component가 존재하는 클래스들을 객체로 생성하여 빈으로 관리(root-context.xml와 같은 역할 : bean)
**@RunWith** : 지정한 클래스를 이용해 테스트 메소드를 수행하도록 지정   
**@ContextConfiguration** : 스프링이 실행되면서 어떤 설정 정보를 읽어 들여야 하는지 명시   
**@Logger** : Lombok을 이용해서 로그를 기록하는 Logger를 변수로 생성   
**@Autowired** : 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해 달라는 표시   
**@Test** : JUnit에서 해당 메서드가 jUnit 상에서 단위 테스트의 대상인지를 알려줌   
**@AllArgsConstructor** : 인스턴스 변수로 선언된 모든 것을 파라미터로 받는 생성자를 작성   
**@RequiredArgsConstructor** : 여러 개의 인스턴스 변수들 중에서 특정한 변수에 대해서만 생성자를 작성(@NonNull, final이 붙은 인스턴스 변수에 대한 생성자를 만듦)   
**@NonNull** : null값을 허용하지 않는다   



