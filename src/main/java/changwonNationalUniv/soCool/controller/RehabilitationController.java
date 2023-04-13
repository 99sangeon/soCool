package changwonNationalUniv.soCool.controller;

import changwonNationalUniv.soCool.dto.RehabilitationInfoRequest;
import changwonNationalUniv.soCool.service.RehabilitationInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@ResponseBody
@Slf4j
public class RehabilitationController {

    private final RehabilitationInfoService rehabilitationInfoService;

    @RequestMapping("/saveRehabilitation")
    public ResponseEntity<Map> save(@RequestBody RehabilitationInfoRequest rehabilitationInfoRequest) {

        log.info("rehabilitationInfoRequest={}", rehabilitationInfoRequest);

        Long id = rehabilitationInfoService.save(rehabilitationInfoRequest);
        Map<String, Long> map = new HashMap<>();
        map.put("rehabilitationInfoId", id);

        return ResponseEntity.ok(map);
    }

}
