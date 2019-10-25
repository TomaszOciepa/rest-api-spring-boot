package pl.tom.restapispringboot.manager;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.tom.restapispringboot.dao.VideoCassetteRepo;
import pl.tom.restapispringboot.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }


    public void deleteById(Long id) {
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class) // uruchominie metody po starcie aplikacji
    public void fillDB() {
        save(new VideoCassette(1L, "Titanic", LocalDate.of(1991, 01, 01)));
        save(new VideoCassette(2L, "Pulp Fiction", LocalDate.of(1995, 02, 02)));
    }

}
