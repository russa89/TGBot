package pro.sky.telegrambot.repository;

import pro.sky.telegrambot.model.NotificationTask;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


public interface NotificationTaskRepository extends JpaRepository <NotificationTask, Long>{
    List<NotificationTask> findAllByDateTime(LocalDateTime dateTime);
}
