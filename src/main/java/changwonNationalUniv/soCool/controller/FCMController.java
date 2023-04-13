package changwonNationalUniv.soCool.controller;

import changwonNationalUniv.soCool.service.FCMService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class FCMController {

    private final FCMService fcmService;

    @ResponseBody
    @RequestMapping("/api/fcm")
    public ResponseEntity pushMessage() throws IOException {

        fcmService.sendMessageTo(
                "cwu4d_saT62q0e2HiYVjP5:APA91bH6SRskfvBoJrLRQEff4ZHgC2X8a2LyXrR8r9JoSnnCNGL3LDRFeC1KxU_YxDUMZPFdhEZ2rEUIyPNg0v2bk0dwHwhbhHd5_AjsQLUuSjjD33aIU2r9rWea7BpP8HsIz1TBNpPr",
                "하이하이",
                "ㄹㅇㅋㅋ");
        return ResponseEntity.ok().build();
    }
}