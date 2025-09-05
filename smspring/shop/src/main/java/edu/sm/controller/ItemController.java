package edu.sm.controller;

import edu.sm.app.dto.Marker;
import edu.sm.app.service.MarkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ItemController {

    private final MarkerService markerService; // map 모듈의 서비스를 주입
    String dir="item/";

    @RequestMapping("/item")
    public String main(Model model) {
        model.addAttribute("center",dir+"center");
        model.addAttribute("left",dir+"left");
        return "index";
    }
    @RequestMapping("/item/add")
    public String chart1(Model model) {
        model.addAttribute("center",dir+"chart1");
        model.addAttribute("left",dir+"left");
        return "index";
    }
    @RequestMapping("/item/get")
    public String chart2(Model model) {
        model.addAttribute("center",dir+"chart2");
        model.addAttribute("left",dir+"left");
        return "index";
    }

    // 루트("/") 또는 "/map" 경로로 접속 시 지도 페이지를 보여줍니다.
    @RequestMapping(value = {"/", "/map"})
    public String map(Model model) {
        model.addAttribute("center", "map/map1");
        model.addAttribute("left", "map/left");
        return "index";
    }

    // "/go" 경로로 접속 시 target ID에 해당하는 가게의 상세 정보를 보여줍니다.
    @RequestMapping("/go")
    public String go(@RequestParam("target") int target, Model model) throws Exception {
        Marker marker = markerService.get(target);
        model.addAttribute("marker", marker);
        model.addAttribute("center", "map/go"); // go.jsp를 중앙 컨텐츠로 설정
        model.addAttribute("left", "map/left");
        return "index";
    }
}