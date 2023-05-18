package changwonNationalUniv.soCool.config;


import changwonNationalUniv.soCool.socket.BiologicalInfoSocket;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private final BiologicalInfoSocket biologicalInfoSocket;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(biologicalInfoSocket, "/ws/biologicalInfo");
    }
}
