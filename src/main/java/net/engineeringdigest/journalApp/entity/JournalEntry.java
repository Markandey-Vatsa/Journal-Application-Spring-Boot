package net.engineeringdigest.journalApp.entity;

//POJO -> PLANE OLD JAVA OBJECT CLASS

import com.fasterxml.jackson.databind.DatabindException;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "Journal_entries") // -> Now this document(similar to rows) will be mapped with (Journal_entries) collection(similar to table).
@Data
@NoArgsConstructor
public class JournalEntry {
    @Id
    private ObjectId id;

    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;
}
