package com.example.mjboard.board;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
    // 1. 화면에 helloworld 출력시키기
    @GetMapping(value="/helloworld/string")
    @ResponseBody
    public String helloWorldString(){
        return "helloWorld";
    }

    // 2. 화면에 {message:helloWorld} 출력시키기
    @GetMapping(value="/helloworld/json")
    @ResponseBody
    public Hello helloWorldJson(){
        Hello hello = new Hello();
        hello.measage = "helloWorld";
        return hello;
    }

    @Setter
    @Getter
    public static class Hello{
        private String measage;
    }

    /**
     * @Controller
     * Spring에 해당 클래스가 Controller라는 것을 알려주기 위해 class명 상단에 붙여서 사용합니다.
     *
     * @GetMapping("RequestURL")
     * 해당 주소의 Resource를 이용하기 위해서 Get method로 호출할 수 있게 하는 어노테이션입니다.
     * 웹 브라우저에서 로컬 호스트 주소 뒤에 코드에 적어준 URL을 붙여서 실행하면 Get방식으로 호출이 됩니다.
     * 위의 예시 코드에서 결과를 웹브라우저에서 확인을 하려면 아래의 주소를 실행하면 됩니다.
     * http://localhost:8080/helloworld/string
     * http://localhost:8080/helloworld/json
     *
     * @ResponseBody
     * 해당 어노테이션은 말 그대로 결과를 그대로 출력한다는 뜻입니다.
     */

}
