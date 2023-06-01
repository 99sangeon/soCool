package changwonNationalUniv.soCool.controller;

import changwonNationalUniv.soCool.dto.response.RehabilitationInfoResponse;
import changwonNationalUniv.soCool.service.FCMService;
import changwonNationalUniv.soCool.service.RehabilitationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
@RequestMapping("/fcm")
public class FCMController {

    private final FCMService fcmService;
    private final RehabilitationInfoService rehabilitationInfoService;

    @ResponseBody
    @RequestMapping("/call/{rehabilitationInfoId}")
    public ResponseEntity call(@PathVariable Long rehabilitationInfoId) throws IOException {

        RehabilitationInfoResponse rehabilitationInfo
                = rehabilitationInfoService.findRehabilitationInfo(rehabilitationInfoId);

        fcmService.sendMessageTo(
                "cwu4d_saT62q0e2HiYVjP5:APA91bH6SRskfvBoJrLRQEff4ZHgC2X8a2LyXrR8r9JoSnnCNGL3LDRFeC1KxU_YxDUMZPFdhEZ2rEUIyPNg0v2bk0dwHwhbhHd5_AjsQLUuSjjD33aIU2r9rWea7BpP8HsIz1TBNpPr",
                "관리자호출",
                rehabilitationInfo.getMemberName() + "님이 호출했습니다.");

        return ResponseEntity.ok().build();
    }

    @ResponseBody
    @RequestMapping("/emergency/{rehabilitationInfoId}")
    public ResponseEntity emergency(@PathVariable Long rehabilitationInfoId) throws IOException {

        RehabilitationInfoResponse rehabilitationInfo
                = rehabilitationInfoService.findRehabilitationInfo(rehabilitationInfoId);

        fcmService.sendMessageTo(
                "cwu4d_saT62q0e2HiYVjP5:APA91bH6SRskfvBoJrLRQEff4ZHgC2X8a2LyXrR8r9JoSnnCNGL3LDRFeC1KxU_YxDUMZPFdhEZ2rEUIyPNg0v2bk0dwHwhbhHd5_AjsQLUuSjjD33aIU2r9rWea7BpP8HsIz1TBNpPr",
                "안전사고",
                rehabilitationInfo.getMemberName() + "님 안전사고 발생했습니다.");

        return ResponseEntity.ok().build();
    }
}