package ru.sbrf.efs.install.releasemanager.web.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.sbrf.efs.install.releasemanager.web.model.HistoryComponent;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class HistoryService {

    private List<HistoryComponent> mockHistoryComponents = new ArrayList<HistoryComponent>() {{
        add(
                new HistoryComponent(
                        "Артефакт зарегистрирован в Nexus",
                        "2018-06-25:11-00"
                )
        );

        add(
                new HistoryComponent(
                        "Начат деплой на контур TEST",
                        "2018-06-25:11-10"
                )
        );

        add(
                new HistoryComponent(
                        "Запуск тестов на контуре TEST",
                        "2018-06-25:11-11"
                )
        );

        add(
                new HistoryComponent(
                        "Тестирование  на контуре TEST успешно завершено",
                        "2018-06-25:11-11"
                )
        );
    }};

}
