package org.dromara.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.dromara.common.websocket.utils.WebSocketUtils;
import com.aizuda.snailjob.client.common.init.SnailJobStartListener;

@SpringBootTest
@ActiveProfiles("test")
public class WebSocketTest {


    @DisplayName("测试 publishAll 方法")
    @Test
    public void publishAll() {
        WebSocketUtils.publishAll("2312312323");
    }
}
