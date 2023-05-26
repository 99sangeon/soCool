package changwonNationalUniv.soCool.controller;

import changwonNationalUniv.soCool.dto.RehabilitationInfoRequest;
import changwonNationalUniv.soCool.dto.response.RehabilitationInfoResponse;
import changwonNationalUniv.soCool.service.RehabilitationInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/rehabilitation")
public class RehabilitationController {

    private final RehabilitationInfoService rehabilitationInfoService;

    @GetMapping( "/list")
    public String list(Model model) {

        List<RehabilitationInfoResponse> rehabilitationInfos = rehabilitationInfoService.findRehabilitationInfos();
        model.addAttribute("rehabilitationInfos", rehabilitationInfos);
        return "/rehabilitation/list";

    }


    @RequestMapping ("/setting")
    public ResponseEntity<Map> setting(@RequestBody RehabilitationInfoRequest rehabilitationInfoRequest) {

        log.info("rehabilitationInfoRequest={}", rehabilitationInfoRequest);

        Long id = rehabilitationInfoService.save(rehabilitationInfoRequest);
        Map<String, Long> map = new HashMap<>();
        map.put("rehabilitationInfoId", id);

        return ResponseEntity.ok(map);
    }

    @RequestMapping("/start")
    public void start(@RequestBody RehabilitationInfoRequest rehabilitationInfoRequest) {

        rehabilitationInfoService.rehabilitationStart(rehabilitationInfoRequest.getRehabilitationInfoId());

    }

    @RequestMapping("/end")
    public void end(@RequestBody RehabilitationInfoRequest rehabilitationInfoRequest) {

        rehabilitationInfoService.rehabilitationEnd(rehabilitationInfoRequest);

    }


}
