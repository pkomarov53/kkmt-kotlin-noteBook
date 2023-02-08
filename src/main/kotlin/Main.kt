import java.awt.Desktop
import java.io.File

fun fileOutput(noteObject: Note) {
    val fileWriter = File("output-files", noteObject.name)
    fileWriter.writeText("${noteObject}\n")
    println("Файл успешно добавлен!\n")
}

fun openFileDir() {
    val fileInput = File("/home/p1-20@stud.local/IdeaProjects/noteBook/output-files")
    if (Desktop.isDesktopSupported()) {
        val desktop = Desktop.getDesktop()
        desktop.open(fileInput)
    }
}

fun delFile(fileName: String) {
    val destFile = File("output-files", fileName)
    if (destFile.delete()) {
        println("Файл успешно удален\n")

    } else println("Не удалось удалить файл\n")
}

fun openFile(fileName: String) {
    val openFile = File("output-files", fileName)
    if (openFile.isFile) {
        print("${openFile.readLines().joinToString()}\n")
    } else println("Не удалось найти файл\n")
}

fun main() {
    println("Меню программы: \n" +
            "\t1 - добавить заметку\n" +
            "\t2 - удалить заметку\n" +
            "\t3 - просмотреть заметки\n" +
            "\t4 - найти заметку по имени\n" +
            "\t5 - завершить работу программы")

    while (true) {
        print("Введите команду -> ")
        when (readln()) {
            "1" -> {
                print("Введите название заметки: ")
                val tempNoteName = readln()

                print("Введите автора заметки: ")
                val tempAuthorName = readln()

                print("Введите текст заметки: ")
                val text: String = readlnOrNull().toString()

                val tempObject = Note(tempNoteName, tempAuthorName, text)
                fileOutput(tempObject)
            }

            "2" -> {
                print("Введите название файла -> ")
                delFile(readln())
            }

            "3" -> openFileDir()

            "4" -> {
                print("Введите название файла -> ")
                openFile(readln())
            }

            "5" -> break

            else -> {
                println("Некорректная команда\n")
                continue
            }
        }
    }
}