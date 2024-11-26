package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.model.NotificationTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.repository.NotificationTaskRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class NotificationTaskService {

    private final TelegramBot telegramBot;

    private final NotificationTaskRepository notificationTaskRepository;

    public NotificationTaskService(TelegramBot telegramBot, NotificationTaskRepository notificationTaskRepository) {
        this.telegramBot = telegramBot;
        this.notificationTaskRepository = notificationTaskRepository;
    }

    Logger logger = LoggerFactory.getLogger(NotificationTaskService.class);

    public NotificationTask createTask(NotificationTask notificationTask) {
        logger.info("Was invoked method for create notification task");
        return notificationTaskRepository.save(notificationTask);
    }
    public List<NotificationTask> findAllByLocalDateTime(LocalDateTime dateTime) {
        return notificationTaskRepository.findAllByDateTime(dateTime);
    }

    @Scheduled(cron = "0 0/1 * * * *")
    public void findDataByLocalTime() {

        findAllByLocalDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))
                .forEach(reminder -> {
                    telegramBot.execute(new SendMessage(reminder.getChatId(),
                            reminder.getMessage()));
         });
    }
}
