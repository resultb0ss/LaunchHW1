import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {

    println("Программа покупки продуктов")
    delay(1000L)
    println("Купить товар\n 1.Да \n 2.Нет")
    var input = readln()
    var goodByeCoroutine = launch(start = CoroutineStart.LAZY) {goodBye()}

    when(input){
        "1" -> {
            val startJob = launch{startJob()}
            startJob.join()
        }
        "2" -> {
            val endJob = launch{endJob()}
            endJob.join()
        }
        else ->{
            var errorProc = launch { errorCoroutines()}
            errorProc.join()
        }
    }
    goodByeCoroutine.start()
    println()


}

suspend fun goodBye(){
    println("До свидания")
}

suspend fun startJob(){
    println("Оплата продукта началась")
    delay(2000L)
    println("Сканирование и обработка")
    delay(2000L)
    println("Покупка оплачена")
}

suspend fun endJob(){
    println("Отмена покупки")
    delay(2000L)
    println("Покупка отменена")
}

suspend fun errorCoroutines(){
    println("Ошибка оплаты")
}