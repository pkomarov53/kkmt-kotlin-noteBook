import java.time.LocalDate
import java.time.format.DateTimeFormatter

var counterId: Int = 0

class Note(var name: String, private val authorName: String, private val noteText: String) {

    private var id: Int = 0
    private val noteDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    init {
        if (this.name.isEmpty()) this.name = noteText.substring(0, 10)
        this.id = counterId
        counterId++
    }

    override fun toString(): String {
        return  "id заметки - ${id}\n" +
                "Название заметки - $name\n" +
                "Дата написания заметки - $noteDate\n" +
                "Автор заметки - $authorName\n" +
                "Текст заметки - $noteText\n"
    }
}