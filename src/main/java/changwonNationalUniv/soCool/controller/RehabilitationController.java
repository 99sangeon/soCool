package changwonNationalUniv.soCool.controller;

import changwonNationalUniv.soCool.dto.RehabilitationInfoRequest;
import changwonNationalUniv.soCool.dto.response.BiologicalInfoResponse;
import changwonNationalUniv.soCool.dto.response.RehabilitationInfoResponse;
import changwonNationalUniv.soCool.service.BiologicalInfoService;
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
public class   RehabilitationController {

    private final RehabilitationInfoService rehabilitationInfoService;
    private final BiologicalInfoService biologicalInfoService;

    @GetMapping( "/list")
    public String list(Model model) {

        List<RehabilitationInfoResponse> rehabilitationInfos = rehabilitationInfoService.findRehabilitationInfos();
        model.addAttribute("rehabilitationInfos", rehabilitationInfos);

        return "/rehabilitation/list";
    }

    @GetMapping( "/detail/{rehabilitationInfoId}")
    public String detail(@PathVariable("rehabilitationInfoId") Long rehabilitationInfoId, Model model) {

        RehabilitationInfoResponse rehabilitationInfo = rehabilitationInfoService.findRehabilitationInfo(rehabilitationInfoId);
        List<BiologicalInfoResponse> biologicalInfos = biologicalInfoService.findBiologicalInfos(rehabilitationInfoId);

        model.addAttribute("rehabilitationInfo", rehabilitationInfo);
        model.addAttribute("biologicalInfos",biologicalInfos);

        return "/rehabilitation/detail";
    }


    @RequestMapping ("/setting")
    public ResponseEntity<Map> setting(@RequestBody RehabilitationInfoRequest rehabilitationInfoRequest) {

        Long id = rehabilitationInfoService.save(rehabilitationInfoRequest);
        Map<String, Long> map = new HashMap<>();
        map.put("rehabilitationInfoId", id);

        return ResponseEntity.ok(map);
    }

    @RequestMapping("/start")
    public ResponseEntity start(@RequestBody RehabilitationInfoRequest rehabilitationInfoRequest) {

        rehabilitationInfoService.rehabilitationStart(rehabilitationInfoRequest.getRehabilitationInfoId());

        return ResponseEntity.ok().build();
    }

    @RequestMapping("/end")
    public ResponseEntity end(@RequestBody RehabilitationInfoRequest rehabilitationInfoRequest) {

        rehabilitationInfoService.rehabilitationEnd(rehabilitationInfoRequest);

        return ResponseEntity.ok().build();
    }


}
