package changwonNationalUniv.soCool.socket;

import changwonNationalUniv.soCool.service.BiologicalInfoService;
import changwonNationalUniv.soCool.dto.BiologicalInfoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class BiologicalInfoSocket extends TextWebSocketHandler {

    private final BiologicalInfoService biologicalInfoService;
    private final ObjectMapper objectMapper;
    private static List<WebSocketSession> list = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);
        log.info("[{}] 보행보조차 재활 시작", session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        
        BiologicalInfoRequest biologicalInfoRequest = objectMapper.readValue(message.asBytes(), BiologicalInfoRequest.class);
        biologicalInfoService.save(biologicalInfoRequest);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("[{}] 보행보조차 재활 종료", session);
        list.remove(session);
    }
}
