package com.gwonsystem.gwonsystem; // <-- 이 부분을 당신의 패키지 이름으로 변경하세요

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReactRouterController {

    @GetMapping(value = "/")
    public String index() {
        return "index.html";
    }

    // `.`(점) 앞의 `\`를 제거하여 경고를 없앱니다.
    @GetMapping(value = "/{path:[^.]*}")
    public String forward() {
        return "forward:/";
    }
}