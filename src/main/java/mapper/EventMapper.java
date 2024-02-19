package mapper;
import dto.EventDTO;
import org.springframework.stereotype.Component;
import entity.Event;

@Component
public class EventMapper {
    public EventDTO toDTO(Event event) {
        EventDTO dto = new EventDTO();

        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setEventDate(event.getEventDate());
        dto.setStartTime(event.getStartTime());
        dto.setEndTime(event.getEndTime());
        dto.setLatitude(event.getLatitude());
        dto.setLongitude(event.getLongitude());
        return dto;
    }

    public Event toEntity(EventDTO dto) {
        Event event = new Event();
        event.setId(dto.getId());
        event.setName(dto.getName());
        event.setEventDate(dto.getEventDate());
        event.setStartTime(dto.getStartTime());
        event.setEndTime(dto.getEndTime());
        event.setLatitude(dto.getLatitude());
        event.setLongitude(dto.getLongitude());
        return event;
    }
}

