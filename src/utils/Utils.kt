package utils

import java.io.File

class Utils {
    companion object {
        fun loadResource(fileName: String): String {
            println("Load Resource   : $fileName")
            return File(
                    System.getProperty("user.dir") + "/$fileName"
            ).readText(Charsets.UTF_8)
        }
    }
}